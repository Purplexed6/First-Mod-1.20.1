package net.mak.oresrise.entity;

import net.mak.oresrise.ExampleMod; // Make sure this matches your main mod class name
import net.mak.oresrise.entity.custom.EmberHuskEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MOD_ID);

    public static final RegistryObject<EntityType<EmberHuskEntity>> EMBER_HUSK =
            ENTITIES.register("ember_husk", () -> EntityType.Builder.of(EmberHuskEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build("ember_husk"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
