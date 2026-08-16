package net.mak.oresrise.mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class TestMixin {

    @Inject(
            method = "setPos",
            at = @At("HEAD")
    )
    private void test(double x, double y, double z, CallbackInfo ci) {
    }
}