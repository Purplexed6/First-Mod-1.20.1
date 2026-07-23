package net.mak.oresrise.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class LunarisShovelItem extends ShovelItem {

    public LunarisShovelItem(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {

        if (!level.isClientSide && entity instanceof Player player && player.isShiftKeyDown()) {

            if (state.is(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL)) {

                BlockPos directionPos = pos.relative(
                        getLookingDirection(player),
                        1
                );

                for (int i = 1; i <= 2; i++) {

                    BlockPos targetPos = pos.relative(
                            getLookingDirection(player),
                            i
                    );

                    BlockState targetState = level.getBlockState(targetPos);

                    if (!targetState.isAir()
                            && targetState.is(net.minecraft.tags.BlockTags.MINEABLE_WITH_SHOVEL)
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


    private net.minecraft.core.Direction getLookingDirection(Player player) {

        double x = player.getLookAngle().x;
        double y = player.getLookAngle().y;
        double z = player.getLookAngle().z;

        if (Math.abs(y) > Math.abs(x) && Math.abs(y) > Math.abs(z)) {
            return y > 0
                    ? net.minecraft.core.Direction.UP
                    : net.minecraft.core.Direction.DOWN;
        }

        if (Math.abs(x) > Math.abs(z)) {
            return x > 0
                    ? net.minecraft.core.Direction.EAST
                    : net.minecraft.core.Direction.WEST;
        }

        return z > 0
                ? net.minecraft.core.Direction.SOUTH
                : net.minecraft.core.Direction.NORTH;
    }
}