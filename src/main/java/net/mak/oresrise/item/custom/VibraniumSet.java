package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class VibraniumSet {

    public static final RegistryObject<Item> ROUGH_VIBRANIUM = ModItems.ITEMS.register("rough_vibranium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VIBRANIUM = ModItems.ITEMS.register("vibranium",
            () -> new Item(new Item.Properties()));

    public static void register() {}
}