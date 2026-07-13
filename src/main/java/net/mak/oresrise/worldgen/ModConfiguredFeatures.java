package net.mak.oresrise.worldgen;

import com.mojang.blaze3d.audio.Library;
import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;


import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALEXANDRITE_ORE_KEY = registerKey("alexandrite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUGILITE_ORE_KEY = registerKey("sugilite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> WITHERITE_ORE_KEY = registerKey("witherite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_ORE_KEY = registerKey("soul_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUINTESSITE_ORE_KEY = registerKey("quintessite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HEMOGEM_ORE_KEY = registerKey("hemogem_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OBLIVIONITE_ORE_KEY = registerKey("oblivionite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUNARIS_ORE_KEY = registerKey("lunaris_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYPTON_ORE_KEY = registerKey("crypton_ore");
    // public static final ResourceKey<ConfiguredFeature<?, ?>> STARRITE_ORE_KEY = registerKey("starrite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBERWOOD_KEY = registerKey("amberwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASTRALITE_SURFACE_KEY = registerKey("astralite_surface");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UMBROCK_FILLER_KEY = registerKey("umbrock_filler");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest blackstoneReplacables = new BlockMatchTest(Blocks.BLACKSTONE);
        RuleTest soulsoilReplacables = new BlockMatchTest(Blocks.SOUL_SOIL);
        RuleTest paleslateReplacables = new BlockMatchTest(ModBlocks.PALESLATE.get());
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest astraliteReplaceables = new BlockMatchTest(ModBlocks.ASTRALITE.get());
        RuleTest grassReplaceable = new BlockMatchTest(Blocks.GRASS_BLOCK);

        List<OreConfiguration.TargetBlockState> overworldSapphireOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldSugiliteOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SUGILITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SUGILITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldAlexandriteOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.ALEXANDRITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> starriteOres = List.of(
                OreConfiguration.target(stoneReplaceable,
                        ModBlocks.STARRITE_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> astraliteReplace = List.of(
                // Target 1: Replaces Grass
                OreConfiguration.target(grassReplaceable, ModBlocks.ASTRALITE.get().defaultBlockState()),
                // Target 2: Replaces Dirt
                OreConfiguration.target(new BlockMatchTest(Blocks.DIRT), ModBlocks.ASTRALITE.get().defaultBlockState()));

        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSapphireOres, 4));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 4));
        register(context, ALEXANDRITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAlexandriteOres, 4));
        register(context, SUGILITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSugiliteOres, 4));
        // register(context, STARRITE_ORE_KEY, Feature.ORE, new OreConfiguration(starriteOres, 9));

        register(context, WITHERITE_ORE_KEY, Feature.ORE, new OreConfiguration(paleslateReplacables,
                ModBlocks.WITHERITE_ORE.get().defaultBlockState(), 30));
        register(context, SOUL_ORE_KEY, Feature.ORE, new OreConfiguration(soulsoilReplacables,
                ModBlocks.SOUL_ORE.get().defaultBlockState(), 3));
        register(context, QUINTESSITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.QUINTESSITE_ORE.get().defaultBlockState(), 3));
        register(context, HEMOGEM_ORE_KEY, Feature.ORE, new OreConfiguration(blackstoneReplacables,
                ModBlocks.HEMOGEM_ORE.get().defaultBlockState(), 3));

        register(context, OBLIVIONITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.OBLIVIONITE_ORE.get().defaultBlockState(), 2));
        register(context, LUNARIS_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.LUNARIS_ORE.get().defaultBlockState(), 3));
        register(context, CRYPTON_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.CRYPTON_ORE.get().defaultBlockState(), 2));

        register(context, AMBERWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.AMBERWOOD_LOG.get()),
                new ForkingTrunkPlacer(5, 4, 2),

                BlockStateProvider.simple(ModBlocks.AMBERWOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

        register(context, ASTRALITE_SURFACE_KEY, Feature.ORE,
                new OreConfiguration(astraliteReplace, 64));

        List<OreConfiguration.TargetBlockState> umbrockReplace = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.UMBROCK.get().defaultBlockState())
        );

        register(context, UMBROCK_FILLER_KEY, Feature.ORE, new OreConfiguration(umbrockReplace, 64)); // Max size 64

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ExampleMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}