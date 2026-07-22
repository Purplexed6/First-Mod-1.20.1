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
        public static final TagKey<Block> NEEDS_ROSE_GOLD_TOOL = tag("needs_rose_gold_tool");
        public static final TagKey<Block> NEEDS_ROSITE_TOOL = tag("needs_rosite_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL = tag("needs_steel_tool");
        public static final TagKey<Block> NEEDS_AMETHYST_TOOL = tag("needs_amethyst_tool");
      //  public static final TagKey<Block> NEEDS_COBALT_TOOL = tag("needs_cobalt_tool");
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");
        public static final TagKey<Block> NEEDS_RUBY_TOOL = tag("needs_ruby_tool");
        public static final TagKey<Block> NEEDS_EMERALD_TOOL = tag("needs_emerald_tool");
       // public static final TagKey<Block> NEEDS_JADE_TOOL = tag("needs_jade_tool");
        public static final TagKey<Block> NEEDS_AQUAMARINE_TOOL = tag("needs_aquamarine_tool");
        public static final TagKey<Block> NEEDS_PLATINUM_TOOL = tag("needs_platinum_tool");
        public static final TagKey<Block> NEEDS_OBSIDIUM_TOOL = tag("needs_obsidium_tool");
        public static final TagKey<Block> NEEDS_STARRITE_TOOL = tag("needs_starrite_tool");
        public static final TagKey<Block> NEEDS_RESONITE_TOOL = tag("needs_resonite_tool");
        public static final TagKey<Block> NEEDS_STAR_PLATINUM_TOOL = tag("needs_star_platinum_tool");
        public static final TagKey<Block> NEEDS_VOLTIUM_TOOL = tag("needs_voltium_tool");
        public static final TagKey<Block> NEEDS_KEYOLITE_TOOL = tag("needs_keyolite_tool");
       // public static final TagKey<Block> NEEDS_FIREITE_TOOL = tag("needs_fireite_tool");
        public static final TagKey<Block> NEEDS_HEMOGEM_TOOL = tag("needs_hemogem_tool");
        public static final TagKey<Block> NEEDS_QUINTESSITE_TOOL = tag("needs_quintessite_tool");
        public static final TagKey<Block> NEEDS_WITHERITE_TOOL = tag("needs_witherite_tool");
        public static final TagKey<Block> NEEDS_SOULFORGED_TOOL = tag("needs_soulforged_tool");
        public static final TagKey<Block> NEEDS_SHADOW_STEEL_TOOL = tag("needs_shadow_steel_tool");
        public static final TagKey<Block> NEEDS_SOUL_STEEL_TOOL = tag("needs_soul_steel_tool");
        public static final TagKey<Block> NEEDS_ONYX_TOOL = tag("needs_onyx_tool");
        public static final TagKey<Block> NEEDS_LUNARIS_TOOL = tag("needs_lunaris_tool");
        public static final TagKey<Block> NEEDS_CRYPTON_TOOL = tag("needs_crypton_tool");
        // public static final TagKey<Block> NEEDS_OBLIVIONITE_TOOL = tag("needs_oblivionite_tool");


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