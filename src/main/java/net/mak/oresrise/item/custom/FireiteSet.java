package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.mak.oresrise.item.ModItems.ITEMS;

public class FireiteSet {

    public static final RegistryObject<Item> PYROGEL = ITEMS.register("pyrogel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIREITE_INGOT = ITEMS.register("fireite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FIREITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("smithing_template.fireite_upgrade",
            ModSmithingTemplateItem::createFireiteUpgradeTemplate);

    public static final RegistryObject<Item> FIREITE_BLADE = ModItems.ITEMS.register("fireite_blade",
            () -> new SwordItem(ModToolTiers.FIREITE, 4, -2.4f, new Item.Properties()));

    public static void register() {}
}