package net.kg.mod.item.custom;

import net.kg.mod.block.ModBlocks;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;


import java.util.Map;

public class TransmutationItem extends Item {
    private static final Map<Block, Block> TRANSMUTATION_MAP = Map.ofEntries(
            //Block Downgrade
            Map.entry(Blocks.NETHERITE_BLOCK, Blocks.DIAMOND_BLOCK),
            Map.entry(Blocks.DIAMOND_BLOCK, Blocks.LAPIS_BLOCK),
            Map.entry(Blocks.LAPIS_BLOCK,Blocks.EMERALD_BLOCK),
            Map.entry(Blocks.EMERALD_BLOCK, Blocks.GOLD_BLOCK),
            Map.entry(Blocks.GOLD_BLOCK, Blocks.IRON_BLOCK),
            Map.entry(Blocks.IRON_BLOCK, Blocks.COPPER_BLOCK),
            Map.entry(Blocks.COPPER_BLOCK, Blocks.COAL_BLOCK),
            Map.entry(Blocks.COAL_BLOCK, Blocks.STONE),
            Map.entry(Blocks.STONE, Blocks.COBBLESTONE),
            Map.entry(Blocks.COBBLESTONE, Blocks.GRASS_BLOCK),
            Map.entry(Blocks.GRASS_BLOCK, Blocks.DIRT),
            Map.entry(Blocks.DIRT, Blocks.AIR),

            //Ore Downgrade
            Map.entry(Blocks.ANCIENT_DEBRIS, Blocks.DIAMOND_ORE),
            Map.entry(Blocks.DIAMOND_ORE, Blocks.LAPIS_ORE),
            Map.entry(Blocks.LAPIS_ORE, Blocks.EMERALD_ORE),
            Map.entry(Blocks.EMERALD_ORE, Blocks.GOLD_ORE),
            Map.entry(Blocks.GOLD_ORE, Blocks.IRON_ORE),
            Map.entry(Blocks.IRON_ORE, Blocks.COPPER_ORE),
            Map.entry(Blocks.COPPER_ORE, Blocks.COAL_ORE),
            Map.entry(Blocks.COAL_ORE, Blocks.STONE),

            //Deepslate Downgrade
            Map.entry(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_LAPIS_ORE),
            Map.entry(Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_EMERALD_ORE),
            Map.entry(Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_GOLD_ORE),
            Map.entry(Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_IRON_ORE),
            Map.entry(Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_COPPER_ORE),
            Map.entry(Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_COAL_ORE),
            Map.entry(Blocks.DEEPSLATE_COAL_ORE, Blocks.STONE),

            //Stone Variants
            Map.entry(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS),
            Map.entry(Blocks.CRACKED_STONE_BRICKS, Blocks.STONE),
            Map.entry(Blocks.STONE_BRICK_STAIRS, Blocks.STONE_STAIRS),
            Map.entry(Blocks.STONE_STAIRS, Blocks.COBBLESTONE_STAIRS),
            Map.entry(Blocks.STONE_BRICK_SLAB, Blocks.STONE_SLAB),
            Map.entry(Blocks.STONE_SLAB, Blocks.COBBLESTONE_SLAB),

            //Deepslate variants
            Map.entry(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS),
            Map.entry(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE),
            Map.entry(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE),
            Map.entry(Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.COBBLED_DEEPSLATE_STAIRS),
            Map.entry(Blocks.DEEPSLATE_BRICK_SLAB, Blocks.COBBLED_DEEPSLATE_SLAB),

            //Froglight
            Map.entry(Blocks.OCHRE_FROGLIGHT, Blocks.VERDANT_FROGLIGHT),
            Map.entry(Blocks.VERDANT_FROGLIGHT, Blocks.PEARLESCENT_FROGLIGHT),
            Map.entry(Blocks.PEARLESCENT_FROGLIGHT, Blocks.OCHRE_FROGLIGHT),

            //Amethyst
            Map.entry(Blocks.AMETHYST_CLUSTER, Blocks.LARGE_AMETHYST_BUD),
            Map.entry(Blocks.LARGE_AMETHYST_BUD, Blocks.MEDIUM_AMETHYST_BUD),
            Map.entry(Blocks.MEDIUM_AMETHYST_BUD, Blocks.SMALL_AMETHYST_BUD),
            Map.entry(Blocks.SMALL_AMETHYST_BUD, Blocks.AMETHYST_CLUSTER),

            //Gravel & Sand
            Map.entry(Blocks.GRAVEL, Blocks.SAND),
            Map.entry(Blocks.SAND, Blocks.GRAVEL),

            //Granite & Diorite & Andersite
            Map.entry(Blocks.GRANITE, Blocks.DIORITE),
            Map.entry(Blocks.GRANITE_STAIRS, Blocks.DIORITE_STAIRS),
            Map.entry(Blocks.GRANITE_SLAB, Blocks.DIORITE_SLAB),
            Map.entry(Blocks.GRANITE_WALL, Blocks.DIORITE_WALL),
            Map.entry(Blocks.POLISHED_GRANITE, Blocks.POLISHED_DIORITE),
            Map.entry(Blocks.POLISHED_GRANITE_STAIRS, Blocks.POLISHED_DIORITE_STAIRS),
            Map.entry(Blocks.POLISHED_GRANITE_SLAB, Blocks.POLISHED_DIORITE_SLAB),
            Map.entry(Blocks.DIORITE, Blocks.ANDESITE),
            Map.entry(Blocks.DIORITE_STAIRS, Blocks.ANDESITE_STAIRS),
            Map.entry(Blocks.DIORITE_SLAB, Blocks.ANDESITE_SLAB),
            Map.entry(Blocks.DIORITE_WALL, Blocks.ANDESITE_WALL),
            Map.entry(Blocks.POLISHED_DIORITE, Blocks.POLISHED_ANDESITE),
            Map.entry(Blocks.POLISHED_DIORITE_STAIRS, Blocks.POLISHED_ANDESITE_STAIRS),
            Map.entry(Blocks.POLISHED_DIORITE_SLAB, Blocks.POLISHED_ANDESITE_SLAB),
            Map.entry(Blocks.ANDESITE, Blocks.GRANITE),
            Map.entry(Blocks.ANDESITE_STAIRS, Blocks.GRANITE_STAIRS),
            Map.entry(Blocks.ANDESITE_SLAB, Blocks.GRANITE_SLAB),
            Map.entry(Blocks.ANDESITE_WALL, Blocks.GRANITE_WALL),
            Map.entry(Blocks.POLISHED_ANDESITE, Blocks.POLISHED_GRANITE),
            Map.entry(Blocks.POLISHED_ANDESITE_STAIRS, Blocks.POLISHED_GRANITE_STAIRS),
            Map.entry(Blocks.POLISHED_ANDESITE_SLAB, Blocks.POLISHED_GRANITE_SLAB),

            //Wool
            Map.entry(Blocks.BLACK_WOOL, Blocks.BLUE_WOOL),
            Map.entry(Blocks.BLUE_WOOL, Blocks.BROWN_WOOL),
            Map.entry(Blocks.BROWN_WOOL, Blocks.CYAN_WOOL),
            Map.entry(Blocks.CYAN_WOOL, Blocks.GRAY_WOOL),
            Map.entry(Blocks.GRAY_WOOL, Blocks.GREEN_WOOL),
            Map.entry(Blocks.GREEN_WOOL, Blocks.LIGHT_BLUE_WOOL),
            Map.entry(Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_GRAY_WOOL),
            Map.entry(Blocks.LIGHT_GRAY_WOOL, Blocks.LIME_WOOL),
            Map.entry(Blocks.LIME_WOOL, Blocks.MAGENTA_WOOL),
            Map.entry(Blocks.MAGENTA_WOOL, Blocks.ORANGE_WOOL),
            Map.entry(Blocks.ORANGE_WOOL, Blocks.PINK_WOOL),
            Map.entry(Blocks.PINK_WOOL, Blocks.PURPLE_WOOL),
            Map.entry(Blocks.PURPLE_WOOL, Blocks.RED_WOOL),
            Map.entry(Blocks.RED_WOOL, Blocks.WHITE_WOOL),
            Map.entry(Blocks.WHITE_WOOL, Blocks.YELLOW_WOOL),
            Map.entry(Blocks.YELLOW_WOOL, Blocks.BLACK_WOOL),

            //Concrete Powder
            Map.entry(Blocks.BLACK_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER),
            Map.entry(Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER),
            Map.entry(Blocks.BROWN_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER),
            Map.entry(Blocks.CYAN_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER),
            Map.entry(Blocks.GRAY_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER),
            Map.entry(Blocks.GREEN_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER),
            Map.entry(Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER),
            Map.entry(Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER),
            Map.entry(Blocks.LIME_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER),
            Map.entry(Blocks.MAGENTA_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER),
            Map.entry(Blocks.ORANGE_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER),
            Map.entry(Blocks.PINK_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER),
            Map.entry(Blocks.PURPLE_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER),
            Map.entry(Blocks.RED_CONCRETE_POWDER, Blocks.WHITE_CONCRETE_POWDER),
            Map.entry(Blocks.WHITE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER),
            Map.entry(Blocks.YELLOW_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER),

            //Concrete
            Map.entry(Blocks.BLACK_CONCRETE, Blocks.BLUE_CONCRETE),
            Map.entry(Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE),
            Map.entry(Blocks.BROWN_CONCRETE, Blocks.CYAN_CONCRETE),
            Map.entry(Blocks.CYAN_CONCRETE, Blocks.GRAY_CONCRETE),
            Map.entry(Blocks.GRAY_CONCRETE, Blocks.GREEN_CONCRETE),
            Map.entry(Blocks.GREEN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE),
            Map.entry(Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE),
            Map.entry(Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIME_CONCRETE),
            Map.entry(Blocks.LIME_CONCRETE, Blocks.MAGENTA_CONCRETE),
            Map.entry(Blocks.MAGENTA_CONCRETE, Blocks.ORANGE_CONCRETE),
            Map.entry(Blocks.ORANGE_CONCRETE, Blocks.PINK_CONCRETE),
            Map.entry(Blocks.PINK_CONCRETE, Blocks.PURPLE_CONCRETE),
            Map.entry(Blocks.PURPLE_CONCRETE, Blocks.RED_CONCRETE),
            Map.entry(Blocks.RED_CONCRETE, Blocks.WHITE_CONCRETE),
            Map.entry(Blocks.WHITE_CONCRETE, Blocks.YELLOW_CONCRETE),
            Map.entry(Blocks.YELLOW_CONCRETE, Blocks.BLACK_CONCRETE),

            //Terracotta
            Map.entry(Blocks.TERRACOTTA, Blocks.BLACK_TERRACOTTA),
            Map.entry(Blocks.BLACK_TERRACOTTA, Blocks.BLUE_TERRACOTTA),
            Map.entry(Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA),
            Map.entry(Blocks.BROWN_TERRACOTTA, Blocks.CYAN_TERRACOTTA),
            Map.entry(Blocks.CYAN_TERRACOTTA, Blocks.GRAY_TERRACOTTA),
            Map.entry(Blocks.GRAY_TERRACOTTA, Blocks.GREEN_TERRACOTTA),
            Map.entry(Blocks.GREEN_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA),
            Map.entry(Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA),
            Map.entry(Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIME_TERRACOTTA),
            Map.entry(Blocks.LIME_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA),
            Map.entry(Blocks.MAGENTA_TERRACOTTA, Blocks.ORANGE_TERRACOTTA),
            Map.entry(Blocks.ORANGE_TERRACOTTA, Blocks.PINK_TERRACOTTA),
            Map.entry(Blocks.PINK_TERRACOTTA, Blocks.PURPLE_TERRACOTTA),
            Map.entry(Blocks.PURPLE_TERRACOTTA, Blocks.RED_TERRACOTTA),
            Map.entry(Blocks.RED_TERRACOTTA, Blocks.WHITE_TERRACOTTA),
            Map.entry(Blocks.WHITE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA),
            Map.entry(Blocks.YELLOW_TERRACOTTA, Blocks.TERRACOTTA),

            //glazed terracotta
            Map.entry(Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA),
            Map.entry(Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA),
            Map.entry(Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA),
            Map.entry(Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA),
            Map.entry(Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA),
            Map.entry(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA),
            Map.entry(Blocks.LIME_GLAZED_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA),
            Map.entry(Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA),
            Map.entry(Blocks.PINK_GLAZED_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA),
            Map.entry(Blocks.RED_GLAZED_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA),
            Map.entry(Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA),
            
            //Carpet
            Map.entry(Blocks.BLACK_CARPET, Blocks.BLUE_CARPET),
            Map.entry(Blocks.BLUE_CARPET, Blocks.BROWN_CARPET),
            Map.entry(Blocks.BROWN_CARPET, Blocks.CYAN_CARPET),
            Map.entry(Blocks.CYAN_CARPET, Blocks.GRAY_CARPET),
            Map.entry(Blocks.GRAY_CARPET, Blocks.GREEN_CARPET),
            Map.entry(Blocks.GREEN_CARPET, Blocks.LIGHT_BLUE_CARPET),
            Map.entry(Blocks.LIGHT_BLUE_CARPET, Blocks.LIGHT_GRAY_CARPET),
            Map.entry(Blocks.LIGHT_GRAY_CARPET, Blocks.LIME_CARPET),
            Map.entry(Blocks.LIME_CARPET, Blocks.MAGENTA_CARPET),
            Map.entry(Blocks.MAGENTA_CARPET, Blocks.ORANGE_CARPET),
            Map.entry(Blocks.ORANGE_CARPET, Blocks.PINK_CARPET),
            Map.entry(Blocks.PINK_CARPET, Blocks.PURPLE_CARPET),
            Map.entry(Blocks.PURPLE_CARPET, Blocks.RED_CARPET),
            Map.entry(Blocks.RED_CARPET, Blocks.WHITE_CARPET),
            Map.entry(Blocks.WHITE_CARPET, Blocks.YELLOW_CARPET),
            Map.entry(Blocks.YELLOW_CARPET, Blocks.MOSS_CARPET),
            Map.entry(Blocks.MOSS_CARPET, Blocks.BLACK_CARPET),

            //Banner
            Map.entry(Blocks.BLACK_BANNER, Blocks.BLUE_BANNER),
            Map.entry(Blocks.BLUE_BANNER, Blocks.BROWN_BANNER),
            Map.entry(Blocks.BROWN_BANNER, Blocks.CYAN_BANNER),
            Map.entry(Blocks.CYAN_BANNER, Blocks.GRAY_BANNER),
            Map.entry(Blocks.GRAY_BANNER, Blocks.GREEN_BANNER),
            Map.entry(Blocks.GREEN_BANNER, Blocks.LIGHT_BLUE_BANNER),
            Map.entry(Blocks.LIGHT_BLUE_BANNER, Blocks.LIGHT_GRAY_BANNER),
            Map.entry(Blocks.LIGHT_GRAY_BANNER, Blocks.LIME_BANNER),
            Map.entry(Blocks.LIME_BANNER, Blocks.MAGENTA_BANNER),
            Map.entry(Blocks.MAGENTA_BANNER, Blocks.ORANGE_BANNER),
            Map.entry(Blocks.ORANGE_BANNER, Blocks.PINK_BANNER),
            Map.entry(Blocks.PINK_BANNER, Blocks.PURPLE_BANNER),
            Map.entry(Blocks.PURPLE_BANNER, Blocks.RED_BANNER),
            Map.entry(Blocks.RED_BANNER, Blocks.WHITE_BANNER),
            Map.entry(Blocks.WHITE_BANNER, Blocks.YELLOW_BANNER),
            Map.entry(Blocks.YELLOW_BANNER, Blocks.BLACK_BANNER),

            //Glass
            Map.entry(Blocks.GLASS, Blocks.BLACK_STAINED_GLASS),
            Map.entry(Blocks.BLACK_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS),
            Map.entry(Blocks.BLUE_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS),
            Map.entry(Blocks.BROWN_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS),
            Map.entry(Blocks.CYAN_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS),
            Map.entry(Blocks.GRAY_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS),
            Map.entry(Blocks.GREEN_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS),
            Map.entry(Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS),
            Map.entry(Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.LIME_STAINED_GLASS),
            Map.entry(Blocks.LIME_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS),
            Map.entry(Blocks.MAGENTA_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS),
            Map.entry(Blocks.ORANGE_STAINED_GLASS, Blocks.PINK_STAINED_GLASS),
            Map.entry(Blocks.PINK_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS),
            Map.entry(Blocks.PURPLE_STAINED_GLASS, Blocks.RED_STAINED_GLASS),
            Map.entry(Blocks.RED_STAINED_GLASS, Blocks.WHITE_STAINED_GLASS),
            Map.entry(Blocks.WHITE_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS),
            Map.entry(Blocks.YELLOW_STAINED_GLASS, Blocks.TINTED_GLASS),
            Map.entry(Blocks.TINTED_GLASS, Blocks.GLASS),

            //Glass Pane
            Map.entry(Blocks.GLASS_PANE, Blocks.BLACK_STAINED_GLASS_PANE),
            Map.entry(Blocks.BLACK_STAINED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS_PANE),
            Map.entry(Blocks.BLUE_STAINED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS_PANE),
            Map.entry(Blocks.BROWN_STAINED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS_PANE),
            Map.entry(Blocks.CYAN_STAINED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS_PANE),
            Map.entry(Blocks.GRAY_STAINED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS_PANE),
            Map.entry(Blocks.GREEN_STAINED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE),
            Map.entry(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE),
            Map.entry(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, Blocks.LIME_STAINED_GLASS_PANE),
            Map.entry(Blocks.LIME_STAINED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS_PANE),
            Map.entry(Blocks.MAGENTA_STAINED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS_PANE),
            Map.entry(Blocks.ORANGE_STAINED_GLASS_PANE, Blocks.PINK_STAINED_GLASS_PANE),
            Map.entry(Blocks.PINK_STAINED_GLASS_PANE, Blocks.PURPLE_STAINED_GLASS_PANE),
            Map.entry(Blocks.PURPLE_STAINED_GLASS_PANE, Blocks.RED_STAINED_GLASS_PANE),
            Map.entry(Blocks.RED_STAINED_GLASS_PANE, Blocks.WHITE_STAINED_GLASS_PANE),
            Map.entry(Blocks.WHITE_STAINED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS_PANE),
            Map.entry(Blocks.YELLOW_STAINED_GLASS_PANE, Blocks.GLASS_PANE),

            //CANDLE
            Map.entry(Blocks.CANDLE, Blocks.BLACK_CANDLE),
            Map.entry(Blocks.BLACK_CANDLE, Blocks.BLUE_CANDLE),
            Map.entry(Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE),
            Map.entry(Blocks.BROWN_CANDLE, Blocks.CYAN_CANDLE),
            Map.entry(Blocks.CYAN_CANDLE, Blocks.GRAY_CANDLE),
            Map.entry(Blocks.GRAY_CANDLE, Blocks.GREEN_CANDLE),
            Map.entry(Blocks.GREEN_CANDLE, Blocks.LIGHT_BLUE_CANDLE),
            Map.entry(Blocks.LIGHT_BLUE_CANDLE, Blocks.LIGHT_GRAY_CANDLE),
            Map.entry(Blocks.LIGHT_GRAY_CANDLE, Blocks.LIME_CANDLE),
            Map.entry(Blocks.LIME_CANDLE, Blocks.MAGENTA_CANDLE),
            Map.entry(Blocks.MAGENTA_CANDLE, Blocks.ORANGE_CANDLE),
            Map.entry(Blocks.ORANGE_CANDLE, Blocks.PINK_CANDLE),
            Map.entry(Blocks.PINK_CANDLE, Blocks.PURPLE_CANDLE),
            Map.entry(Blocks.PURPLE_CANDLE, Blocks.RED_CANDLE),
            Map.entry(Blocks.RED_CANDLE, Blocks.WHITE_CANDLE),
            Map.entry(Blocks.WHITE_CANDLE, Blocks.YELLOW_CANDLE),
            Map.entry(Blocks.YELLOW_CANDLE, Blocks.CANDLE),

            //Glowstone & Shroomlight
            Map.entry(Blocks.GLOWSTONE, Blocks.SHROOMLIGHT),
            Map.entry(Blocks.SHROOMLIGHT, Blocks.GLOWSTONE),

            //Magma block and Soul sand
            Map.entry(Blocks.MAGMA_BLOCK, Blocks.SOUL_SAND),
            Map.entry(Blocks.SOUL_SAND, Blocks.MAGMA_BLOCK),

            //Grass
            Map.entry(Blocks.TALL_GRASS, Blocks.SHORT_GRASS),
            Map.entry(Blocks.SHORT_GRASS, Blocks.TALL_GRASS),

            //Lantern
            Map.entry(Blocks.LANTERN, Blocks.SOUL_LANTERN),
            Map.entry(Blocks.SOUL_LANTERN, Blocks.LANTERN),

            //Campfire
            Map.entry(Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE),
            Map.entry(Blocks.SOUL_CAMPFIRE, Blocks.CAMPFIRE),

            //Redstone
            Map.entry(Blocks.PISTON, Blocks.STICKY_PISTON),
            Map.entry(Blocks.NOTE_BLOCK, Blocks.JUKEBOX),
            Map.entry(Blocks.DISPENSER, Blocks.DROPPER),
            Map.entry(Blocks.SCULK_SENSOR, Blocks.CALIBRATED_SCULK_SENSOR),
            Map.entry(Blocks.CALIBRATED_SCULK_SENSOR, Blocks.SCULK_SENSOR),

            //Mushroom
            Map.entry(Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM),
            Map.entry(Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM),
            Map.entry(Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS),
            Map.entry(Blocks.WARPED_FUNGUS, Blocks.CRIMSON_FUNGUS),

            //Ice
            Map.entry(Blocks.BLUE_ICE, Blocks.PACKED_ICE),
            Map.entry(Blocks.PACKED_ICE, Blocks.ICE),

            //Log
            Map.entry(Blocks.ACACIA_LOG, Blocks.BIRCH_LOG),
            Map.entry(Blocks.BIRCH_LOG, Blocks.CHERRY_LOG),
            Map.entry(Blocks.CHERRY_LOG, Blocks.OAK_LOG),
            Map.entry(Blocks.OAK_LOG, Blocks.DARK_OAK_LOG),
            Map.entry(Blocks.DARK_OAK_LOG, Blocks.JUNGLE_LOG),
            Map.entry(Blocks.JUNGLE_LOG, Blocks.MANGROVE_LOG),
            Map.entry(Blocks.MANGROVE_LOG, Blocks.SPRUCE_LOG),
            Map.entry(Blocks.SPRUCE_LOG, Blocks.ACACIA_LOG),
            Map.entry(Blocks.CRIMSON_STEM, Blocks.WARPED_STEM),
            Map.entry(Blocks.WARPED_STEM, Blocks.CRIMSON_STEM),

            //Sapling
            Map.entry(Blocks.ACACIA_SAPLING, Blocks.BIRCH_SAPLING),
            Map.entry(Blocks.BIRCH_SAPLING, Blocks.CHERRY_SAPLING),
            Map.entry(Blocks.CHERRY_SAPLING, Blocks.OAK_SAPLING),
            Map.entry(Blocks.OAK_SAPLING, Blocks.DARK_OAK_SAPLING),
            Map.entry(Blocks.DARK_OAK_SAPLING, Blocks.JUNGLE_SAPLING),
            Map.entry(Blocks.JUNGLE_SAPLING, Blocks.MANGROVE_PROPAGULE),
            Map.entry(Blocks.MANGROVE_PROPAGULE, Blocks.SPRUCE_SAPLING),
            Map.entry(Blocks.SPRUCE_SAPLING, Blocks.ACACIA_SAPLING),

            //Mod
            Map.entry(ModBlocks.OBAMABLOCK.get(), ModBlocks.OBAMAORE.get())
    );

    public TransmutationItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        ItemStack stack = pContext.getItemInHand();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (TRANSMUTATION_MAP.containsKey(clickedBlock) && player != null) {
            if (!level.isClientSide()) {
                // Transform block
                level.setBlockAndUpdate(pContext.getClickedPos(), TRANSMUTATION_MAP.get(clickedBlock).defaultBlockState());

                // Damage item (1.21 compatible)
                if (player instanceof ServerPlayer) {
                    stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                } else {
                    // Client-side fallback
                    stack.setDamageValue(stack.getDamageValue() + 1);
                    if (stack.getDamageValue() >= stack.getMaxDamage()) {
                        stack.shrink(1);
                    }
                }
                level.playSound(null,pContext.getClickedPos(), SoundEvents.COBWEB_BREAK, SoundSource.BLOCKS);
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return InteractionResult.SUCCESS;
    }
}
