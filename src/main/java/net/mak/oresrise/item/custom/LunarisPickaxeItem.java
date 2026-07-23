package net.mak.oresrise.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

import java.util.HashSet;
import java.util.Set;

public class LunarisPickaxeItem extends PickaxeItem {

    public LunarisPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {

        if (!level.isClientSide && entity instanceof Player player && player.isShiftKeyDown()) {


            // ORE VEIN MINING
            if (state.is(Tags.Blocks.ORES)) {

                Set<BlockPos> blocks = new HashSet<>();

                findConnectedBlocks(
                        level,
                        pos,
                        state,
                        blocks
                );


                for (BlockPos blockPos : blocks) {

                    if (blockPos.equals(pos))
                        continue;

                    BlockState targetState = level.getBlockState(blockPos);

                    if (!targetState.isAir()
                            && targetState.canHarvestBlock(level, blockPos, player)) {

                        level.destroyBlock(blockPos, true);

                        stack.hurtAndBreak(
                                1,
                                player,
                                p -> p.broadcastBreakEvent(player.getUsedItemHand())
                        );
                    }
                }

            } else {

                // GRAVITY DIG FOR NORMAL BLOCKS

                Direction direction = getLookingDirection(player);

                for (int i = 1; i <= 2; i++) {

                    BlockPos targetPos = pos.relative(direction, i);

                    BlockState targetState = level.getBlockState(targetPos);

                    if (!targetState.isAir()
                            && targetState.canHarvestBlock(level, targetPos, player)) {

                        level.destroyBlock(targetPos, true);

                        stack.hurtAndBreak(
                                1,
                                player,
                                p -> p.broadcastBreakEvent(player.getUsedItemHand())
                        );
                    }
                }
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }


    private void findConnectedBlocks(Level level, BlockPos pos, BlockState originalState, Set<BlockPos> found) {

        if (found.size() >= 64)
            return;

        if (found.contains(pos))
            return;

        BlockState currentState = level.getBlockState(pos);

        if (!currentState.is(originalState.getBlock()))
            return;

        found.add(pos);


        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {

                    findConnectedBlocks(
                            level,
                            pos.offset(x, y, z),
                            originalState,
                            found
                    );
                }
            }
        }
    }


    private Direction getLookingDirection(Player player) {

        double x = player.getLookAngle().x;
        double y = player.getLookAngle().y;
        double z = player.getLookAngle().z;


        if (Math.abs(y) > Math.abs(x) && Math.abs(y) > Math.abs(z)) {
            return y > 0 ? Direction.UP : Direction.DOWN;
        }


        if (Math.abs(x) > Math.abs(z)) {
            return x > 0 ? Direction.EAST : Direction.WEST;
        }


        return z > 0 ? Direction.SOUTH : Direction.NORTH;
    }
}