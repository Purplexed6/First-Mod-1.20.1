package net.mak.oresrise.worldgen.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Set;

public class NetherBuriedTreasureFeature
        extends Feature<NoneFeatureConfiguration> {

    private static final ResourceLocation LOOT_TABLE =
            new ResourceLocation(
                    "oresrise",
                    "chests/nether_buried_treasure"
            );

    private static final Set<net.minecraft.world.level.block.Block> VALID_BLOCKS =
            Set.of(
                    Blocks.NETHERRACK,
                    Blocks.BLACKSTONE,
                    Blocks.BASALT,
                    Blocks.SMOOTH_BASALT,
                    Blocks.NETHER_GOLD_ORE,
                    Blocks.NETHER_QUARTZ_ORE,
                    Blocks.ANCIENT_DEBRIS
            );

    public NetherBuriedTreasureFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(
            FeaturePlaceContext<NoneFeatureConfiguration> context
    ) {

        WorldGenLevel level = context.level();

        BlockPos origin = context.origin();

        /*
         * Try several nearby positions.
         */
        for (int attempt = 0; attempt < 20; attempt++) {

            int x =
                    origin.getX()
                            + context.random().nextInt(9)
                            - 4;

            int z =
                    origin.getZ()
                            + context.random().nextInt(9)
                            - 4;

            /*
             * Start at the Y supplied by the
             * HeightRangePlacement.
             */
            int startY = origin.getY();

            /*
             * Search downward up to 10 blocks.
             */
            for (int y = startY; y >= Math.max(10, startY - 10); y--) {

                BlockPos chestPos =
                        new BlockPos(x, y, z);

                BlockState ground =
                        level.getBlockState(chestPos);

                BlockState above =
                        level.getBlockState(
                                chestPos.above()
                        );

                /*
                 * The chest must replace a Nether block.
                 */
                if (!VALID_BLOCKS.contains(
                        ground.getBlock()
                )) {
                    continue;
                }

                /*
                 * Make sure the block above is solid.
                 */
                if (!above.isSolid()) {
                    continue;
                }

                /*
                 * Place the chest.
                 */
                Direction facing =
                        context.random().nextBoolean()
                                ? Direction.NORTH
                                : Direction.SOUTH;

                level.setBlock(
                        chestPos,
                        Blocks.CHEST.defaultBlockState()
                                .setValue(
                                        ChestBlock.FACING,
                                        facing
                                ),
                        2
                );

                /*
                 * Get the chest block entity.
                 */
                if (level.getBlockEntity(chestPos)
                        instanceof ChestBlockEntity chest) {

                    chest.setLootTable(
                            LOOT_TABLE,
                            context.random().nextLong()
                    );

                    chest.setChanged();

                    return true;
                }

                return false;
            }
        }

        return false;
    }
}