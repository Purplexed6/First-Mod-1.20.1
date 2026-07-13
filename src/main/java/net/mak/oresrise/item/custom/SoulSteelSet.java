package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class SoulSteelSet {

    public static final RegistryObject<Item> SOUL_STEEL_INGOT = ModItems.ITEMS.register("soul_steel_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOUL_STEEL_SWORD = ModItems.ITEMS.register("soul_steel_sword",
            () -> new ModSwordItem(ModToolTiers.SOUL_STEEL, 5, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_PICKAXE = ModItems.ITEMS.register("soul_steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SOUL_STEEL, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_AXE = ModItems.ITEMS.register("soul_steel_axe",
            () -> new AxeItem(ModToolTiers.SOUL_STEEL, 6f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_SHOVEL = ModItems.ITEMS.register("soul_steel_shovel",
            () -> new ShovelItem(ModToolTiers.SOUL_STEEL, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_HOE = ModItems.ITEMS.register("soul_steel_hoe",
            () -> new HoeItem(ModToolTiers.SOUL_STEEL, -4, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> SOUL_STEEL_HELMET = ModItems.ITEMS.register("soul_steel_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SOUL_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_CHESTPLATE = ModItems.ITEMS.register("soul_steel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SOUL_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_LEGGINGS = ModItems.ITEMS.register("soul_steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.SOUL_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_STEEL_BOOTS = ModItems.ITEMS.register("soul_steel_boots",
            () -> new ArmorItem(ModArmorMaterials.SOUL_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}