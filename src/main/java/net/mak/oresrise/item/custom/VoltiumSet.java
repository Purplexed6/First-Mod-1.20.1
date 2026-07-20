package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class VoltiumSet {
    public static final RegistryObject<Item> FLUXITE = ModItems.ITEMS.register("fluxite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELECTRIC_MATTER = ModItems.ITEMS.register("electric_matter",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_INGOT = ModItems.ITEMS.register("voltium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_NUGGET = ModItems.ITEMS.register("voltium_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOLTIUM_SWORD = ModItems.ITEMS.register("fluxite_sword",
            () -> new SwordItem(ModToolTiers.VOLTIUM, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_PICKAXE = ModItems.ITEMS.register("fluxite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.VOLTIUM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_AXE = ModItems.ITEMS.register("fluxite_axe",
            () -> new AxeItem(ModToolTiers.VOLTIUM, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_SHOVEL = ModItems.ITEMS.register("fluxite_shovel",
            () -> new ShovelItem(ModToolTiers.VOLTIUM, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_HOE = ModItems.ITEMS.register("fluxite_hoe",
            () -> new HoeItem(ModToolTiers.VOLTIUM, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> VOLTIUM_HELMET = ModItems.ITEMS.register("fluxite_helmet",
            () -> new ArmorItem(ModArmorMaterials.VOLTIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_CHESTPLATE = ModItems.ITEMS.register("fluxite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.VOLTIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_LEGGINGS = ModItems.ITEMS.register("fluxite_leggings",
            () -> new ArmorItem(ModArmorMaterials.VOLTIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> VOLTIUM_BOOTS = ModItems.ITEMS.register("fluxite_boots",
            () -> new ArmorItem(ModArmorMaterials.VOLTIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}