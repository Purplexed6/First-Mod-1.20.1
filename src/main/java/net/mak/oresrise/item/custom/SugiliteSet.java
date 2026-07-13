package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class SugiliteSet {

    public static final RegistryObject<Item> SUGILITE = ModItems.ITEMS.register("sugilite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUGILITE_SWORD = ModItems.ITEMS.register("sugilite_sword",
            () -> new SwordItem(ModToolTiers.SUGILITE, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> SUGILITE_PICKAXE = ModItems.ITEMS.register("sugilite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SUGILITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> SUGILITE_AXE = ModItems.ITEMS.register("sugilite_axe",
            () -> new AxeItem(ModToolTiers.SUGILITE, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SUGILITE_SHOVEL = ModItems.ITEMS.register("sugilite_shovel",
            () -> new ShovelItem(ModToolTiers.SUGILITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> SUGILITE_HOE = ModItems.ITEMS.register("sugilite_hoe",
            () -> new HoeItem(ModToolTiers.SUGILITE, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> SUGILITE_HELMET = ModItems.ITEMS.register("sugilite_helmet",
            () -> new ArmorItem(ModArmorMaterials.SUGILITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SUGILITE_CHESTPLATE = ModItems.ITEMS.register("sugilite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SUGILITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SUGILITE_LEGGINGS = ModItems.ITEMS.register("sugilite_leggings",
            () -> new ArmorItem(ModArmorMaterials.SUGILITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SUGILITE_BOOTS = ModItems.ITEMS.register("sugilite_boots",
            () -> new ArmorItem(ModArmorMaterials.SUGILITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}