package net.luke.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.luke.tutorialmod.TutorialMod;
import net.luke.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //Create a new creative tab that contains Ruby and Raw Ruby
    public static  final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_BLOCK_OF_RUBY);

                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);

                        entries.add(ModItems.DIAMOND_DETECTOR);

                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.RAW_SAPPHIRE);

                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.RAW_BLOCK_OF_SAPPHIRE);

                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                        entries.add(ModBlocks.NETHER_SAPPHIRE_ORE);
                        entries.add(ModBlocks.END_STONE_SAPPHIRE_ORE);

                        entries.add(ModBlocks.SOUND_BLOCK);

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.STRAWBERRY);

                        entries.add(ModItems.COAL_BIT);
                        entries.add(ModItems.PINE_CONE);
                    }).build());
    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
