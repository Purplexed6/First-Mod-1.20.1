package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class AquamarineSet {

    public static final RegistryObject<Item> AQUAMARINE = ModItems.ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROUGH_AQUAMARINE = ModItems.ITEMS.register("rough_aquamarine",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AQUAMARINE_SWORD = ModItems.ITEMS.register("aquamarine_sword",
            () -> new SwordItem(ModToolTiers.AQUAMARINE, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_PICKAXE = ModItems.ITEMS.register("aquamarine_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AQUAMARINE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_AXE = ModItems.ITEMS.register("aquamarine_axe",
            () -> new AxeItem(ModToolTiers.AQUAMARINE, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_SHOVEL = ModItems.ITEMS.register("aquamarine_shovel",
            () -> new ShovelItem(ModToolTiers.AQUAMARINE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_HOE = ModItems.ITEMS.register("aquamarine_hoe",
            () -> new HoeItem(ModToolTiers.AQUAMARINE, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> AQUAMARINE_HELMET = ModItems.ITEMS.register("aquamarine_helmet",
            () -> new ModArmorItem(ModArmorMaterials.AQUAMARINE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_CHESTPLATE = ModItems.ITEMS.register("aquamarine_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AQUAMARINE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_LEGGINGS = ModItems.ITEMS.register("aquamarine_leggings",
            () -> new ArmorItem(ModArmorMaterials.AQUAMARINE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE_BOOTS = ModItems.ITEMS.register("aquamarine_boots",
            () -> new ArmorItem(ModArmorMaterials.AQUAMARINE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}