package net.luke.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.luke.tutorialmod.TutorialMod;
import net.luke.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //Item named ruby is registered
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    //Second item is added called raw_ruby
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new FabricItemSettings()));

    //Diamond detector item made from the MetalDectectorItem file which you can see is happening here v
    public static final Item DIAMOND_DETECTOR = registerItem("diamond_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));

    //FOOD
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new FabricItemSettings().food(ModFoodComponents.STRAWBERRY)));

    //FUEL
    public static final Item COAL_BIT = registerItem("coal_bit", new Item(new FabricItemSettings()));
    public static final Item PINE_CONE = registerItem("pine_cone", new Item(new FabricItemSettings()));

    //Add the item Ruby to the ingredients tab in creative
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    //Actually Registers the item passed in (Takes a name and a item object
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    //Tell Minecraft Im Make New Items
    public static void registerModItems() {
        //Say in console we are regersting items (not really nesisary)
        TutorialMod.LOGGER.info("Registering Mod Items for + " + TutorialMod.MOD_ID);

        //Actually adds it to the ingredients tab "INGREDIENTS" and it takes the item from the method addItemsToIngredientsItemGroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
