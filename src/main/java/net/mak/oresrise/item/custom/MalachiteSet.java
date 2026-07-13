package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class MalachiteSet {

    public static final RegistryObject<Item> MALACHITE = ModItems.ITEMS.register("malachite",
            () -> new Item(new Item.Properties()));

    public static void register() {}
}