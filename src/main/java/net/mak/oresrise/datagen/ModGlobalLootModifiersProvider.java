package net.mak.oresrise.datagen;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.Misc;
import net.mak.oresrise.item.custom.WitheriteSet;
import net.mak.oresrise.loot.AddItemModifier;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ExampleMod.MOD_ID);

    }

    @Override
    protected void start() {
        add("raw_witherite_from_wither", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        ResourceLocation.fromNamespaceAndPath("minecraft", "entities/wither")
                ).build()
        }, WitheriteSet.RAW_WITHERITE.get(), 9));

        add("witherite_ingot_from_wither", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath("minecraft", "entities/wither")).build() }, WitheriteSet.WITHERITE_INGOT.get(), 5));

        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath("minecraft", "chests/jungle_temple")).build() }, ModItems.ORE_DETECTOR.get(), 1));

        add("ice_crystal_from_igloos", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        ResourceLocation.fromNamespaceAndPath("minecraft", "chests/igloo")
                ).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, Misc.ICE_CRYSTAL.get() ,1));

        add("ice_crystal_from_snowy_village", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(
                        ResourceLocation.fromNamespaceAndPath("minecraft", "chests/village/village_snowy_house")
                ).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()
        }, Misc.ICE_CRYSTAL.get(), 1));

        add("blaze_slag_from_blaze", new AddItemModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.BLAZE)).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()
        }, Misc.BLAZE_SLAG.get(), 1));

        add("wither_slag_from_wither_skeleton", new AddItemModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.WITHER_SKELETON)).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()
        }, Misc.WITHER_SLAG.get(), 1));

        add("witherite_from_wither_skeleton", new AddItemModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.WITHER_SKELETON)).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()
        }, WitheriteSet.RAW_WITHERITE.get(), 1));

        add("ice_crystal_from_stray", new AddItemModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.STRAY)).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()
        }, Misc.ICE_CRYSTAL.get(), 1));

        add("end_slag_from_enderman", new AddItemModifier(new LootItemCondition[] {
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().of(EntityType.ENDERMAN)).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()
        }, Misc.ENDER_SLAG.get(), 1));
    }
}