package net.mak.oresrise.event.sword;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3f;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = "oresrise")
public class BloodPactEvents {

    private static final DustParticleOptions BLOOD_PARTICLE =
            new DustParticleOptions(
                    new Vector3f(1.0f, 0.0f, 0.0f),
                    1.0f
            );

    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {

        LivingEntity victim = event.getEntity();

        if (!BloodPactManager.isPacted(victim))
            return;

        Entity attacker = event.getSource().getEntity();

        // Damage that has no entity attacker
        // such as some environmental damage is blocked.
        if (!(attacker instanceof LivingEntity livingAttacker)) {
            event.setCanceled(true);
            return;
        }

        // The ONLY entity allowed to damage the victim
        // is their Blood Pact partner.
        if (!BloodPactManager.isPactedWith(victim, livingAttacker)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {

        LivingEntity dead = event.getEntity();

        if (BloodPactManager.isPacted(dead)) {
            BloodPactManager.removePact(dead);
        }
    }

    public static void drawPactLine(ServerLevel level, LivingEntity first) {

        if (!BloodPactManager.isPacted(first))
            return;

        UUID partnerUUID = BloodPactManager.getPartner(first);

        if (partnerUUID == null)
            return;

        LivingEntity partner = findEntity(level, partnerUUID);

        if (partner == null || !partner.isAlive()) {
            BloodPactManager.removePact(first);
            return;
        }

        double x1 = first.getX();
        double y1 = first.getY() + first.getBbHeight() * 0.5;
        double z1 = first.getZ();

        double x2 = partner.getX();
        double y2 = partner.getY() + partner.getBbHeight() * 0.5;
        double z2 = partner.getZ();

        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;

        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

        if (distance <= 0.1)
            return;

        int particles = Math.max(2, (int) (distance * 4));

        for (int i = 0; i <= particles; i++) {

            double progress = (double) i / particles;

            double x = x1 + dx * progress;
            double y = y1 + dy * progress;
            double z = z1 + dz * progress;

            level.sendParticles(
                    BLOOD_PARTICLE,
                    x,
                    y,
                    z,
                    1,
                    0,
                    0,
                    0,
                    0
            );
        }
    }

    private static LivingEntity findEntity(ServerLevel level, UUID uuid) {

        Entity entity = level.getEntity(uuid);

        if (entity instanceof LivingEntity livingEntity) {
            return livingEntity;
        }

        return null;
    }

    @SubscribeEvent
    public static void onServerTick(
            net.minecraftforge.event.TickEvent.ServerTickEvent event
    ) {

        if (event.phase != net.minecraftforge.event.TickEvent.Phase.END)
            return;

        for (ServerLevel level : event.getServer().getAllLevels()) {

            for (ServerPlayer player : level.players()) {

                if (BloodPactManager.isPacted(player)) {

                    // Spawn the Blood Pact particles every 3 ticks
                    if (level.getGameTime() % 3 == 0) {
                        drawPactLine(level, player);
                    }
                }
            }
        }
    }
}