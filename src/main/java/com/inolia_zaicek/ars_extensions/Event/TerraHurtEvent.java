package com.inolia_zaicek.ars_extensions.Event;

import com.hollingsworth.arsnouveau.setup.registry.DamageTypesRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.confluence.lib.common.LibAttributes;

public class TerraHurtEvent {
    @SubscribeEvent
    public static void hurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            float number = 1;
            float overNumber = 1;
            float fixedNumber = 0;
            //泰拉饰品
            if (event.getSource().is(DamageTypesRegistry.GENERIC_SPELL_DAMAGE) || event.getSource().is(DamageTypesRegistry.COLD_SNAP)
                    || event.getSource().is(DamageTypesRegistry.FLARE) || event.getSource().is(DamageTypesRegistry.WINDSHEAR) ||
                    event.getSource().is(DamageTypesRegistry.CRUSH)) {
                float damageUp = (float) attacker.getAttributeValue(LibAttributes.getMagicDamage().value());
                number *= damageUp;
            }
            float damage = (event.getAmount() * number + fixedNumber) * overNumber;
            event.setAmount(damage);
        }
    }
}
