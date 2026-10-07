package com.inolia_zaicek.ars_extensions;

import com.inolia_zaicek.ars_extensions.Event.HurtEvent;
import com.inolia_zaicek.ars_extensions.Event.IronHurtEvent;
import com.inolia_zaicek.ars_extensions.Event.TerraHurtEvent;
import com.inolia_zaicek.ars_extensions.Register.ArsEEffectsRegister;
import com.inolia_zaicek.ars_extensions.Register.ArsEItemRegister;
import com.inolia_zaicek.ars_extensions.Register.Tab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.LoadingModList;


@Mod(ArsExtensions.MODID)
public class ArsExtensions {
    public static final String MODID = "ars_extensions";
    public static final boolean TERRA_CURIO = LoadingModList.get().getModFileById("terra_curio") != null;

    public ArsExtensions(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        // 注册 Item、Tab、Entity 类型
        Tab.register(bus);
        ArsEItemRegister.register(bus);
        ArsEEffectsRegister.INOEFFECT.register(bus);
        MinecraftForge.EVENT_BUS.register(HurtEvent.class);
        //铁魔法增幅
        if (ModList.get().isLoaded("irons_spellbooks")) {
            MinecraftForge.EVENT_BUS.register(IronHurtEvent.class);
        }
        if (ArsExtensions.TERRA_CURIO) {
            MinecraftForge.EVENT_BUS.register(TerraHurtEvent.class);
        }
    }
}
