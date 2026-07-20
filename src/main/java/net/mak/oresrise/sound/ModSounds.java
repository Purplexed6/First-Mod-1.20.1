package net.mak.oresrise.sound;

import net.mak.oresrise.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.entity.Entity.MovementEmission.SOUNDS;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ExampleMod.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");

    public static final RegistryObject<SoundEvent> STAR_PLATINUM_IMPACT =
            registerSoundEvents("star_platinum_impact");

    public static final RegistryObject<SoundEvent> GLOW =
            registerSoundEvents("glow");

    public static final RegistryObject<SoundEvent> DING =
            registerSoundEvents("ding");

    public static final RegistryObject<SoundEvent> TELEPORT =
            registerSoundEvents("teleport");

    public static final RegistryObject<SoundEvent> CHARM =
            registerSoundEvents("charm");

    public static final RegistryObject<SoundEvent> TITAN =
            registerSoundEvents("titan");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ExampleMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}