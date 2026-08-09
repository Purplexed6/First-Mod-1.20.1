package net.mak.oresrise.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class OnyxPickaxeItem extends PickaxeItem {


    private static final String MINED_TAG = "OnyxBlocksMined";


    public OnyxPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }



    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {


        if (!level.isClientSide && entity instanceof Player player) {


            int mined =
                    stack.getOrCreateTag().getInt(MINED_TAG);


            mined++;



            if (mined >= 20) {


                // explosion at mined block
                level.explode(
                        player,
                        pos.getX() + 0.5,
                        pos.getY() + 0.5,
                        pos.getZ() + 0.5,
                        15.0F, // explosion power
                        Level.ExplosionInteraction.BLOCK
                );


                mined = 0;
            }



            stack.getOrCreateTag().putInt(
                    MINED_TAG,
                    mined
            );
        }



        return super.mineBlock(stack, level, state, pos, entity);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip,
                                TooltipFlag flag) {

        int mined = stack.getOrCreateTag().getInt(MINED_TAG);

        tooltip.add(
                Component.literal(
                        "Blocks mined: " + mined + "/20"
                )
        );

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
