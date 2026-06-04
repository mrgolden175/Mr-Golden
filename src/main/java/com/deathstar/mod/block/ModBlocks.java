package com.deathstar.mod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;
import net.minecraft.core.registries.Registries;
import com.deathstar.mod.DeathStarMod;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, DeathStarMod.MOD_ID);

    public static final RegistryObject<Block> DEATH_STAR_BLOCK = BLOCKS.register("death_star_block",
            () -> new DeathStarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)
                    .mapColor(MapColor.COLOR_BLACK)));
}
