package com.deathstar.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;
import net.minecraft.core.registries.Registries;
import com.deathstar.mod.DeathStarMod;
import com.deathstar.mod.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, DeathStarMod.MOD_ID);

    public static final RegistryObject<Item> DEATH_STAR_BLOCK = ITEMS.register("death_star_block",
            () -> new BlockItem(ModBlocks.DEATH_STAR_BLOCK.get(), new Item.Properties()));
}
