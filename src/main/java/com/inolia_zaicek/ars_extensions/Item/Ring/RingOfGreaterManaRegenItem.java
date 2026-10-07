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

public class RingOfGreaterManaRegenItem extends Item implements ICurioItem {
    public RingOfGreaterManaRegenItem() {
        super((new Properties()).stacksTo(1).fireResistant());
    }

    public int getMaxManaBoost(ItemStack i) {
        return 10;
    }

    public int getManaRegenBonus(ItemStack i) {
        return 4;
    }

    protected String getTooltipItemName() {
        return BuiltInRegistries.ITEM.getKey(this).getPath();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
        attributes.put(PerkAttributes.MAX_MANA.get(), new AttributeModifier(uuid, getTooltipItemName(), this.getMaxManaBoost(stack), AttributeModifier.Operation.ADDITION));
        attributes.put(PerkAttributes.MANA_REGEN_BONUS.get(), new AttributeModifier(uuid, getTooltipItemName(), this.getManaRegenBonus(stack), AttributeModifier.Operation.ADDITION));
        return attributes;
    }
}
