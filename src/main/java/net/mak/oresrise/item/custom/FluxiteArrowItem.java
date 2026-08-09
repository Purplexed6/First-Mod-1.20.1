package net.mak.oresrise.item.custom;

import net.mak.oresrise.entity.FluxiteArrowEntity;
import net.mak.oresrise.entity.ModEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FluxiteArrowItem extends ArrowItem {

    public FluxiteArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(
            Level level,
            ItemStack stack,
            LivingEntity shooter
    ) {
        FluxiteArrowEntity arrow = new FluxiteArrowEntity(
                ModEntities.FLUXITE_ARROW.get(),
                level
        );

        arrow.setOwner(shooter);
        arrow.setEffectsFromItem(stack);

        return arrow;
    }
}