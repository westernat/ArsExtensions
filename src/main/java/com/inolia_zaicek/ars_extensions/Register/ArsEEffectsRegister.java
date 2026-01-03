package com.inolia_zaicek.ars_extensions.Register;

import com.inolia_zaicek.ars_extensions.Register.buff.ManaSicknessBuff;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.inolia_zaicek.ars_extensions.ArsExtensions.MODID;


public class ArsEEffectsRegister {
    public static final DeferredRegister<MobEffect> INOEFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,MODID);
    //决斗
    public static final RegistryObject<MobEffect> ManaSickness = INOEFFECT.register("mana_sickness", ManaSicknessBuff::new);
}
