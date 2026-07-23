package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import static net.mak.oresrise.item.ModItems.ITEMS;

public class LunarisSet {

    public static final RegistryObject<Item> LUNARIS = ModItems.ITEMS.register("lunaris",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LUNARIS_SWORD = ModItems.ITEMS.register("lunaris_sword",
            () -> new ModSwordItem(ModToolTiers.LUNARIS, 4, -2.3f, new Item.Properties()));
    public static final RegistryObject<Item> LUNARIS_PICKAXE = ModItems.ITEMS.register("lunaris_pickaxe",
            () -> new LunarisPickaxeItem(ModToolTiers.LUNARIS, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> LUNARIS_AXE = ModItems.ITEMS.register("lunaris_axe",
            () -> new LunarisAxeItem(ModToolTiers.LUNARIS, 5.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> LUNARIS_SHOVEL = ModItems.ITEMS.register("lunaris_shovel",
            () -> new LunarisShovelItem(ModToolTiers.LUNARIS, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> LUNARIS_HOE = ModItems.ITEMS.register("lunaris_hoe",
            () -> new HoeItem(ModToolTiers.LUNARIS, -3, 0.0f, new Item.Properties()));

    public static final RegistryObject<Item> LUNARIS_HELMET = ModItems.ITEMS.register("lunaris_helmet",
            () -> new ModArmorItem(ModArmorMaterials.LUNARIS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> LUNARIS_CHESTPLATE = ModItems.ITEMS.register("lunaris_chestplate",
            () -> new ArmorItem(ModArmorMaterials.LUNARIS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LUNARIS_LEGGINGS = ModItems.ITEMS.register("lunaris_leggings",
            () -> new ArmorItem(ModArmorMaterials.LUNARIS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> LUNARIS_BOOTS = ModItems.ITEMS.register("lunaris_boots",
            () -> new ArmorItem(ModArmorMaterials.LUNARIS, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> LUNARIS_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("smithing_template.lunaris_upgrade",
            ModSmithingTemplateItem::createLunarisUpgradeTemplate);

    public static void register() {}
}