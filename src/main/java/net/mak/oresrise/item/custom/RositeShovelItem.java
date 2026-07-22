package net.mak.oresrise.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class RositeShovelItem extends ShovelItem {

    public RositeShovelItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        builder.putAll(super.getDefaultAttributeModifiers(slot));

        if (slot == EquipmentSlot.MAINHAND) {
            builder.put(
                    ForgeMod.BLOCK_REACH.get(),
                    new AttributeModifier(
                            UUID.fromString("a1b2c3d4-e5f6-7890-abcd-123456789003"),
                            "Rosite Reach",
                            2.0,
                            AttributeModifier.Operation.ADDITION
                    )
            );
        }

        return builder.build();
    }
}
