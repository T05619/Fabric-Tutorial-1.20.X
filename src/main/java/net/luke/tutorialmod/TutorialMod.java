package net.luke.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.luke.tutorialmod.block.ModBlocks;
import net.luke.tutorialmod.item.FuelItems;
import net.luke.tutorialmod.item.ModItemGroups;
import net.luke.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups(); //Make a new creative tab to hold all the new items
		ModItems.registerModItems(); //Call the function inside the class
		ModBlocks.registerModBlocks(); //Makes the blocks
		FuelItems.registerFuel(); //Register Fuels
	}
}