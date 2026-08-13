package net.mak.oresrise.worldgen.feature;

import net.mak.oresrise.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(
                    Registries.FEATURE,
                    ExampleMod.MOD_ID
            );

    public static final RegistryObject<Feature<NoneFeatureConfiguration>>
            PHASMITE_PILLAR =
            FEATURES.register(
                    "phasmite_pillar",
                    () -> new StarritePillarFeature(
                            NoneFeatureConfiguration.CODEC
                    )
            );

    public static final RegistryObject<Feature<NoneFeatureConfiguration>>
            NETHER_BURIED_TREASURE =
            FEATURES.register(
                    "nether_buried_treasure",
                    NetherBuriedTreasureFeature::new
            );

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> RUGITE_BLOB =
            FEATURES.register(
                    "rugite_blob",
                    () -> new RugiteBlobFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SOULSTONE_BLOB =
            FEATURES.register(
                    "soulstone_blob",
                    () -> new SoulstoneBlobFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ASTRALITE_BLOB =
            FEATURES.register(
                    "astralite_blob",
                    () -> new AstraliteBlobFeature(NoneFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SOUL_MAGMA_BLOB =
            FEATURES.register(
                    "soul_magma_blob",
                    () -> new SoulMagmaBlobFeature(NoneFeatureConfiguration.CODEC));
}