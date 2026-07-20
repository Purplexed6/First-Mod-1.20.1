package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class SteelSet {

    public static final RegistryObject<Item> STEEL_INGOT = ModItems.ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NUGGET = ModItems.ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEEL_SWORD = ModItems.ITEMS.register("steel_sword",
            () -> new SwordItem(ModToolTiers.STEEL, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PICKAXE = ModItems.ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL, 2, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_AXE = ModItems.ITEMS.register("steel_axe",
            () -> new AxeItem(ModToolTiers.STEEL, 6, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SHOVEL = ModItems.ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModToolTiers.STEEL, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HOE = ModItems.ITEMS.register("steel_hoe",
            () -> new HoeItem(ModToolTiers.STEEL, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HELMET = ModItems.ITEMS.register("steel_helmet",
            () -> new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ModItems.ITEMS.register("steel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ModItems.ITEMS.register("steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_BOOTS = ModItems.ITEMS.register("steel_boots",
            () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}