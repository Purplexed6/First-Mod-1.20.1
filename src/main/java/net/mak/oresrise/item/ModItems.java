package net.mak.oresrise.item;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.entity.ModEntities;
import net.mak.oresrise.item.custom.*;
import net.mak.oresrise.item.custom.OreDetectorItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> SOUL_COOKIE = ITEMS.register("soul_cookie",
            () -> new Item(new Item.Properties().food(ModFoods.SOUL_COOKIE)));
    public static final RegistryObject<Item> OBSIDIAN_COOKIE = ITEMS.register("obsidian_cookie",
            () -> new Item(new Item.Properties().food(ModFoods.OBSIDIAN_COOKIE)));
    public static final RegistryObject<Item> SAPPHIRE_APPLE = ITEMS.register("sapphire_apple",
            () -> new Item(new Item.Properties().food(ModFoods.SAPPHIRE_APPLE)));
    public static final RegistryObject<Item> TOASTED_BREAD = ITEMS.register("toasted_bread",
            () -> new Item(new Item.Properties().food(ModFoods.TOASTED_BREAD)));
    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice",
            () -> new Item(new Item.Properties().food(ModFoods.BREAD_SLICE)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE)));
    public static final RegistryObject<Item> CHEESE_SLICE = ITEMS.register("cheese_slice",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE_SLICE)));
    public static final RegistryObject<Item> CHEESE_WHEEL = ITEMS.register("cheese_wheel",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> GRILLED_CHEESE = ITEMS.register("grilled_cheese",
            () -> new Item(new Item.Properties().food(ModFoods.GRILLED_CHEESE)));
    public static final RegistryObject<Item> CHEESE_SANDWICH = ITEMS.register("cheese_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE_SANDWICH)));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties().food(ModFoods.PEPPER)));
    public static final RegistryObject<Item> FLAMING_PORKCHOP = ITEMS.register("flaming_porkchop",
            () -> new Item(new Item.Properties().food(ModFoods.FLAMING_PORKCHOP)));
    public static final RegistryObject<Item> FLAMING_STEAK = ITEMS.register("flaming_steak",
            () -> new Item(new Item.Properties().food(ModFoods.FLAMING_STEAK)));
    public static final RegistryObject<Item> FLAMING_RABBIT = ITEMS.register("flaming_rabbit",
            () -> new Item(new Item.Properties().food(ModFoods.FLAMING_RABBIT)));
    public static final RegistryObject<Item> FLAMING_CHICKEN = ITEMS.register("flaming_chicken",
            () -> new Item(new Item.Properties().food(ModFoods.FLAMING_CHICKEN)));
    public static final RegistryObject<Item> FLAMING_MUTTON = ITEMS.register("flaming_mutton",
            () -> new Item(new Item.Properties().food(ModFoods.FLAMING_MUTTON)));

    public static final RegistryObject<Item> AMBERWOOD_LOG = ITEMS.register("amberwood_log",
            () -> new BlockItem(ModBlocks.AMBERWOOD_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMBERWOOD_WOOD = ITEMS.register("amberwood_wood",
            () -> new BlockItem(ModBlocks.AMBERWOOD_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_AMBERWOOD_LOG = ITEMS.register("stripped_amberwood_log",
            () -> new BlockItem(ModBlocks.STRIPPED_AMBERWOOD_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_AMBERWOOD_WOOD = ITEMS.register("stripped_amberwood_wood",
            () -> new BlockItem(ModBlocks.STRIPPED_AMBERWOOD_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMBERWOOD_PLANKS = ITEMS.register("amberwood_planks",
            () -> new BlockItem(ModBlocks.AMBERWOOD_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMBERWOOD_LEAVES = ITEMS.register("amberwood_leaves",
            () -> new BlockItem(ModBlocks.AMBERWOOD_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMBERWOOD_SAPLING = ITEMS.register("amberwood_sapling",
            () -> new BlockItem(ModBlocks.AMBERWOOD_SAPLING.get(), new Item.Properties()));



    public static final RegistryObject<Item> PALESLATE = ITEMS.register("paleslate",
            () -> new BlockItem(ModBlocks.PALESLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ASTRALITE = ITEMS.register("astralite",
            () -> new BlockItem(ModBlocks.ASTRALITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> UMBROCK = ITEMS.register("umbrock",
            () -> new BlockItem(ModBlocks.UMBROCK.get(), new Item.Properties()));


    public static final RegistryObject<Item> ORE_DETECTOR = ITEMS.register("ore_detector",
            () -> new OreDetectorItem(new Item.Properties().durability(120)));

    public static final RegistryObject<Item> EMBER_HUSK_SPAWN_EGG = ITEMS.register("ember_husk_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.EMBER_HUSK,
                    0x4d2121, // Background color (Dark Red/Brown)
                    0xf4a442, // Dots color (Orange/Ember)
                    new Item.Properties()));

    public static final RegistryObject<Item> BUCKET =
            ITEMS.register("bucket",
                    () -> new Item(new Item.Properties()
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)
                    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

        // This wakes up the class.
        // DO NOT put "eventBus" inside these parentheses!
        FluxiteSet.register();
        RubySet.register();
        SapphireSet.register();
        SoulSet.register();
        Misc.register();
        ObsidianSet.register();
        WitheriteSet.register();
        SoulSteelSet.register();
        RositeSet.register();
        RoseGoldSet.register();
        LunarisSet.register();
        HemoSet.register();
        CryptonSet.register();
        AlexandriteSet.register();
        ResoniteSet.register();
        QuintessiteSet.register();
        SugiliteSet.register();
        OnyxSet.register();
        StarriteSet.register();
        PlatinumSet.register();
        StarPlatinumSet.register();
        CobaltSet.register();
        AmethystSet.register();
        EmeraldSet.register();
        MalachiteSet.register();
        OblivioniteSet.register();
        ShadowSteelSet.register();
        FireiteSet.register();
        VibraniumSet.register();
    }
}
