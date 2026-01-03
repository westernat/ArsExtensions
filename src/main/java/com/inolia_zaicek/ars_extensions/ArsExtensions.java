package com.inolia_zaicek.ars_extensions;

import com.inolia_zaicek.ars_extensions.Event.HurtEvent;
import com.inolia_zaicek.ars_extensions.Event.IronHurtEvent;
import com.inolia_zaicek.ars_extensions.Event.TerraHurtEvent;
import com.inolia_zaicek.ars_extensions.ModelProvider.ZeroingModRecipesGen;
import com.inolia_zaicek.ars_extensions.Register.ArsEItemRegister;
import com.inolia_zaicek.ars_extensions.Register.ArsEEffectsRegister;
import com.inolia_zaicek.ars_extensions.Register.Tab;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.*;


@Mod(ArsExtensions.MODID)
public class ArsExtensions {

    public static final String MODID = "ars_extensions";
    public ArsExtensions() {
        init();
    }

    public void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // 注册 Item、Tab、Entity 类型
        Tab.register(bus);
        ArsEItemRegister.register(bus);
        ArsEEffectsRegister.INOEFFECT.register(bus);
        // 注册 CommonSetup 事件
        bus.addListener(this::commonSetup);
        // !!! 注册 ClientSetup 事件 !!!
        bus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(HurtEvent.class);
        //铁魔法增幅
        if(ModList.get().isLoaded("irons_spellbooks")) {
            MinecraftForge.EVENT_BUS.register(IronHurtEvent.class);
        }
        if (ModList.get().isLoaded("confluence")) {
            MinecraftForge.EVENT_BUS.register(TerraHurtEvent.class);
        }
    }

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
        });
    }

    // 客户端设置事件，用于注册渲染器和GUI屏幕
    // 加上 @SubscribeEvent，使其成为 Mod 事件总线上的监听器
    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }

    //注册掉落物
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        if (event.includeServer()) {
            generator.addProvider(event.includeServer(), new ZeroingModRecipesGen(output));
        }
    }

    public static ResourceLocation prefix(String name){
        return new ResourceLocation(MODID,name.toLowerCase(Locale.ROOT));
    }
    public static ResourceLocation getResource(String id) {
        return new ResourceLocation("ars_extensions", id);
    }
}