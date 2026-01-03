package com.inolia_zaicek.ars_extensions.Event;

import com.hollingsworth.arsnouveau.api.mana.IManaCap;
import com.hollingsworth.arsnouveau.setup.config.ServerConfig;
import com.hollingsworth.arsnouveau.setup.registry.CapabilityRegistry;
import com.inolia_zaicek.ars_extensions.ArsExtensions;
import com.inolia_zaicek.ars_extensions.Register.ArsEEffectsRegister;
import com.inolia_zaicek.ars_extensions.Register.ArsEItemRegister;
import com.inolia_zaicek.ars_extensions.Util.TEGUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE,modid = ArsExtensions.MODID)
public class TickEvent {
    @SubscribeEvent
    public static void playerOnTick(net.minecraftforge.event.TickEvent.PlayerTickEvent e) {
        if (!e.player.getCommandSenderWorld().isClientSide && e.player.getCommandSenderWorld().getGameTime() % (long) (Integer) ServerConfig.REGEN_INTERVAL.get() == 0L) {
            Player player = e.player;
            IManaCap mana = (IManaCap) CapabilityRegistry.getMana(e.player).orElse((IManaCap) null);
            if (mana != null) {
                // 条件满足时，做额外检测
                if (ModList.get().isLoaded("confluence")) {
                    // 魔力花
                    if (TEGUtil.isCurioEquipped(player, ArsEItemRegister.ArsManaFlower.get()) && mana.getCurrentMana() <= mana.getMaxMana() * 0.5F ) {
                        // 新增的检测和消耗逻辑
                        boolean consumed = false;

                        // 按顺序检测：主手、副手、物品栏、背包
                        // 检查主手
                        ItemStack mainHand = player.getMainHandItem();
                        if (mainHand.getItem() == Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation("ars_nouveau", "sourceberry_bush"))) && mainHand.getCount() > 0) {
                            mainHand.shrink(1); // 消耗1个
                            consumed = true;
                        }
                        // 如果没消耗，检测副手
                        if (!consumed) {
                            ItemStack offHand = player.getOffhandItem();
                            if (offHand.getItem() == Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation("ars_nouveau", "sourceberry_bush"))) && offHand.getCount() > 0) {
                                offHand.shrink(1);
                                consumed = true;
                            }
                        }
                        // 如果还没消耗，检测物品栏
                        if (!consumed) {
                            Inventory inventory = player.getInventory();
                            for (int i = 0; i < inventory.getContainerSize(); i++) {
                                ItemStack stackInSlot = inventory.getItem(i);
                                if (stackInSlot.getItem() == Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation("ars_nouveau", "sourceberry_bush"))) && stackInSlot.getCount() > 0) {
                                    stackInSlot.shrink(1); // 消耗1个
                                    consumed = true;
                                    break;
                                }
                            }
                        }

                        // 最后，检测背包内
                        if (!consumed) {
                            Inventory inventory = player.getInventory();
                            for (int i = 0; i < inventory.getContainerSize(); i++) {
                                ItemStack stackInSlot = inventory.getItem(i);
                                if (stackInSlot.getItem() == Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation("ars_nouveau", "sourceberry_bush"))) && stackInSlot.getCount() > 0) {
                                    stackInSlot.shrink(1); // 消耗1个
                                    consumed = true;
                                    break;
                                }
                            }
                        }

                        // 如果找到了物品并消耗了，增加法力
                        if (consumed) {
                            mana.addMana(mana.getMaxMana()*0.08F);
                            player.addEffect(new MobEffectInstance(ArsEEffectsRegister.ManaSickness.get(),100,0));
                        }
                    }
                }
            }
        }
    }
}