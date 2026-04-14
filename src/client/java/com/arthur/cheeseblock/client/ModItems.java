package com.arthur.cheeseblock.client;

import com.arthur.cheeseblock.CheeseBlock;
import com.arthur.cheeseblock.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import java.util.function.Function;

public class ModItems {
    public static final Item CHEESE_SLICE = register("cheese_slice", Item::new,
            new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.6f)
                    .build()));
    public static final Item BLOCK_O_CHEESE = register("block_o_cheese",
            props -> new BlockItem(ModBlocks.BLOCK_O_CHEESE, props),
            new Item.Properties());
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CheeseBlock.MOD_ID, name));
        // Create the item instance.

        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.CHEESE_SLICE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((creativeTab) -> creativeTab.accept(ModItems.BLOCK_O_CHEESE));
    }

}