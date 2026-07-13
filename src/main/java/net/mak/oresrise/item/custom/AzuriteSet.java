package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class AzuriteSet {
    public static final RegistryObject<Item> AZURITE = ModItems.ITEMS.register("azurite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AZURITE_SWORD = ModItems.ITEMS.register("azurite_sword",
            () -> new SwordItem(ModToolTiers.AZURITE, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_PICKAXE = ModItems.ITEMS.register("azurite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AZURITE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_AXE = ModItems.ITEMS.register("azurite_axe",
            () -> new AxeItem(ModToolTiers.AZURITE, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_SHOVEL = ModItems.ITEMS.register("azurite_shovel",
            () -> new ShovelItem(ModToolTiers.AZURITE, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_HOE = ModItems.ITEMS.register("azurite_hoe",
            () -> new HoeItem(ModToolTiers.AZURITE, -3, 0, new Item.Properties()));

    public static final RegistryObject<Item> AZURITE_HELMET = ModItems.ITEMS.register("azurite_helmet",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_CHESTPLATE = ModItems.ITEMS.register("azurite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_LEGGINGS = ModItems.ITEMS.register("azurite_leggings",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AZURITE_BOOTS = ModItems.ITEMS.register("azurite_boots",
            () -> new ArmorItem(ModArmorMaterials.AZURITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}