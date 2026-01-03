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

public class RingOfGreaterManaBoostItem extends Item implements ICurioItem {
    public RingOfGreaterManaBoostItem() {
        super((new Properties()).stacksTo(1).fireResistant());
    }
    public int getMaxManaBoost(ItemStack i) {
        return 70;
    }
    public int getManaRegenBonus(ItemStack i) {
        return 1;
    }
    protected String getTooltipItemName() {
        return BuiltInRegistries.ITEM.getKey(this).getPath();
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributes = ICurioItem.super.getAttributeModifiers(slotContext, uuid, stack);
        attributes.put((Attribute) PerkAttributes.MAX_MANA.get(), new AttributeModifier(uuid, getTooltipItemName(), (double)this.getMaxManaBoost(stack), AttributeModifier.Operation.ADDITION));
        attributes.put((Attribute)PerkAttributes.MANA_REGEN_BONUS.get(), new AttributeModifier(uuid, getTooltipItemName(), (double)this.getManaRegenBonus(stack), AttributeModifier.Operation.ADDITION));
        return attributes;
    }
}
