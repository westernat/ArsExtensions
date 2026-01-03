package com.inolia_zaicek.ars_extensions.Event;

import com.hollingsworth.arsnouveau.setup.registry.DamageTypesRegistry;
import com.inolia_zaicek.ars_extensions.ArsExtensions;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.confluence.mod.misc.ModAttributes;

public class TerraHurtEvent {

    @SubscribeEvent
    public static void hurt(LivingHurtEvent event) {
        if (ModList.get().isLoaded("confluence")) {
            LivingEntity attacked = event.getEntity();
            if (attacked != null) {
                float number = 1;
                float overNumber = 1;
                float fixedNumber = 0;
            }
            if (event.getSource().getEntity() instanceof LivingEntity attacker) {
                float number = 1;
                float overNumber = 1;
                float fixedNumber = 0;
                //泰拉饰品
                if (event.getSource().is(DamageTypesRegistry.GENERIC_SPELL_DAMAGE) || event.getSource().is(DamageTypesRegistry.COLD_SNAP)
                        || event.getSource().is(DamageTypesRegistry.FLARE) || event.getSource().is(DamageTypesRegistry.WINDSHEAR) ||
                        event.getSource().is(DamageTypesRegistry.CRUSH)) {
                    float damageUp = (float) attacker.getAttributeValue(ModAttributes.MAGIC_DAMAGE.get());
                    number *= damageUp;
                }
                float damage = (event.getAmount() * number + fixedNumber) * overNumber;
                event.setAmount(damage);
            }
        }
    }
}