package net.mak.oresrise.datagen.loot;

import java.util.Set;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.*;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // --- 1. Standard Blocks ---
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.ROUGH_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.ROUGH_RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.ROSITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_WITHERITE_BLOCK.get());
        this.dropSelf(ModBlocks.WITHERITE_BLOCK.get());
  //      this.dropSelf(ModBlocks.OBLIVIONITE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUL_BLOCK.get());
        this.dropSelf(ModBlocks.AQUAMARINE_BLOCK.get());
    //    this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.dropSelf(ModBlocks.QUINTESSITE_BLOCK.get());
        this.dropSelf(ModBlocks.HEMOGEM_BLOCK.get());
        this.dropSelf(ModBlocks.CRYPTON_BLOCK.get());
        this.dropSelf(ModBlocks.SOUL_STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.LUNARIS_BLOCK.get());
        this.dropSelf(ModBlocks.FLUXITE_BLOCK.get());
        this.dropSelf(ModBlocks.VOLTIUM_BLOCK.get());
        this.dropSelf(ModBlocks.ONYX_BLOCK.get());
        this.dropSelf(ModBlocks.STARRITE_BLOCK.get());
        // this.dropSelf(ModBlocks.COBALT_BLOCK.get());
      //  this.dropSelf(ModBlocks.RAW_COBALT_BLOCK.get());
        this.dropSelf(ModBlocks.PLATINUM_BLOCK.get());
        this.dropSelf(ModBlocks.MALACHITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_PLATINUM_BLOCK.get());
        this.dropSelf(ModBlocks.STAR_PLATINUM_BLOCK.get());
        this.dropSelf(ModBlocks.ROSE_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.ROUGH_VIBRANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.VIBRANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.KEYOLITE_BLOCK.get());
        this.dropSelf(ModBlocks.OBSIDIUM_BLOCK.get());

        this.add(ModBlocks.SAPPHIRE_ORE.get(), (block) ->
                createOreDrop(block, SapphireSet.ROUGH_SAPPHIRE.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), (block) ->
                createOreDrop(block, SapphireSet.ROUGH_SAPPHIRE.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));

        this.add(ModBlocks.RUBY_ORE.get(), (block) ->
                createOreDrop(block, RubySet.ROUGH_RUBY.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(), (block) ->
                createOreDrop(block, RubySet.ROUGH_RUBY.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));

        this.add(ModBlocks.AQUAMARINE_ORE.get(), (block) ->
                createOreDrop(block, AquamarineSet.ROUGH_AQUAMARINE.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));

        /* this.add(ModBlocks.JADE_ORE.get(), (block) ->
                createOreDrop(block, JadeSet.JADE.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));
        this.add(ModBlocks.DEEPSLATE_JADE_ORE.get(), (block) ->
                createOreDrop(block, JadeSet.JADE.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get())))); */

        this.add(ModBlocks.VIBRANIUM_ORE.get(), (block) ->
                createOreDrop(block, VibraniumSet.ROUGH_VIBRANIUM.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));

        this.add(ModBlocks.MALACHITE_ORE.get(), (block) ->
                createOreDrop(block, MalachiteSet.MALACHITE.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));
        this.add(ModBlocks.DEEPSLATE_MALACHITE_ORE.get(), (block) ->
                createOreDrop(block, MalachiteSet.MALACHITE.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));

        this.add(ModBlocks.STARRITE_ORE.get(), (block) ->
                createOreDrop(block, StarriteSet.STARRITE.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))));

        /* this.add(ModBlocks.COBALT_ORE.get(), (block) ->
                createOreDrop(block, CobaltSet.RAW_COBALT.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get())))); */

        this.add(ModBlocks.PLATINUM_ORE.get(), (block) ->
                createOreDrop(block, PlatinumSet.RAW_PLATINUM.get())
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.COMPRESSED_SLAG.get()))));






        this.add(ModBlocks.WITHERITE_ORE.get(), (block) ->
                createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                        LootItem.lootTableItem(WitheriteSet.RAW_WITHERITE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));

        this.add(ModBlocks.SOUL_ORE.get(), (block) ->
                createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                        LootItem.lootTableItem(SoulSet.SOUL_FRAGMENT.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));

        this.add(ModBlocks.QUINTESSITE_ORE.get(), (block) ->
                createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                        LootItem.lootTableItem(QuintessiteSet.QUINTESSITE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.NETHER_SLAG.get()))));

        this.add(ModBlocks.HEMOGEM_ORE.get(), (block) ->
                createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                        LootItem.lootTableItem(HemoSet.HEMOGEM.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));

        this.add(ModBlocks.FLUXITE_ORE.get(), (block) ->
                createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                        LootItem.lootTableItem(VoltiumSet.FLUXITE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));





        /* this.add(ModBlocks.OBLIVIONITE_ORE.get(), (block) ->
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(OblivioniteSet.OBLIVIONITE_SHARD.get()))) // No fortune applied here
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.ENDER_SLAG.get())))); */

        this.add(ModBlocks.CRYPTON_ORE.get(), (block) ->
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(CryptonSet.CRYPTON_SHARD.get()))) // No fortune applied here
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.ENDER_SLAG.get()))));

        this.add(ModBlocks.LUNARIS_ORE.get(), (block) ->
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(LunarisSet.LUNARIS.get()))) // No fortune applied here
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.ENDER_SLAG.get()))));

        this.add(ModBlocks.ONYX_ORE.get(), (block) ->
                LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(OnyxSet.ONYX.get()))) // No fortune applied here
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f))
                                .add(LootItem.lootTableItem(Misc.ENDER_SLAG.get()))));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
