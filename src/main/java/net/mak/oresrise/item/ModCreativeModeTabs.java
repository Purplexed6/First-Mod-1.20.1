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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SapphireSet.SAPPHIRE.get()))
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
                        pOutput.accept(RositeSet.ROSITE_NUGGET.get());
                        pOutput.accept(RositeSet.ROSITE_HELMET.get());
                        pOutput.accept(RositeSet.ROSITE_CHESTPLATE.get());
                        pOutput.accept(RositeSet.ROSITE_LEGGINGS.get());
                        pOutput.accept(RositeSet.ROSITE_BOOTS.get());
                        pOutput.accept(RositeSet.ROSITE_SWORD.get());
                        pOutput.accept(RositeSet.ROSITE_PICKAXE.get());
                        pOutput.accept(RositeSet.ROSITE_AXE.get());
                        pOutput.accept(RositeSet.ROSITE_SHOVEL.get());
                        pOutput.accept(RositeSet.ROSITE_HOE.get());

                        pOutput.accept(KeyoliteSet.ROSAL_COMPOUND.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_INGOT.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_NUGGET.get());

                        pOutput.accept(KeyoliteSet.KEYOLITE_HELMET.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_CHESTPLATE.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_LEGGINGS.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_BOOTS.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_SWORD.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_PICKAXE.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_AXE.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_SHOVEL.get());
                        pOutput.accept(KeyoliteSet.KEYOLITE_HOE.get());

                        pOutput.accept(ObsidiumSet.OBSIDIAN_SHARD.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_HELMET.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_CHESTPLATE.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_LEGGINGS.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_BOOTS.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_SWORD.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_PICKAXE.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_AXE.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_SHOVEL.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_HOE.get());

                        pOutput.accept(ObsidiumSet.OBSIDIUM_INGOT.get());
                        pOutput.accept(ObsidiumSet.OBSIDIUM_NUGGET.get());
                        pOutput.accept(ObsidiumSet.OBSIDIAN_ALLOY.get());

                        pOutput.accept(SoulSet.SOUL_FRAGMENT.get());
                        pOutput.accept(SoulSet.SOUL_CRYSTAL.get());
                        pOutput.accept(SoulSet.SOUL_POWDER.get());
                        pOutput.accept(SoulSet.SOUL_PRISM.get());
                        pOutput.accept(SoulSet.SOULFORGED_SWORD.get());
                        pOutput.accept(SoulSet.SOULFORGED_PICKAXE.get());
                        pOutput.accept(SoulSet.SOULFORGED_AXE.get());
                        pOutput.accept(SoulSet.SOULFORGED_SHOVEL.get());
                        pOutput.accept(SoulSet.SOULFORGED_HOE.get());
                        pOutput.accept(SoulSet.SOULFORGED_HELMET.get());
                        pOutput.accept(SoulSet.SOULFORGED_CHESTPLATE.get());
                        pOutput.accept(SoulSet.SOULFORGED_LEGGINGS.get());
                        pOutput.accept(SoulSet.SOULFORGED_BOOTS.get());

                        pOutput.accept(VoltiumSet.FLUXITE.get());
                        pOutput.accept(VoltiumSet.ELECTRIC_MATTER.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_INGOT.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_NUGGET.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_SWORD.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_PICKAXE.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_AXE.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_SHOVEL.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_HOE.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_HELMET.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_CHESTPLATE.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_LEGGINGS.get());
                        pOutput.accept(VoltiumSet.VOLTIUM_BOOTS.get());

                   //     pOutput.accept(OblivioniteSet.OBLIVIONITE_CRYSTAL.get());
                  //      pOutput.accept(OblivioniteSet.OBLIVIONITE_SHARD.get());

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

                        pOutput.accept(DreadsteelSet.DREADSTEEL_INGOT.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_SWORD.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_PICKAXE.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_AXE.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_SHOVEL.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_HOE.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_HELMET.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_CHESTPLATE.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_LEGGINGS.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_BOOTS.get());
                        pOutput.accept(DreadsteelSet.DREADSTEEL_UPGRADE_SMITHING_TEMPLATE.get());

                        pOutput.accept(HydroSet.HYDRIC_FRAGMENT.get());
                        pOutput.accept(HydroSet.HYDROGEM.get());
                        pOutput.accept(HydroSet.HYDROGEM_SWORD.get());
                        pOutput.accept(HydroSet.HYDROGEM_PICKAXE.get());
                        pOutput.accept(HydroSet.HYDROGEM_AXE.get());
                        pOutput.accept(HydroSet.HYDROGEM_SHOVEL.get());
                        pOutput.accept(HydroSet.HYDROGEM_HOE.get());
                        pOutput.accept(HydroSet.HYDROGEM_HELMET.get());
                        pOutput.accept(HydroSet.HYDROGEM_CHESTPLATE.get());
                        pOutput.accept(HydroSet.HYDROGEM_LEGGINGS.get());
                        pOutput.accept(HydroSet.HYDROGEM_BOOTS.get());

                      /*  pOutput.accept(JadeSet.JADE.get());
                        pOutput.accept(JadeSet.JADE_SWORD.get());
                        pOutput.accept(JadeSet.JADE_PICKAXE.get());
                        pOutput.accept(JadeSet.JADE_AXE.get());
                        pOutput.accept(JadeSet.JADE_SHOVEL.get());
                        pOutput.accept(JadeSet.JADE_HOE.get());
                        pOutput.accept(JadeSet.JADE_HELMET.get());
                        pOutput.accept(JadeSet.JADE_CHESTPLATE.get());
                        pOutput.accept(JadeSet.JADE_LEGGINGS.get());
                        pOutput.accept(JadeSet.JADE_BOOTS.get()); */

                        pOutput.accept(Misc.ECHO_STEEL_INGOT.get());
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

                        /*pOutput.accept(QuintessiteSet.QUINTESSITE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_SWORD.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_PICKAXE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_AXE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_SHOVEL.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_HOE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_HELMET.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_CHESTPLATE.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_LEGGINGS.get());
                        pOutput.accept(QuintessiteSet.QUINTESSITE_BOOTS.get());*/

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
                        pOutput.accept(LunarisSet.LUNARIS_UPGRADE_SMITHING_TEMPLATE.get());

                        pOutput.accept(HemoSet.SANGUINE_FRAGMENT.get());
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

                       // pOutput.accept(FireiteSet.PYROGEL.get());
                      //  pOutput.accept(FireiteSet.FIREITE_INGOT.get());
                       // pOutput.accept(FireiteSet.FIREITE_BLADE.get());

                     //   pOutput.accept(Misc.ICE_CRYSTAL.get());

                        pOutput.accept(SteelSet.STEEL_INGOT.get());
                        pOutput.accept(SteelSet.STEEL_NUGGET.get());
                        pOutput.accept(SteelSet.STEEL_SWORD.get());
                        pOutput.accept(SteelSet.STEEL_PICKAXE.get());
                        pOutput.accept(SteelSet.STEEL_AXE.get());
                        pOutput.accept(SteelSet.STEEL_SHOVEL.get());
                        pOutput.accept(SteelSet.STEEL_HOE.get());
                        pOutput.accept(SteelSet.STEEL_HELMET.get());
                        pOutput.accept(SteelSet.STEEL_CHESTPLATE.get());
                        pOutput.accept(SteelSet.STEEL_LEGGINGS.get());
                        pOutput.accept(SteelSet.STEEL_BOOTS.get());

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

                        pOutput.accept(PhasmiteSet.PHASMIC_SHARD.get());
                        pOutput.accept(PhasmiteSet.PHASMITE.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_SWORD.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_PICKAXE.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_AXE.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_SHOVEL.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_HOE.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_HELMET.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_CHESTPLATE.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_LEGGINGS.get());
                        pOutput.accept(PhasmiteSet.PHASMITE_BOOTS.get());

                    //    pOutput.accept(MalachiteSet.MALACHITE.get());

                        pOutput.accept(RageiteSet.RAGING_FRAGMENT.get());
                        pOutput.accept(RageiteSet.RAGEITE_INGOT.get());
                        pOutput.accept(RageiteSet.RAGEITE_NUGGET.get());
                        pOutput.accept(RageiteSet.RAGING_COMPOUND.get());
                        pOutput.accept(RageiteSet.RAGEITE_SWORD.get());
                        pOutput.accept(RageiteSet.RAGEITE_PICKAXE.get());
                        pOutput.accept(RageiteSet.RAGEITE_AXE.get());
                        pOutput.accept(RageiteSet.RAGEITE_SHOVEL.get());
                        pOutput.accept(RageiteSet.RAGEITE_HOE.get());
                        pOutput.accept(RageiteSet.RAGEITE_HELMET.get());
                        pOutput.accept(RageiteSet.RAGEITE_CHESTPLATE.get());
                        pOutput.accept(RageiteSet.RAGEITE_LEGGINGS.get());
                        pOutput.accept(RageiteSet.RAGEITE_BOOTS.get());

                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_INGOT.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_PICKAXE.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_AXE.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_SHOVEL.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_HOE.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_HELMET.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_CHESTPLATE.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_LEGGINGS.get());
                        pOutput.accept(StarPlatinumSet.STAR_PLATINUM_BOOTS.get());
                        pOutput.accept(StarPlatinumSet.STAR_BREAKER.get());

                      /*  pOutput.accept(CobaltSet.COBALT_INGOT.get());
                        pOutput.accept(CobaltSet.RAW_COBALT.get());
                        pOutput.accept(CobaltSet.COBALT_SWORD.get());
                        pOutput.accept(CobaltSet.COBALT_PICKAXE.get());
                        pOutput.accept(CobaltSet.COBALT_AXE.get());
                        pOutput.accept(CobaltSet.COBALT_SHOVEL.get());
                        pOutput.accept(CobaltSet.COBALT_HOE.get());
                        pOutput.accept(CobaltSet.COBALT_HELMET.get());
                        pOutput.accept(CobaltSet.COBALT_CHESTPLATE.get());
                        pOutput.accept(CobaltSet.COBALT_LEGGINGS.get());
                        pOutput.accept(CobaltSet.COBALT_BOOTS.get()); */

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
                        pOutput.accept(PhasmiteSet.STAR_STAFF.get());
                        pOutput.accept(VoltiumSet.FLUXITE_STAFF.get());

                        pOutput.accept(ModItems.ORE_DETECTOR.get());
                        pOutput.accept(ModItems.TOASTED_BREAD.get());
                        pOutput.accept(ModItems.SAPPHIRE_APPLE.get());
                        pOutput.accept(ModItems.CHEESE.get());
                        pOutput.accept(ModItems.CHEESE_WHEEL.get());
                        pOutput.accept(ModItems.PEPPER.get());
                        pOutput.accept(Misc.DOUGH.get());
                        pOutput.accept(Misc.COMPRESSED_SLAG.get());
                        pOutput.accept(Misc.NETHER_SLAG.get());
                        pOutput.accept(Misc.ENDER_SLAG.get());
                        pOutput.accept(Misc.BLAZE_SLAG.get());
                        pOutput.accept(Misc.WITHER_SLAG.get());
                        pOutput.accept(Misc.IRON_STICK.get());
                        pOutput.accept(Misc.DIAMOND_STICK.get());
                        pOutput.accept(Misc.OBSIDIAN_STICK.get());
                        pOutput.accept(Misc.NETHERITE_STICK.get());
                        pOutput.accept(Misc.STARDUST.get());
                        pOutput.accept(Misc.STARDUST_FRAGMENT.get());
                        pOutput.accept(Misc.WITHERED_BONE.get());
                        pOutput.accept(Misc.NETHERITE_NUGGET.get());
                        pOutput.accept(Misc.NETHERITE_MESH.get());
                        pOutput.accept(Misc.WEEPING_BIT.get());
                        pOutput.accept(Misc.MOLTEN_IRON_INGOT.get());
                        pOutput.accept(VoltiumSet.FLUXITE_ARROW.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> BLOCK_TAB = CREATIVE_MODE_TABS.register("block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SAPPHIRE_BLOCK.get()))
                    .title(Component.translatable("creativetab.block_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.ROSITE_BLOCK.get());

                        pOutput.accept(ModBlocks.ROSE_GOLD_BLOCK.get());

                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());

                        pOutput.accept(ModBlocks.KEYOLITE_BLOCK.get());

                        /*pOutput.accept(ModBlocks.MALACHITE_BLOCK.get());
                        pOutput.accept(ModBlocks.MALACHITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_MALACHITE_ORE.get());*/

                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.ROUGH_RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBY_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

                        //pOutput.accept(ModBlocks.RAW_COBALT_BLOCK.get());
                       // pOutput.accept(ModBlocks.COBALT_BLOCK.get());
                       // pOutput.accept(ModBlocks.COBALT_ORE.get());

                       // pOutput.accept(ModBlocks.JADE_BLOCK.get());
                       // pOutput.accept(ModBlocks.JADE_ORE.get());
                       // pOutput.accept(ModBlocks.DEEPSLATE_JADE_ORE.get());

                        pOutput.accept(ModBlocks.HYDROGEM_BLOCK.get());
                        pOutput.accept(ModBlocks.HYDRIC_ORE.get());

                        pOutput.accept(ModBlocks.VIBRANIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.VIBRANIUM_ORE.get());
                        pOutput.accept(ModBlocks.ROUGH_VIBRANIUM_BLOCK.get());

                        pOutput.accept(ModBlocks.RAGEITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAGING_ORE.get());

                        pOutput.accept(ModBlocks.FLUXITE_BLOCK.get());
                        pOutput.accept(ModBlocks.FLUXITE_ORE.get());
                        pOutput.accept(ModBlocks.VOLTIUM_BLOCK.get());

                        pOutput.accept(ModBlocks.OBSIDIUM_BLOCK.get());

                        pOutput.accept(ModBlocks.PHASMIC_ORE.get());
                        pOutput.accept(ModBlocks.PHASMITE_BLOCK.get());

                        pOutput.accept(ModBlocks.HEMOGEM_BLOCK.get());
                        pOutput.accept(ModBlocks.SANGUINE_ORE.get());

                        pOutput.accept(ModBlocks.WAILING_ORE.get());

                        pOutput.accept(ModBlocks.SOUL_ORE.get());
                        pOutput.accept(ModBlocks.SOUL_BLOCK.get());

                       // pOutput.accept(ModBlocks.QUINTESSITE_BLOCK.get());
                       // pOutput.accept(ModBlocks.QUINTESSITE_ORE.get());

                        pOutput.accept(ModBlocks.WITHERITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_WITHERITE_BLOCK.get());

                        pOutput.accept(ModBlocks.STAR_PLATINUM_BLOCK.get());

                        pOutput.accept(ModBlocks.DREADSTEEL_BLOCK.get());

                        pOutput.accept(ModBlocks.LUNARIS_BLOCK.get());
                        pOutput.accept(ModBlocks.LUNARIS_ORE.get());

                        pOutput.accept(ModBlocks.ONYX_BLOCK.get());
                        pOutput.accept(ModBlocks.ONYX_ORE.get());

                        pOutput.accept(ModBlocks.CRYPTON_BLOCK.get());
                        pOutput.accept(ModBlocks.CRYPTON_ORE.get());

                       // pOutput.accept(ModBlocks.OBLIVIONITE_BLOCK.get());
                       // pOutput.accept(ModBlocks.OBLIVIONITE_ORE.get());
                        })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
