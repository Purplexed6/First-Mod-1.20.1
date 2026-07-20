package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class KeyoliteSet {

    public static final RegistryObject<Item> ROSAL_COMPOUND = ModItems.ITEMS.register("rosal_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_INGOT = ModItems.ITEMS.register("keyolite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_NUGGET = ModItems.ITEMS.register("keyolite_nugget",
            () -> new Item(new Item.Properties()));

    public static void register() {}
}