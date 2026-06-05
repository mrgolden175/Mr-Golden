package com.middlefinger.mod.keybind;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.renderer.entity.ItemInHandRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = "middlefingermod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MiddleFingerKeybind {
    public static final KeyMapping MIDDLE_FINGER_KEY = new KeyMapping(
            "key.middlefingermod.middle_finger",
            GLFW.GLFW_KEY_Z,
            "key.categories.gameplay"
    );

    private static boolean isShowingMiddleFinger = false;
    private static int middleFingerDuration = 0;
    private static final int MAX_DURATION = 60; // 3 seconds (60 ticks)

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        if (MIDDLE_FINGER_KEY.consumeClick()) {
            isShowingMiddleFinger = true;
            middleFingerDuration = MAX_DURATION;
        }
    }

    @SubscribeEvent
    public static void onRender(RenderPlayerEvent.Post event) {
        if (!isShowingMiddleFinger || middleFingerDuration <= 0) {
            return;
        }

        if (Minecraft.getInstance().player == event.getEntity()) {
            showMiddleFinger(event);
        }
    }

    private static void showMiddleFinger(RenderPlayerEvent.Post event) {
        PoseStack poseStack = event.getPoseStack();
        poseStack.pushPose();

        // Translate to hand position
        poseStack.translate(0.3, -0.3, 0.3);
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(45));
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(90));
        poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(180));
        poseStack.scale(0.5f, 0.5f, 0.5f);

        // Render middle finger (using a simple shape)
        renderFingerModel(poseStack, event.getPartialTick());

        poseStack.popPose();

        middleFingerDuration--;
        if (middleFingerDuration <= 0) {
            isShowingMiddleFinger = false;
        }
    }

    private static void renderFingerModel(PoseStack poseStack, float partialTick) {
        // This is a simplified representation
        // In a full implementation, you'd use a custom model
        RenderSystem.setShaderColor(1.0f, 0.8f, 0.6f, 1.0f); // Skin color
    }

    public static boolean isShowingMiddleFinger() {
        return isShowingMiddleFinger && middleFingerDuration > 0;
    }
}