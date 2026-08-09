package net.mak.oresrise.entity;

import net.mak.oresrise.item.ModItems;
import net.mak.oresrise.item.custom.VoltiumSet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.EntityHitResult;

public class FluxiteArrowEntity extends Arrow {

    public FluxiteArrowEntity(EntityType<? extends FluxiteArrowEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!level().isClientSide && result.getEntity() instanceof LivingEntity target) {

            ServerLevel level = (ServerLevel) this.level();

            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);

            if (lightning != null) {
                lightning.moveTo(
                        target.getX(),
                        target.getY(),
                        target.getZ()
                );

                level.addFreshEntity(lightning);
            }
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(VoltiumSet.FLUXITE_ARROW.get());
    }
}