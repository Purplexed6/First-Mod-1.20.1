package net.mak.oresrise.event.sword;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = "oresrise")
public class SoulTornadoManager {

    private static final List<Tornado> TORNADOES =
            new ArrayList<>();


    // =========================================================
    // SETTINGS
    // =========================================================

    // How long the tornado lasts
    private static final int DURATION = 60;

    // Radius of the tornado
    private static final double RADIUS = 6.0D;

    // Height of the tornado
    private static final double HEIGHT = 6.0D;

    // Damage interval
    private static final int DAMAGE_INTERVAL = 5;

    // Damage per hit
    private static final float DAMAGE = 2F;


    // =========================================================
    // START TORNADO
    // =========================================================

    public static void startTornado(Player player) {

        if (!(player.level() instanceof ServerLevel level)) {
            return;
        }

        TORNADOES.add(
                new Tornado(
                        level,
                        player
                )
        );
    }


    // =========================================================
    // SERVER TICK
    // =========================================================

    @SubscribeEvent
    public static void onServerTick(
            TickEvent.ServerTickEvent event
    ) {

        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Iterator<Tornado> iterator =
                TORNADOES.iterator();

        while (iterator.hasNext()) {

            Tornado tornado = iterator.next();

            tornado.tick();

            if (tornado.finished) {

                tornado.finish();

                iterator.remove();
            }
        }
    }


    // =========================================================
    // TORNADO
    // =========================================================

    private static class Tornado {

        private final ServerLevel level;

        private final UUID playerUUID;

        private final Set<UUID> affected =
                new HashSet<>();

        private int age = 0;

        private boolean finished = false;


        Tornado(
                ServerLevel level,
                Player player
        ) {

            this.level = level;
            this.playerUUID =
                    player.getUUID();
        }


        // =====================================================
        // TICK
        // =====================================================

        void tick() {

            age++;


            ServerPlayer player =
                    level.getServer()
                            .getPlayerList()
                            .getPlayer(playerUUID);


            if (player == null ||
                    !player.isAlive()) {

                finished = true;
                return;
            }


            double centerX =
                    player.getX();

            double centerY =
                    player.getY();

            double centerZ =
                    player.getZ();


            // =================================================
            // PARTICLES
            // =================================================

            spawnParticles(
                    centerX,
                    centerY,
                    centerZ
            );


            // =================================================
            // FIND ENEMIES
            // =================================================

            AABB box =
                    new AABB(
                            centerX - RADIUS,
                            centerY,
                            centerZ - RADIUS,
                            centerX + RADIUS,
                            centerY + HEIGHT,
                            centerZ + RADIUS
                    );


            List<LivingEntity> entities =
                    level.getEntitiesOfClass(
                            LivingEntity.class,
                            box,
                            entity ->
                                    entity != player
                                            && entity.isAlive()
                                            && entity.distanceTo(player)
                                            <= RADIUS
                    );


            // =================================================
            // AFFECT ENTITIES
            // =================================================

            for (LivingEntity entity : entities) {

                affected.add(
                        entity.getUUID()
                );


                applyVortexMovement(
                        entity,
                        centerX,
                        centerY,
                        centerZ
                );


                // Damage every 5 ticks
                if (age % DAMAGE_INTERVAL == 0) {

                    entity.hurt(
                            playerDamageSource(player),
                            DAMAGE
                    );
                }
            }


            // =================================================
            // END
            // =================================================

            if (age >= DURATION) {

                finished = true;
            }
        }


        // =====================================================
        // VORTEX MOVEMENT
        // =====================================================

        private void applyVortexMovement(
                LivingEntity entity,
                double centerX,
                double centerY,
                double centerZ
        ) {

            double dx =
                    centerX - entity.getX();

            double dz =
                    centerZ - entity.getZ();


            double distance =
                    Math.sqrt(
                            dx * dx +
                                    dz * dz
                    );


            if (distance < 0.1D) {
                distance = 0.1D;
            }


            // =================================================
            // STRONGER PULL WHEN FARTHER AWAY
            // =================================================

            double pullStrength =
                    0.18D +
                            Math.min(
                                    distance / RADIUS,
                                    1.0D
                            ) * 0.30D;


            double pullX =
                    (dx / distance)
                            * pullStrength;

            double pullZ =
                    (dz / distance)
                            * pullStrength;


            // =================================================
            // ORBIT / SPIN
            // =================================================

            double orbitStrength =
                    0.20D +
                            Math.min(
                                    distance / RADIUS,
                                    1.0D
                            ) * 0.15D;


            double orbitX =
                    (-dz / distance)
                            * orbitStrength;

            double orbitZ =
                    (dx / distance)
                            * orbitStrength;


            // =================================================
            // UPWARD FORCE
            // =================================================

            double upward =
                    0.18D;


            // =================================================
            // COMBINE
            // =================================================

            double newX =
                    pullX +
                            orbitX;

            double newY =
                    upward;

            double newZ =
                    pullZ +
                            orbitZ;


            entity.setDeltaMovement(
                    newX,
                    newY,
                    newZ
            );


            entity.hurtMarked = true;
        }


        // =====================================================
        // PARTICLES
        // =====================================================

        private void spawnParticles(
                double centerX,
                double centerY,
                double centerZ
        ) {

            /*
             * Several spiral layers.
             */

            int points = 30;


            double rotation =
                    age * 0.25D;


            for (int i = 0; i < points; i++) {

                double progress =
                        (double) i /
                                points;


                double y =
                        centerY +
                                progress * HEIGHT;


                /*
                 * Tornado gets wider toward
                 * the middle/top.
                 */

                double width =
                        0.8D +
                                Math.sin(
                                        progress * Math.PI
                                ) * (RADIUS - 0.8D);


                double angle =
                        rotation +
                                progress * Math.PI * 5;


                double x =
                        centerX +
                                Math.cos(angle)
                                        * width;

                double z =
                        centerZ +
                                Math.sin(angle)
                                        * width;


                level.sendParticles(
                        ParticleTypes.SOUL,
                        x,
                        y,
                        z,
                        2,
                        0.15D,
                        0.15D,
                        0.15D,
                        0.02D
                );


                /*
                 * Soul fire particles mixed into
                 * the tornado.
                 */

                if (i % 2 == 0) {

                    level.sendParticles(
                            ParticleTypes.SOUL_FIRE_FLAME,
                            x,
                            y,
                            z,
                            1,
                            0.1D,
                            0.1D,
                            0.1D,
                            0.01D
                    );
                }
            }


            /*
             * Extra chaotic particles near the top.
             */

            for (int i = 0; i < 8; i++) {

                double angle =
                        Math.random()
                                * Math.PI * 2;

                double radius =
                        2.0D +
                                Math.random() * 4.0D;

                double x =
                        centerX +
                                Math.cos(angle)
                                        * radius;

                double z =
                        centerZ +
                                Math.sin(angle)
                                        * radius;

                double y =
                        centerY +
                                HEIGHT +
                                Math.random() * 1.5D;


                level.sendParticles(
                        ParticleTypes.SOUL,
                        x,
                        y,
                        z,
                        1,
                        0.2D,
                        0.2D,
                        0.2D,
                        0.04D
                );
            }
        }


        // =====================================================
        // FINISH TORNADO
        // =====================================================

        void finish() {

            ServerPlayer player =
                    level.getServer()
                            .getPlayerList()
                            .getPlayer(playerUUID);


            if (player == null) {
                return;
            }


            double centerX =
                    player.getX();

            double centerY =
                    player.getY();

            double centerZ =
                    player.getZ();


            /*
             * Fling every affected enemy outward.
             */

            for (UUID uuid : affected) {

                LivingEntity entity =
                        findEntity(uuid);

                if (entity == null ||
                        !entity.isAlive()) {
                    continue;
                }


                double dx =
                        entity.getX()
                                - centerX;

                double dz =
                        entity.getZ()
                                - centerZ;


                double distance =
                        Math.sqrt(
                                dx * dx +
                                        dz * dz
                        );


                if (distance < 0.1D) {

                    dx = 1.0D;
                    dz = 0.0D;
                    distance = 1.0D;
                }


                dx /= distance;
                dz /= distance;


                /*
                 * Violent outward launch.
                 */

                entity.setDeltaMovement(
                        dx * 1.8D,
                        0.9D,
                        dz * 1.8D
                );


                entity.hurtMarked = true;
            }


            /*
             * Final burst of soul particles.
             */

            level.sendParticles(
                    ParticleTypes.SOUL,
                    centerX,
                    centerY + 2.0D,
                    centerZ,
                    100,
                    RADIUS * 0.5D,
                    2.0D,
                    RADIUS * 0.5D,
                    0.15D
            );
        }


        // =====================================================
        // FIND ENTITY
        // =====================================================

        private LivingEntity findEntity(
                UUID uuid
        ) {

            for (ServerPlayer player :
                    level.players()) {

                if (player.getUUID()
                        .equals(uuid)) {

                    return player;
                }
            }


            for (LivingEntity entity :
                    level.getEntitiesOfClass(
                            LivingEntity.class,
                            new AABB(
                                    -30000000,
                                    -64,
                                    -30000000,
                                    30000000,
                                    320,
                                    30000000
                            ),
                            entity ->
                                    entity.getUUID()
                                            .equals(uuid)
                    )) {

                return entity;
            }


            return null;
        }


        // =====================================================
        // DAMAGE SOURCE
        // =====================================================

        private net.minecraft.world.damagesource.DamageSource
        playerDamageSource(
                ServerPlayer player
        ) {

            return level.damageSources()
                    .playerAttack(player);
        }
    }
}