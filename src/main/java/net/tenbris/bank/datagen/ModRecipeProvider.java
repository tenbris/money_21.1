package net.tenbris.bank.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.tenbris.bank.block.ModBlocks;
import net.tenbris.bank.item.ModItems;

import java.security.PrivateKey;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SINGLE_BILL, 8)
                .pattern("PPP")
                .pattern("PEP")
                .pattern("PPP")
                .define('P', Items.PAPER).define('E', Items.EMERALD)
                .unlockedBy("Has_paper", has(Items.PAPER)).save(recipeOutput, "tenbris_bank:dollar_from_emerald");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.STACK_BILL)
                .requires(ModItems.SINGLE_BILL,9)
                .unlockedBy("singe_bill", has(ModItems.SINGLE_BILL)).save(recipeOutput,"tenbris_bank:dollar_to_stack");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.SINGLE_BILL)
                .requires(ModItems.FIFTY_CENT,2)
                .unlockedBy("fifty_cents", has(ModItems.FIFTY_CENT)).save(recipeOutput,"tenbris_bank:dollar_from_half");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.SINGLE_BILL)
                .requires(ModItems.TWENTYFIVE_CENT,4)
                .unlockedBy("twenty_five_cents", has(ModItems.TWENTYFIVE_CENT)).save(recipeOutput,"tenbris_bank:dollar_from_twenty_five");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.SINGLE_BILL, 9)
                .requires(ModItems.STACK_BILL)
                .unlockedBy("stack_bill", has(ModItems.STACK_BILL)).save(recipeOutput,"tenbris_bank:stack_to_dollar");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.FIFTY_CENT,2)
                .requires(ModItems.SINGLE_BILL)
                .unlockedBy("single_bill", has(ModItems.SINGLE_BILL)).save(recipeOutput,"tenbris_bank:dollar_to_half");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.FIFTY_CENT)
                .requires(ModItems.TWENTYFIVE_CENT,2)
                .unlockedBy("twenty_five_cents", has(ModItems.TWENTYFIVE_CENT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.ONE_CENT, 5)
                .requires(ModItems.FIVE_CENT)
                .unlockedBy("five_cents", has(ModItems.FIVE_CENT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.FIVE_CENT)
                .requires(ModItems.ONE_CENT, 5)
                .unlockedBy("five_cents", has(ModItems.ONE_CENT)).save(recipeOutput, "tenbris_bank:one_from_five");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.FIVE_CENT, 5)
                .requires(ModItems.TWENTYFIVE_CENT)
                .unlockedBy("twenty_five_cents", has(ModItems.TWENTYFIVE_CENT)).save(recipeOutput,"tenbris_bank:five_from_twenty");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.TWENTYFIVE_CENT)
                .requires(ModItems.FIVE_CENT, 5)
                .unlockedBy("five_cents", has(ModItems.FIVE_CENT)).save(recipeOutput,"tenbris_bank:twenty_from_five");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.TWENTYFIVE_CENT, 2)
                .requires(ModItems.FIFTY_CENT)
                .unlockedBy("twenty_five_cents", has(ModItems.FIFTY_CENT)).save(recipeOutput,"tenbris_bank:twenty_from_fifty");

        stoneCutting(Blocks.EMERALD_BLOCK,RecipeCategory.MISC,ModBlocks.EMERALD_BRICK,1, "has_emerald_block", "emerald_bricks", recipeOutput);
        stoneCutting(ModBlocks.EMERALD_BRICK,RecipeCategory.MISC,Blocks.EMERALD_BLOCK,1, "has_emerald_brick", "emerald_block_from_brick", recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.HARD_TACK_DOUGH)
                .requires(Items.BREAD)
                .requires(Items.MILK_BUCKET)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("twenty_five_cents", has(ModItems.TWENTYFIVE_CENT)).save(recipeOutput);

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.HARD_TACK_DOUGH.get()),
                        RecipeCategory.MISC,
                        ModItems.HARD_TACK.get(),
                        0.1f,
                        8400
                )
                .unlockedBy("hard_tack_dough", has(ModItems.HARD_TACK_DOUGH))
                .save(recipeOutput,"hard_tack_smelting");
        SimpleCookingRecipeBuilder.campfireCooking(
            Ingredient.of(ModItems.HARD_TACK_DOUGH.get()),
            RecipeCategory.MISC,
            ModItems.HARD_TACK.get(),
                0.1f,
                8400
        )
                .unlockedBy("hard_tack_dough", has(ModItems.HARD_TACK_DOUGH))
                .save(recipeOutput, "hard_tack_campfire");

        super.buildRecipes(recipeOutput);
    }

    private static void stoneCutting(
            ItemLike input,
            RecipeCategory category,
            ItemLike result,
            int count,
            String criterionName,
            String recipeName,
            RecipeOutput recipeOutput
    ) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, result, count)
                .unlockedBy(criterionName, has(input))
                .save(recipeOutput, recipeName);
    }
}
