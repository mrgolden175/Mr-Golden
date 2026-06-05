package com.middlefinger.mod;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.middlefinger.mod.keybind.KeyBindings;

@Mod("middlefingermod")
public class MiddleFingerMod {
    public static final String MOD_ID = "middlefingermod";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public MiddleFingerMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        LOGGER.info("Middle Finger Mod Initialized!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Middle Finger Mod common setup!");
    }

    @OnlyIn(Dist.CLIENT)
    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Middle Finger Mod client setup!");
    }
}