package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class HydroSet {

    public static final RegistryObject<Item> HYDRIC_FRAGMENT = ModItems.ITEMS.register("hydric_fragment",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEM = ModItems.ITEMS.register("hydrogem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HYDROGEM_SWORD = ModItems.ITEMS.register("hydrogem_sword",
            () -> new HydrogemSwordItem(ModToolTiers.HYDROGEM, 4, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEM_PICKAXE = ModItems.ITEMS.register("hydrogem_pickaxe",
            () -> new HydrogemPickaxeItem(ModToolTiers.HYDROGEM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEM_AXE = ModItems.ITEMS.register("hydrogem_axe",
            () -> new AxeItem(ModToolTiers.HYDROGEM, 5.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEM_SHOVEL = ModItems.ITEMS.register("hydrogem_shovel",
            () -> new ShovelItem(ModToolTiers.HYDROGEM, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEM_HOE = ModItems.ITEMS.register("hydrogem_hoe",
            () -> new HoeItem(ModToolTiers.HYDROGEM, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> HYDROGEM_HELMET = ModItems.ITEMS.register("hydrogem_helmet",
            () -> new ModArmorItem(ModArmorMaterials.HYDROGEM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEM_CHESTPLATE = ModItems.ITEMS.register("hydrogem_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HYDROGEM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEM_LEGGINGS = ModItems.ITEMS.register("hydrogem_leggings",
            () -> new ArmorItem(ModArmorMaterials.HYDROGEM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HYDROGEM_BOOTS = ModItems.ITEMS.register("hydrogem_boots",
            () -> new ArmorItem(ModArmorMaterials.HYDROGEM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}