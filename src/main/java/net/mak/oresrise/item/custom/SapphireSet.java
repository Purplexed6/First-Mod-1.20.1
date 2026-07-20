package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class SapphireSet {

    public static final RegistryObject<Item> SAPPHIRE = ModItems.ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROUGH_SAPPHIRE = ModItems.ITEMS.register("rough_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE_SWORD = ModItems.ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ModItems.ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ModItems.ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolTiers.SAPPHIRE, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ModItems.ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolTiers.SAPPHIRE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ModItems.ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolTiers.SAPPHIRE, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE_HELMET = ModItems.ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ModItems.ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ModItems.ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ModItems.ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}