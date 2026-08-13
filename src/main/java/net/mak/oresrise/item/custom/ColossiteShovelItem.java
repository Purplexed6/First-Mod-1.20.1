package net.mak.oresrise.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ColossiteShovelItem extends ShovelItem {

    public ColossiteShovelItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {

        if (!level.isClientSide && entity instanceof Player player && player.isShiftKeyDown()) {

            var look = player.getLookAngle();

            // Looking up/down = horizontal 3x3
            if (Math.abs(look.y) > Math.abs(look.x) && Math.abs(look.y) > Math.abs(look.z)) {

                for (int a = -1; a <= 1; a++) {
                    for (int b = -1; b <= 1; b++) {

                        BlockPos targetPos = pos.offset(a, 0, b);

                        if (targetPos.equals(pos))
                            continue;

                        BlockState targetState = level.getBlockState(targetPos);

                        if (!targetState.isAir() && targetState.canHarvestBlock(level, targetPos, player)) {

                            level.destroyBlock(targetPos, true);

                            stack.hurtAndBreak(
                                    1,
                                    player,
                                    p -> p.broadcastBreakEvent(player.getUsedItemHand())
                            );
                        }
                    }
                }

            } else {

                // Looking sideways = vertical 3x3
                var direction = player.getDirection();

                for (int a = -1; a <= 1; a++) {
                    for (int b = -1; b <= 1; b++) {

                        BlockPos targetPos;

                        if (direction.getAxis() == net.minecraft.core.Direction.Axis.X) {
                            targetPos = pos.offset(0, a, b);
                        } else {
                            targetPos = pos.offset(a, b, 0);
                        }

                        if (targetPos.equals(pos))
                            continue;

                        BlockState targetState = level.getBlockState(targetPos);

                        if (!targetState.isAir() && targetState.canHarvestBlock(level, targetPos, player)) {

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
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }
}