package net.mak.oresrise.worldgen;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.worldgen.feature.ModFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;


import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
 //   public static final ResourceKey<ConfiguredFeature<?, ?>> JADE_ORE_KEY = registerKey("jade_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HYDRIC_ORE_KEY = registerKey("hydric_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCOUROUS_ORE_KEY = registerKey("scourous_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RAGING_ORE_KEY = registerKey("platinum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUXITE_ORE_KEY = registerKey("fluxite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_ORE_KEY = registerKey("soul_ore");
   // public static final ResourceKey<ConfiguredFeature<?, ?>> QUINTESSITE_ORE_KEY = registerKey("quintessite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SANGUINE_ORE_KEY = registerKey("sanguine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WAILING_ORE_KEY = registerKey("wailing_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STARDUST_ORE_KEY = registerKey("stardust_ore");

   // public static final ResourceKey<ConfiguredFeature<?, ?>> OBLIVIONITE_ORE_KEY = registerKey("oblivionite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_ORE_KEY = registerKey("lunaris_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COLOSSAL_ORE_KEY = registerKey("colossal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ONYX_ORE_KEY = registerKey("onyx_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PHASMITE_PILLAR_KEY = registerKey("phasmite_pillar");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUGITE_BLOB =
            registerKey("rugite_blob");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> SOULSTONE_BLOB =
      //      registerKey("soulstone_blob");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASTRALITE_BLOB =
            registerKey("astralite_blob");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOIDSTONE_BLOB =
            registerKey("voidstone_blob");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ECHOROCK_BLOB =
            registerKey("echorock_blob");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_MAGMA_BLOB =
      //      registerKey("soul_magma_blob");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_BURIED_TREASURE =
            registerKey("nether_buried_treasure");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest blackstoneReplacables = new BlockMatchTest(Blocks.BLACKSTONE);
        RuleTest soulsoilReplacables = new BlockMatchTest(Blocks.SOUL_SOIL);
        RuleTest smoothBasaltReplaceables = new BlockMatchTest(Blocks.SMOOTH_BASALT);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest obsidianReplaceables = new BlockMatchTest(Blocks.OBSIDIAN);
        RuleTest tuffReplaceables = new BlockMatchTest(Blocks.TUFF);
        RuleTest rugiteReplaceables = new BlockMatchTest(ModBlocks.RUGITE_BLOCK.get());

        List<OreConfiguration.TargetBlockState> overworldSapphireOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
        /* List<OreConfiguration.TargetBlockState> overworldJadeOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.JADE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState())); */

        List<OreConfiguration.TargetBlockState> overworldHydricOres = List.of(
                OreConfiguration.target(
                        stoneReplaceable,
                        ModBlocks.HYDRIC_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldScourousOres = List.of(
                OreConfiguration.target(
                        rugiteReplaceables,
                        ModBlocks.SCOUROUS_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldFluxiteOres = List.of(
                OreConfiguration.target(
                        smoothBasaltReplaceables,
                        ModBlocks.FLUXITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldRagingOres = List.of(
                OreConfiguration.target(
                        tuffReplaceables,
                        ModBlocks.RAGING_ORE.get().defaultBlockState()));


        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSapphireOres, 4, 0.5F));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 4, 0.5F));
     //   register(context, JADE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldJadeOres, 4, 0.5F));
        register(context, HYDRIC_ORE_KEY, Feature.ORE, new OreConfiguration(overworldHydricOres, 4, 0.5F));
        register(context, SCOUROUS_ORE_KEY, Feature.ORE, new OreConfiguration(overworldScourousOres, 4));
        register(context, FLUXITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldFluxiteOres, 6));
        register(context, RAGING_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRagingOres, 4));

        register(context, SOUL_ORE_KEY, Feature.ORE, new OreConfiguration(soulsoilReplacables,
                ModBlocks.SOUL_ORE.get().defaultBlockState(), 4));
        /*register(context, QUINTESSITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.QUINTESSITE_ORE.get().defaultBlockState(), 6));*/
        register(context, SANGUINE_ORE_KEY, Feature.ORE, new OreConfiguration(blackstoneReplacables,
                ModBlocks.SANGUINE_ORE.get().defaultBlockState(), 6));
        register(context, WAILING_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.WAILING_ORE.get().defaultBlockState(), 4));
        register(context, STARDUST_ORE_KEY, Feature.ORE, new OreConfiguration(blackstoneReplacables,
                ModBlocks.STARDUST_ORE.get().defaultBlockState(), 3));

        List<OreConfiguration.TargetBlockState> phasmiteOres = List.of(
                OreConfiguration.target(
                        obsidianReplaceables,
                        ModBlocks.PHASMIC_ORE.get().defaultBlockState()));

        // register(context, OBLIVIONITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
          //       ModBlocks.OBLIVIONITE_ORE.get().defaultBlockState(), 2));
        register(context, LUNARIS_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.LUNARIS_ORE.get().defaultBlockState(), 3));
        register(context, COLOSSAL_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.COLOSSAL_ORE.get().defaultBlockState(), 2));
        register(context, ONYX_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.ONYX_ORE.get().defaultBlockState(), 3));

        register(
                context,
                PHASMITE_PILLAR_KEY,
                ModFeatures.PHASMITE_PILLAR.get(),
                NoneFeatureConfiguration.INSTANCE);

        register(
                context,
                NETHER_BURIED_TREASURE,
                ModFeatures.NETHER_BURIED_TREASURE.get(),
                NoneFeatureConfiguration.INSTANCE);

        register(
                context,
                RUGITE_BLOB,
                ModFeatures.RUGITE_BLOB.get(),
                NoneFeatureConfiguration.INSTANCE
        );

        /*register(
                context,
                SOULSTONE_BLOB,
                ModFeatures.SOULSTONE_BLOB.get(),
                NoneFeatureConfiguration.INSTANCE
        );*/

        register(
                context,
                ASTRALITE_BLOB,
                ModFeatures.ASTRALITE_BLOB.get(),
                NoneFeatureConfiguration.INSTANCE
        );

        register(
                context,
                VOIDSTONE_BLOB,
                ModFeatures.VOIDSTONE_BLOB.get(),
                NoneFeatureConfiguration.INSTANCE
        );

        register(
                context,
                ECHOROCK_BLOB,
                ModFeatures.ECHOROCK_BLOB.get(),
                NoneFeatureConfiguration.INSTANCE
        );

        /*register(
                context,
                SOUL_MAGMA_BLOB,
                ModFeatures.SOUL_MAGMA_BLOB.get(),
                NoneFeatureConfiguration.INSTANCE
        );*/
}

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ExampleMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}