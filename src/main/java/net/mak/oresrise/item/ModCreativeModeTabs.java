package net.mak.oresrise.item;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.*;
import net.mak.oresrise.item.custom.SoulSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ITEM_TAB = CREATIVE_MODE_TABS.register("item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(OblivioniteSet.OBLIVIONITE_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.item_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(SapphireSet.SAPPHIRE.get());
                        pOutput.accept(SapphireSet.ROUGH_SAPPHIRE.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_SWORD.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_AXE.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_SHOVEL.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_HOE.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_HELMET.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_CHESTPLATE.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_LEGGINGS.get());
                        pOutput.accept(SapphireSet.SAPPHIRE_BOOTS.get());

                        pOutput.accept(RoseGoldSet.ROSE_GOLD_INGOT.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_HELMET.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_CHESTPLATE.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_LEGGINGS.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_BOOTS.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_SWORD.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_PICKAXE.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_AXE.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_SHOVEL.get());
                        pOutput.accept(RoseGoldSet.ROSE_GOLD_HOE.get());

                        pOutput.accept(RubySet.RUBY.get());
                        pOutput.accept(RubySet.ROUGH_RUBY.get());
                        pOutput.accept(RubySet.RUBY_HELMET.get());
                        pOutput.accept(RubySet.RUBY_CHESTPLATE.get());
                        pOutput.accept(RubySet.RUBY_LEGGINGS.get());
                        pOutput.accept(RubySet.RUBY_BOOTS.get());
                        pOutput.accept(RubySet.RUBY_SWORD.get());
                        pOutput.accept(RubySet.RUBY_PICKAXE.get());
                        pOutput.accept(RubySet.RUBY_AXE.get());
                        pOutput.accept(RubySet.RUBY_SHOVEL.get());
                        pOutput.accept(RubySet.RUBY_HOE.get());

                        pOutput.accept(RositeSet.ROSITE_INGOT.get());
                        pOutput.accept(RositeSet.ROSITE_HELMET.get());
                        pOutput.accept(RositeSet.ROSITE_CHESTPLATE.get());
                        pOutput.accept(RositeSet.ROSITE_LEGGINGS.get());
                        pOutput.accept(RositeSet.ROSITE_BOOTS.get());
                        pOutput.accept(RositeSet.ROSITE_SWORD.get());
                        pOutput.accept(RositeSet.ROSITE_PICKAXE.get());
                        pOutput.accept(RositeSet.ROSITE_AXE.get());
                        pOutput.accept(RositeSet.ROSITE_SHOVEL.get());
                        pOutput.accept(RositeSet.ROSITE_HOE.get());

                        pOutput.accept(ObsidianSet.OBSIDIAN_SHARD.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_HELMET.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_CHESTPLATE.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_LEGGINGS.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_BOOTS.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_SWORD.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_PICKAXE.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_AXE.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_SHOVEL.get());
                        pOutput.accept(ObsidianSet.OBSIDIAN_HOE.get());

                        pOutput.accept(SoulSet.SOUL_FRAGMENT.get());
                        pOutput.accept(SoulSet.SOUL_CRYSTAL.get());
                        pOutput.accept(SoulSet.SOUL_POWDER.get());
                        pOutput.accept(SoulSet.SOULFORGED_SWORD.get());
                        pOutput.accept(SoulSet.SOULFORGED_PICKAXE.get());
                        pOutput.accept(SoulSet.SOULFORGED_AXE.get());
                        pOutput.accept(SoulSet.SOULFORGED_SHOVEL.get());
                        pOutput.accept(SoulSet.SOULFORGED_HOE.get());
                        pOutput.accept(SoulSet.SOULFORGED_HELMET.get());
                        pOutput.accept(SoulSet.SOULFORGED_CHESTPLATE.get());
                        pOutput.accept(SoulSet.SOULFORGED_LEGGINGS.get());
                        pOutput.accept(SoulSet.SOULFORGED_BOOTS.get());

                        pOutput.accept(FluxiteSet.FLUXITE.get());
                        pOutput.accept(FluxiteSet.FLUXITE_SWORD.get());
                        pOutput.accept(FluxiteSet.FLUXITE_PICKAXE.get());
                        pOutput.accept(FluxiteSet.FLUXITE_AXE.get());
                        pOutput.accept(FluxiteSet.FLUXITE_SHOVEL.get());
                        pOutput.accept(FluxiteSet.FLUXITE_HOE.get());
                        pOutput.accept(FluxiteSet.FLUXITE_HELMET.get());
                        pOutput.accept(FluxiteSet.FLUXITE_CHESTPLATE.get());
                        pOutput.accept(FluxiteSet.FLUXITE_LEGGINGS.get());
                        pOutput.accept(FluxiteSet.FLUXITE_BOOTS.get());

                        pOutput.accept(OblivioniteSet.OBLIVIONITE_CRYSTAL.get());
                        pOutput.accept(OblivioniteSet.OBLIVIONITE_SHARD.get());

                        pOutput.accept(WitheriteSet.RAW_WITHERITE.get());
                        pOutput.accept(WitheriteSet.WITHERITE_INGOT.get());
                        pOutput.accept(WitheriteSet.WITHERITE_SWORD.get());
                        pOutput.accept(WitheriteSet.WITHERITE_PICKAXE.get());
                        pOutput.accept(WitheriteSet.WITHERITE_AXE.get());
                        pOutput.accept(WitheriteSet.WITHERITE_SHOVEL.get());
                        pOutput.accept(WitheriteSet.WITHERITE_HOE.get());
                        pOutput.accept(WitheriteSet.WITHERITE_HELMET.get());
                        pOutput.accept(WitheriteSet.WITHERITE_CHESTPLATE.get());
                        pOutput.accept(WitheriteSet.WITHERITE_LEGGINGS.get());
                        pOutput.accept(WitheriteSet.WITHERITE_BOOTS.get());

                        pOutput.accept(SoulSteelSet.SOUL_STEEL_INGOT.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_SWORD.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_PICKAXE.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_AXE.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_SHOVEL.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_HOE.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_HELMET.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_CHESTPLATE.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_LEGGINGS.get());
                        pOutput.accept(SoulSteelSet.SOUL_STEEL_BOOTS.get());

                        pOutput.accept(SugiliteSet.SUGILITE.get());
                        pOutput.accept(SugiliteSet.SUGILITE_SWORD.get());
                        pOutput.accept(SugiliteSet.SUGILITE_PICKAXE.get());
                        pOutput.accept(SugiliteSet.SUGILITE_AXE.get());
                        pOutput.accept(SugiliteSet.SUGILITE_SHOVEL.get());
                        pOutput.accept(SugiliteSet.SUGILITE_HOE.get());
                        pOutput.accept(SugiliteSet.SUGILITE_HELMET.get());
                        pOutput.accept(SugiliteSet.SUGILITE_CHESTPLATE.get());
                        pOutput.accept(SugiliteSet.SUGILITE_LEGGINGS.get());
                        pOutput.accept(SugiliteSet.SUGILITE_BOOTS.get());

                        pOutput.accept(AlexandriteSet.ALEXANDRITE.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_SWORD.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_PICKAXE.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_AXE.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_SHOVEL.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_HOE.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_HELMET.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_CHESTPLATE.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_LEGGINGS.get());
                        pOutput.accept(AlexandriteSet.ALEXANDRITE_BOOTS.get());

                        pOutput.accept(VibraniumSet.VIBRANIUM.get());
                        pOutput.accept(VibraniumSet.ROUGH_VIBRANIUM.get());

                        pOutput.accept(ResoniteSet.RESONITE_INGOT.get());
                        pOutput.accept(ResoniteSet.RESONITE_SWORD.get());
                        pOutput.accept(ResoniteSet.RESONITE_PICKAXE.get());
                        pOutput.accept(ResoniteSet.RESONITE_AXE.get());
                        pOutput.accept(ResoniteSet.RESONITE_SHOVEL.get());
                        pOutput.accept(ResoniteSet.RESONITE_HOE.get());
                        pOutput.accept(ResoniteSet.RESONITE_HELMET.get());
                        pOutput.accept(ResoniteSet.RESONITE_CHESTPLATE.get());
                        pOutput.accept(ResoniteSet.RESONITE_LEGGINGS.get());
                        pOutput.accept(ResoniteSet.RESONITE_BOOTS.get());

                        pOutput.accept(Misc.ECHO_STEEL_INGOT.get());

                        pOutput.accept(QuintessiteSet.QUINTESSITE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_SWORD.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_PICKAXE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_AXE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_SHOVEL.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_HOE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_HELMET.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_CHESTPLATE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_LEGGINGS.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_BOOTS.get());

                        pOutput.accept(LunarisSet.LUNARIS.get());
                        pOutput.accept(LunarisSet.LUNARIS_SWORD.get());
                        pOutput.accept(LunarisSet.LUNARIS_PICKAXE.get());
                        pOutput.accept(LunarisSet.LUNARIS_AXE.get());
                        pOutput.accept(LunarisSet.LUNARIS_SHOVEL.get());
                        pOutput.accept(LunarisSet.LUNARIS_HOE.get());
                        pOutput.accept(LunarisSet.LUNARIS_HELMET.get());
                        pOutput.accept(LunarisSet.LUNARIS_CHESTPLATE.get());
                        pOutput.accept(LunarisSet.LUNARIS_LEGGINGS.get());
                        pOutput.accept(LunarisSet.LUNARIS_BOOTS.get());

                        pOutput.accept(HemoSet.HEMOGEM.get());
                        pOutput.accept(HemoSet.HEMOGEM_SWORD.get());
                        pOutput.accept(HemoSet.HEMOGEM_PICKAXE.get());
                        pOutput.accept(HemoSet.HEMOGEM_AXE.get());
                        pOutput.accept(HemoSet.HEMOGEM_SHOVEL.get());
                        pOutput.accept(HemoSet.HEMOGEM_HOE.get());
                        pOutput.accept(HemoSet.HEMOGEM_HELMET.get());
                        pOutput.accept(HemoSet.HEMOGEM_CHESTPLATE.get());
                        pOutput.accept(HemoSet.HEMOGEM_LEGGINGS.get());
                        pOutput.accept(HemoSet.HEMOGEM_BOOTS.get());

                        pOutput.accept(FireiteSet.PYROGEL.get());
                        pOutput.accept(FireiteSet.FIREITE_INGOT.get());
                        pOutput.accept(FireiteSet.FIREITE_BLADE.get());
                        pOutput.accept(FireiteSet.FIREITE_UPGRADE_SMITHING_TEMPLATE.get());

                        pOutput.accept(CryptonSet.CRYPTON.get());
                        pOutput.accept(CryptonSet.CRYPTON_SHARD.get());
                        pOutput.accept(CryptonSet.CRYPTON_SWORD.get());
                        pOutput.accept(CryptonSet.CRYPTON_PICKAXE.get());
                        pOutput.accept(CryptonSet.CRYPTON_AXE.get());
                        pOutput.accept(CryptonSet.CRYPTON_SHOVEL.get());
                        pOutput.accept(CryptonSet.CRYPTON_HOE.get());
                        pOutput.accept(CryptonSet.CRYPTON_HELMET.get());
                        pOutput.accept(CryptonSet.CRYPTON_CHESTPLATE.get());
                        pOutput.accept(CryptonSet.CRYPTON_LEGGINGS.get());
                        pOutput.accept(CryptonSet.CRYPTON_BOOTS.get());

                        pOutput.accept(OnyxSet.ONYX.get());
                        pOutput.accept(OnyxSet.ONYX_SWORD.get());
                        pOutput.accept(OnyxSet.ONYX_PICKAXE.get());
                        pOutput.accept(OnyxSet.ONYX_AXE.get());
                        pOutput.accept(OnyxSet.ONYX_SHOVEL.get());
                        pOutput.accept(OnyxSet.ONYX_HOE.get());
                        pOutput.accept(OnyxSet.ONYX_HELMET.get());
                        pOutput.accept(OnyxSet.ONYX_CHESTPLATE.get());
                        pOutput.accept(OnyxSet.ONYX_LEGGINGS.get());
                        pOutput.accept(OnyxSet.ONYX_BOOTS.get());

                        pOutput.accept(StarriteSet.STARRITE.get());
                        pOutput.accept(StarriteSet.STARRITE_SWORD.get());
                        pOutput.accept(StarriteSet.STARRITE_PICKAXE.get());
                        pOutput.accept(StarriteSet.STARRITE_AXE.get());
                        pOutput.accept(StarriteSet.STARRITE_SHOVEL.get());
                        pOutput.accept(StarriteSet.STARRITE_HOE.get());
                        pOutput.accept(StarriteSet.STARRITE_HELMET.get());
                        pOutput.accept(StarriteSet.STARRITE_CHESTPLATE.get());
                        pOutput.accept(StarriteSet.STARRITE_LEGGINGS.get());
                        pOutput.accept(StarriteSet.STARRITE_BOOTS.get());

                        pOutput.accept(MalachiteSet.MALACHITE.get());

                        pOutput.accept(PlatinumSet.PLATINUM_INGOT.get());
                        pOutput.accept(PlatinumSet.RAW_PLATINUM.get());
                        pOutput.accept(PlatinumSet.PLATINUM_SWORD.get());
                        pOutput.accept(PlatinumSet.PLATINUM_PICKAXE.get());
                        pOutput.accept(PlatinumSet.PLATINUM_AXE.get());
                        pOutput.accept(PlatinumSet.PLATINUM_SHOVEL.get());
                        pOutput.accept(PlatinumSet.PLATINUM_HOE.get());
                        pOutput.accept(PlatinumSet.PLATINUM_HELMET.get());
                        pOutput.accept(PlatinumSet.PLATINUM_CHESTPLATE.get());
                        pOutput.accept(PlatinumSet.PLATINUM_LEGGINGS.get());
                        pOutput.accept(PlatinumSet.PLATINUM_BOOTS.get());

                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_INGOT.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_SWORD.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_PICKAXE.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_AXE.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_SHOVEL.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_HOE.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_HELMET.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_CHESTPLATE.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_LEGGINGS.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_BOOTS.get());
                        pOutput.accept(StarPlatinumSet.STAR_BREAKER.get());

                        pOutput.accept(CobaltSet.COBALT_INGOT.get());
                        pOutput.accept(CobaltSet.RAW_COBALT.get());
                        pOutput.accept(CobaltSet.COBALT_SWORD.get());
                        pOutput.accept(CobaltSet.COBALT_PICKAXE.get());
                        pOutput.accept(CobaltSet.COBALT_AXE.get());
                        pOutput.accept(CobaltSet.COBALT_SHOVEL.get());
                        pOutput.accept(CobaltSet.COBALT_HOE.get());
                        pOutput.accept(CobaltSet.COBALT_HELMET.get());
                        pOutput.accept(CobaltSet.COBALT_CHESTPLATE.get());
                        pOutput.accept(CobaltSet.COBALT_LEGGINGS.get());
                        pOutput.accept(CobaltSet.COBALT_BOOTS.get());

                        pOutput.accept(AmethystSet.AMETHYST_SWORD.get());
                        pOutput.accept(AmethystSet.AMETHYST_PICKAXE.get());
                        pOutput.accept(AmethystSet.AMETHYST_AXE.get());
                        pOutput.accept(AmethystSet.AMETHYST_SHOVEL.get());
                        pOutput.accept(AmethystSet.AMETHYST_HOE.get());
                        pOutput.accept(AmethystSet.AMETHYST_HELMET.get());
                        pOutput.accept(AmethystSet.AMETHYST_CHESTPLATE.get());
                        pOutput.accept(AmethystSet.AMETHYST_LEGGINGS.get());
                        pOutput.accept(AmethystSet.AMETHYST_BOOTS.get());

                        pOutput.accept(EmeraldSet.EMERALD_SWORD.get());
                        pOutput.accept(EmeraldSet.EMERALD_PICKAXE.get());
                        pOutput.accept(EmeraldSet.EMERALD_AXE.get());
                        pOutput.accept(EmeraldSet.EMERALD_SHOVEL.get());
                        pOutput.accept(EmeraldSet.EMERALD_HOE.get());
                        pOutput.accept(EmeraldSet.EMERALD_HELMET.get());
                        pOutput.accept(EmeraldSet.EMERALD_CHESTPLATE.get());
                        pOutput.accept(EmeraldSet.EMERALD_LEGGINGS.get());
                        pOutput.accept(EmeraldSet.EMERALD_BOOTS.get());

                        pOutput.accept(ShadowSteelSet.SHADOW_DAGGER.get());
                        pOutput.accept(StarriteSet.STAR_STAFF.get());

                        pOutput.accept(ModItems.ORE_DETECTOR.get());
                        pOutput.accept(ModItems.TOASTED_BREAD.get());
                        pOutput.accept(ModItems.SAPPHIRE_APPLE.get());
                        pOutput.accept(ModItems.OBSIDIAN_COOKIE.get());
                        pOutput.accept(ModItems.SOUL_COOKIE.get());
                        pOutput.accept(ModItems.BREAD_SLICE.get());
                        pOutput.accept(ModItems.CHEESE_SLICE.get());
                        pOutput.accept(ModItems.GRILLED_CHEESE.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.CHEESE.get());
                        pOutput.accept(ModItems.CHEESE_WHEEL.get());
                        pOutput.accept(ModItems.CHEESE_SANDWICH.get());
                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                        pOutput.accept(ModItems.PEPPER.get());
                        pOutput.accept(ModItems.FLAMING_MUTTON.get());
                        pOutput.accept(ModItems.FLAMING_CHICKEN.get());
                        pOutput.accept(ModItems.FLAMING_PORKCHOP.get());
                        pOutput.accept(ModItems.FLAMING_STEAK.get());
                        pOutput.accept(ModItems.FLAMING_RABBIT.get());
                        pOutput.accept(Misc.DOUGH.get());
                        pOutput.accept(Misc.COMPRESSED_SLAG.get());
                        pOutput.accept(Misc.NETHER_SLAG.get());
                        pOutput.accept(Misc.ENDER_SLAG.get());
                        pOutput.accept(Misc.BLAZE_SLAG.get());
                        pOutput.accept(Misc.WITHER_SLAG.get());
                        pOutput.accept(Misc.IRON_STICK.get());
                        pOutput.accept(Misc.NETHERITE_STICK.get());
                        pOutput.accept(Misc.STARDUST.get());
                        pOutput.accept(Misc.WITHERED_BONE.get());

                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());

                        pOutput.accept(ModItems.EMBER_HUSK_SPAWN_EGG.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> BLOCK_TAB = CREATIVE_MODE_TABS.register("block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.OBLIVIONITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.block_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.PALESLATE.get());
                        pOutput.accept(ModBlocks.ASTRALITE.get());
                        pOutput.accept(ModBlocks.UMBROCK.get());

                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModBlocks.MOD_PORTAL.get());

                        pOutput.accept(ModBlocks.AMBERWOOD_LOG.get());
                        pOutput.accept(ModBlocks.AMBERWOOD_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_AMBERWOOD_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_AMBERWOOD_WOOD.get());
                        pOutput.accept(ModBlocks.AMBERWOOD_PLANKS.get());
                        pOutput.accept(ModBlocks.AMBERWOOD_LEAVES.get());
                        pOutput.accept(ModBlocks.AMBERWOOD_SAPLING.get());

                        pOutput.accept(ModBlocks.ROSITE_BLOCK.get());

                        pOutput.accept(ModBlocks.ROSE_GOLD_BLOCK.get());

                        pOutput.accept(ModBlocks.MALACHITE_BLOCK.get());
                        pOutput.accept(ModBlocks.MALACHITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_MALACHITE_ORE.get());

                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.ROUGH_RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBY_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

                        pOutput.accept(ModBlocks.RAW_COBALT_BLOCK.get());
                        pOutput.accept(ModBlocks.COBALT_BLOCK.get());
                        pOutput.accept(ModBlocks.COBALT_ORE.get());

                        pOutput.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());

                        pOutput.accept(ModBlocks.SUGILITE_BLOCK.get());
                        pOutput.accept(ModBlocks.SUGILITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SUGILITE_ORE.get());

                        pOutput.accept(ModBlocks.VIBRANIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.VIBRANIUM_ORE.get());
                        pOutput.accept(ModBlocks.ROUGH_VIBRANIUM_BLOCK.get());

                        pOutput.accept(ModBlocks.PLATINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_PLATINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.PLATINUM_ORE.get());

                        pOutput.accept(ModBlocks.FLUXITE_BLOCK.get());
                        pOutput.accept(ModBlocks.FLUXITE_ORE.get());

                        pOutput.accept(ModBlocks.STARRITE_ORE.get());
                        pOutput.accept(ModBlocks.STARRITE_BLOCK.get());

                        pOutput.accept(ModBlocks.HEMOGEM_BLOCK.get());
                        pOutput.accept(ModBlocks.HEMOGEM_ORE.get());

                        pOutput.accept(ModBlocks.SOUL_ORE.get());
                        pOutput.accept(ModBlocks.SOUL_BLOCK.get());

                        pOutput.accept(ModBlocks.QUINTESSITE_BLOCK.get());
                        pOutput.accept(ModBlocks.QUINTESSITE_ORE.get());

                        pOutput.accept(ModBlocks.WITHERITE_BLOCK.get());
                        pOutput.accept(ModBlocks.WITHERITE_ORE.get());
                        pOutput.accept(ModBlocks.RAW_WITHERITE_BLOCK.get());

                        pOutput.accept(ModBlocks.STAR_PLATINUM_BLOCK.get());

                        pOutput.accept(ModBlocks.SOUL_STEEL_BLOCK.get());

                        pOutput.accept(ModBlocks.LUNARIS_BLOCK.get());
                        pOutput.accept(ModBlocks.LUNARIS_ORE.get());

                        pOutput.accept(ModBlocks.ONYX_BLOCK.get());
                        pOutput.accept(ModBlocks.ONYX_ORE.get());

                        pOutput.accept(ModBlocks.CRYPTON_BLOCK.get());
                        pOutput.accept(ModBlocks.CRYPTON_ORE.get());

                        pOutput.accept(ModBlocks.OBLIVIONITE_BLOCK.get());
                        pOutput.accept(ModBlocks.OBLIVIONITE_ORE.get());
                        })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
