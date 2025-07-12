package net.tenbris.bank.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tenbris.bank.Tenbris_Bank;
import net.tenbris.bank.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tenbris_Bank.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ONE_CENT.get());
        basicItem(ModItems.FIVE_CENT.get());
        basicItem(ModItems.TWENTYFIVE_CENT.get());
        basicItem(ModItems.FIFTY_CENT.get());
        basicItem(ModItems.SINGLE_BILL.get());
        basicItem(ModItems.STACK_BILL.get());
        basicItem(ModItems.THUNDER_BRINGER.get());
        basicItem(ModItems.HARD_TACK.get());
        basicItem(ModItems.HARD_TACK_DOUGH.get());

    }
}
