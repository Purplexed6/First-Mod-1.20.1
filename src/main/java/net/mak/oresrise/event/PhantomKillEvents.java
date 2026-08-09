package net.mak.oresrise.event;

import net.minecraft.advancements.Advancement;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oresrise")
public class PhantomKillEvents {

    private static final String PHANTOM_KILLS = "OresRisePhantomKills";

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {

        // Only care about Phantoms
        if (event.getEntity().getType() != EntityType.PHANTOM) {
            return;
        }

        // Check who killed it
        if (!(event.getSource().getEntity() instanceof ServerPlayer player)) {
            return;
        }

        // Get the player's persistent data
        CompoundTag data = player.getPersistentData();

        // Get current kill count
        int kills = data.getInt(PHANTOM_KILLS);

        // Add one kill
        kills++;

        // Save the new count
        data.putInt(PHANTOM_KILLS, kills);

        // Award at 100 kills
        if (kills >= 100) {

            Advancement advancement =
                    player.server.getAdvancements().getAdvancement(
                            new ResourceLocation("oresrise", "phantom_lord")
                    );

            if (advancement != null) {

                player.getAdvancements().award(
                        advancement,
                        "phantom_kills"
                );
            }
        }
    }
}