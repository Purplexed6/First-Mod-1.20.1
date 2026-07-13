package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class PlatinumSet {

    public static final RegistryObject<Item> PLATINUM_INGOT = ModItems.ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PLATINUM = ModItems.ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_SWORD = ModItems.ITEMS.register("platinum_sword",
            () -> new SwordItem(ModToolTiers.PLATINUM, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ModItems.ITEMS.register("platinum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLATINUM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_AXE = ModItems.ITEMS.register("platinum_axe",
            () -> new AxeItem(ModToolTiers.PLATINUM, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ModItems.ITEMS.register("platinum_shovel",
            () -> new ShovelItem(ModToolTiers.PLATINUM, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_HOE = ModItems.ITEMS.register("platinum_hoe",
            () -> new HoeItem(ModToolTiers.PLATINUM, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> PLATINUM_HELMET = ModItems.ITEMS.register("platinum_helmet",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ModItems.ITEMS.register("platinum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS = ModItems.ITEMS.register("platinum_leggings",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_BOOTS = ModItems.ITEMS.register("platinum_boots",
            () -> new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}