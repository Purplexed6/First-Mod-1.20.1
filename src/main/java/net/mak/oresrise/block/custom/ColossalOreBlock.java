package net.mak.oresrise.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ColossalOreBlock extends DropExperienceBlock {

    public ColossalOreBlock(Properties properties, IntProvider xpRange) {
        super(properties, xpRange);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        int side = random.nextInt(6);
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();

        // Use a small buffer (e.g., 0.05) to push it just outside the block face
        // and limit the randomness to 1.0 (covering the face)
        switch (side) {
            case 0 -> x -= 0.05; // West
            case 1 -> x += 1.05; // East
            case 2 -> y -= 0.05; // Bottom
            case 3 -> y += 1.05; // Top
            case 4 -> z -= 0.05; // North
            case 5 -> z += 1.05; // South
        }

        // Add jitter only within the 1.0 block range, but keep them on the face
        // If it's a side face (0, 1, 4, 5), fix the X or Z and randomize the others
        if (side == 0 || side == 1) { // West/East faces: fix X, randomize Y and Z
            y += random.nextDouble();
            z += random.nextDouble();
        } else if (side == 2 || side == 3) { // Top/Bottom faces: fix Y, randomize X and Z
            x += random.nextDouble();
            z += random.nextDouble();
        } else { // North/South faces: fix Z, randomize X and Y
            x += random.nextDouble();
            y += random.nextDouble();
        }

        level.addParticle(
                ParticleTypes.GLOW_SQUID_INK,
                x, y, z,
                0.0D, 0.0D, 0.0D
        );
    }
}
