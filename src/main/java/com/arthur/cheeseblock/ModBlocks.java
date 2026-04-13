package com.arthur.cheeseblock;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static final Block BLOCK_O_CHEESE = register(
            "block_o_cheese",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(0.5f)
                    .sound(SoundType.WOOL)
    );

    public static <T extends Block> T register(String name, Function<BlockBehaviour.Properties, T> blockFactory, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CheeseBlock.MOD_ID, name));
        T block = blockFactory.apply(settings.setId(blockKey));
        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        return block;
    }

    public static void initialize() {
        // Calling this method forces the static fields to initialise and register the block
    }
}

