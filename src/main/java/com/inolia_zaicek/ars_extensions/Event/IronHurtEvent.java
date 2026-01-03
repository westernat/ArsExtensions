package com.inolia_zaicek.ars_extensions.Event;

import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import com.hollingsworth.arsnouveau.setup.registry.DamageTypesRegistry;
import com.inolia_zaicek.ars_extensions.ArsExtensions;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.tags.DamageTypeTags.WITCH_RESISTANT_TO;

public class IronHurtEvent {

    @SubscribeEvent
    public static void hurt(LivingHurtEvent event) {
        if (ModList.get().isLoaded("irons_spellbooks")) {
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
                //【每点通用法强或该学派法强，约提升2%，非该学派法强提升约为1%】
                //魔艺魔法伤害——邪术
                if (event.getSource().is(DamageTypesRegistry.GENERIC_SPELL_DAMAGE)) {
                    //铁魔法属性计算
                    float all = (float) attacker.getAttributeValue(AttributeRegistry.SPELL_POWER.get()) - 1;
                    float fire = (float) attacker.getAttributeValue(AttributeRegistry.FIRE_SPELL_POWER.get()) - 1;
                    float ice = (float) attacker.getAttributeValue(AttributeRegistry.ICE_SPELL_POWER.get()) - 1;
                    float lightning = (float) attacker.getAttributeValue(AttributeRegistry.LIGHTNING_SPELL_POWER.get()) - 1;
                    float blood = (float) attacker.getAttributeValue(AttributeRegistry.BLOOD_SPELL_POWER.get()) - 1;
                    float evocation = (float) attacker.getAttributeValue(AttributeRegistry.EVOCATION_MAGIC_RESIST.get());
                    float holy = (float) attacker.getAttributeValue(AttributeRegistry.HOLY_SPELL_POWER.get()) - 1;
                    float nature = (float) attacker.getAttributeValue(AttributeRegistry.NATURE_SPELL_POWER.get()) - 1;
                    float eldritch = (float) attacker.getAttributeValue(AttributeRegistry.ELDRITCH_SPELL_POWER.get()) - 1;
                    number *= all * 2 + fire + ice + lightning + blood + evocation + holy + nature + eldritch * 2;
                }
                //冻结
                else if (event.getSource().is(DamageTypesRegistry.COLD_SNAP)) {
                    //铁魔法属性计算
                    float all = (float) attacker.getAttributeValue(AttributeRegistry.SPELL_POWER.get()) - 1;
                    float fire = (float) attacker.getAttributeValue(AttributeRegistry.FIRE_SPELL_POWER.get()) - 1;
                    float ice = (float) attacker.getAttributeValue(AttributeRegistry.ICE_SPELL_POWER.get()) - 1;
                    float lightning = (float) attacker.getAttributeValue(AttributeRegistry.LIGHTNING_SPELL_POWER.get()) - 1;
                    float blood = (float) attacker.getAttributeValue(AttributeRegistry.BLOOD_SPELL_POWER.get()) - 1;
                    float evocation = (float) attacker.getAttributeValue(AttributeRegistry.EVOCATION_MAGIC_RESIST.get());
                    float holy = (float) attacker.getAttributeValue(AttributeRegistry.HOLY_SPELL_POWER.get()) - 1;
                    float nature = (float) attacker.getAttributeValue(AttributeRegistry.NATURE_SPELL_POWER.get()) - 1;
                    float eldritch = (float) attacker.getAttributeValue(AttributeRegistry.ELDRITCH_SPELL_POWER.get()) - 1;
                    number *= all * 2 + fire + ice * 2 + lightning + blood + evocation + holy + nature + eldritch;
                }
                //炎爆
                else if (event.getSource().is(DamageTypesRegistry.FLARE)) {
                    //铁魔法属性计算
                    float all = (float) attacker.getAttributeValue(AttributeRegistry.SPELL_POWER.get()) - 1;
                    float fire = (float) attacker.getAttributeValue(AttributeRegistry.FIRE_SPELL_POWER.get()) - 1;
                    float ice = (float) attacker.getAttributeValue(AttributeRegistry.ICE_SPELL_POWER.get()) - 1;
                    float lightning = (float) attacker.getAttributeValue(AttributeRegistry.LIGHTNING_SPELL_POWER.get()) - 1;
                    float blood = (float) attacker.getAttributeValue(AttributeRegistry.BLOOD_SPELL_POWER.get()) - 1;
                    float evocation = (float) attacker.getAttributeValue(AttributeRegistry.EVOCATION_MAGIC_RESIST.get());
                    float holy = (float) attacker.getAttributeValue(AttributeRegistry.HOLY_SPELL_POWER.get()) - 1;
                    float nature = (float) attacker.getAttributeValue(AttributeRegistry.NATURE_SPELL_POWER.get()) - 1;
                    float eldritch = (float) attacker.getAttributeValue(AttributeRegistry.ELDRITCH_SPELL_POWER.get()) - 1;
                    number *= all * 2 + fire * 2 + ice + lightning + blood + evocation + holy + nature + eldritch;
                }
                //烈风
                else if (event.getSource().is(DamageTypesRegistry.WINDSHEAR)) {
                    //铁魔法属性计算
                    float all = (float) attacker.getAttributeValue(AttributeRegistry.SPELL_POWER.get()) - 1;
                    float fire = (float) attacker.getAttributeValue(AttributeRegistry.FIRE_SPELL_POWER.get()) - 1;
                    float ice = (float) attacker.getAttributeValue(AttributeRegistry.ICE_SPELL_POWER.get()) - 1;
                    float lightning = (float) attacker.getAttributeValue(AttributeRegistry.LIGHTNING_SPELL_POWER.get()) - 1;
                    float blood = (float) attacker.getAttributeValue(AttributeRegistry.BLOOD_SPELL_POWER.get()) - 1;
                    float evocation = (float) attacker.getAttributeValue(AttributeRegistry.EVOCATION_MAGIC_RESIST.get());
                    float holy = (float) attacker.getAttributeValue(AttributeRegistry.HOLY_SPELL_POWER.get()) - 1;
                    float nature = (float) attacker.getAttributeValue(AttributeRegistry.NATURE_SPELL_POWER.get()) - 1;
                    float eldritch = (float) attacker.getAttributeValue(AttributeRegistry.ELDRITCH_SPELL_POWER.get()) - 1;
                    number *= all * 2 + fire + ice + lightning + blood + evocation * 2 + holy + nature + eldritch;
                }
                //碾压
                else if (event.getSource().is(DamageTypesRegistry.CRUSH)) {
                    //铁魔法属性计算
                    float all = (float) attacker.getAttributeValue(AttributeRegistry.SPELL_POWER.get()) - 1;
                    float fire = (float) attacker.getAttributeValue(AttributeRegistry.FIRE_SPELL_POWER.get()) - 1;
                    float ice = (float) attacker.getAttributeValue(AttributeRegistry.ICE_SPELL_POWER.get()) - 1;
                    float lightning = (float) attacker.getAttributeValue(AttributeRegistry.LIGHTNING_SPELL_POWER.get()) - 1;
                    float blood = (float) attacker.getAttributeValue(AttributeRegistry.BLOOD_SPELL_POWER.get()) - 1;
                    float evocation = (float) attacker.getAttributeValue(AttributeRegistry.EVOCATION_MAGIC_RESIST.get());
                    float holy = (float) attacker.getAttributeValue(AttributeRegistry.HOLY_SPELL_POWER.get()) - 1;
                    float nature = (float) attacker.getAttributeValue(AttributeRegistry.NATURE_SPELL_POWER.get()) - 1;
                    float eldritch = (float) attacker.getAttributeValue(AttributeRegistry.ELDRITCH_SPELL_POWER.get()) - 1;
                    number *= all * 2 + fire + ice + lightning + blood + evocation + holy + nature * 2 + eldritch;
                }
                /// 新生魔艺增幅铁魔法
                if (event.getSource().is(ISSDamageTypes.FIRE_MAGIC)||event.getSource().is(ISSDamageTypes.ICE_MAGIC)
                        ||event.getSource().is(ISSDamageTypes.LIGHTNING_MAGIC)||event.getSource().is(ISSDamageTypes.EVOCATION_MAGIC)
                        ||event.getSource().is(ISSDamageTypes.BLOOD_MAGIC)||event.getSource().is(ISSDamageTypes.HOLY_MAGIC)
                        ||event.getSource().is(ISSDamageTypes.ELDRITCH_MAGIC)||event.getSource().is(ISSDamageTypes.ENDER_MAGIC)
                        ||event.getSource().is(ISSDamageTypes.NATURE_MAGIC)
                ) {
                    fixedNumber += (float) attacker.getAttributeValue(PerkAttributes.SPELL_DAMAGE_BONUS.get());
                }
                //铁魔法增幅
                float damage = (event.getAmount() * number + fixedNumber) * overNumber;
                event.setAmount(damage);
            }
        }
    }
}