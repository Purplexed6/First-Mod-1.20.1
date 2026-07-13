package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class AmberSet {

    public static final RegistryObject<Item> ROUGH_AMBER = ModItems.ITEMS.register("rough_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMBER = ModItems.ITEMS.register("amber",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AMBER_SWORD = ModItems.ITEMS.register("amber_sword",
            () -> new SwordItem(ModToolTiers.AMBER, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AMBER_PICKAXE = ModItems.ITEMS.register("amber_pickaxe",
            () -> new ModPickaxeItem(ModToolTiers.AMBER, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> AMBER_AXE = ModItems.ITEMS.register("amber_axe",
            () -> new AxeItem(ModToolTiers.AMBER, 5.0f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> AMBER_SHOVEL = ModItems.ITEMS.register("amber_shovel",
            () -> new ShovelItem(ModToolTiers.AMBER, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> AMBER_HOE = ModItems.ITEMS.register("amber_hoe",
            () -> new HoeItem(ModToolTiers.AMBER, -3, -0.0f, new Item.Properties()));

    public static final RegistryObject<Item> AMBER_HELMET = ModItems.ITEMS.register("amber_helmet",
            () -> new ArmorItem(ModArmorMaterials.AMBER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AMBER_CHESTPLATE = ModItems.ITEMS.register("amber_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AMBER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AMBER_LEGGINGS = ModItems.ITEMS.register("amber_leggings",
            () -> new ArmorItem(ModArmorMaterials.AMBER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AMBER_BOOTS = ModItems.ITEMS.register("amber_boots",
            () -> new ArmorItem(ModArmorMaterials.AMBER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}