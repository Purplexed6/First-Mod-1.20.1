package net.mak.oresrise;

import com.mojang.logging.LogUtils;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.item.ModCreativeModeTabs;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.loot.ModLootModifiers;
import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.sound.ModSounds;
import net.mak.oresrise.worldgen.feature.ModFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MOD_ID)
public class ExampleMod {
    public static final String MOD_ID = "oresrise";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);

        ModFeatures.FEATURES.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        SimpleChannel channel;
        ModNetwork.register();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }


    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
