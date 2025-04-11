package net.kg.mod.block.custom;

import net.kg.mod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class TransmutationBlock extends Block {
    private static Map<Item, Item> transmutationMap;

    public TransmutationBlock(Properties properties) {
        super(properties);
    }

    private static Map<Item, Item> getTransmutationMap() {
        if (transmutationMap == null) {
            transmutationMap = Map.ofEntries(
                    //Music Disc
                    Map.entry(Items.MUSIC_DISC_13, Items.MUSIC_DISC_CAT),
                    Map.entry(Items.MUSIC_DISC_CAT, Items.MUSIC_DISC_BLOCKS),
                    Map.entry(Items.MUSIC_DISC_BLOCKS, Items.MUSIC_DISC_CHIRP),
                    Map.entry(Items.MUSIC_DISC_CHIRP, Items.MUSIC_DISC_FAR),
                    Map.entry(Items.MUSIC_DISC_FAR, Items.MUSIC_DISC_MALL),
                    Map.entry(Items.MUSIC_DISC_MALL, Items.MUSIC_DISC_MELLOHI),
                    Map.entry(Items.MUSIC_DISC_MELLOHI, Items.MUSIC_DISC_STAL),
                    Map.entry(Items.MUSIC_DISC_STAL, Items.MUSIC_DISC_STRAD),
                    Map.entry(Items.MUSIC_DISC_STRAD, Items.MUSIC_DISC_WARD),
                    Map.entry(Items.MUSIC_DISC_WARD, Items.MUSIC_DISC_11),
                    Map.entry(Items.MUSIC_DISC_11, Items.MUSIC_DISC_CREATOR_MUSIC_BOX),
                    Map.entry(Items.MUSIC_DISC_CREATOR_MUSIC_BOX, Items.MUSIC_DISC_WAIT),
                    Map.entry(Items.MUSIC_DISC_WAIT, Items.MUSIC_DISC_CREATOR),
                    Map.entry(Items.MUSIC_DISC_CREATOR, Items.MUSIC_DISC_PRECIPICE),
                    Map.entry(Items.MUSIC_DISC_PRECIPICE, Items.MUSIC_DISC_OTHERSIDE),
                    Map.entry(Items.MUSIC_DISC_OTHERSIDE, Items.MUSIC_DISC_RELIC),
                    Map.entry(Items.MUSIC_DISC_RELIC, Items.MUSIC_DISC_5),
                    Map.entry(Items.MUSIC_DISC_5, Items.MUSIC_DISC_PIGSTEP),

                    //Coral
                    Map.entry(Items.TUBE_CORAL, Items.BRAIN_CORAL),
                    Map.entry(Items.BRAIN_CORAL, Items.BUBBLE_CORAL),
                    Map.entry(Items.BUBBLE_CORAL, Items.FIRE_CORAL),
                    Map.entry(Items.FIRE_CORAL, Items.HORN_CORAL),
                    Map.entry(Items.HORN_CORAL, Items.TUBE_CORAL),
                    Map.entry(Items.TUBE_CORAL_FAN, Items.BRAIN_CORAL_FAN),
                    Map.entry(Items.BRAIN_CORAL_FAN, Items.BUBBLE_CORAL_FAN),
                    Map.entry(Items.BUBBLE_CORAL_FAN, Items.FIRE_CORAL_FAN),
                    Map.entry(Items.FIRE_CORAL_FAN, Items.HORN_CORAL_FAN),
                    Map.entry(Items.HORN_CORAL_FAN, Items.TUBE_CORAL_FAN),
                    Map.entry(Items.TUBE_CORAL_BLOCK, Items.BRAIN_CORAL_BLOCK),
                    Map.entry(Items.BRAIN_CORAL_BLOCK, Items.BUBBLE_CORAL_BLOCK),
                    Map.entry(Items.BUBBLE_CORAL_BLOCK, Items.FIRE_CORAL_BLOCK),
                    Map.entry(Items.FIRE_CORAL_BLOCK, Items.HORN_CORAL_BLOCK),
                    Map.entry(Items.HORN_CORAL_BLOCK, Items.TUBE_CORAL_BLOCK),
                    Map.entry(Items.DEAD_TUBE_CORAL, Items.DEAD_BRAIN_CORAL),
                    Map.entry(Items.DEAD_BRAIN_CORAL, Items.DEAD_BUBBLE_CORAL),
                    Map.entry(Items.DEAD_BUBBLE_CORAL, Items.DEAD_FIRE_CORAL),
                    Map.entry(Items.DEAD_FIRE_CORAL, Items.DEAD_HORN_CORAL),
                    Map.entry(Items.DEAD_HORN_CORAL, Items.DEAD_TUBE_CORAL),
                    Map.entry(Items.DEAD_TUBE_CORAL_FAN, Items.DEAD_BRAIN_CORAL_FAN),
                    Map.entry(Items.DEAD_BRAIN_CORAL_FAN, Items.DEAD_BUBBLE_CORAL_FAN),
                    Map.entry(Items.DEAD_BUBBLE_CORAL_FAN, Items.DEAD_FIRE_CORAL_FAN),
                    Map.entry(Items.DEAD_FIRE_CORAL_FAN, Items.DEAD_HORN_CORAL_FAN),
                    Map.entry(Items.DEAD_HORN_CORAL_FAN, Items.DEAD_TUBE_CORAL_FAN),
                    Map.entry(Items.DEAD_TUBE_CORAL_BLOCK, Items.DEAD_BRAIN_CORAL_BLOCK),
                    Map.entry(Items.DEAD_BRAIN_CORAL_BLOCK, Items.DEAD_BUBBLE_CORAL_BLOCK),
                    Map.entry(Items.DEAD_BUBBLE_CORAL_BLOCK, Items.DEAD_FIRE_CORAL_BLOCK),
                    Map.entry(Items.DEAD_FIRE_CORAL_BLOCK, Items.DEAD_HORN_CORAL_BLOCK),
                    Map.entry(Items.DEAD_HORN_CORAL_BLOCK, Items.DEAD_TUBE_CORAL_BLOCK),

                    //Leaves
                    Map.entry(Items.OAK_LEAVES, Items.BIRCH_LEAVES),
                    Map.entry(Items.BIRCH_LEAVES, Items.SPRUCE_LEAVES),
                    Map.entry(Items.SPRUCE_LEAVES, Items.JUNGLE_LEAVES),
                    Map.entry(Items.JUNGLE_LEAVES, Items.ACACIA_LEAVES),
                    Map.entry(Items.ACACIA_LEAVES, Items.DARK_OAK_LEAVES),
                    Map.entry(Items.DARK_OAK_LEAVES, Items.MANGROVE_LEAVES),
                    Map.entry(Items.MANGROVE_LEAVES, Items.CHERRY_LEAVES),
                    Map.entry(Items.CHERRY_LEAVES, Items.NETHER_WART_BLOCK),
                    Map.entry(Items.NETHER_WART_BLOCK, Items.WARPED_WART_BLOCK),
                    Map.entry(Items.WARPED_WART_BLOCK, Items.OAK_LEAVES),

                    //Saplings
                    Map.entry(Items.OAK_SAPLING, Items.BIRCH_SAPLING),
                    Map.entry(Items.BIRCH_SAPLING, Items.SPRUCE_SAPLING),
                    Map.entry(Items.SPRUCE_SAPLING, Items.JUNGLE_SAPLING),
                    Map.entry(Items.JUNGLE_SAPLING, Items.ACACIA_SAPLING),
                    Map.entry(Items.ACACIA_SAPLING, Items.DARK_OAK_SAPLING),
                    Map.entry(Items.DARK_OAK_SAPLING, Items.MANGROVE_PROPAGULE),
                    Map.entry(Items.MANGROVE_PROPAGULE, Items.CHERRY_SAPLING),
                    Map.entry(Items.CHERRY_SAPLING, Items.OAK_SAPLING),

                    Map.entry(Items.OAK_BOAT, Items.BIRCH_BOAT),
                    Map.entry(Items.BIRCH_BOAT, Items.SPRUCE_BOAT),
                    Map.entry(Items.SPRUCE_BOAT, Items.JUNGLE_BOAT),
                    Map.entry(Items.JUNGLE_BOAT, Items.ACACIA_BOAT),
                    Map.entry(Items.ACACIA_BOAT, Items.DARK_OAK_BOAT),
                    Map.entry(Items.DARK_OAK_BOAT, Items.MANGROVE_BOAT),
                    Map.entry(Items.MANGROVE_BOAT, Items.CHERRY_BOAT),
                    Map.entry(Items.CHERRY_BOAT, Items.OAK_BOAT),

                    Map.entry(Items.OAK_CHEST_BOAT, Items.BIRCH_CHEST_BOAT),
                    Map.entry(Items.BIRCH_CHEST_BOAT, Items.SPRUCE_CHEST_BOAT),
                    Map.entry(Items.SPRUCE_CHEST_BOAT, Items.JUNGLE_CHEST_BOAT),
                    Map.entry(Items.JUNGLE_CHEST_BOAT, Items.ACACIA_CHEST_BOAT),
                    Map.entry(Items.ACACIA_CHEST_BOAT, Items.DARK_OAK_CHEST_BOAT),
                    Map.entry(Items.DARK_OAK_CHEST_BOAT, Items.MANGROVE_CHEST_BOAT),
                    Map.entry(Items.MANGROVE_CHEST_BOAT, Items.CHERRY_CHEST_BOAT),
                    Map.entry(Items.CHERRY_CHEST_BOAT, Items.OAK_CHEST_BOAT),

                    //Log
                    Map.entry(Items.OAK_LOG, Items.BIRCH_LOG),
                    Map.entry(Items.BIRCH_LOG, Items.SPRUCE_LOG),
                    Map.entry(Items.SPRUCE_LOG, Items.JUNGLE_LOG),
                    Map.entry(Items.JUNGLE_LOG, Items.ACACIA_LOG),
                    Map.entry(Items.ACACIA_LOG, Items.DARK_OAK_LOG),
                    Map.entry(Items.DARK_OAK_LOG, Items.MANGROVE_LOG),
                    Map.entry(Items.MANGROVE_LOG, Items.CHERRY_LOG),
                    Map.entry(Items.CHERRY_LOG, Items.CRIMSON_STEM),
                    Map.entry(Items.CRIMSON_STEM, Items.WARPED_STEM),
                    Map.entry(Items.WARPED_STEM, Items.OAK_LOG),

                    //Stripped Log
                    Map.entry(Items.STRIPPED_OAK_LOG, Items.STRIPPED_BIRCH_LOG),
                    Map.entry(Items.STRIPPED_BIRCH_LOG, Items.STRIPPED_SPRUCE_LOG),
                    Map.entry(Items.STRIPPED_SPRUCE_LOG, Items.STRIPPED_JUNGLE_LOG),
                    Map.entry(Items.STRIPPED_JUNGLE_LOG, Items.STRIPPED_ACACIA_LOG),
                    Map.entry(Items.STRIPPED_ACACIA_LOG, Items.STRIPPED_DARK_OAK_LOG),
                    Map.entry(Items.STRIPPED_DARK_OAK_LOG, Items.STRIPPED_MANGROVE_LOG),
                    Map.entry(Items.STRIPPED_MANGROVE_LOG, Items.STRIPPED_CHERRY_LOG),
                    Map.entry(Items.STRIPPED_CHERRY_LOG, Items.STRIPPED_CRIMSON_STEM),
                    Map.entry(Items.STRIPPED_CRIMSON_STEM, Items.STRIPPED_WARPED_STEM),
                    Map.entry(Items.STRIPPED_WARPED_STEM, Items.STRIPPED_OAK_LOG),

                    //Wood
                    Map.entry(Items.OAK_WOOD, Items.BIRCH_WOOD),
                    Map.entry(Items.BIRCH_WOOD, Items.SPRUCE_WOOD),
                    Map.entry(Items.SPRUCE_WOOD, Items.JUNGLE_WOOD),
                    Map.entry(Items.JUNGLE_WOOD, Items.ACACIA_WOOD),
                    Map.entry(Items.ACACIA_WOOD, Items.DARK_OAK_WOOD),
                    Map.entry(Items.DARK_OAK_WOOD, Items.MANGROVE_WOOD),
                    Map.entry(Items.MANGROVE_WOOD, Items.CHERRY_WOOD),
                    Map.entry(Items.CHERRY_WOOD, Items.CRIMSON_HYPHAE),
                    Map.entry(Items.CRIMSON_HYPHAE, Items.WARPED_HYPHAE),
                    Map.entry(Items.WARPED_HYPHAE, Items.OAK_WOOD),
                    
                    //Stripped wood
                    Map.entry(Items.STRIPPED_OAK_WOOD, Items.STRIPPED_BIRCH_WOOD),
                    Map.entry(Items.STRIPPED_BIRCH_WOOD, Items.STRIPPED_SPRUCE_WOOD),
                    Map.entry(Items.STRIPPED_SPRUCE_WOOD, Items.STRIPPED_JUNGLE_WOOD),
                    Map.entry(Items.STRIPPED_JUNGLE_WOOD, Items.STRIPPED_ACACIA_WOOD),
                    Map.entry(Items.STRIPPED_ACACIA_WOOD, Items.STRIPPED_DARK_OAK_WOOD),
                    Map.entry(Items.STRIPPED_DARK_OAK_WOOD, Items.STRIPPED_MANGROVE_WOOD),
                    Map.entry(Items.STRIPPED_MANGROVE_WOOD, Items.STRIPPED_CHERRY_WOOD),
                    Map.entry(Items.STRIPPED_CHERRY_WOOD, Items.STRIPPED_CRIMSON_HYPHAE),
                    Map.entry(Items.STRIPPED_CRIMSON_HYPHAE, Items.STRIPPED_WARPED_HYPHAE),
                    Map.entry(Items.STRIPPED_WARPED_HYPHAE, Items.STRIPPED_OAK_WOOD),

                    //Wood planks
                    Map.entry(Items.OAK_PLANKS, Items.BIRCH_PLANKS),
                    Map.entry(Items.BIRCH_PLANKS, Items.SPRUCE_PLANKS),
                    Map.entry(Items.SPRUCE_PLANKS, Items.JUNGLE_PLANKS),
                    Map.entry(Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS),
                    Map.entry(Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS),
                    Map.entry(Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS),
                    Map.entry(Items.MANGROVE_PLANKS, Items.CHERRY_PLANKS),
                    Map.entry(Items.CHERRY_PLANKS, Items.CRIMSON_PLANKS),
                    Map.entry(Items.CRIMSON_PLANKS, Items.WARPED_PLANKS),
                    Map.entry(Items.WARPED_PLANKS, Items.OAK_PLANKS),

                    //Wood stairs
                    Map.entry(Items.OAK_STAIRS, Items.BIRCH_STAIRS),
                    Map.entry(Items.BIRCH_STAIRS, Items.SPRUCE_STAIRS),
                    Map.entry(Items.SPRUCE_STAIRS, Items.JUNGLE_STAIRS),
                    Map.entry(Items.JUNGLE_STAIRS, Items.ACACIA_STAIRS),
                    Map.entry(Items.ACACIA_STAIRS, Items.DARK_OAK_STAIRS),
                    Map.entry(Items.DARK_OAK_STAIRS, Items.MANGROVE_STAIRS),
                    Map.entry(Items.MANGROVE_STAIRS, Items.CHERRY_STAIRS),
                    Map.entry(Items.CHERRY_STAIRS, Items.CRIMSON_STAIRS),
                    Map.entry(Items.CRIMSON_STAIRS, Items.WARPED_STAIRS),
                    Map.entry(Items.WARPED_STAIRS, Items.OAK_STAIRS),

                    //Wood slab
                    Map.entry(Items.OAK_SLAB, Items.BIRCH_SLAB),
                    Map.entry(Items.BIRCH_SLAB, Items.SPRUCE_SLAB),
                    Map.entry(Items.SPRUCE_SLAB, Items.JUNGLE_SLAB),
                    Map.entry(Items.JUNGLE_SLAB, Items.ACACIA_SLAB),
                    Map.entry(Items.ACACIA_SLAB, Items.DARK_OAK_SLAB),
                    Map.entry(Items.DARK_OAK_SLAB, Items.MANGROVE_SLAB),
                    Map.entry(Items.MANGROVE_SLAB, Items.CHERRY_SLAB),
                    Map.entry(Items.CHERRY_SLAB, Items.CRIMSON_SLAB),
                    Map.entry(Items.CRIMSON_SLAB, Items.WARPED_SLAB),
                    Map.entry(Items.WARPED_SLAB, Items.OAK_SLAB),

                    //Wood fence
                    Map.entry(Items.OAK_FENCE, Items.BIRCH_FENCE),
                    Map.entry(Items.BIRCH_FENCE, Items.SPRUCE_FENCE),
                    Map.entry(Items.SPRUCE_FENCE, Items.JUNGLE_FENCE),
                    Map.entry(Items.JUNGLE_FENCE, Items.ACACIA_FENCE),
                    Map.entry(Items.ACACIA_FENCE, Items.DARK_OAK_FENCE),
                    Map.entry(Items.DARK_OAK_FENCE, Items.MANGROVE_FENCE),
                    Map.entry(Items.MANGROVE_FENCE, Items.CHERRY_FENCE),
                    Map.entry(Items.CHERRY_FENCE, Items.CRIMSON_FENCE),
                    Map.entry(Items.CRIMSON_FENCE, Items.WARPED_FENCE),
                    Map.entry(Items.WARPED_FENCE, Items.OAK_FENCE),

                    //Wood fence gate
                    Map.entry(Items.OAK_FENCE_GATE, Items.BIRCH_FENCE_GATE),
                    Map.entry(Items.BIRCH_FENCE_GATE, Items.SPRUCE_FENCE_GATE),
                    Map.entry(Items.SPRUCE_FENCE_GATE, Items.JUNGLE_FENCE_GATE),
                    Map.entry(Items.JUNGLE_FENCE_GATE, Items.ACACIA_FENCE_GATE),
                    Map.entry(Items.ACACIA_FENCE_GATE, Items.DARK_OAK_FENCE_GATE),
                    Map.entry(Items.DARK_OAK_FENCE_GATE, Items.MANGROVE_FENCE_GATE),
                    Map.entry(Items.MANGROVE_FENCE_GATE, Items.CHERRY_FENCE_GATE),
                    Map.entry(Items.CHERRY_FENCE_GATE, Items.CRIMSON_FENCE_GATE),
                    Map.entry(Items.CRIMSON_FENCE_GATE, Items.WARPED_FENCE_GATE),
                    Map.entry(Items.WARPED_FENCE_GATE, Items.OAK_FENCE_GATE),

                    //Wood door
                    Map.entry(Items.OAK_DOOR, Items.BIRCH_DOOR),
                    Map.entry(Items.BIRCH_DOOR, Items.SPRUCE_DOOR),
                    Map.entry(Items.SPRUCE_DOOR, Items.JUNGLE_DOOR),
                    Map.entry(Items.JUNGLE_DOOR, Items.ACACIA_DOOR),
                    Map.entry(Items.ACACIA_DOOR, Items.DARK_OAK_DOOR),
                    Map.entry(Items.DARK_OAK_DOOR, Items.MANGROVE_DOOR),
                    Map.entry(Items.MANGROVE_DOOR, Items.CHERRY_DOOR),
                    Map.entry(Items.CHERRY_DOOR, Items.CRIMSON_DOOR),
                    Map.entry(Items.CRIMSON_DOOR, Items.WARPED_DOOR),
                    Map.entry(Items.WARPED_DOOR, Items.OAK_DOOR),

                    //Wood trapdoor
                    Map.entry(Items.OAK_TRAPDOOR, Items.BIRCH_TRAPDOOR),
                    Map.entry(Items.BIRCH_TRAPDOOR, Items.SPRUCE_TRAPDOOR),
                    Map.entry(Items.SPRUCE_TRAPDOOR, Items.JUNGLE_TRAPDOOR),
                    Map.entry(Items.JUNGLE_TRAPDOOR, Items.ACACIA_TRAPDOOR),
                    Map.entry(Items.ACACIA_TRAPDOOR, Items.DARK_OAK_TRAPDOOR),
                    Map.entry(Items.DARK_OAK_TRAPDOOR, Items.MANGROVE_TRAPDOOR),
                    Map.entry(Items.MANGROVE_TRAPDOOR, Items.CHERRY_TRAPDOOR),
                    Map.entry(Items.CHERRY_TRAPDOOR, Items.CRIMSON_TRAPDOOR),
                    Map.entry(Items.CRIMSON_TRAPDOOR, Items.WARPED_TRAPDOOR),
                    Map.entry(Items.WARPED_TRAPDOOR, Items.OAK_TRAPDOOR),

                    Map.entry(Items.OAK_PRESSURE_PLATE, Items.BIRCH_PRESSURE_PLATE),
                    Map.entry(Items.BIRCH_PRESSURE_PLATE, Items.SPRUCE_PRESSURE_PLATE),
                    Map.entry(Items.SPRUCE_PRESSURE_PLATE, Items.JUNGLE_PRESSURE_PLATE),
                    Map.entry(Items.JUNGLE_PRESSURE_PLATE, Items.ACACIA_PRESSURE_PLATE),
                    Map.entry(Items.ACACIA_PRESSURE_PLATE, Items.DARK_OAK_PRESSURE_PLATE),
                    Map.entry(Items.DARK_OAK_PRESSURE_PLATE, Items.MANGROVE_PRESSURE_PLATE),
                    Map.entry(Items.MANGROVE_PRESSURE_PLATE, Items.CHERRY_PRESSURE_PLATE),
                    Map.entry(Items.CHERRY_PRESSURE_PLATE, Items.CRIMSON_PRESSURE_PLATE),
                    Map.entry(Items.CRIMSON_PRESSURE_PLATE, Items.WARPED_PRESSURE_PLATE),
                    Map.entry(Items.WARPED_PRESSURE_PLATE, Items.OAK_PRESSURE_PLATE),

                    Map.entry(Items.OAK_BUTTON, Items.BIRCH_BUTTON),
                    Map.entry(Items.BIRCH_BUTTON, Items.SPRUCE_BUTTON),
                    Map.entry(Items.SPRUCE_BUTTON, Items.JUNGLE_BUTTON),
                    Map.entry(Items.JUNGLE_BUTTON, Items.ACACIA_BUTTON),
                    Map.entry(Items.ACACIA_BUTTON, Items.DARK_OAK_BUTTON),
                    Map.entry(Items.DARK_OAK_BUTTON, Items.MANGROVE_BUTTON),
                    Map.entry(Items.MANGROVE_BUTTON, Items.CHERRY_BUTTON),
                    Map.entry(Items.CHERRY_BUTTON, Items.CRIMSON_BUTTON),
                    Map.entry(Items.CRIMSON_BUTTON, Items.WARPED_BUTTON),
                    Map.entry(Items.WARPED_BUTTON, Items.OAK_BUTTON),

                    Map.entry(Items.OAK_SIGN, Items.BIRCH_SIGN),
                    Map.entry(Items.BIRCH_SIGN, Items.SPRUCE_SIGN),
                    Map.entry(Items.SPRUCE_SIGN, Items.JUNGLE_SIGN),
                    Map.entry(Items.JUNGLE_SIGN, Items.ACACIA_SIGN),
                    Map.entry(Items.ACACIA_SIGN, Items.DARK_OAK_SIGN),
                    Map.entry(Items.DARK_OAK_SIGN, Items.MANGROVE_SIGN),
                    Map.entry(Items.MANGROVE_SIGN, Items.CHERRY_SIGN),
                    Map.entry(Items.CHERRY_SIGN, Items.CRIMSON_SIGN),
                    Map.entry(Items.CRIMSON_SIGN, Items.WARPED_SIGN),
                    Map.entry(Items.WARPED_SIGN, Items.OAK_SIGN),

                    Map.entry(Items.OAK_HANGING_SIGN, Items.BIRCH_HANGING_SIGN),
                    Map.entry(Items.BIRCH_HANGING_SIGN, Items.SPRUCE_HANGING_SIGN),
                    Map.entry(Items.SPRUCE_HANGING_SIGN, Items.JUNGLE_HANGING_SIGN),
                    Map.entry(Items.JUNGLE_HANGING_SIGN, Items.ACACIA_HANGING_SIGN),
                    Map.entry(Items.ACACIA_HANGING_SIGN, Items.DARK_OAK_HANGING_SIGN),
                    Map.entry(Items.DARK_OAK_HANGING_SIGN, Items.MANGROVE_HANGING_SIGN),
                    Map.entry(Items.MANGROVE_HANGING_SIGN, Items.CHERRY_HANGING_SIGN),
                    Map.entry(Items.CHERRY_HANGING_SIGN, Items.CRIMSON_HANGING_SIGN),
                    Map.entry(Items.CRIMSON_HANGING_SIGN, Items.WARPED_HANGING_SIGN),
                    Map.entry(Items.WARPED_HANGING_SIGN, Items.OAK_HANGING_SIGN),

                    // Dyes
                    Map.entry(Items.BLACK_DYE, Items.BLUE_DYE),
                    Map.entry(Items.BLUE_DYE, Items.BROWN_DYE),
                    Map.entry(Items.BROWN_DYE, Items.CYAN_DYE),
                    Map.entry(Items.CYAN_DYE, Items.GRAY_DYE),
                    Map.entry(Items.GRAY_DYE, Items.GREEN_DYE),
                    Map.entry(Items.GREEN_DYE, Items.LIGHT_BLUE_DYE),
                    Map.entry(Items.LIGHT_BLUE_DYE, Items.LIGHT_GRAY_DYE),
                    Map.entry(Items.LIGHT_GRAY_DYE, Items.LIME_DYE),
                    Map.entry(Items.LIME_DYE, Items.MAGENTA_DYE),
                    Map.entry(Items.MAGENTA_DYE, Items.ORANGE_DYE),
                    Map.entry(Items.ORANGE_DYE, Items.PINK_DYE),
                    Map.entry(Items.PINK_DYE, Items.PURPLE_DYE),
                    Map.entry(Items.PURPLE_DYE, Items.RED_DYE),
                    Map.entry(Items.RED_DYE, Items.WHITE_DYE),
                    Map.entry(Items.WHITE_DYE, Items.YELLOW_DYE),
                    Map.entry(Items.YELLOW_DYE, Items.BLACK_DYE),

                    //Wool
                    Map.entry(Items.BLACK_WOOL, Items.BLUE_WOOL),
                    Map.entry(Items.BLUE_WOOL, Items.BROWN_WOOL),
                    Map.entry(Items.BROWN_WOOL, Items.CYAN_WOOL),
                    Map.entry(Items.CYAN_WOOL, Items.GRAY_WOOL),
                    Map.entry(Items.GRAY_WOOL, Items.GREEN_WOOL),
                    Map.entry(Items.GREEN_WOOL, Items.LIGHT_BLUE_WOOL),
                    Map.entry(Items.LIGHT_BLUE_WOOL, Items.LIGHT_GRAY_WOOL),
                    Map.entry(Items.LIGHT_GRAY_WOOL, Items.LIME_WOOL),
                    Map.entry(Items.LIME_WOOL, Items.MAGENTA_WOOL),
                    Map.entry(Items.MAGENTA_WOOL, Items.ORANGE_WOOL),
                    Map.entry(Items.ORANGE_WOOL, Items.PINK_WOOL),
                    Map.entry(Items.PINK_WOOL, Items.PURPLE_WOOL),
                    Map.entry(Items.PURPLE_WOOL, Items.RED_WOOL),
                    Map.entry(Items.RED_WOOL, Items.WHITE_WOOL),
                    Map.entry(Items.WHITE_WOOL, Items.YELLOW_WOOL),
                    Map.entry(Items.YELLOW_WOOL, Items.BLACK_WOOL),
                    
                    //Bed
                    Map.entry(Items.BLACK_BED, Items.BLUE_BED),
                    Map.entry(Items.BLUE_BED, Items.BROWN_BED),
                    Map.entry(Items.BROWN_BED, Items.CYAN_BED),
                    Map.entry(Items.CYAN_BED, Items.GRAY_BED),
                    Map.entry(Items.GRAY_BED, Items.GREEN_BED),
                    Map.entry(Items.GREEN_BED, Items.LIGHT_BLUE_BED),
                    Map.entry(Items.LIGHT_BLUE_BED, Items.LIGHT_GRAY_BED),
                    Map.entry(Items.LIGHT_GRAY_BED, Items.LIME_BED),
                    Map.entry(Items.LIME_BED, Items.MAGENTA_BED),
                    Map.entry(Items.MAGENTA_BED, Items.ORANGE_BED),
                    Map.entry(Items.ORANGE_BED, Items.PINK_BED),
                    Map.entry(Items.PINK_BED, Items.PURPLE_BED),
                    Map.entry(Items.PURPLE_BED, Items.RED_BED),
                    Map.entry(Items.RED_BED, Items.WHITE_BED),
                    Map.entry(Items.WHITE_BED, Items.YELLOW_BED),
                    Map.entry(Items.YELLOW_BED, Items.BLACK_BED),

                    //Concrete Powder
                    Map.entry(Items.BLACK_CONCRETE_POWDER, Items.BLUE_CONCRETE_POWDER),
                    Map.entry(Items.BLUE_CONCRETE_POWDER, Items.BROWN_CONCRETE_POWDER),
                    Map.entry(Items.BROWN_CONCRETE_POWDER, Items.CYAN_CONCRETE_POWDER),
                    Map.entry(Items.CYAN_CONCRETE_POWDER, Items.GRAY_CONCRETE_POWDER),
                    Map.entry(Items.GRAY_CONCRETE_POWDER, Items.GREEN_CONCRETE_POWDER),
                    Map.entry(Items.GREEN_CONCRETE_POWDER, Items.LIGHT_BLUE_CONCRETE_POWDER),
                    Map.entry(Items.LIGHT_BLUE_CONCRETE_POWDER, Items.LIGHT_GRAY_CONCRETE_POWDER),
                    Map.entry(Items.LIGHT_GRAY_CONCRETE_POWDER, Items.LIME_CONCRETE_POWDER),
                    Map.entry(Items.LIME_CONCRETE_POWDER, Items.MAGENTA_CONCRETE_POWDER),
                    Map.entry(Items.MAGENTA_CONCRETE_POWDER, Items.ORANGE_CONCRETE_POWDER),
                    Map.entry(Items.ORANGE_CONCRETE_POWDER, Items.PINK_CONCRETE_POWDER),
                    Map.entry(Items.PINK_CONCRETE_POWDER, Items.PURPLE_CONCRETE_POWDER),
                    Map.entry(Items.PURPLE_CONCRETE_POWDER, Items.RED_CONCRETE_POWDER),
                    Map.entry(Items.RED_CONCRETE_POWDER, Items.WHITE_CONCRETE_POWDER),
                    Map.entry(Items.WHITE_CONCRETE_POWDER, Items.YELLOW_CONCRETE_POWDER),
                    Map.entry(Items.YELLOW_CONCRETE_POWDER, Items.BLACK_CONCRETE_POWDER),

                    //Concrete
                    Map.entry(Items.BLACK_CONCRETE, Items.BLUE_CONCRETE),
                    Map.entry(Items.BLUE_CONCRETE, Items.BROWN_CONCRETE),
                    Map.entry(Items.BROWN_CONCRETE, Items.CYAN_CONCRETE),
                    Map.entry(Items.CYAN_CONCRETE, Items.GRAY_CONCRETE),
                    Map.entry(Items.GRAY_CONCRETE, Items.GREEN_CONCRETE),
                    Map.entry(Items.GREEN_CONCRETE, Items.LIGHT_BLUE_CONCRETE),
                    Map.entry(Items.LIGHT_BLUE_CONCRETE, Items.LIGHT_GRAY_CONCRETE),
                    Map.entry(Items.LIGHT_GRAY_CONCRETE, Items.LIME_CONCRETE),
                    Map.entry(Items.LIME_CONCRETE, Items.MAGENTA_CONCRETE),
                    Map.entry(Items.MAGENTA_CONCRETE, Items.ORANGE_CONCRETE),
                    Map.entry(Items.ORANGE_CONCRETE, Items.PINK_CONCRETE),
                    Map.entry(Items.PINK_CONCRETE, Items.PURPLE_CONCRETE),
                    Map.entry(Items.PURPLE_CONCRETE, Items.RED_CONCRETE),
                    Map.entry(Items.RED_CONCRETE, Items.WHITE_CONCRETE),
                    Map.entry(Items.WHITE_CONCRETE, Items.YELLOW_CONCRETE),
                    Map.entry(Items.YELLOW_CONCRETE, Items.BLACK_CONCRETE),

                    //Terracotta
                    Map.entry(Items.TERRACOTTA, Items.BLACK_TERRACOTTA),
                    Map.entry(Items.BLACK_TERRACOTTA, Items.BLUE_TERRACOTTA),
                    Map.entry(Items.BLUE_TERRACOTTA, Items.BROWN_TERRACOTTA),
                    Map.entry(Items.BROWN_TERRACOTTA, Items.CYAN_TERRACOTTA),
                    Map.entry(Items.CYAN_TERRACOTTA, Items.GRAY_TERRACOTTA),
                    Map.entry(Items.GRAY_TERRACOTTA, Items.GREEN_TERRACOTTA),
                    Map.entry(Items.GREEN_TERRACOTTA, Items.LIGHT_BLUE_TERRACOTTA),
                    Map.entry(Items.LIGHT_BLUE_TERRACOTTA, Items.LIGHT_GRAY_TERRACOTTA),
                    Map.entry(Items.LIGHT_GRAY_TERRACOTTA, Items.LIME_TERRACOTTA),
                    Map.entry(Items.LIME_TERRACOTTA, Items.MAGENTA_TERRACOTTA),
                    Map.entry(Items.MAGENTA_TERRACOTTA, Items.ORANGE_TERRACOTTA),
                    Map.entry(Items.ORANGE_TERRACOTTA, Items.PINK_TERRACOTTA),
                    Map.entry(Items.PINK_TERRACOTTA, Items.PURPLE_TERRACOTTA),
                    Map.entry(Items.PURPLE_TERRACOTTA, Items.RED_TERRACOTTA),
                    Map.entry(Items.RED_TERRACOTTA, Items.WHITE_TERRACOTTA),
                    Map.entry(Items.WHITE_TERRACOTTA, Items.YELLOW_TERRACOTTA),
                    Map.entry(Items.YELLOW_TERRACOTTA, Items.TERRACOTTA),

                    //glazed terracotta
                    Map.entry(Items.BLACK_GLAZED_TERRACOTTA, Items.BLUE_GLAZED_TERRACOTTA),
                    Map.entry(Items.BLUE_GLAZED_TERRACOTTA, Items.BROWN_GLAZED_TERRACOTTA),
                    Map.entry(Items.BROWN_GLAZED_TERRACOTTA, Items.CYAN_GLAZED_TERRACOTTA),
                    Map.entry(Items.CYAN_GLAZED_TERRACOTTA, Items.GRAY_GLAZED_TERRACOTTA),
                    Map.entry(Items.GRAY_GLAZED_TERRACOTTA, Items.GREEN_GLAZED_TERRACOTTA),
                    Map.entry(Items.GREEN_GLAZED_TERRACOTTA, Items.LIGHT_BLUE_GLAZED_TERRACOTTA),
                    Map.entry(Items.LIGHT_BLUE_GLAZED_TERRACOTTA, Items.LIGHT_GRAY_GLAZED_TERRACOTTA),
                    Map.entry(Items.LIGHT_GRAY_GLAZED_TERRACOTTA, Items.LIME_GLAZED_TERRACOTTA),
                    Map.entry(Items.LIME_GLAZED_TERRACOTTA, Items.MAGENTA_GLAZED_TERRACOTTA),
                    Map.entry(Items.MAGENTA_GLAZED_TERRACOTTA, Items.ORANGE_GLAZED_TERRACOTTA),
                    Map.entry(Items.ORANGE_GLAZED_TERRACOTTA, Items.PINK_GLAZED_TERRACOTTA),
                    Map.entry(Items.PINK_GLAZED_TERRACOTTA, Items.PURPLE_GLAZED_TERRACOTTA),
                    Map.entry(Items.PURPLE_GLAZED_TERRACOTTA, Items.RED_GLAZED_TERRACOTTA),
                    Map.entry(Items.RED_GLAZED_TERRACOTTA, Items.WHITE_GLAZED_TERRACOTTA),
                    Map.entry(Items.WHITE_GLAZED_TERRACOTTA, Items.YELLOW_GLAZED_TERRACOTTA),
                    Map.entry(Items.YELLOW_GLAZED_TERRACOTTA, Items.BLACK_GLAZED_TERRACOTTA),

                    //Carpet
                    Map.entry(Items.BLACK_CARPET, Items.BLUE_CARPET),
                    Map.entry(Items.BLUE_CARPET, Items.BROWN_CARPET),
                    Map.entry(Items.BROWN_CARPET, Items.CYAN_CARPET),
                    Map.entry(Items.CYAN_CARPET, Items.GRAY_CARPET),
                    Map.entry(Items.GRAY_CARPET, Items.GREEN_CARPET),
                    Map.entry(Items.GREEN_CARPET, Items.LIGHT_BLUE_CARPET),
                    Map.entry(Items.LIGHT_BLUE_CARPET, Items.LIGHT_GRAY_CARPET),
                    Map.entry(Items.LIGHT_GRAY_CARPET, Items.LIME_CARPET),
                    Map.entry(Items.LIME_CARPET, Items.MAGENTA_CARPET),
                    Map.entry(Items.MAGENTA_CARPET, Items.ORANGE_CARPET),
                    Map.entry(Items.ORANGE_CARPET, Items.PINK_CARPET),
                    Map.entry(Items.PINK_CARPET, Items.PURPLE_CARPET),
                    Map.entry(Items.PURPLE_CARPET, Items.RED_CARPET),
                    Map.entry(Items.RED_CARPET, Items.WHITE_CARPET),
                    Map.entry(Items.WHITE_CARPET, Items.YELLOW_CARPET),
                    Map.entry(Items.YELLOW_CARPET, Items.MOSS_CARPET),
                    Map.entry(Items.MOSS_CARPET, Items.BLACK_CARPET),

                    //Banner
                    Map.entry(Items.BLACK_BANNER, Items.BLUE_BANNER),
                    Map.entry(Items.BLUE_BANNER, Items.BROWN_BANNER),
                    Map.entry(Items.BROWN_BANNER, Items.CYAN_BANNER),
                    Map.entry(Items.CYAN_BANNER, Items.GRAY_BANNER),
                    Map.entry(Items.GRAY_BANNER, Items.GREEN_BANNER),
                    Map.entry(Items.GREEN_BANNER, Items.LIGHT_BLUE_BANNER),
                    Map.entry(Items.LIGHT_BLUE_BANNER, Items.LIGHT_GRAY_BANNER),
                    Map.entry(Items.LIGHT_GRAY_BANNER, Items.LIME_BANNER),
                    Map.entry(Items.LIME_BANNER, Items.MAGENTA_BANNER),
                    Map.entry(Items.MAGENTA_BANNER, Items.ORANGE_BANNER),
                    Map.entry(Items.ORANGE_BANNER, Items.PINK_BANNER),
                    Map.entry(Items.PINK_BANNER, Items.PURPLE_BANNER),
                    Map.entry(Items.PURPLE_BANNER, Items.RED_BANNER),
                    Map.entry(Items.RED_BANNER, Items.WHITE_BANNER),
                    Map.entry(Items.WHITE_BANNER, Items.YELLOW_BANNER),
                    Map.entry(Items.YELLOW_BANNER, Items.BLACK_BANNER),

                    //Glass
                    Map.entry(Items.GLASS, Items.BLACK_STAINED_GLASS),
                    Map.entry(Items.BLACK_STAINED_GLASS, Items.BLUE_STAINED_GLASS),
                    Map.entry(Items.BLUE_STAINED_GLASS, Items.BROWN_STAINED_GLASS),
                    Map.entry(Items.BROWN_STAINED_GLASS, Items.CYAN_STAINED_GLASS),
                    Map.entry(Items.CYAN_STAINED_GLASS, Items.GRAY_STAINED_GLASS),
                    Map.entry(Items.GRAY_STAINED_GLASS, Items.GREEN_STAINED_GLASS),
                    Map.entry(Items.GREEN_STAINED_GLASS, Items.LIGHT_BLUE_STAINED_GLASS),
                    Map.entry(Items.LIGHT_BLUE_STAINED_GLASS, Items.LIGHT_GRAY_STAINED_GLASS),
                    Map.entry(Items.LIGHT_GRAY_STAINED_GLASS, Items.LIME_STAINED_GLASS),
                    Map.entry(Items.LIME_STAINED_GLASS, Items.MAGENTA_STAINED_GLASS),
                    Map.entry(Items.MAGENTA_STAINED_GLASS, Items.ORANGE_STAINED_GLASS),
                    Map.entry(Items.ORANGE_STAINED_GLASS, Items.PINK_STAINED_GLASS),
                    Map.entry(Items.PINK_STAINED_GLASS, Items.PURPLE_STAINED_GLASS),
                    Map.entry(Items.PURPLE_STAINED_GLASS, Items.RED_STAINED_GLASS),
                    Map.entry(Items.RED_STAINED_GLASS, Items.WHITE_STAINED_GLASS),
                    Map.entry(Items.WHITE_STAINED_GLASS, Items.YELLOW_STAINED_GLASS),
                    Map.entry(Items.YELLOW_STAINED_GLASS, Items.TINTED_GLASS),
                    Map.entry(Items.TINTED_GLASS, Items.GLASS),

                    //Glass Pane
                    Map.entry(Items.GLASS_PANE, Items.BLACK_STAINED_GLASS_PANE),
                    Map.entry(Items.BLACK_STAINED_GLASS_PANE, Items.BLUE_STAINED_GLASS_PANE),
                    Map.entry(Items.BLUE_STAINED_GLASS_PANE, Items.BROWN_STAINED_GLASS_PANE),
                    Map.entry(Items.BROWN_STAINED_GLASS_PANE, Items.CYAN_STAINED_GLASS_PANE),
                    Map.entry(Items.CYAN_STAINED_GLASS_PANE, Items.GRAY_STAINED_GLASS_PANE),
                    Map.entry(Items.GRAY_STAINED_GLASS_PANE, Items.GREEN_STAINED_GLASS_PANE),
                    Map.entry(Items.GREEN_STAINED_GLASS_PANE, Items.LIGHT_BLUE_STAINED_GLASS_PANE),
                    Map.entry(Items.LIGHT_BLUE_STAINED_GLASS_PANE, Items.LIGHT_GRAY_STAINED_GLASS_PANE),
                    Map.entry(Items.LIGHT_GRAY_STAINED_GLASS_PANE, Items.LIME_STAINED_GLASS_PANE),
                    Map.entry(Items.LIME_STAINED_GLASS_PANE, Items.MAGENTA_STAINED_GLASS_PANE),
                    Map.entry(Items.MAGENTA_STAINED_GLASS_PANE, Items.ORANGE_STAINED_GLASS_PANE),
                    Map.entry(Items.ORANGE_STAINED_GLASS_PANE, Items.PINK_STAINED_GLASS_PANE),
                    Map.entry(Items.PINK_STAINED_GLASS_PANE, Items.PURPLE_STAINED_GLASS_PANE),
                    Map.entry(Items.PURPLE_STAINED_GLASS_PANE, Items.RED_STAINED_GLASS_PANE),
                    Map.entry(Items.RED_STAINED_GLASS_PANE, Items.WHITE_STAINED_GLASS_PANE),
                    Map.entry(Items.WHITE_STAINED_GLASS_PANE, Items.YELLOW_STAINED_GLASS_PANE),
                    Map.entry(Items.YELLOW_STAINED_GLASS_PANE, Items.GLASS_PANE),

                    //Candle
                    Map.entry(Items.CANDLE, Items.BLACK_CANDLE),
                    Map.entry(Items.BLACK_CANDLE, Items.BLUE_CANDLE),
                    Map.entry(Items.BLUE_CANDLE, Items.BROWN_CANDLE),
                    Map.entry(Items.BROWN_CANDLE, Items.CYAN_CANDLE),
                    Map.entry(Items.CYAN_CANDLE, Items.GRAY_CANDLE),
                    Map.entry(Items.GRAY_CANDLE, Items.GREEN_CANDLE),
                    Map.entry(Items.GREEN_CANDLE, Items.LIGHT_BLUE_CANDLE),
                    Map.entry(Items.LIGHT_BLUE_CANDLE, Items.LIGHT_GRAY_CANDLE),
                    Map.entry(Items.LIGHT_GRAY_CANDLE, Items.LIME_CANDLE),
                    Map.entry(Items.LIME_CANDLE, Items.MAGENTA_CANDLE),
                    Map.entry(Items.MAGENTA_CANDLE, Items.ORANGE_CANDLE),
                    Map.entry(Items.ORANGE_CANDLE, Items.PINK_CANDLE),
                    Map.entry(Items.PINK_CANDLE, Items.PURPLE_CANDLE),
                    Map.entry(Items.PURPLE_CANDLE, Items.RED_CANDLE),
                    Map.entry(Items.RED_CANDLE, Items.WHITE_CANDLE),
                    Map.entry(Items.WHITE_CANDLE, Items.YELLOW_CANDLE),
                    Map.entry(Items.YELLOW_CANDLE, Items.CANDLE),

                    //Common Mob Drops (Zombie, Creeper, Skeleton, Spider)
                    Map.entry(Items.ROTTEN_FLESH, Items.GUNPOWDER),
                    Map.entry(Items.GUNPOWDER, Items.BONE),
                    Map.entry(Items.BONE, Items.SPIDER_EYE),
                    Map.entry(Items.SPIDER_EYE, Items.ROTTEN_FLESH),

                    //Rare Mob Drops (Guardian, Slime, Phantom, Breeze, Magma Cube, Ghast, Blaze, Enderman)
                    Map.entry(Items.PRISMARINE_SHARD, Items.PRISMARINE_CRYSTALS),
                    Map.entry(Items.PRISMARINE_CRYSTALS, Items.SLIME_BALL),
                    Map.entry(Items.SLIME_BALL, Items.PHANTOM_MEMBRANE),
                    Map.entry(Items.PHANTOM_MEMBRANE, Items.BREEZE_ROD),
                    Map.entry(Items.BREEZE_ROD, Items.BLAZE_ROD),
                    Map.entry(Items.BLAZE_ROD, Items.MAGMA_CREAM),
                    Map.entry(Items.MAGMA_CREAM, Items.GHAST_TEAR),
                    Map.entry(Items.GHAST_TEAR, Items.ENDER_PEARL),
                    Map.entry(Items.ENDER_PEARL, Items.PRISMARINE_SHARD),

                    //Boss or Good Mob Drops (Elder Guardian, Ender Dragon, Wither, Shulker, Warden, Evoker)
                    Map.entry(Items.WET_SPONGE, Items.DRAGON_EGG),
                    Map.entry(Items.DRAGON_EGG, Items.NETHER_STAR),
                    Map.entry(Items.NETHER_STAR, Items.SHULKER_SHELL),
                    Map.entry(Items.SHULKER_SHELL, Items.SCULK_CATALYST),
                    Map.entry(Items.SCULK_CATALYST, Items.TOTEM_OF_UNDYING),
                    Map.entry(Items.TOTEM_OF_UNDYING, Items.WET_SPONGE),

                    //Nether Lights
                    Map.entry(Items.GLOWSTONE, Items.SHROOMLIGHT),
                    Map.entry(Items.SHROOMLIGHT, Items.GLOWSTONE),

                    //Magma block & Soul sand & Soul Soil
                    Map.entry(Items.MAGMA_BLOCK, Items.SOUL_SAND),
                    Map.entry(Items.SOUL_SAND, Items.SOUL_SOIL),
                    Map.entry(Items.SOUL_SOIL, Items.MAGMA_BLOCK),

                    //Lantern
                    Map.entry(Items.LANTERN, Items.SOUL_LANTERN),
                    Map.entry(Items.SOUL_LANTERN, Items.LANTERN),

                    //Campfire
                    Map.entry(Items.CAMPFIRE, Items.SOUL_CAMPFIRE),
                    Map.entry(Items.SOUL_CAMPFIRE, Items.CAMPFIRE),

                    //Redstone
                    Map.entry(Items.PISTON, Items.STICKY_PISTON),
                    Map.entry(Items.NOTE_BLOCK, Items.JUKEBOX),
                    Map.entry(Items.DISPENSER, Items.DROPPER),
                    Map.entry(Items.SCULK_SENSOR, Items.CALIBRATED_SCULK_SENSOR),
                    Map.entry(Items.CALIBRATED_SCULK_SENSOR, Items.SCULK_SENSOR),
                    Map.entry(Items.HONEY_BLOCK, Items.SLIME_BLOCK),
                    Map.entry(Items.SLIME_BLOCK, Items.HONEY_BLOCK),

                    //Mushroom
                    Map.entry(Items.BROWN_MUSHROOM, Items.RED_MUSHROOM),
                    Map.entry(Items.RED_MUSHROOM, Items.BROWN_MUSHROOM),
                    Map.entry(Items.CRIMSON_FUNGUS, Items.WARPED_FUNGUS),
                    Map.entry(Items.WARPED_FUNGUS, Items.CRIMSON_FUNGUS),

                    //Ice
                    Map.entry(Items.BLUE_ICE, Items.PACKED_ICE),
                    Map.entry(Items.PACKED_ICE, Items.ICE),

                    //Flower
                    Map.entry(Items.DANDELION, Items.POPPY),
                    Map.entry(Items.POPPY, Items.BLUE_ORCHID),
                    Map.entry(Items.BLUE_ORCHID, Items.ALLIUM),
                    Map.entry(Items.ALLIUM, Items.AZURE_BLUET),
                    Map.entry(Items.AZURE_BLUET, Items.RED_TULIP),
                    Map.entry(Items.RED_TULIP, Items.ORANGE_TULIP),
                    Map.entry(Items.ORANGE_TULIP, Items.WHITE_TULIP),
                    Map.entry(Items.WHITE_TULIP, Items.PINK_TULIP),
                    Map.entry(Items.PINK_TULIP, Items.OXEYE_DAISY),
                    Map.entry(Items.OXEYE_DAISY, Items.CORNFLOWER),
                    Map.entry(Items.CORNFLOWER, Items.LILY_OF_THE_VALLEY),
                    Map.entry(Items.LILY_OF_THE_VALLEY, Items.TORCHFLOWER),
                    Map.entry(Items.TORCHFLOWER, Items.SUNFLOWER),
                    Map.entry(Items.SUNFLOWER, Items.LILAC),
                    Map.entry(Items.LILAC, Items.ROSE_BUSH),
                    Map.entry(Items.ROSE_BUSH, Items.PEONY),
                    Map.entry(Items.PEONY, Items.PITCHER_PLANT),
                    Map.entry(Items.PITCHER_PLANT, Items.DANDELION),

                    //Melon & Pumpkin
                    Map.entry(Items.PUMPKIN, Items.MELON),
                    Map.entry(Items.MELON, Items.PUMPKIN),

                    //Amethyst
                    Map.entry(Items.AMETHYST_CLUSTER, Items.LARGE_AMETHYST_BUD),
                    Map.entry(Items.LARGE_AMETHYST_BUD, Items.MEDIUM_AMETHYST_BUD),
                    Map.entry(Items.MEDIUM_AMETHYST_BUD, Items.SMALL_AMETHYST_BUD),
                    Map.entry(Items.SMALL_AMETHYST_BUD, Items.AMETHYST_CLUSTER),

                    //Froglight
                    Map.entry(Items.OCHRE_FROGLIGHT, Items.VERDANT_FROGLIGHT),
                    Map.entry(Items.VERDANT_FROGLIGHT, Items.PEARLESCENT_FROGLIGHT),
                    Map.entry(Items.PEARLESCENT_FROGLIGHT, Items.OCHRE_FROGLIGHT),

                    // Metal Ingots
                    Map.entry(Items.NETHERITE_INGOT, Items.DIAMOND),
                    Map.entry(Items.DIAMOND, Items.LAPIS_LAZULI),
                    Map.entry(Items.LAPIS_LAZULI, Items.EMERALD),
                    Map.entry(Items.EMERALD, Items.REDSTONE),
                    Map.entry(Items.REDSTONE, Items.GOLD_INGOT),
                    Map.entry(Items.GOLD_INGOT, Items.IRON_INGOT),
                    Map.entry(Items.IRON_INGOT, Items.COPPER_INGOT),
                    Map.entry(Items.COPPER_INGOT, Items.COAL),
                    Map.entry(Items.COAL, Items.STONE),

                    // Ores
                    Map.entry(Items.ANCIENT_DEBRIS, Items.DIAMOND),
                    Map.entry(Items.RAW_IRON, Items.RAW_COPPER),
                    Map.entry(Items.RAW_COPPER, Items.RAW_GOLD),
                    Map.entry(Items.RAW_GOLD, Items.RAW_IRON),

                    //Stone Variants


                    //Deepslate variants


                    //Gravel & Sand
                    Map.entry(Items.GRAVEL, Items.SAND),
                    Map.entry(Items.SAND, Items.GRAVEL),
                    
                    //Diorite & Granite & Andesite
                    Map.entry(Items.GRANITE, Items.DIORITE),
                    Map.entry(Items.GRANITE_STAIRS, Items.DIORITE_STAIRS),
                    Map.entry(Items.GRANITE_SLAB, Items.DIORITE_SLAB),
                    Map.entry(Items.GRANITE_WALL, Items.DIORITE_WALL),
                    Map.entry(Items.POLISHED_GRANITE, Items.POLISHED_DIORITE),
                    Map.entry(Items.POLISHED_GRANITE_STAIRS, Items.POLISHED_DIORITE_STAIRS),
                    Map.entry(Items.POLISHED_GRANITE_SLAB, Items.POLISHED_DIORITE_SLAB),
                    Map.entry(Items.DIORITE, Items.ANDESITE),
                    Map.entry(Items.DIORITE_STAIRS, Items.ANDESITE_STAIRS),
                    Map.entry(Items.DIORITE_SLAB, Items.ANDESITE_SLAB),
                    Map.entry(Items.DIORITE_WALL, Items.ANDESITE_WALL),
                    Map.entry(Items.POLISHED_DIORITE, Items.POLISHED_ANDESITE),
                    Map.entry(Items.POLISHED_DIORITE_STAIRS, Items.POLISHED_ANDESITE_STAIRS),
                    Map.entry(Items.POLISHED_DIORITE_SLAB, Items.POLISHED_ANDESITE_SLAB),
                    Map.entry(Items.ANDESITE, Items.GRANITE),
                    Map.entry(Items.ANDESITE_STAIRS, Items.GRANITE_STAIRS),
                    Map.entry(Items.ANDESITE_SLAB, Items.GRANITE_SLAB),
                    Map.entry(Items.ANDESITE_WALL, Items.GRANITE_WALL),
                    Map.entry(Items.POLISHED_ANDESITE, Items.POLISHED_GRANITE),
                    Map.entry(Items.POLISHED_ANDESITE_STAIRS, Items.POLISHED_GRANITE_STAIRS),
                    Map.entry(Items.POLISHED_ANDESITE_SLAB, Items.POLISHED_GRANITE_SLAB),

                    // Tools & Weapons downgrades
                    Map.entry(Items.NETHERITE_SWORD, Items.DIAMOND_SWORD),
                    Map.entry(Items.DIAMOND_SWORD, Items.IRON_SWORD),
                    Map.entry(Items.IRON_SWORD, Items.STONE_SWORD),
                    Map.entry(Items.STONE_SWORD, Items.GOLDEN_SWORD),
                    Map.entry(Items.GOLDEN_SWORD, Items.WOODEN_SWORD),
                    Map.entry(Items.NETHERITE_PICKAXE, Items.DIAMOND_PICKAXE),
                    Map.entry(Items.DIAMOND_PICKAXE, Items.IRON_PICKAXE),
                    Map.entry(Items.IRON_PICKAXE, Items.STONE_PICKAXE),
                    Map.entry(Items.STONE_PICKAXE, Items.GOLDEN_PICKAXE),
                    Map.entry(Items.GOLDEN_PICKAXE, Items.WOODEN_PICKAXE),
                    Map.entry(Items.NETHERITE_AXE, Items.DIAMOND_AXE),
                    Map.entry(Items.DIAMOND_AXE, Items.IRON_AXE),
                    Map.entry(Items.IRON_AXE, Items.STONE_AXE),
                    Map.entry(Items.STONE_AXE, Items.GOLDEN_AXE),
                    Map.entry(Items.GOLDEN_AXE, Items.WOODEN_AXE),
                    Map.entry(Items.NETHERITE_HOE, Items.DIAMOND_HOE),
                    Map.entry(Items.DIAMOND_HOE, Items.IRON_HOE),
                    Map.entry(Items.IRON_HOE, Items.STONE_HOE),
                    Map.entry(Items.STONE_HOE, Items.GOLDEN_HOE),
                    Map.entry(Items.GOLDEN_HOE, Items.WOODEN_HOE),
                    Map.entry(Items.NETHERITE_SHOVEL, Items.DIAMOND_SHOVEL),
                    Map.entry(Items.DIAMOND_SHOVEL, Items.IRON_SHOVEL),
                    Map.entry(Items.IRON_SHOVEL, Items.STONE_SHOVEL),
                    Map.entry(Items.STONE_SHOVEL, Items.GOLDEN_SHOVEL),
                    Map.entry(Items.GOLDEN_SHOVEL, Items.WOODEN_SHOVEL),

                    // Armor Downgrade
                    Map.entry(Items.NETHERITE_HELMET, Items.DIAMOND_HELMET),
                    Map.entry(Items.DIAMOND_HELMET, Items.IRON_HELMET),
                    Map.entry(Items.IRON_HELMET, Items.GOLDEN_HELMET),
                    Map.entry(Items.GOLDEN_HELMET, Items.LEATHER_HELMET),
                    Map.entry(Items.NETHERITE_CHESTPLATE, Items.DIAMOND_CHESTPLATE),
                    Map.entry(Items.DIAMOND_CHESTPLATE, Items.IRON_CHESTPLATE),
                    Map.entry(Items.IRON_CHESTPLATE, Items.GOLDEN_CHESTPLATE),
                    Map.entry(Items.GOLDEN_CHESTPLATE, Items.LEATHER_CHESTPLATE),
                    Map.entry(Items.NETHERITE_LEGGINGS, Items.DIAMOND_LEGGINGS),
                    Map.entry(Items.DIAMOND_LEGGINGS, Items.IRON_LEGGINGS),
                    Map.entry(Items.IRON_LEGGINGS, Items.GOLDEN_LEGGINGS),
                    Map.entry(Items.GOLDEN_LEGGINGS, Items.LEATHER_LEGGINGS),
                    Map.entry(Items.NETHERITE_BOOTS, Items.DIAMOND_BOOTS),
                    Map.entry(Items.DIAMOND_BOOTS, Items.IRON_BOOTS),
                    Map.entry(Items.IRON_BOOTS, Items.GOLDEN_BOOTS),
                    Map.entry(Items.GOLDEN_BOOTS, Items.LEATHER_BOOTS),

                    //Horse Armor Downgrade
                    Map.entry(Items.DIAMOND_HORSE_ARMOR, Items.IRON_HORSE_ARMOR),
                    Map.entry(Items.IRON_HORSE_ARMOR, Items.GOLDEN_HORSE_ARMOR),
                    Map.entry(Items.GOLDEN_HORSE_ARMOR, Items.LEATHER_HORSE_ARMOR),

                    //Bucket
                    Map.entry(Items.WATER_BUCKET, Items.LAVA_BUCKET),
                    Map.entry(Items.LAVA_BUCKET, Items.POWDER_SNOW_BUCKET),
                    Map.entry(Items.POWDER_SNOW_BUCKET, Items.MILK_BUCKET),
                    Map.entry(Items.MILK_BUCKET, Items.COD_BUCKET),
                    Map.entry(Items.COD_BUCKET, Items.SALMON_BUCKET),
                    Map.entry(Items.SALMON_BUCKET, Items.TROPICAL_FISH_BUCKET),
                    Map.entry(Items.TROPICAL_FISH_BUCKET, Items.PUFFERFISH_BUCKET),
                    Map.entry(Items.PUFFERFISH_BUCKET, Items.AXOLOTL_BUCKET),
                    Map.entry(Items.AXOLOTL_BUCKET, Items.TADPOLE_BUCKET),

                    //On a stick
                    Map.entry(Items.CARROT_ON_A_STICK, Items.WARPED_FUNGUS_ON_A_STICK),
                    Map.entry(Items.WARPED_FUNGUS_ON_A_STICK, Items.CARROT_ON_A_STICK),

                    //Squid loot
                    Map.entry(Items.INK_SAC, Items.GLOW_INK_SAC),
                    Map.entry(Items.GLOW_INK_SAC, Items.INK_SAC),

                    //Food Downgrade
                    Map.entry(Items.GOLDEN_APPLE, Items.APPLE),
                    Map.entry(Items.GOLDEN_CARROT, Items.CARROT),
                    Map.entry(Items.COOKED_BEEF, Items.BEEF),
                    Map.entry(Items.COOKED_PORKCHOP, Items.PORKCHOP),
                    Map.entry(Items.COOKED_CHICKEN, Items.CHICKEN),
                    Map.entry(Items.COOKED_MUTTON, Items.MUTTON),
                    Map.entry(Items.COOKED_RABBIT, Items.RABBIT),
                    Map.entry(Items.COOKED_COD, Items.COD),
                    Map.entry(Items.COOKED_SALMON, Items.SALMON),

                    //Food cycle


                    //Crop cycle
                    Map.entry(Items.POTATO, Items.CARROT),
                    Map.entry(Items.CARROT, Items.BEETROOT),
                    Map.entry(Items.BEETROOT, Items.WHEAT),
                    Map.entry(Items.WHEAT, Items.POTATO),
                    Map.entry(Items.SUGAR_CANE, Items.BAMBOO),
                    Map.entry(Items.BAMBOO, Items.SUGAR_CANE),

                    //Crop seed cycle
                    Map.entry(Items.WHEAT_SEEDS, Items.PUMPKIN_SEEDS),
                    Map.entry(Items.PUMPKIN_SEEDS, Items.MELON_SEEDS),
                    Map.entry(Items.MELON_SEEDS, Items.BEETROOT_SEEDS),
                    Map.entry(Items.BEETROOT_SEEDS, Items.TORCHFLOWER_SEEDS),
                    Map.entry(Items.TORCHFLOWER_SEEDS, Items.PITCHER_POD),
                    Map.entry(Items.PITCHER_POD, Items.WHEAT_SEEDS),

                    //Useless food cycle
                    Map.entry(Items.POISONOUS_POTATO, Items.TROPICAL_FISH),
                    Map.entry(Items.TROPICAL_FISH, Items.POISONOUS_POTATO),

                    // Special Items
                    Map.entry(Items.BEACON, Items.ELYTRA),
                    Map.entry(Items.ELYTRA, Items.HEAVY_CORE),
                    Map.entry(Items.HEAVY_CORE, Items.ENCHANTED_GOLDEN_APPLE),
                    Map.entry(Items.ENCHANTED_GOLDEN_APPLE, Items.SPAWNER),
                    Map.entry(Items.SPAWNER, Items.BEDROCK),
                    Map.entry(Items.BEDROCK, Items.BEACON),

                    //Mod
                    Map.entry(Items.DRAGON_HEAD, ModItems.TRANSMUTATIONWAND.get()),
                    Map.entry(ModItems.OBAMAFUEL.get(), ModItems.JOHNPORKMEAT.get()),
                    Map.entry(ModItems.JOHNPORKMEAT.get(), ModItems.OBAMAFUEL.get())
            );
        }
        return transmutationMap;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            // Check if this item has already been transmuted
            CompoundTag tag = itemEntity.getPersistentData();
            if (!tag.contains("TransmutedByBlock")) {
                ItemStack stack = itemEntity.getItem();
                Item transformedItem = getTransmutationMap().get(stack.getItem());

                // Special case for wand
                if (transformedItem == Items.DIAMOND && stack.getItem() == Items.DRAGON_HEAD) {
                    transformedItem = ModItems.TRANSMUTATIONWAND.get();
                }

                if (transformedItem != null) {
                    // Mark the item as transmuted
                    tag.putBoolean("TransmutedByBlock", true);

                    // Perform the transmutation
                    itemEntity.setItem(new ItemStack(transformedItem, stack.getCount()));

                    // Play sounds
                    level.playSound(null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.playSound(null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, 1.5F);
                }
            }
        }
        super.stepOn(level, pos, state, entity);
    }
}