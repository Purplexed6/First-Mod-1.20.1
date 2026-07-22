package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class RoseGoldSet {

    public static final RegistryObject<Item> ROSE_GOLD_INGOT = ModItems.ITEMS.register("rose_gold_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROSE_GOLD_HELMET = ModItems.ITEMS.register("rose_gold_helmet",
            () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD_INGOT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_CHESTPLATE = ModItems.ITEMS.register("rose_gold_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD_INGOT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_LEGGINGS = ModItems.ITEMS.register("rose_gold_leggings",
            () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD_INGOT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_BOOTS = ModItems.ITEMS.register("rose_gold_boots",
            () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD_INGOT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ROSE_GOLD_SWORD = ModItems.ITEMS.register("rose_gold_sword",
            () -> new SwordItem(ModToolTiers.ROSE_GOLD_INGOT, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_PICKAXE = ModItems.ITEMS.register("rose_gold_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ROSE_GOLD_INGOT, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_AXE = ModItems.ITEMS.register("rose_gold_axe",
            () -> new AxeItem(ModToolTiers.ROSE_GOLD_INGOT, 5, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_SHOVEL = ModItems.ITEMS.register("rose_gold_shovel",
            () -> new ShovelItem(ModToolTiers.ROSE_GOLD_INGOT, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ROSE_GOLD_HOE = ModItems.ITEMS.register("rose_gold_hoe",
            () -> new AxeItem(ModToolTiers.ROSE_GOLD_INGOT, -3, -0.0f, new Item.Properties()));

    public static void register() {}
}