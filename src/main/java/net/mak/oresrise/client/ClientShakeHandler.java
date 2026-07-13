package net.mak.oresrise.client;

import net.minecraft.client.Minecraft;

public class ClientShakeHandler {

    private static int shakeTicks = 0;
    private static float intensity = 0;

    public static void triggerShake(float power, int duration) {
        shakeTicks = duration;
        intensity = power;
    }

    public static void tick() {
        if (shakeTicks > 0) {
            shakeTicks--;
        }
    }

    public static float getShake() {
        if (shakeTicks <= 0) return 0;
        return intensity;
    }
}
