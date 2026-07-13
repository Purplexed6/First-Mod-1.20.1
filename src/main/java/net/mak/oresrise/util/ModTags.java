package net.mak.oresrise.util;

import net.mak.oresrise.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ORE_DETECTOR_VALUABLES = tag("ore_detector_valuables");
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = tag("needs_netherite_tool");
        public static final TagKey<Block> NEEDS_SOUL_STEEL_TOOL = tag("needs_soul_steel_tool");
        public static final TagKey<Block> NEEDS_CRYPTON_TOOL = tag("needs_crypton_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ExampleMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ExampleMod.MOD_ID, name));
        }
    }
}