package net.mak.oresrise.datagen;

import net.mak.oresrise.worldgen.ModBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsProvider extends TagsProvider<Biome> {

    public ModBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, net.minecraft.core.registries.Registries.BIOME, provider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModBiomeTags.HYDROGEM_BIOMES)
                .add(
                        Biomes.FROZEN_OCEAN,
                        Biomes.DEEP_FROZEN_OCEAN,
                        Biomes.FROZEN_RIVER,
                        Biomes.SNOWY_PLAINS,
                        Biomes.ICE_SPIKES
                );
    }
}