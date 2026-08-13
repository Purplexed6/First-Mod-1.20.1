package net.mak.oresrise.effect;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.effect.custom.ScouriumInfectionEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(
                    ForgeRegistries.MOB_EFFECTS,
                    ExampleMod.MOD_ID
            );

    public static final RegistryObject<MobEffect> SCOURIUM_INFECTION =
            EFFECTS.register(
                    "scourium_infection",
                    ScouriumInfectionEffect::new
            );

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}