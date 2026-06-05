package com.middlefinger.mod.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import com.middlefinger.mod.keybind.MiddleFingerKeybind;

@Mod.EventBusSubscriber(modid = "middlefingermod", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(MiddleFingerKeybind.MIDDLE_FINGER_KEY);
    }
}