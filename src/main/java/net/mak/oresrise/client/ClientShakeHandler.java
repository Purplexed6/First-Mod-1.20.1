package net.mak.oresrise.client;

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

        } else {

            intensity = 0;

        }
    }


    public static float getShake() {

        return shakeTicks > 0 ? intensity : 0;

    }
}