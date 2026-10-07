package com.inolia_zaicek.ars_extensions.Register;

import com.inolia_zaicek.ars_extensions.ArsExtensions;
import com.inolia_zaicek.ars_extensions.Item.ConfluenceITEM.ArsManaBandItem;
import com.inolia_zaicek.ars_extensions.Item.ConfluenceITEM.ArsManaFlowerItem;
import com.inolia_zaicek.ars_extensions.Item.Necklece.AmuletOfDiscountItem;
import com.inolia_zaicek.ars_extensions.Item.Necklece.AmuletOfOriginItem;
import com.inolia_zaicek.ars_extensions.Item.Necklece.AmuletOfSpellDamageItem;
import com.inolia_zaicek.ars_extensions.Item.Ring.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.inolia_zaicek.ars_extensions.ArsExtensions.MODID;

public class ArsEItemRegister {
    public static final DeferredRegister<Item> ZeroingITEM = DeferredRegister.create(Registries.ITEM, MODID);
    public static final DeferredRegister<Item> ConfluenceITEM = DeferredRegister.create(Registries.ITEM, MODID);
    public static List<RegistryObject<Item>> CommonItem = new ArrayList<>(List.of());

    public static RegistryObject<Item> registerCommonMaterials(DeferredRegister<Item> register, String name, Supplier<? extends Item> sup) {
        RegistryObject<Item> object = register.register(name, sup);
        CommonItem.add(object);
        return object;
    }
    //伤害：剑A的情况下，斧头A+2，镐A-2，锹A-1.5，锄固定为1
    // 攻击速度（镐统一-2.8，斧头-3.1，剑-2.4，锹-3，锄0
    /// 铜
    //tag
    public static final TagKey<Item> copper = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", "ingots/copper"));

    //public static final RegistryObject<Item> DragonBreathIngot = registerCommonMaterials(ZeroingITEM,"dragon_breath_ingot", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> RingOfUltimateDiscount = registerCommonMaterials(ZeroingITEM, "ring_of_ultimate_discount", RingOfUltimateDiscountItem::new);

    public static final RegistryObject<Item> RingOfLesserManaBoost = registerCommonMaterials(ZeroingITEM, "ring_of_lesser_mana_boost", RingOfLesserManaBoostItem::new);
    public static final RegistryObject<Item> RingOfGreaterManaBoost = registerCommonMaterials(ZeroingITEM, "ring_of_greater_mana_boost", RingOfGreaterManaBoostItem::new);
    public static final RegistryObject<Item> RingOfUltimateManaBoost = registerCommonMaterials(ZeroingITEM, "ring_of_ultimate_mana_boost", RingOfUltimateManaBoostItem::new);

    public static final RegistryObject<Item> RingOfLesserManaRegen = registerCommonMaterials(ZeroingITEM, "ring_of_lesser_mana_regen", RingOfLesserManaRegenItem::new);
    public static final RegistryObject<Item> RingOfGreaterManaRegen = registerCommonMaterials(ZeroingITEM, "ring_of_greater_mana_regen", RingOfGreaterManaRegenItem::new);
    public static final RegistryObject<Item> RingOfUltimateManaRegen = registerCommonMaterials(ZeroingITEM, "ring_of_ultimate_mana_regen", RingOfUltimateManaRegenItem::new);

    public static final RegistryObject<Item> RingOfLesserArsSpell = registerCommonMaterials(ZeroingITEM, "ring_of_lesser_ars_spell", RingOfLesserArsSpellItem::new);
    public static final RegistryObject<Item> RingOfGreaterArsSpell = registerCommonMaterials(ZeroingITEM, "ring_of_greater_ars_spell", RingOfGreaterArsSpellItem::new);
    public static final RegistryObject<Item> RingOfUltimateArsSpell = registerCommonMaterials(ZeroingITEM, "ring_of_ultimate_ars_spell", RingOfUltimateArsSpellItem::new);

    public static final RegistryObject<Item> AmuletOfDiscount = registerCommonMaterials(ZeroingITEM, "amulet_of_discount", AmuletOfDiscountItem::new);
    public static final RegistryObject<Item> AmuletOfSpellDamage = registerCommonMaterials(ZeroingITEM, "amulet_of_spell_damage", AmuletOfSpellDamageItem::new);

    public static final RegistryObject<Item> AmuletOfOrigin = registerCommonMaterials(ZeroingITEM, "amulet_of_origin", AmuletOfOriginItem::new);

    //铁魔法联动饰品
    public static RegistryObject<Item> ArsManaBand;
    public static RegistryObject<Item> ArsManaFlower;

    public static void register(IEventBus bus) {
        ZeroingITEM.register(bus);
        if (ArsExtensions.TERRA_CURIO) {
            ConfluenceITEM.register(bus);
            ArsManaBand = registerCommonMaterials(ConfluenceITEM, "ars_mana_band", ArsManaBandItem::new);
            ArsManaFlower = registerCommonMaterials(ConfluenceITEM, "ars_mana_flower", ArsManaFlowerItem::new);
        }
    }
}