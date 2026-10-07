package com.inolia_zaicek.ars_extensions.Item.Necklece;

import com.hollingsworth.arsnouveau.common.items.curios.DiscountRing;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AmuletOfDiscountItem extends DiscountRing implements ICurioItem {
    @Override
    public int getManaDiscount() {
        return 20;
    }

    @Override
    public int getMaxManaBoost(ItemStack i) {
        return 5;
    }

    @Override
    public int getManaRegenBonus(ItemStack i) {
        return 0;
    }

    protected String getTooltipItemName() {
        return BuiltInRegistries.ITEM.getKey(this).getPath();
    }
}
