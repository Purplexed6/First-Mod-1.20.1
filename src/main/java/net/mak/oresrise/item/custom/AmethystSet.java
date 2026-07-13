package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

public class AmethystSet {

    public static final RegistryObject<Item> AMETHYST_SWORD = ModItems.ITEMS.register("amethyst_sword",
            () -> new SwordItem(ModToolTiers.AMETHYST, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_PICKAXE = ModItems.ITEMS.register("amethyst_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AMETHYST, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_AXE = ModItems.ITEMS.register("amethyst_axe",
            () -> new AxeItem(ModToolTiers.AMETHYST, 5.0f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_SHOVEL = ModItems.ITEMS.register("amethyst_shovel",
            () -> new ShovelItem(ModToolTiers.AMETHYST, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_HOE = ModItems.ITEMS.register("amethyst_hoe",
            () -> new HoeItem(ModToolTiers.AMETHYST, -3, -0.0f, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_HELMET = ModItems.ITEMS.register("amethyst_helmet",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ModItems.ITEMS.register("amethyst_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ModItems.ITEMS.register("amethyst_leggings",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ModItems.ITEMS.register("amethyst_boots",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register() {}
}

