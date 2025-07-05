package net.tenbris.bank.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.tenbris.bank.Tenbris_Bank;
import net.tenbris.bank.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tenbris_Bank.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.EMERALD_BRICK);

    }

    private void blockWithItem(DeferredBlock<?> deferedBlock) {
        simpleBlockWithItem(deferedBlock.get(), cubeAll(deferedBlock.get()));
    }
}
