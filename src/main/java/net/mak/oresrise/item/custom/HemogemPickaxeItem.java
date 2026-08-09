package net.mak.oresrise.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class HemogemPickaxeItem extends PickaxeItem {

    public HemogemPickaxeItem(
            Tier tier,
            int attackDamage,
            float attackSpeed,
            Item.Properties properties
    ) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean mineBlock(
            ItemStack stack,
            Level level,
            BlockState state,
            BlockPos pos,
            LivingEntity entity
    ) {

        // Only run on the server
        if (!level.isClientSide && entity instanceof Player player) {

            if (isStoneBlock(state.getBlock())) {

                // 3% chance
                if (player.getRandom().nextFloat() < 0.03F) {

                    Block.popResource(
                            level,
                            pos,
                            new ItemStack(
                                    net.minecraft.world.item.Items.IRON_NUGGET
                            )
                    );
                }
            }
        }

        return super.mineBlock(
                stack,
                level,
                state,
                pos,
                entity
        );
    }

    private boolean isStoneBlock(Block block) {

        return block == Blocks.STONE
                || block == Blocks.DEEPSLATE
                || block == Blocks.GRANITE
                || block == Blocks.ANDESITE
                || block == Blocks.DIORITE
                || block == Blocks.NETHERRACK
                || block == Blocks.END_STONE
                || block == Blocks.BLACKSTONE
                || block == Blocks.BASALT
                || block == Blocks.CALCITE
                || block == Blocks.SMOOTH_BASALT
                || block == Blocks.TUFF
                || block == Blocks.DRIPSTONE_BLOCK
                || block == Blocks.COBBLESTONE
                || block == Blocks.COBBLED_DEEPSLATE
                || block == Blocks.MOSSY_COBBLESTONE
                || block == Blocks.SANDSTONE;
    }
}