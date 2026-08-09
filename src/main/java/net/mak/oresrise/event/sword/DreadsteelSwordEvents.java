package net.mak.oresrise.event.sword;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = "oresrise")
public class DreadsteelSwordEvents {

    private static final List<DreadNova> ACTIVE_NOVAS =
            new ArrayList<>();

    // Ability lasts 2 seconds
    private static final int DURATION = 25;

    // Radius
    private static final double RADIUS = 6.0D;


    // =========================================================
    // START ABILITY
    // =========================================================

    public static void startDreadNova(Player player) {

        if (!(player.level() instanceof ServerLevel level)) {
            return;
        }

        ACTIVE_NOVAS.add(
                new DreadNova(
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

        Iterator<DreadNova> iterator =
                ACTIVE_NOVAS.iterator();

        while (iterator.hasNext()) {

            DreadNova nova = iterator.next();

            nova.tick();

            if (nova.finished) {

                nova.finish();

                iterator.remove();
            }
        }
    }


    // =========================================================
    // DAMAGE IMMUNITY
    // =========================================================

    @SubscribeEvent
    public static void onLivingAttack(
            LivingAttackEvent event
    ) {

        LivingEntity victim =
                event.getEntity();

        for (DreadNova nova : ACTIVE_NOVAS) {

            if (nova.isPlayer(victim)) {

                /*
                 * Only block entity-caused damage.
                 *
                 * Fire, lava, fall damage, etc.
                 * still work normally.
                 */

                Entity attacker =
                        event.getSource()
                                .getEntity();

                if (attacker instanceof LivingEntity) {

                    event.setCanceled(true);
                    return;
                }
            }
        }
    }


    // =========================================================
    // DREAD NOVA
    // =========================================================

    private static class DreadNova {

        private final ServerLevel level;

        private final UUID playerUUID;

        private final Set<UUID> affected =
                new HashSet<>();

        private int age = 0;

        private boolean finished = false;


        DreadNova(
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
                    getPlayer();

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
                    player.getBoundingBox()
                            .inflate(RADIUS);


            List<LivingEntity> enemies =
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
            // PULL ENEMIES
            // =================================================

            for (LivingEntity enemy :
                    enemies) {

                affected.add(
                        enemy.getUUID()
                );


                pullEnemy(
                        enemy,
                        player
                );
            }


            // =================================================
            // END
            // =================================================

            if (age >= DURATION) {

                finished = true;
            }
        }


        // =====================================================
        // PULL
        // =====================================================

        private void pullEnemy(
                LivingEntity enemy,
                Player player
        ) {

            double dx =
                    player.getX()
                            - enemy.getX();

            double dy =
                    (player.getY()
                            + player.getBbHeight() * 0.5D)
                            - enemy.getY();

            double dz =
                    player.getZ()
                            - enemy.getZ();


            double distance =
                    Math.sqrt(
                            dx * dx +
                                    dy * dy +
                                    dz * dz
                    );


            if (distance < 0.2D) {
                return;
            }


            /*
             * Pull gets stronger as the ability
             * gets closer to ending.
             *
             * 0.0 -> weak
             * 1.0 -> extremely strong
             */

            double progress =
                    (double) age /
                            DURATION;


            double strength =
                    0.20D +
                            progress * 0.65D;


            dx /= distance;
            dy /= distance;
            dz /= distance;


            enemy.setDeltaMovement(
                    dx * strength,
                    dy * strength,
                    dz * strength
            );


            enemy.hurtMarked = true;
        }


        // =====================================================
        // PARTICLES
        // =====================================================

        private void spawnParticles(
                double x,
                double y,
                double z
        ) {

            double rotation =
                    age * 0.35D;


            // Swirling soul particles
            for (int i = 0; i < 25; i++) {

                double angle =
                        rotation
                                + (Math.PI * 2D * i / 25D);


                double radius =
                        0.8D
                                + Math.random()
                                * 3.5D;


                double px =
                        x +
                                Math.cos(angle)
                                        * radius;

                double py =
                        y +
                                0.2D +
                                Math.random()
                                        * 2.8D;

                double pz =
                        z +
                                Math.sin(angle)
                                        * radius;


                level.sendParticles(
                        ParticleTypes.SOUL,
                        px,
                        py,
                        pz,
                        2,
                        0.08D,
                        0.08D,
                        0.08D,
                        0.02D
                );


                // Soul fire mixed in
                if (i % 3 == 0) {

                    level.sendParticles(
                            ParticleTypes.SOUL_FIRE_FLAME,
                            px,
                            py,
                            pz,
                            1,
                            0.05D,
                            0.05D,
                            0.05D,
                            0.01D
                    );
                }
            }


            // Stronger particles near the player
            level.sendParticles(
                    ParticleTypes.SOUL,
                    x,
                    y + 1.0D,
                    z,
                    8,
                    1.5D,
                    1.2D,
                    1.5D,
                    0.08D
            );
        }


        // =====================================================
        // FINISH
        // =====================================================

        void finish() {

            ServerPlayer player =
                    getPlayer();


            if (player == null) {
                return;
            }


            double centerX =
                    player.getX();

            double centerY =
                    player.getY();

            double centerZ =
                    player.getZ();


            // =================================================
            // FLING ENEMIES
            // =================================================

            for (UUID uuid : affected) {

                LivingEntity enemy =
                        findEntity(uuid);


                if (enemy == null ||
                        !enemy.isAlive()) {

                    continue;
                }


                double dx =
                        enemy.getX()
                                - centerX;

                double dz =
                        enemy.getZ()
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
                 * HUGE launch.
                 */

                enemy.setDeltaMovement(
                        dx * 2.0D,
                        0.7D,
                        dz * 2.0D
                );


                enemy.hurtMarked = true;
            }


            // =================================================
            // HEAL 3 HEARTS
            // =================================================

            player.heal(6.0F);


            // =================================================
            // STRENGTH I - 5 SECONDS
            // =================================================

            player.addEffect(
                    new MobEffectInstance(
                            MobEffects.DAMAGE_BOOST,
                            20 * 5,
                            0
                    )
            );


            // =================================================
            // MASSIVE PARTICLE BURST
            // =================================================

            level.sendParticles(
                    ParticleTypes.SOUL,
                    centerX,
                    centerY + 1.0D,
                    centerZ,
                    150,
                    3.0D,
                    2.0D,
                    3.0D,
                    0.15D
            );


            level.sendParticles(
                    ParticleTypes.SOUL_FIRE_FLAME,
                    centerX,
                    centerY + 1.0D,
                    centerZ,
                    80,
                    2.5D,
                    1.5D,
                    2.5D,
                    0.12D
            );
        }


        // =====================================================
        // GET PLAYER
        // =====================================================

        private ServerPlayer getPlayer() {

            return level.getServer()
                    .getPlayerList()
                    .getPlayer(playerUUID);
        }


        // =====================================================
        // IS PLAYER
        // =====================================================

        private boolean isPlayer(
                LivingEntity entity
        ) {

            return entity.getUUID()
                    .equals(playerUUID);
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

            return level.getEntitiesOfClass(
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
                    ).stream()
                    .findFirst()
                    .orElse(null);
        }
    }
}