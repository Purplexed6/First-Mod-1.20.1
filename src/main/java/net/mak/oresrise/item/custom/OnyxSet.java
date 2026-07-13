package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class OnyxSet {

    public static final RegistryObject<Item> ONYX = ModItems.ITEMS.register("onyx",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ONYX_SWORD = ModItems.ITEMS.register("onyx_sword",
            () -> new OnyxSwordItem(ModToolTiers.ONYX, 4, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_PICKAXE = ModItems.ITEMS.register("onyx_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ONYX, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_AXE = ModItems.ITEMS.register("onyx_axe",
            () -> new AxeItem(ModToolTiers.ONYX, 5, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_SHOVEL = ModItems.ITEMS.register("onyx_shovel",
            () -> new ShovelItem(ModToolTiers.ONYX, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_HOE = ModItems.ITEMS.register("onyx_hoe",
            () -> new HoeItem(ModToolTiers.ONYX, -4, 0, new Item.Properties()));

    public static final RegistryObject<Item> ONYX_HELMET = ModItems.ITEMS.register("onyx_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_CHESTPLATE = ModItems.ITEMS.register("onyx_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_LEGGINGS = ModItems.ITEMS.register("onyx_leggings",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ONYX_BOOTS = ModItems.ITEMS.register("onyx_boots",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}