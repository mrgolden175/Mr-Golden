package com.deathstar.mod.block;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.Explosion;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class DeathStarBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(2, 2, 2, 14, 14, 14);

    public DeathStarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide && player != null) {
            triggerDeathStarExplosion(level, pos);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    private void triggerDeathStarExplosion(Level level, BlockPos blockPos) {
        // Play explosion sound
        level.playSound(null, blockPos, SoundEvents.EXPLOSION, SoundSource.BLOCKS, 4.0F, 1.0F);

        // Create massive 1000x1000 explosion
        int explosionRadius = 500; // 1000x1000 area
        int centerX = blockPos.getX();
        int centerZ = blockPos.getZ();
        int centerY = blockPos.getY();

        // Destroy blocks in the area
        for (int x = centerX - explosionRadius; x <= centerX + explosionRadius; x++) {
            for (int z = centerZ - explosionRadius; z <= centerZ + explosionRadius; z++) {
                for (int y = centerY - 50; y <= centerY + 50; y++) {
                    BlockPos targetPos = new BlockPos(x, y, z);
                    BlockState targetState = level.getBlockState(targetPos);
                    if (!targetState.getMaterial().isReplaceable()) {
                        level.destroyBlock(targetPos, true);
                    }
                }
            }
        }

        // Create explosion effect
        level.explode(null, centerX, centerY, centerZ, 200.0F, Explosion.BlockInteraction.DESTROY);

        // Remove the Death Star block itself
        level.destroyBlock(blockPos, false);
    }
}
