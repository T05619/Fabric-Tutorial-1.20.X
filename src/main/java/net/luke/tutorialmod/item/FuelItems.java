package net.luke.tutorialmod.item;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class FuelItems implements ModInitializer {
    @Override
    public void onInitialize() {

    }

    public static void registerFuel() {
        FuelRegistry.INSTANCE.add(ModItems.COAL_BIT, 800);
        FuelRegistry.INSTANCE.add(ModItems.PINE_CONE, 1000);
    }
}
