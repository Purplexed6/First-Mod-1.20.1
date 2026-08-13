package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class WitheriteSet {

    public static final RegistryObject<Item> RAW_WITHERITE = ModItems.ITEMS.register("raw_witherite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WITHERITE_INGOT = ModItems.ITEMS.register("witherite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WITHERITE_SWORD = ModItems.ITEMS.register("witherite_sword",
            () -> new ModSwordItem(ModToolTiers.WITHERITE, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> WITHERITE_PICKAXE = ModItems.ITEMS.register("witherite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.WITHERITE, 1, -2.7f, new Item.Properties()));
    public static final RegistryObject<Item> WITHERITE_AXE = ModItems.ITEMS.register("witherite_axe",
            () -> new AxeItem(ModToolTiers.WITHERITE, 6, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> WITHERITE_SHOVEL = ModItems.ITEMS.register("witherite_shovel",
            () -> new ShovelItem(ModToolTiers.WITHERITE, 1.5f, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> WITHERITE_HOE = ModItems.ITEMS.register("witherite_hoe",
            () -> new HoeItem(ModToolTiers.WITHERITE, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> WITHERITE_HELMET = ModItems.ITEMS.register("witherite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.WITHERITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WITHERITE_CHESTPLATE = ModItems.ITEMS.register("witherite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.WITHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WITHERITE_LEGGINGS = ModItems.ITEMS.register("witherite_leggings",
            () -> new ArmorItem(ModArmorMaterials.WITHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WITHERITE_BOOTS = ModItems.ITEMS.register("witherite_boots",
            () -> new ArmorItem(ModArmorMaterials.WITHERITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}