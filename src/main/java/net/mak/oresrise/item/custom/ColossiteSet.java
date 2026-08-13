package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class ColossiteSet {

    public static final RegistryObject<Item> COLOSSAL_ROD = ModItems.ITEMS.register("colossal_rod",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COLOSSAL_STAR = ModItems.ITEMS.register("colossal_star",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COLOSSAL_COMPOUND = ModItems.ITEMS.register("colossal_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COLOSSITE_INGOT = ModItems.ITEMS.register("colossite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COLOSSITE_SWORD = ModItems.ITEMS.register("colossite_sword",
            () -> new ColossiteSwordItem(ModToolTiers.COLOSSITE, 4, -2.0f, new Item.Properties()));
    public static final RegistryObject<Item> COLOSSITE_PICKAXE = ModItems.ITEMS.register("colossite_pickaxe",
            () -> new ColossitePickaxeItem(ModToolTiers.COLOSSITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> COLOSSITE_AXE = ModItems.ITEMS.register("colossite_axe",
            () -> new ColossiteAxeItem(ModToolTiers.COLOSSITE, 6, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> COLOSSITE_SHOVEL = ModItems.ITEMS.register("colossite_shovel",
            () -> new ColossiteShovelItem(ModToolTiers.COLOSSITE, 1, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> COLOSSITE_HOE = ModItems.ITEMS.register("colossite_hoe",
            () -> new HoeItem(ModToolTiers.COLOSSITE, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> COLOSSITE_HELMET = ModItems.ITEMS.register("colossite_helmet",
            () -> new ArmorItem(ModArmorMaterials.COLOSSITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COLOSSITE_CHESTPLATE = ModItems.ITEMS.register("colossite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COLOSSITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COLOSSITE_LEGGINGS = ModItems.ITEMS.register("colossite_leggings",
            () -> new ArmorItem(ModArmorMaterials.COLOSSITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COLOSSITE_BOOTS = ModItems.ITEMS.register("colossite_boots",
            () -> new ArmorItem(ModArmorMaterials.COLOSSITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}