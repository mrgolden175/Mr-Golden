package com.deathstar.mod;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.deathstar.mod.block.ModBlocks;
import com.deathstar.mod.item.ModItems;

@Mod("deathstarmod")
public class DeathStarMod {
    public static final String MOD_ID = "deathstarmod";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public DeathStarMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        LOGGER.info("Death Star Mod Initialized!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Death Star Mod common setup!");
    }
}
