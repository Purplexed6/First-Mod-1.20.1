package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class ObsidianSet {

    public static final RegistryObject<Item> OBSIDIAN_SHARD = ModItems.ITEMS.register("obsidian_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIAN_SWORD = ModItems.ITEMS.register("obsidian_sword",
            () -> new SwordItem(ModToolTiers.OBSIDIAN, 4, -2.0f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ModItems.ITEMS.register("obsidian_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OBSIDIAN, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ModItems.ITEMS.register("obsidian_axe",
            () -> new AxeItem(ModToolTiers.OBSIDIAN, 6, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ModItems.ITEMS.register("obsidian_shovel",
            () -> new AxeItem(ModToolTiers.OBSIDIAN, 1, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ModItems.ITEMS.register("obsidian_hoe",
            () -> new AxeItem(ModToolTiers.OBSIDIAN, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIAN_HELMET = ModItems.ITEMS.register("obsidian_helmet",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ModItems.ITEMS.register("obsidian_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ModItems.ITEMS.register("obsidian_leggings",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ModItems.ITEMS.register("obsidian_boots",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}