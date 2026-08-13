package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.LootParams;

public class ModPickaxeItem extends PickaxeItem {

    public ModPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {

        if (this.getTier() == ModToolTiers.SCOURIUM && entity instanceof Player player) {

            if (!level.isClientSide && level instanceof ServerLevel serverLevel) {

                //
                LootParams.Builder builder = new LootParams.Builder(serverLevel)
                        .withParameter(LootContextParams.ORIGIN, pos.getCenter())
                        .withParameter(LootContextParams.THIS_ENTITY, player);

                ItemStack fakeTool = stack.copy();
                fakeTool.enchant(Enchantments.SILK_TOUCH, 1);

                builder.withParameter(LootContextParams.TOOL, fakeTool);

                for (ItemStack drop : state.getDrops(builder)) {
                    Block.popResource(level, pos, drop);
                }

                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);

                stack.hurtAndBreak(1, entity, living ->
                        living.broadcastBreakEvent(entity.getUsedItemHand()));

                level.levelEvent(2001, pos, Block.getId(state));

                player.awardStat(Stats.BLOCK_MINED.get(state.getBlock()));

                return true;
            }
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }
}