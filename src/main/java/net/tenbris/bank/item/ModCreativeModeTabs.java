package net.tenbris.bank.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tenbris.bank.Tenbris_Bank;
import net.tenbris.bank.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tenbris_Bank.MOD_ID);

    public static final Supplier<CreativeModeTab> MONEY_ITEMS = CREATIVE_MODE_TAB.register("money_items",
            ()-> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ModItems.STACK_BILL.get()))
                    .title(Component.translatable("creativetabs.tenbris_bank.money_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ONE_CENT);
                        output.accept(ModItems.FIVE_CENT);
                        output.accept(ModItems.TWENTYFIVE_CENT);
                        output.accept(ModItems.FIFTY_CENT);
                        output.accept(ModItems.SINGLE_BILL);
                        output.accept(ModItems.STACK_BILL);
                        output.accept(ModItems.THUNDER_BRINGER);
                        output.accept(ModItems.HARD_TACK);
                        output.accept(ModItems.HARD_TACK_DOUGH);
                    })
                    .build());
    public static final Supplier<CreativeModeTab> MONEY_BLOCK = CREATIVE_MODE_TAB.register("money_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.EMERALD_BRICK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Tenbris_Bank.MOD_ID, "money_items"))
                    .title(Component.translatable("creativetab.tenbris_bank.money_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.EMERALD_BRICK);
                        output.accept(ModBlocks.BANK);

                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
