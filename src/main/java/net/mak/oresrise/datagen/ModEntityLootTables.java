package net.mak.oresrise.datagen;

import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.Misc;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;

public class ModEntityLootTables extends EntityLootSubProvider {

    public ModEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {

        this.add(EntityType.WITHER_SKELETON,
                LootTable.lootTable()
                        // Main drops
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .add(LootItem.lootTableItem(Misc.WITHERED_BONE.get()))
                                        .add(LootItem.lootTableItem(net.minecraft.world.item.Items.COAL))
                        )
        );
    }
}
