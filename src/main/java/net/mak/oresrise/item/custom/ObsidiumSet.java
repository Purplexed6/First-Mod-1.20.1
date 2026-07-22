package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class ObsidiumSet {

    public static final RegistryObject<Item> OBSIDIAN_ALLOY = ModItems.ITEMS.register("obsidian_alloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_INGOT = ModItems.ITEMS.register("obsidium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_NUGGET = ModItems.ITEMS.register("obsidium_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIAN_SHARD = ModItems.ITEMS.register("obsidian_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIUM_SWORD = ModItems.ITEMS.register("obsidium_sword",
            () -> new SwordItem(ModToolTiers.OBSIDIUM, 4, -2.0f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_PICKAXE = ModItems.ITEMS.register("obsidium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.OBSIDIUM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_AXE = ModItems.ITEMS.register("obsidium_axe",
            () -> new AxeItem(ModToolTiers.OBSIDIUM, 6, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_SHOVEL = ModItems.ITEMS.register("obsidium_shovel",
            () -> new ShovelItem(ModToolTiers.OBSIDIUM, 1, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_HOE = ModItems.ITEMS.register("obsidium_hoe",
            () -> new HoeItem(ModToolTiers.OBSIDIUM, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> OBSIDIUM_HELMET = ModItems.ITEMS.register("obsidium_helmet",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_CHESTPLATE = ModItems.ITEMS.register("obsidium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_LEGGINGS = ModItems.ITEMS.register("obsidium_leggings",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIUM_BOOTS = ModItems.ITEMS.register("obsidium_boots",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}