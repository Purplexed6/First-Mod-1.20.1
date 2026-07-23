package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import static net.mak.oresrise.item.ModItems.ITEMS;

public class DreadsteelSet {

    public static final RegistryObject<Item> DREADSTEEL_INGOT = ModItems.ITEMS.register("dreadsteel_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DREADSTEEL_SWORD = ModItems.ITEMS.register("dreadsteel_sword",
            () -> new ModSwordItem(ModToolTiers.DREADSTEEL, 5, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> DREADSTEEL_PICKAXE = ModItems.ITEMS.register("dreadsteel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.DREADSTEEL, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> DREADSTEEL_AXE = ModItems.ITEMS.register("dreadsteel_axe",
            () -> new AxeItem(ModToolTiers.DREADSTEEL, 6f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> DREADSTEEL_SHOVEL = ModItems.ITEMS.register("dreadsteel_shovel",
            () -> new ShovelItem(ModToolTiers.DREADSTEEL, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> DREADSTEEL_HOE = ModItems.ITEMS.register("dreadsteel_hoe",
            () -> new HoeItem(ModToolTiers.DREADSTEEL, -4, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> DREADSTEEL_HELMET = ModItems.ITEMS.register("dreadsteel_helmet",
            () -> new ModArmorItem(ModArmorMaterials.DREADSTEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DREADSTEEL_CHESTPLATE = ModItems.ITEMS.register("dreadsteel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.DREADSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DREADSTEEL_LEGGINGS = ModItems.ITEMS.register("dreadsteel_leggings",
            () -> new ArmorItem(ModArmorMaterials.DREADSTEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DREADSTEEL_BOOTS = ModItems.ITEMS.register("dreadsteel_boots",
            () -> new ArmorItem(ModArmorMaterials.DREADSTEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> DREADSTEEL_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("smithing_template.dreadsteel_upgrade",
            ModSmithingTemplateItem::createDreadsteelUpgradeTemplate);

    public static void register() {}
}