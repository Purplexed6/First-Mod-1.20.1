package net.mak.oresrise.item.custom;

import net.mak.oresrise.ExampleMod;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private static final Component FIREITE_UPGRADE = Component.translatable(
                    Util.makeDescriptionId("item", new ResourceLocation(ExampleMod.MOD_ID, "smithing_template.fireite_upgrade")))
            .withStyle(TITLE_FORMAT);
    private static final Component FIREITE_UPGRADE_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", new ResourceLocation(ExampleMod.MOD_ID, "smithing_template.fireite_upgrade.applies_to")))
            .withStyle(DESCRIPTION_FORMAT);
    private static final Component FIREITE_UPGRADE_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", new ResourceLocation(ExampleMod.MOD_ID, "smithing_template.fireite_upgrade.ingredients")))
            .withStyle(DESCRIPTION_FORMAT);
    private static final Component FIREITE_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", new ResourceLocation(ExampleMod.MOD_ID, "smithing_template.fireite_upgrade.base_slot_description")));
    private static final Component FIREITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", new ResourceLocation(ExampleMod.MOD_ID, "smithing_template.fireite_upgrade.additions_slot_description")));

    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("minecraft", "item/empty_slot_ingot");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("minecraft", "item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("minecraft", "item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("minecraft", "item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("minecraft", "item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("minecraft", "item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("minecraft", "item/empty_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("minecraft", "item/empty_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("minecraft", "item/empty_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("minecraft", "item/empty_slot_boots");

    public ModSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpgradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditionalSlotEmptyIcons) {
        super(pAppliesTo, pIngredients, pUpgradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditionalSlotEmptyIcons);
    }

    public static SmithingTemplateItem createFireiteUpgradeTemplate() {
        return new SmithingTemplateItem(FIREITE_UPGRADE_APPLIES_TO, FIREITE_UPGRADE_INGREDIENTS, FIREITE_UPGRADE, FIREITE_UPGRADE_BASE_SLOT_DESCRIPTION,
                FIREITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createFireiteUpgradeIconList(), createFireiteUpgradeMaterialList());
    }

    private static List<ResourceLocation> createFireiteUpgradeIconList() {
        return List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<ResourceLocation> createFireiteUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
