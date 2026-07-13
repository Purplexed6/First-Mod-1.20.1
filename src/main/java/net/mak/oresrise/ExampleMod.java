package net.mak.oresrise;

import com.mojang.logging.LogUtils;
import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.entity.ModEntities;
import net.mak.oresrise.entity.custom.EmberHuskEntity;
import net.mak.oresrise.item.ModCreativeModeTabs;
import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.loot.ModLootModifiers;
import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.network.ShakePacket;
import net.mak.oresrise.sound.ModSounds;
import net.mak.oresrise.worldgen.ModConfiguredFeatures;
import net.mak.oresrise.worldgen.ModPlacedFeatures;
import net.mak.oresrise.worldgen.biome.ModNetherRegion;
import net.mak.oresrise.worldgen.biome.ModTerrablender;
import net.mak.oresrise.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;
import terrablender.api.RegionType;
import terrablender.api.SurfaceRuleManager;

import java.util.Set;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MOD_ID)
public class ExampleMod {
    public static final String MOD_ID = "oresrise";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.register(modEventBus);
        modEventBus.addListener(this::entityAttributes);

        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModTerrablender.registerBiomes();
        SimpleChannel channel;
        ModNetwork.register();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.EMBER_HUSK.get(), EmberHuskEntity.createAttributes().build());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(
                    ModEntities.EMBER_HUSK.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING,
                    Monster::checkMonsterSpawnRules
            );
            // Register the Region with a weight (higher weight = more common)
            terrablender.api.Regions.register(new ModNetherRegion(new ResourceLocation(MOD_ID, "nether"), 5));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, ModSurfaceRules.makeRules());
        });
    }


    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT)
    public class ClientCameraEvents {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
            return ((ForgeSpawnEggItem)stack.getItem()).getColor(tintIndex);
        }, ModItems.EMBER_HUSK_SPAWN_EGG.get());
    }
}
}
