package net.luke.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.luke.tutorialmod.block.ModBlocks;
import net.luke.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE);

    private static final List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE,
            ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.NETHER_SAPPHIRE_ORE, ModBlocks.END_STONE_SAPPHIRE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                1.2f, 100, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                1.5f, 80, "ruby");

        offerSmelting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                1.2f, 100, "sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                1.5f, 80, "sapphire");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_BLOCK_OF_RUBY);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_BLOCK_OF_SAPPHIRE);
    }
}