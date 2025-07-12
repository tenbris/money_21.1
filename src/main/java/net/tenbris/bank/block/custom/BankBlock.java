package net.tenbris.bank.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.tenbris.bank.item.ModItems;

import java.util.List;

public class BankBlock extends Block {
    public BankBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if (entity instanceof ItemEntity itemEntity){
            ItemStack itemStack = itemEntity.getItem();
            if (itemStack.getItem() == Items.EMERALD) {
                itemEntity.setItem(new ItemStack(ModItems.SINGLE_BILL.get(), 8));
            }
        }

        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.tenbris_bank.bank_block"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
