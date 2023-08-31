package net.luke.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.luke.tutorialmod.block.ModBlocks;
import net.luke.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RAW_BLOCK_OF_RUBY);

        addDrop(ModBlocks.RUBY_ORE, manyOreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY, 5f, 2f));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, manyOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY, 6f, 3f));
        addDrop(ModBlocks.NETHER_RUBY_ORE, manyOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY, 8f, 4f));
        addDrop(ModBlocks.END_STONE_RUBY_ORE, manyOreDrops(ModBlocks.END_STONE_RUBY_ORE, ModItems.RAW_RUBY, 10f, 6f));

        addDrop(ModBlocks.SAPPHIRE_BLOCK);
        addDrop(ModBlocks.RAW_BLOCK_OF_SAPPHIRE);

        addDrop(ModBlocks.SAPPHIRE_ORE, manyOreDrops(ModBlocks.SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE, 5f, 2f));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, manyOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE, 6f, 3f));
        addDrop(ModBlocks.NETHER_SAPPHIRE_ORE, manyOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE, 8f, 4f));
        addDrop(ModBlocks.END_STONE_SAPPHIRE_ORE, manyOreDrops(ModBlocks.END_STONE_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE, 10f, 6f));

        addDrop(ModBlocks.SOUND_BLOCK);
    }

    public LootTable.Builder manyOreDrops(Block drop, Item item, Float max, Float min) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(min, max))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}