package com.inolia_zaicek.ars_extensions.Item.Necklece;

import com.google.common.collect.Multimap;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class AmuletOfSpellDamageItem extends Item implements ICurioItem {
    public AmuletOfSpellDamageItem() {
        super((new Properties()).stacksTo(1).fireResistant());
    }

    public int getSpellDamage(ItemStack i) {
        return 3;
    }

    protected String getTooltipItemName() {
        return BuiltInRegistries.ITEM.getKey(this).getPath();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
        attributes.put(PerkAttributes.SPELL_DAMAGE_BONUS.get(), new AttributeModifier(uuid, getTooltipItemName(), (double) this.getSpellDamage(stack), AttributeModifier.Operation.ADDITION));
        return attributes;
    }
}
