package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class ScouriumSet {

    public static final RegistryObject<Item> SCOUROUS_TEAR = ModItems.ITEMS.register("scourous_tear",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM = ModItems.ITEMS.register("scourium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCOUROUS_SUBSTANCE = ModItems.ITEMS.register("scourous_substance",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM_INGOT = ModItems.ITEMS.register("scourium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SCOURIUM_SWORD = ModItems.ITEMS.register("scourium_sword",
            () -> new ScouriumSwordItem(ModToolTiers.SCOURIUM, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM_PICKAXE = ModItems.ITEMS.register("scourium_pickaxe",
            () -> new ModPickaxeItem(ModToolTiers.SCOURIUM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM_AXE = ModItems.ITEMS.register("scourium_axe",
            () -> new AxeItem(ModToolTiers.SCOURIUM, 5.0f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM_SHOVEL = ModItems.ITEMS.register("scourium_shovel",
            () -> new ShovelItem(ModToolTiers.SCOURIUM, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM_HOE = ModItems.ITEMS.register("scourium_hoe",
            () -> new HoeItem(ModToolTiers.SCOURIUM, -3, -0.0f, new Item.Properties()));

    public static final RegistryObject<Item> SCOURIUM_HELMET = ModItems.ITEMS.register("scourium_helmet",
            () -> new ArmorItem(ModArmorMaterials.SCOURIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM_CHESTPLATE = ModItems.ITEMS.register("scourium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SCOURIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM_LEGGINGS = ModItems.ITEMS.register("scourium_leggings",
            () -> new ArmorItem(ModArmorMaterials.SCOURIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SCOURIUM_BOOTS = ModItems.ITEMS.register("scourium_boots",
            () -> new ArmorItem(ModArmorMaterials.SCOURIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}