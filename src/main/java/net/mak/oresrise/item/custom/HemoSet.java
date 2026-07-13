package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class HemoSet {

    public static final RegistryObject<Item> HEMOGEM = ModItems.ITEMS.register("hemogem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEMOGEM_SWORD = ModItems.ITEMS.register("hemogem_sword",
            () -> new ModSwordItem(ModToolTiers.HEMOGEM, 4, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> HEMOGEM_PICKAXE = ModItems.ITEMS.register("hemogem_pickaxe",
            () -> new PickaxeItem(ModToolTiers.HEMOGEM, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> HEMOGEM_AXE = ModItems.ITEMS.register("hemogem_axe",
            () -> new AxeItem(ModToolTiers.HEMOGEM, 5.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> HEMOGEM_SHOVEL = ModItems.ITEMS.register("hemogem_shovel",
            () -> new ShovelItem(ModToolTiers.HEMOGEM, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> HEMOGEM_HOE = ModItems.ITEMS.register("hemogem_hoe",
            () -> new HoeItem(ModToolTiers.HEMOGEM, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> HEMOGEM_HELMET = ModItems.ITEMS.register("hemogem_helmet",
            () -> new ModArmorItem(ModArmorMaterials.HEMOGEM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HEMOGEM_CHESTPLATE = ModItems.ITEMS.register("hemogem_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HEMOGEM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HEMOGEM_LEGGINGS = ModItems.ITEMS.register("hemogem_leggings",
            () -> new ArmorItem(ModArmorMaterials.HEMOGEM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HEMOGEM_BOOTS = ModItems.ITEMS.register("hemogem_boots",
            () -> new ArmorItem(ModArmorMaterials.HEMOGEM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}