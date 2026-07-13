package net.mak.oresrise.datagen;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(SapphireSet.SAPPHIRE);
        simpleItem(SapphireSet.ROUGH_SAPPHIRE);
        handheldItem(SapphireSet.SAPPHIRE_SWORD);
        handheldItem(SapphireSet.SAPPHIRE_PICKAXE);
        handheldItem(SapphireSet.SAPPHIRE_AXE);
        handheldItem(SapphireSet.SAPPHIRE_SHOVEL);
        handheldItem(SapphireSet.SAPPHIRE_HOE);
        simpleItem(SapphireSet.SAPPHIRE_HELMET);
        simpleItem(SapphireSet.SAPPHIRE_CHESTPLATE);
        simpleItem(SapphireSet.SAPPHIRE_LEGGINGS);
        simpleItem(SapphireSet.SAPPHIRE_BOOTS);

        simpleItem(RoseGoldSet.ROSE_GOLD_INGOT);
        simpleItem(RoseGoldSet.ROSE_GOLD_HELMET);
        simpleItem(RoseGoldSet.ROSE_GOLD_CHESTPLATE);
        simpleItem(RoseGoldSet.ROSE_GOLD_LEGGINGS);
        simpleItem(RoseGoldSet.ROSE_GOLD_BOOTS);
        handheldItem(RoseGoldSet.ROSE_GOLD_SWORD);
        handheldItem(RoseGoldSet.ROSE_GOLD_PICKAXE);
        handheldItem(RoseGoldSet.ROSE_GOLD_AXE);
        handheldItem(RoseGoldSet.ROSE_GOLD_SHOVEL);
        handheldItem(RoseGoldSet.ROSE_GOLD_HOE);

        simpleItem(RubySet.RUBY);
        simpleItem(RubySet.ROUGH_RUBY);
        simpleItem(RubySet.RUBY_HELMET);
        simpleItem(RubySet.RUBY_CHESTPLATE);
        simpleItem(RubySet.RUBY_LEGGINGS);
        simpleItem(RubySet.RUBY_BOOTS);
        handheldItem(RubySet.RUBY_SWORD);
        handheldItem(RubySet.RUBY_PICKAXE);
        handheldItem(RubySet.RUBY_AXE);
        handheldItem(RubySet.RUBY_SHOVEL);
        handheldItem(RubySet.RUBY_HOE);

        simpleItem(RositeSet.ROSITE_INGOT);
        simpleItem(RositeSet.ROSITE_HELMET);
        simpleItem(RositeSet.ROSITE_CHESTPLATE);
        simpleItem(RositeSet.ROSITE_LEGGINGS);
        simpleItem(RositeSet.ROSITE_BOOTS);
        handheldItem(RositeSet.ROSITE_SWORD);
        handheldItem(RositeSet.ROSITE_PICKAXE);
        handheldItem(RositeSet.ROSITE_AXE);
        handheldItem(RositeSet.ROSITE_SHOVEL);
        handheldItem(RositeSet.ROSITE_HOE);

        simpleItem(SoulSteelSet.SOUL_STEEL_INGOT);
        handheldItem(SoulSteelSet.SOUL_STEEL_SWORD);
        handheldItem(SoulSteelSet.SOUL_STEEL_PICKAXE);
        handheldItem(SoulSteelSet.SOUL_STEEL_AXE);
        handheldItem(SoulSteelSet.SOUL_STEEL_SHOVEL);
        handheldItem(SoulSteelSet.SOUL_STEEL_HOE);
        simpleItem(SoulSteelSet.SOUL_STEEL_HELMET);
        simpleItem(SoulSteelSet.SOUL_STEEL_CHESTPLATE);
        simpleItem(SoulSteelSet.SOUL_STEEL_LEGGINGS);
        simpleItem(SoulSteelSet.SOUL_STEEL_BOOTS);

        simpleItem(OblivioniteSet.OBLIVIONITE_SHARD);
        simpleItem(OblivioniteSet.OBLIVIONITE_CRYSTAL);

        simpleItem(WitheriteSet.WITHERITE_INGOT);
        simpleItem(WitheriteSet.RAW_WITHERITE);
        simpleItem(WitheriteSet.WITHERITE_HELMET);
        simpleItem(WitheriteSet.WITHERITE_CHESTPLATE);
        simpleItem(WitheriteSet.WITHERITE_LEGGINGS);
        simpleItem(WitheriteSet.WITHERITE_BOOTS);
        handheldItem(WitheriteSet.WITHERITE_SWORD);
        handheldItem(WitheriteSet.WITHERITE_PICKAXE);
        handheldItem(WitheriteSet.WITHERITE_AXE);
        handheldItem(WitheriteSet.WITHERITE_SHOVEL);
        handheldItem(WitheriteSet.WITHERITE_HOE);

        simpleItem(SoulSet.SOUL_FRAGMENT);
        simpleItem(SoulSet.SOUL_CRYSTAL);
        simpleItem(SoulSet.SOUL_POWDER);
        simpleItem(SoulSet.SOULFORGED_HELMET);
        simpleItem(SoulSet.SOULFORGED_CHESTPLATE);
        simpleItem(SoulSet.SOULFORGED_LEGGINGS);
        simpleItem(SoulSet.SOULFORGED_BOOTS);
        handheldItem(SoulSet.SOULFORGED_SWORD);
        handheldItem(SoulSet.SOULFORGED_PICKAXE);
        handheldItem(SoulSet.SOULFORGED_AXE);
        handheldItem(SoulSet.SOULFORGED_SHOVEL);
        handheldItem(SoulSet.SOULFORGED_HOE);

        simpleItem(ModItems.ORE_DETECTOR);
        simpleItem(Misc.COMPRESSED_SLAG);
        simpleItem(Misc.NETHER_SLAG);
        simpleItem(Misc.ENDER_SLAG);
        simpleItem(Misc.BLAZE_SLAG);
        simpleItem(Misc.WITHER_SLAG);
        simpleItem(Misc.IRON_STICK);
        simpleItem(Misc.OBSIDIAN_STICK);
        simpleItem(Misc.NETHERITE_STICK);
        simpleItem(Misc.DOUGH);
        simpleItem(Misc.STARDUST);

        simpleItem(ObsidianSet.OBSIDIAN_SHARD);
        simpleItem(ObsidianSet.OBSIDIAN_HELMET);
        simpleItem(ObsidianSet.OBSIDIAN_CHESTPLATE);
        simpleItem(ObsidianSet.OBSIDIAN_LEGGINGS);
        simpleItem(ObsidianSet.OBSIDIAN_BOOTS);
        handheldItem(ObsidianSet.OBSIDIAN_SWORD);
        handheldItem(ObsidianSet.OBSIDIAN_PICKAXE);
        handheldItem(ObsidianSet.OBSIDIAN_AXE);
        handheldItem(ObsidianSet.OBSIDIAN_SHOVEL);
        handheldItem(ObsidianSet.OBSIDIAN_HOE);

        simpleItem(ModItems.TOASTED_BREAD);
        simpleItem(ModItems.SAPPHIRE_APPLE);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.STRAWBERRY_SEEDS);
        simpleItem(ModItems.SOUL_COOKIE);
        simpleItem(ModItems.OBSIDIAN_COOKIE);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.CHEESE_WHEEL);
        simpleItem(ModItems.CHEESE_SLICE);
        simpleItem(ModItems.CHEESE_SANDWICH);
        simpleItem(ModItems.BREAD_SLICE);
        simpleItem(ModItems.GRILLED_CHEESE);
        simpleItem(ModItems.PEPPER);
        simpleItem(ModItems.FLAMING_MUTTON);
        simpleItem(ModItems.FLAMING_CHICKEN);
        simpleItem(ModItems.FLAMING_PORKCHOP);
        simpleItem(ModItems.FLAMING_RABBIT);
        simpleItem(ModItems.FLAMING_STEAK);

        simpleItem(AzuriteSet.AZURITE);
        handheldItem(AzuriteSet.AZURITE_SWORD);
        handheldItem(AzuriteSet.AZURITE_PICKAXE);
        handheldItem(AzuriteSet.AZURITE_AXE);
        handheldItem(AzuriteSet.AZURITE_SHOVEL);
        handheldItem(AzuriteSet.AZURITE_HOE);
        simpleItem(AzuriteSet.AZURITE_HELMET);
        simpleItem(AzuriteSet.AZURITE_CHESTPLATE);
        simpleItem(AzuriteSet.AZURITE_LEGGINGS);
        simpleItem(AzuriteSet.AZURITE_BOOTS);

        simpleItem(AmberSet.AMBER);
        simpleItem(AmberSet.ROUGH_AMBER);
        handheldItem(AmberSet.AMBER_SWORD);
        handheldItem(AmberSet.AMBER_PICKAXE);
        handheldItem(AmberSet.AMBER_AXE);
        handheldItem(AmberSet.AMBER_SHOVEL);
        handheldItem(AmberSet.AMBER_HOE);
        simpleItem(AmberSet.AMBER_HELMET);
        simpleItem(AmberSet.AMBER_CHESTPLATE);
        simpleItem(AmberSet.AMBER_LEGGINGS);
        simpleItem(AmberSet.AMBER_BOOTS);

        simpleItem(CryptonSet.CRYPTON);
        simpleItem(CryptonSet.CRYPTON_SHARD);
        handheldItem(CryptonSet.CRYPTON_SWORD);
        handheldItem(CryptonSet.CRYPTON_PICKAXE);
        handheldItem(CryptonSet.CRYPTON_AXE);
        handheldItem(CryptonSet.CRYPTON_SHOVEL);
        handheldItem(CryptonSet.CRYPTON_HOE);
        simpleItem(CryptonSet.CRYPTON_HELMET);
        simpleItem(CryptonSet.CRYPTON_CHESTPLATE);
        simpleItem(CryptonSet.CRYPTON_LEGGINGS);
        simpleItem(CryptonSet.CRYPTON_BOOTS);

        simpleItem(SugiliteSet.SUGILITE);
        simpleItem(SugiliteSet.SUGILITE_HELMET);
        simpleItem(SugiliteSet.SUGILITE_CHESTPLATE);
        simpleItem(SugiliteSet.SUGILITE_LEGGINGS);
        simpleItem(SugiliteSet.SUGILITE_BOOTS);
        handheldItem(SugiliteSet.SUGILITE_SWORD);
        handheldItem(SugiliteSet.SUGILITE_PICKAXE);
        handheldItem(SugiliteSet.SUGILITE_AXE);
        handheldItem(SugiliteSet.SUGILITE_SHOVEL);
        handheldItem(SugiliteSet.SUGILITE_HOE);

        simpleItem(QuintessiteSet.QUINTESSITE);
        handheldItem(QuintessiteSet.QUINTESSITE_SWORD);
        handheldItem(QuintessiteSet.QUINTESSITE_PICKAXE);
        handheldItem(QuintessiteSet.QUINTESSITE_AXE);
        handheldItem(QuintessiteSet.QUINTESSITE_SHOVEL);
        handheldItem(QuintessiteSet.QUINTESSITE_HOE);
        simpleItem(QuintessiteSet.QUINTESSITE_HELMET);
        simpleItem(QuintessiteSet.QUINTESSITE_CHESTPLATE);
        simpleItem(QuintessiteSet.QUINTESSITE_LEGGINGS);
        simpleItem(QuintessiteSet.QUINTESSITE_BOOTS);

        simpleItem(HemoSet.HEMOGEM);
        simpleItem(HemoSet.HEMOGEM_HELMET);
        simpleItem(HemoSet.HEMOGEM_CHESTPLATE);
        simpleItem(HemoSet.HEMOGEM_LEGGINGS);
        simpleItem(HemoSet.HEMOGEM_BOOTS);
        handheldItem(HemoSet.HEMOGEM_SWORD);
        handheldItem(HemoSet.HEMOGEM_PICKAXE);
        handheldItem(HemoSet.HEMOGEM_AXE);
        handheldItem(HemoSet.HEMOGEM_SHOVEL);
        handheldItem(HemoSet.HEMOGEM_HOE);

        simpleItem(AlexandriteSet.ALEXANDRITE);
        simpleItem(AlexandriteSet.ALEXANDRITE_HELMET);
        simpleItem(AlexandriteSet.ALEXANDRITE_CHESTPLATE);
        simpleItem(AlexandriteSet.ALEXANDRITE_LEGGINGS);
        simpleItem(AlexandriteSet.ALEXANDRITE_BOOTS);
        handheldItem(AlexandriteSet.ALEXANDRITE_SWORD);
        handheldItem(AlexandriteSet.ALEXANDRITE_PICKAXE);
        handheldItem(AlexandriteSet.ALEXANDRITE_AXE);
        handheldItem(AlexandriteSet.ALEXANDRITE_SHOVEL);
        handheldItem(AlexandriteSet.ALEXANDRITE_HOE);

        simpleItem(LunarisSet.LUNARIS);
        simpleItem(LunarisSet.LUNARIS_HELMET);
        simpleItem(LunarisSet.LUNARIS_CHESTPLATE);
        simpleItem(LunarisSet.LUNARIS_LEGGINGS);
        simpleItem(LunarisSet.LUNARIS_BOOTS);
        handheldItem(LunarisSet.LUNARIS_SWORD);
        handheldItem(LunarisSet.LUNARIS_PICKAXE);
        handheldItem(LunarisSet.LUNARIS_AXE);
        handheldItem(LunarisSet.LUNARIS_SHOVEL);
        handheldItem(LunarisSet.LUNARIS_HOE);

        simpleItem(OnyxSet.ONYX);
        handheldItem(OnyxSet.ONYX_SWORD);
        handheldItem(OnyxSet.ONYX_PICKAXE);
        handheldItem(OnyxSet.ONYX_AXE);
        handheldItem(OnyxSet.ONYX_SHOVEL);
        handheldItem(OnyxSet.ONYX_HOE);
        simpleItem(OnyxSet.ONYX_HELMET);
        simpleItem(OnyxSet.ONYX_CHESTPLATE);
        simpleItem(OnyxSet.ONYX_LEGGINGS);
        simpleItem(OnyxSet.ONYX_BOOTS);

        simpleItem(StarriteSet.STARRITE);
        simpleItem(StarriteSet.STARRITE_HELMET);
        simpleItem(StarriteSet.STARRITE_CHESTPLATE);
        simpleItem(StarriteSet.STARRITE_LEGGINGS);
        simpleItem(StarriteSet.STARRITE_BOOTS);
        handheldItem(StarriteSet.STARRITE_SWORD);
        handheldItem(StarriteSet.STARRITE_PICKAXE);
        handheldItem(StarriteSet.STARRITE_AXE);
        handheldItem(StarriteSet.STARRITE_SHOVEL);
        handheldItem(StarriteSet.STARRITE_HOE);

        simpleItem(MalachiteSet.MALACHITE);

        simpleItem(FireiteSet.PYROGEL);
        simpleItem(FireiteSet.FIREITE_INGOT);

        simpleItem(PlatinumSet.RAW_PLATINUM);
        simpleItem(PlatinumSet.PLATINUM_INGOT);
        simpleItem(PlatinumSet.PLATINUM_HELMET);
        simpleItem(PlatinumSet.PLATINUM_CHESTPLATE);
        simpleItem(PlatinumSet.PLATINUM_LEGGINGS);
        simpleItem(PlatinumSet.PLATINUM_BOOTS);
        handheldItem(PlatinumSet.PLATINUM_SWORD);
        handheldItem(PlatinumSet.PLATINUM_PICKAXE);
        handheldItem(PlatinumSet.PLATINUM_AXE);
        handheldItem(PlatinumSet.PLATINUM_SHOVEL);
        handheldItem(PlatinumSet.PLATINUM_HOE);

        simpleItem(StarPlatinumSet.STAR_PLATINUM_INGOT);
        simpleItem(StarPlatinumSet.STAR_PLATINUM_HELMET);
        simpleItem(StarPlatinumSet.STAR_PLATINUM_CHESTPLATE);
        simpleItem(StarPlatinumSet.STAR_PLATINUM_LEGGINGS);
        simpleItem(StarPlatinumSet.STAR_PLATINUM_BOOTS);
        handheldItem(StarPlatinumSet.STAR_PLATINUM_SWORD);
        handheldItem(StarPlatinumSet.STAR_PLATINUM_PICKAXE);
        handheldItem(StarPlatinumSet.STAR_PLATINUM_AXE);
        handheldItem(StarPlatinumSet.STAR_PLATINUM_SHOVEL);
        handheldItem(StarPlatinumSet.STAR_PLATINUM_HOE);

        simpleItem(CobaltSet.RAW_COBALT);
        simpleItem(CobaltSet.COBALT_INGOT);
        handheldItem(CobaltSet.COBALT_SWORD);
        handheldItem(CobaltSet.COBALT_PICKAXE);
        handheldItem(CobaltSet.COBALT_AXE);
        handheldItem(CobaltSet.COBALT_SHOVEL);
        handheldItem(CobaltSet.COBALT_HOE);
        simpleItem(CobaltSet.COBALT_HELMET);
        simpleItem(CobaltSet.COBALT_CHESTPLATE);
        simpleItem(CobaltSet.COBALT_LEGGINGS);
        simpleItem(CobaltSet.COBALT_BOOTS);

        simpleItem(AmethystSet.AMETHYST_HELMET);
        simpleItem(AmethystSet.AMETHYST_CHESTPLATE);
        simpleItem(AmethystSet.AMETHYST_LEGGINGS);
        simpleItem(AmethystSet.AMETHYST_BOOTS);
        handheldItem(AmethystSet.AMETHYST_SWORD);
        handheldItem(AmethystSet.AMETHYST_PICKAXE);
        handheldItem(AmethystSet.AMETHYST_AXE);
        handheldItem(AmethystSet.AMETHYST_SHOVEL);
        handheldItem(AmethystSet.AMETHYST_HOE);

        simpleItem(EmeraldSet.EMERALD_HELMET);
        simpleItem(EmeraldSet.EMERALD_CHESTPLATE);
        simpleItem(EmeraldSet.EMERALD_LEGGINGS);
        simpleItem(EmeraldSet.EMERALD_BOOTS);
        handheldItem(EmeraldSet.EMERALD_SWORD);
        handheldItem(EmeraldSet.EMERALD_PICKAXE);
        handheldItem(EmeraldSet.EMERALD_AXE);
        handheldItem(EmeraldSet.EMERALD_SHOVEL);
        handheldItem(EmeraldSet.EMERALD_HOE);

        handheldItem(ShadowSteelSet.SHADOW_DAGGER);
        handheldItem(StarriteSet.STAR_STAFF);

        withExistingParent("astralite",
                new ResourceLocation(ExampleMod.MOD_ID, "block/astralite"));

        withExistingParent("umbrock",
                new ResourceLocation(ExampleMod.MOD_ID, "block/umbrock"));

        withExistingParent("paleslate",
                new ResourceLocation(ExampleMod.MOD_ID, "block/paleslate"));

        withExistingParent("sound_block",
                new ResourceLocation(ExampleMod.MOD_ID, "block/sound_block"));

        withExistingParent("amberwood_log",
                new ResourceLocation(ExampleMod.MOD_ID, "block/amberwood_log"));
        withExistingParent("amberwood_wood",
                new ResourceLocation(ExampleMod.MOD_ID, "block/amberwood_wood"));
        withExistingParent("stripped_amberwood_log",
                new ResourceLocation(ExampleMod.MOD_ID, "block/stripped_amberwood_log"));
        withExistingParent("stripped_amberwood_wood",
                new ResourceLocation(ExampleMod.MOD_ID, "block/stripped_amberwood_wood"));
        withExistingParent("amberwood_planks",
                new ResourceLocation(ExampleMod.MOD_ID, "block/amberwood_planks"));
        withExistingParent("amberwood_leaves",
                new ResourceLocation(ExampleMod.MOD_ID, "block/amberwood_leaves"));

        simpleItem(ModItems.EMBER_HUSK_SPAWN_EGG);

        saplingItem(ModBlocks.AMBERWOOD_SAPLING);
        withExistingParent(ModBlocks.AMBERWOOD_SAPLING.getId().getPath(),
                new ResourceLocation(ExampleMod.MOD_ID, "block/amberwood_sapling"));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ExampleMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ExampleMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ExampleMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}