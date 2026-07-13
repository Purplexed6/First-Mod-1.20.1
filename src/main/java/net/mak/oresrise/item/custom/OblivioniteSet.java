package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class OblivioniteSet {

    public static final RegistryObject<Item> OBLIVIONITE_SHARD = ModItems.ITEMS.register("oblivionite_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBLIVIONITE_CRYSTAL = ModItems.ITEMS.register("oblivionite_crystal",
            () -> new Item(new Item.Properties()));

    public static void register() {}
}