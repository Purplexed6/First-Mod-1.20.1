package net.mak.oresrise.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashSet;
import java.util.Set;

public class CryptonAxeItem extends AxeItem {

    public CryptonAxeItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {

        if (!level.isClientSide && entity instanceof Player player && player.isShiftKeyDown()) {

            if (state.is(net.minecraft.tags.BlockTags.LOGS)) {

                Set<BlockPos> logs = new HashSet<>();

                findLogs(level, pos, logs);

                for (BlockPos logPos : logs) {

                    if (!logPos.equals(pos)) {

                        level.destroyBlock(logPos, true);

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


    private void findLogs(Level level, BlockPos pos, Set<BlockPos> found) {

        if (found.size() > 128)
            return; // safety limit

        if (found.contains(pos))
            return;

        BlockState state = level.getBlockState(pos);

        if (!state.is(net.minecraft.tags.BlockTags.LOGS))
            return;

        found.add(pos);


        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {

                    findLogs(
                            level,
                            pos.offset(x, y, z),
                            found
                    );
                }
            }
        }
    }
}
