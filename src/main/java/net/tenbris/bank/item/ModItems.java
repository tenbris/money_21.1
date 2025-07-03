package net.tenbris.bank.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tenbris.bank.Tenbris_Bank;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Tenbris_Bank.MOD_ID);

    public static final DeferredItem<Item> ONE_CENT = ITEMS.register("one_cent",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FIVE_CENT = ITEMS.register("five_cent",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TWENTYFIVE_CENT = ITEMS.register("twentyfive_cent",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FIFTY_CENT = ITEMS.register("fifty_cent",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SINGLE_BILL = ITEMS.register("single_bill",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STACK_BILL = ITEMS.register("stack_bill",
            ()-> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
