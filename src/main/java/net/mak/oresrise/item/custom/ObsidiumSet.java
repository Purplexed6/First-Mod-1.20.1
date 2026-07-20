package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ObsidiumSet {

    public static final RegistryObject<Item> OBSIDIAN_ALLOY = ModItems.ITEMS.register("obsidian_alloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_INGOT = ModItems.ITEMS.register("obsidium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_NUGGET = ModItems.ITEMS.register("obsidium_nugget",
            () -> new Item(new Item.Properties()));

    public static void register() {}
}