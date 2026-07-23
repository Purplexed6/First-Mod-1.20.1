package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class CryptonSet {

    public static final RegistryObject<Item> CRYPTON = ModItems.ITEMS.register("crypton",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYPTON_SHARD = ModItems.ITEMS.register("crypton_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRYPTON_SWORD = ModItems.ITEMS.register("crypton_sword",
            () -> new ChargedSwordItem(ModToolTiers.CRYPTON, 4, -2.0f, new Item.Properties()));
    public static final RegistryObject<Item> CRYPTON_PICKAXE = ModItems.ITEMS.register("crypton_pickaxe",
            () -> new CryptonPickaxeItem(ModToolTiers.CRYPTON, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> CRYPTON_AXE = ModItems.ITEMS.register("crypton_axe",
            () -> new CryptonAxeItem(ModToolTiers.CRYPTON, 6, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> CRYPTON_SHOVEL = ModItems.ITEMS.register("crypton_shovel",
            () -> new CryptonShovelItem(ModToolTiers.CRYPTON, 1, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> CRYPTON_HOE = ModItems.ITEMS.register("crypton_hoe",
            () -> new HoeItem(ModToolTiers.CRYPTON, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> CRYPTON_HELMET = ModItems.ITEMS.register("crypton_helmet",
            () -> new ArmorItem(ModArmorMaterials.CRYPTON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CRYPTON_CHESTPLATE = ModItems.ITEMS.register("crypton_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CRYPTON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CRYPTON_LEGGINGS = ModItems.ITEMS.register("crypton_leggings",
            () -> new ArmorItem(ModArmorMaterials.CRYPTON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CRYPTON_BOOTS = ModItems.ITEMS.register("crypton_boots",
            () -> new ArmorItem(ModArmorMaterials.CRYPTON, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}