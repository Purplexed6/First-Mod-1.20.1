package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class FluxiteSet {
    public static final RegistryObject<Item> FLUXITE = ModItems.ITEMS.register("fluxite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLUXITE_SWORD = ModItems.ITEMS.register("fluxite_sword",
            () -> new SwordItem(ModToolTiers.FLUXITE, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> FLUXITE_PICKAXE = ModItems.ITEMS.register("fluxite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FLUXITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> FLUXITE_AXE = ModItems.ITEMS.register("fluxite_axe",
            () -> new AxeItem(ModToolTiers.FLUXITE, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> FLUXITE_SHOVEL = ModItems.ITEMS.register("fluxite_shovel",
            () -> new ShovelItem(ModToolTiers.FLUXITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> FLUXITE_HOE = ModItems.ITEMS.register("fluxite_hoe",
            () -> new HoeItem(ModToolTiers.FLUXITE, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> FLUXITE_HELMET = ModItems.ITEMS.register("fluxite_helmet",
            () -> new ArmorItem(ModArmorMaterials.FLUXITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> FLUXITE_CHESTPLATE = ModItems.ITEMS.register("fluxite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.FLUXITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> FLUXITE_LEGGINGS = ModItems.ITEMS.register("fluxite_leggings",
            () -> new ArmorItem(ModArmorMaterials.FLUXITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> FLUXITE_BOOTS = ModItems.ITEMS.register("fluxite_boots",
            () -> new ArmorItem(ModArmorMaterials.FLUXITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}