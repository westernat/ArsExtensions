package com.inolia_zaicek.ars_extensions.Event;

import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import com.hollingsworth.arsnouveau.setup.registry.DamageTypesRegistry;
import com.inolia_zaicek.ars_extensions.Register.ArsEEffectsRegister;
import com.inolia_zaicek.ars_extensions.Register.ArsEItemRegister;
import com.inolia_zaicek.ars_extensions.Util.TEGUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static net.minecraft.tags.DamageTypeTags.WITCH_RESISTANT_TO;

public class HurtEvent {
    @SubscribeEvent
    public static void hurt(LivingHurtEvent event) {
            LivingEntity attacked = event.getEntity();
            if (attacked != null) {
                float number = 1;
                float overNumber = 1;
                float fixedNumber = 0;
            }
            if (event.getSource().getEntity() instanceof LivingEntity attacker&&attacked!=null) {
                float number = 1;
                float overNumber = 1;
                float fixedNumber = 0;
                //原版法术伤害
                if(event.getSource().is(WITCH_RESISTANT_TO)){
                    fixedNumber += (float) attacker.getAttributeValue(PerkAttributes.SPELL_DAMAGE_BONUS.get());
                }
                //是魔艺伤害
                if (event.getSource().is(DamageTypesRegistry.GENERIC_SPELL_DAMAGE) || event.getSource().is(DamageTypesRegistry.COLD_SNAP)
                        || event.getSource().is(DamageTypesRegistry.FLARE) || event.getSource().is(DamageTypesRegistry.WINDSHEAR) ||
                        event.getSource().is(DamageTypesRegistry.CRUSH)) {
                    //虚时
                    if(TEGUtil.isCurioEquipped(attacker, ArsEItemRegister.RingOfLesserArsSpell.get())
                    ||TEGUtil.isCurioEquipped(attacker, ArsEItemRegister.RingOfGreaterArsSpell.get())
                    ||TEGUtil.isCurioEquipped(attacker, ArsEItemRegister.RingOfUltimateArsSpell.get())) {
                        float invulnerableTime = attacked.invulnerableTime*100;
                        if (TEGUtil.isCurioEquipped(attacker, ArsEItemRegister.RingOfLesserArsSpell.get())) {
                            invulnerableTime *= 0.75F;
                        }
                        if (TEGUtil.isCurioEquipped(attacker, ArsEItemRegister.RingOfGreaterArsSpell.get())) {
                            invulnerableTime *= 0.5F;
                        }
                        if (TEGUtil.isCurioEquipped(attacker, ArsEItemRegister.RingOfUltimateArsSpell.get())) {
                            invulnerableTime = 0;
                        }
                        attacked.invulnerableTime = (int) (invulnerableTime / 100);
                    }
                    if (attacker.hasEffect(ArsEEffectsRegister.ManaSickness.get())){
                        number*=0.75F;
                    }
                }
                float damage = (event.getAmount() * number + fixedNumber) * overNumber;
                event.setAmount(damage);
        }
    }
}
