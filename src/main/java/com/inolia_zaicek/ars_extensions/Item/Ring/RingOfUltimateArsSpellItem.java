package com.inolia_zaicek.ars_extensions.Item.Ring;

import com.google.common.collect.Multimap;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class RingOfUltimateArsSpellItem extends Item implements ICurioItem {
    public RingOfUltimateArsSpellItem() {
        super((new Properties()).stacksTo(1).fireResistant());
    }
    public int getSpellDamage(ItemStack i) {return 5;}
    protected String getTooltipItemName() {
        return BuiltInRegistries.ITEM.getKey(this).getPath();
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
        attributes.put((Attribute) PerkAttributes.MAX_MANA.get(), new AttributeModifier(uuid, getTooltipItemName(), 0.1, AttributeModifier.Operation.MULTIPLY_BASE));
        attributes.put((Attribute)PerkAttributes.MANA_REGEN_BONUS.get(), new AttributeModifier(uuid, getTooltipItemName(), 0.2, AttributeModifier.Operation.MULTIPLY_BASE));
        attributes.put((Attribute)PerkAttributes.SPELL_DAMAGE_BONUS.get(), new AttributeModifier(uuid, getTooltipItemName(), (double)this.getSpellDamage(stack), AttributeModifier.Operation.ADDITION));
        return attributes;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        String itemName = getTooltipItemName(); // 获取物品 ID
        // 鼠标经过时的默认文本
        // 翻译键格式: tooltip.<你的ModID>.<物品ID>_text
        pTooltipComponents.add(Component.translatable("tooltip." + "ars_extensions" + "." + itemName + ".text")
                .withStyle(style -> style.withColor(ChatFormatting.WHITE)));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
