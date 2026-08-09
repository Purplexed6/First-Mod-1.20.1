package net.mak.oresrise.item.custom;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HemogemSwordItem extends SwordItem {

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public HemogemSwordItem(
            Tier tier,
            int attackDamage,
            float attackSpeed,
            Properties properties
    ) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    // =========================================================
    // HEMOGEM LIFESTEAL + TYPE O POSITIVE
    // =========================================================

    @Override
    public boolean hurtEnemy(
            ItemStack stack,
            LivingEntity target,
            LivingEntity attacker
    ) {

        // Only the server should handle the actual lifesteal
        // and advancement.
        if (!target.level().isClientSide && attacker instanceof Player player) {

            // 0.5 hearts = 1.0 health
            player.heal(1.0F);


            // ❤️ BLOOD HEAL PARTICLES

            if (target.level() instanceof ServerLevel server) {

                server.sendParticles(
                        net.minecraft.core.particles.ParticleTypes.HEART,
                        target.getX(),
                        target.getY() + 1,
                        target.getZ(),
                        5,
                        0.2,
                        0.5,
                        0.2,
                        0.1
                );
            }


            // 🩸 TYPE O POSITIVE ADVANCEMENT

            triggerTypeOPositive(player);
        }


        return super.hurtEnemy(stack, target, attacker);
    }


    // =========================================================
    // BLOOD PACT ACTIVATION
    // =========================================================

    @Override
    public InteractionResult interactLivingEntity(
            ItemStack stack,
            Player player,
            LivingEntity target,
            InteractionHand hand
    ) {

        // Server only
        if (player.level().isClientSide) {
            return InteractionResult.SUCCESS;
        }


        // Don't pact with yourself
        if (target == player) {
            return InteractionResult.PASS;
        }


        // Must be within 5 blocks
        if (player.distanceTo(target) > 5.0D) {
            return InteractionResult.PASS;
        }


        // Target must be alive
        if (!target.isAlive()) {
            return InteractionResult.PASS;
        }


        // Player cannot already have a pact
        if (isPacted(player)) {
            player.displayClientMessage(
                    Component.literal("§4You already have a Blood Pact."),
                    true
            );

            return InteractionResult.FAIL;
        }


        // Target cannot already have a pact
        if (isPacted(target)) {
            player.displayClientMessage(
                    Component.literal("§4That entity is already bound."),
                    true
            );

            return InteractionResult.FAIL;
        }


        // CREATE THE PACT

        createPact(player, target);


        // BLOOD BROTHERS ADVANCEMENT

        triggerBloodBrothers(player);


        // Feedback
        player.displayClientMessage(
                Component.literal("§4Blood Pact established."),
                true
        );


        return InteractionResult.SUCCESS;
    }


    // =========================================================
    // BLOOD PACT DATA
    // =========================================================

    /*
     * Every entity UUID points to its pact partner UUID.
     *
     * Player UUID -> Target UUID
     * Target UUID -> Player UUID
     *
     * This means the pact is pair-specific.
     */

    private static final Map<UUID, UUID> BLOOD_PACTS = new HashMap<>();


    private static void createPact(
            LivingEntity first,
            LivingEntity second
    ) {

        BLOOD_PACTS.put(
                first.getUUID(),
                second.getUUID()
        );

        BLOOD_PACTS.put(
                second.getUUID(),
                first.getUUID()
        );
    }


    private static boolean isPacted(Entity entity) {

        return BLOOD_PACTS.containsKey(
                entity.getUUID()
        );
    }


    private static boolean isPactedWith(
            Entity first,
            Entity second
    ) {

        UUID partner = BLOOD_PACTS.get(
                first.getUUID()
        );

        return partner != null
                && partner.equals(second.getUUID());
    }


    private static void removePact(Entity entity) {

        UUID entityUUID = entity.getUUID();

        UUID partnerUUID =
                BLOOD_PACTS.remove(entityUUID);


        if (partnerUUID != null) {

            BLOOD_PACTS.remove(
                    partnerUUID
            );
        }
    }


    // =========================================================
    // TYPE O POSITIVE ADVANCEMENT
    // =========================================================

    private static void triggerTypeOPositive(
            Player player
    ) {

        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }


        Advancement advancement =
                serverPlayer.server
                        .getAdvancements()
                        .getAdvancement(
                                new ResourceLocation(
                                        "oresrise",
                                        "type_o_positive"
                                )
                        );


        if (advancement == null) {
            return;
        }


        AdvancementProgress progress =
                serverPlayer.getAdvancements()
                        .getOrStartProgress(
                                advancement
                        );


        if (!progress.isDone()) {

            serverPlayer.getAdvancements()
                    .award(
                            advancement,
                            "hemogem_sword_strike"
                    );
        }
    }


    // =========================================================
    // BLOOD BROTHERS ADVANCEMENT
    // =========================================================

    private static void triggerBloodBrothers(
            Player player
    ) {

        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }


        Advancement advancement =
                serverPlayer.server
                        .getAdvancements()
                        .getAdvancement(
                                new ResourceLocation(
                                        "oresrise",
                                        "blood_brothers"
                                )
                        );


        if (advancement == null) {
            return;
        }


        AdvancementProgress progress =
                serverPlayer.getAdvancements()
                        .getOrStartProgress(
                                advancement
                        );


        if (!progress.isDone()) {

            serverPlayer.getAdvancements()
                    .award(
                            advancement,
                            "blood_pact"
                    );
        }
    }


    // =========================================================
    // BLOOD PACT EVENTS
    // =========================================================

    @Mod.EventBusSubscriber(
            modid = "oresrise"
    )
    public static class BloodPactEvents {


        // -----------------------------------------------------
        // BLOCK OUTSIDE DAMAGE
        // -----------------------------------------------------

        @SubscribeEvent
        public static void onLivingAttack(LivingAttackEvent event) {

            LivingEntity victim = event.getEntity();

            Entity attacker = event.getSource().getEntity();


            // =====================================================
            // ATTACKER IS A LIVING ENTITY
            // =====================================================

            if (attacker instanceof LivingEntity livingAttacker) {

                /*
                 * If the attacker is pacted, they can ONLY
                 * damage their pact partner.
                 */

                if (isPacted(livingAttacker)) {

                    if (!isPactedWith(
                            livingAttacker,
                            victim
                    )) {

                        event.setCanceled(true);
                        return;
                    }
                }


                /*
                 * If the victim is pacted, ONLY their pact
                 * partner can damage them.
                 */

                if (isPacted(victim)) {

                    if (!isPactedWith(
                            victim,
                            livingAttacker
                    )) {

                        event.setCanceled(true);
                    }
                }
            }

            /*
             * If the attacker is NOT a LivingEntity
             * (fall, fire, lava, freezing, cactus, etc.),
             * DON'T cancel anything.
             */
        }


        // -----------------------------------------------------
        // REMOVE PACT WHEN SOMEONE DIES
        // -----------------------------------------------------

        @SubscribeEvent
        public static void onLivingDeath(
                LivingDeathEvent event
        ) {

            LivingEntity dead =
                    event.getEntity();


            if (isPacted(dead)) {

                removePact(dead);
            }
        }


        // -----------------------------------------------------
        // RED PARTICLE CONNECTION
        // -----------------------------------------------------

        @SubscribeEvent
        public static void onServerTick(
                TickEvent.ServerTickEvent event
        ) {

            if (event.phase != TickEvent.Phase.END) {
                return;
            }


            for (ServerLevel level :
                    event.getServer().getAllLevels()) {

                for (ServerPlayer player :
                        level.players()) {

                    if (!isPacted(player)) {
                        continue;
                    }


                    UUID partnerUUID =
                            BLOOD_PACTS.get(
                                    player.getUUID()
                            );


                    if (partnerUUID == null) {
                        continue;
                    }


                    Entity partner =
                            level.getEntity(
                                    partnerUUID
                            );


                    if (!(partner instanceof LivingEntity livingPartner)) {

                        removePact(player);
                        continue;
                    }


                    if (!livingPartner.isAlive()) {

                        removePact(player);
                        continue;
                    }


                    drawBloodLine(
                            level,
                            player,
                            livingPartner
                    );
                }
            }
        }
    }


    // =========================================================
    // BLOOD PARTICLE LINE
    // =========================================================

    private static final DustParticleOptions BLOOD_PARTICLE =
            new DustParticleOptions(
                    new Vector3f(
                            1.0F,
                            0.0F,
                            0.0F
                    ),
                    1.0F
            );


    private static void drawBloodLine(
            ServerLevel level,
            LivingEntity first,
            LivingEntity second
    ) {

        double x1 =
                first.getX();

        double y1 =
                first.getY()
                        + first.getBbHeight()
                        * 0.5D;

        double z1 =
                first.getZ();


        double x2 =
                second.getX();

        double y2 =
                second.getY()
                        + second.getBbHeight()
                        * 0.5D;

        double z2 =
                second.getZ();


        double dx =
                x2 - x1;

        double dy =
                y2 - y1;

        double dz =
                z2 - z1;


        double distance =
                Math.sqrt(
                        dx * dx
                                + dy * dy
                                + dz * dz
                );


        if (distance < 0.1D) {
            return;
        }


        /*
         * Roughly 4 particles per block.
         */

        int particleCount =
                Math.max(
                        2,
                        (int) (distance * 4)
                );


        for (int i = 0;
             i <= particleCount;
             i++) {

            double progress =
                    (double) i
                            / particleCount;


            double x =
                    x1
                            + dx
                            * progress;

            double y =
                    y1
                            + dy
                            * progress;

            double z =
                    z1
                            + dz
                            * progress;


            level.sendParticles(
                    BLOOD_PARTICLE,
                    x,
                    y,
                    z,
                    1,
                    0.0D,
                    0.0D,
                    0.0D,
                    0.0D
            );
        }
    }


    // =========================================================
    // TOOLTIP
    // =========================================================

    @Override
    public void appendHoverText(
            ItemStack stack,
            @Nullable Level level,
            List<Component> tooltip,
            TooltipFlag flag
    ) {

        tooltip.add(
                Component.translatable(
                        "tooltip.oresrise.hemogem_sword.tooltip"
                )
        );


        super.appendHoverText(
                stack,
                level,
                tooltip,
                flag
        );
    }
}