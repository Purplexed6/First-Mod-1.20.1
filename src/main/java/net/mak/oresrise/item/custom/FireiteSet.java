package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class FireiteSet {

    public static final RegistryObject<Item> PYROGEL = ModItems.ITEMS.register("pyrogel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIREITE_INGOT = ModItems.ITEMS.register("fireite_ingot",
            () -> new Item(new Item.Properties()));

    public static void register() {}
}