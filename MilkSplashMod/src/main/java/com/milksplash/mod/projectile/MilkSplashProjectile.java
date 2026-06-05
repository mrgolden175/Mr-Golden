package com.milksplash.mod.projectile;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.nbt.CompoundTag;

public class MilkSplashProjectile extends ThrownPotion {
    public MilkSplashProjectile(EntityType<? extends ThrownPotion> entityType, Level level) {
        super(entityType, level);
    }

    public MilkSplashProjectile(Level level, LivingEntity thrower, ItemStack itemStack) {
        super(level, thrower, itemStack);
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        
        if (!this.level().isClientSide) {
            // Apply milk effect to nearby entities
            for (LivingEntity entity : this.level().getEntitiesOfClass(
                    LivingEntity.class,
                    this.getBoundingBox().inflate(4.0D))) {
                entity.removeAllEffects();
            }
        }
    }
}