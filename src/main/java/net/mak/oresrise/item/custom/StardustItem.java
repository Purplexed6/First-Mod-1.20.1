package net.mak.oresrise.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class StardustItem extends Item {

    public StardustItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
