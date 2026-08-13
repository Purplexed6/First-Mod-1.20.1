package net.mak.oresrise.item;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.custom.*;
import net.mak.oresrise.item.custom.OreDetectorItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.security.Key;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);


    public static final RegistryObject<Item> SAPPHIRE_APPLE = ITEMS.register("sapphire_apple",
            () -> new Item(new Item.Properties().food(ModFoods.SAPPHIRE_APPLE)));
    public static final RegistryObject<Item> TOASTED_BREAD = ITEMS.register("toasted_bread",
            () -> new Item(new Item.Properties().food(ModFoods.TOASTED_BREAD)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE)));
    public static final RegistryObject<Item> CHEESE_WHEEL = ITEMS.register("cheese_wheel",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties().food(ModFoods.PEPPER)));






    public static final RegistryObject<Item> ORE_DETECTOR = ITEMS.register("ore_detector",
            () -> new OreDetectorItem(new Item.Properties().durability(120)));

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
        VoltiumSet.register();
        RubySet.register();
        SapphireSet.register();
        SoulSet.register();
        Misc.register();
        WitheriteSet.register();
        DreadsteelSet.register();
        RositeSet.register();
        RoseGoldSet.register();
        LunarisSet.register();
        HemoSet.register();
        ColossiteSet.register();
        JadeSet.register();
        ScouriumSet.register();
        QuintessiteSet.register();
        HydroSet.register();
        OnyxSet.register();
        PhasmiteSet.register();
        RageiteSet.register();
        CobaltSet.register();
        AmethystSet.register();
        EmeraldSet.register();
        MalachiteSet.register();
        OblivioniteSet.register();
        ShadowSteelSet.register();
        FireiteSet.register();
        ScouriumSet.register();
        ObsidiumSet.register();
        SteelSet.register();
        KeyoliteSet.register();
    }
}
