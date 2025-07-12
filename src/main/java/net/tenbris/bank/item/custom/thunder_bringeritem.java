package net.tenbris.bank.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class thunder_bringeritem extends Item {
    public thunder_bringeritem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        Block clickedblock = level.getBlockState(context.getClickedPos()).getBlock();

        if (!level.isClientSide()) {
            // Get the position where the block was clicked
            Vec3 clickPos = context.getClickedPos().getCenter();

            // Create a lightning bolt entity
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning != null) {
                // Set the lightning bolt's position to the clicked location
                lightning.moveTo(clickPos.x, clickPos.y, clickPos.z);
                // Spawn the lightning bolt in the world
                level.addFreshEntity(lightning);
            }

            // Optional: Damage the item (if it has durability)
            if (!context.getPlayer().isCreative()) {
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND)
                        );

            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.tenbris_bank.thunder_bringer"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
