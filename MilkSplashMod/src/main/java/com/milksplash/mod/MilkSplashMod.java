package com.milksplash.mod;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.milksplash.mod.item.ModItems;
import com.milksplash.mod.potion.ModPotions;

@Mod("milksplashmod")
public class MilkSplashMod {
    public static final String MOD_ID = "milksplashmod";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public MilkSplashMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        ModItems.ITEMS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
        LOGGER.info("Milk Splash Mod Initialized!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Milk Splash Mod common setup!");
    }

    @OnlyIn(Dist.CLIENT)
    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Milk Splash Mod client setup!");
    }
}