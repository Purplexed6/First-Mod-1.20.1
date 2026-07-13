package net.mak.oresrise.entity.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class EmberHuskEntity extends Zombie {
    public EmberHuskEntity(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Zombie.createAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    @Override
    public boolean doHurtTarget(Entity pTarget) {
        boolean flag = super.doHurtTarget(pTarget);
        if (flag) {
            pTarget.setSecondsOnFire(4); // Sets target on fire!
        }
        return flag;
    }

    @Override
    protected boolean isSunSensitive() {
        return false; // Doesn't burn in daylight
    }
}
