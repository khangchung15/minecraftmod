package net.kg.mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class JohnPorkBlock extends Block {
    public JohnPorkBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!level.isClientSide()) {
            level.playSound(null, pos, SoundEvents.PIG_HURT, SoundSource.BLOCKS, 2f, 1f);
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        if (!level.isClientSide()) {
            BlockPos pos = hit.getBlockPos();
            level.playSound(null, pos.getX(), pos.getY(), pos.getZ(),
                    SoundEvents.PIG_DEATH, SoundSource.BLOCKS, 2f, 1f);
        }
        super.onProjectileHit(level, state, hit, projectile);
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (!level.isClientSide()) {
            ItemStack heldItem = player.getItemInHand(InteractionHand.MAIN_HAND);
            if (heldItem.is(Items.WOODEN_SWORD) ||
                    heldItem.is(Items.STONE_SWORD) ||
                    heldItem.is(Items.IRON_SWORD) ||
                    heldItem.is(Items.GOLDEN_SWORD) ||
                    heldItem.is(Items.DIAMOND_SWORD) ||
                    heldItem.is(Items.NETHERITE_SWORD) ||
                    heldItem.is(Items.WOODEN_AXE) ||
                    heldItem.is(Items.STONE_AXE) ||
                    heldItem.is(Items.IRON_AXE) ||
                    heldItem.is(Items.GOLDEN_AXE) ||
                    heldItem.is(Items.DIAMOND_AXE) ||
                    heldItem.is(Items.NETHERITE_AXE)) {
                level.playSound(null, pos, SoundEvents.PIG_DEATH, SoundSource.BLOCKS, 2f, 1f);
            }
        }
        super.attack(state, level, pos, player);
    }

}