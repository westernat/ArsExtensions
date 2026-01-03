package com.inolia_zaicek.ars_extensions.Item.Ring;

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

public class RingOfUltimateManaBoostItem extends Item implements ICurioItem {
    public RingOfUltimateManaBoostItem() {
        super((new Properties()).stacksTo(1).fireResistant());
    }
    protected String getTooltipItemName() {
        return BuiltInRegistries.ITEM.getKey(this).getPath();
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
        attributes.put((Attribute) PerkAttributes.MAX_MANA.get(), new AttributeModifier(uuid, getTooltipItemName(), 1, AttributeModifier.Operation.MULTIPLY_BASE));
        attributes.put((Attribute)PerkAttributes.MANA_REGEN_BONUS.get(), new AttributeModifier(uuid, getTooltipItemName(), 0.2, AttributeModifier.Operation.MULTIPLY_BASE));
        return attributes;
    }
}
