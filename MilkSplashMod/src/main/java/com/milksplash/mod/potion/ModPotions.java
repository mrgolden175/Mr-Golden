package com.milksplash.mod.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;
import net.minecraft.core.registries.Registries;
import com.milksplash.mod.MilkSplashMod;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, MilkSplashMod.MOD_ID);

    public static final RegistryObject<Potion> MILK_POTION = POTIONS.register("milk",
            () -> new MilkPotion(new MobEffectInstance(MobEffect.byId(0), 20, 0)));

    public static class MilkPotion extends Potion {
        public MilkPotion(MobEffectInstance... effects) {
            super(effects);
        }

        @Override
        public void applyEffects(LivingEntity entity, double strength) {
            // Remove all potion effects
            entity.removeAllEffects();
        }
    }
}