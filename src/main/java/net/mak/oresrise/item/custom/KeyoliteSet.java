package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class KeyoliteSet {

    public static final RegistryObject<Item> ROSAL_COMPOUND = ModItems.ITEMS.register("rosal_compound",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_INGOT = ModItems.ITEMS.register("keyolite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_NUGGET = ModItems.ITEMS.register("keyolite_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KEYOLITE_SWORD = ModItems.ITEMS.register("keyolite_sword",
            () -> new ModSwordItem(ModToolTiers.KEYOLITE, 4, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_PICKAXE = ModItems.ITEMS.register("keyolite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.KEYOLITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_AXE = ModItems.ITEMS.register("keyolite_axe",
            () -> new AxeItem(ModToolTiers.KEYOLITE, 5.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_SHOVEL = ModItems.ITEMS.register("keyolite_shovel",
            () -> new ShovelItem(ModToolTiers.KEYOLITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_HOE = ModItems.ITEMS.register("keyolite_hoe",
            () -> new HoeItem(ModToolTiers.KEYOLITE, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> KEYOLITE_HELMET = ModItems.ITEMS.register("keyolite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.KEYOLITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_CHESTPLATE = ModItems.ITEMS.register("keyolite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.KEYOLITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_LEGGINGS = ModItems.ITEMS.register("keyolite_leggings",
            () -> new ArmorItem(ModArmorMaterials.KEYOLITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> KEYOLITE_BOOTS = ModItems.ITEMS.register("keyolite_boots",
            () -> new ArmorItem(ModArmorMaterials.KEYOLITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}