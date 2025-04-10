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

                    // Food
                    Map.entry(Items.ENCHANTED_GOLDEN_APPLE, Items.GOLDEN_APPLE),
                    Map.entry(Items.GOLDEN_APPLE, Items.APPLE),
                    Map.entry(Items.GOLDEN_CARROT, Items.CARROT),
                    Map.entry(Items.COOKED_BEEF, Items.BEEF),
                    Map.entry(Items.COOKED_PORKCHOP, Items.PORKCHOP),
                    Map.entry(Items.COOKED_CHICKEN, Items.CHICKEN),
                    Map.entry(Items.COOKED_MUTTON, Items.MUTTON),
                    Map.entry(Items.COOKED_RABBIT, Items.RABBIT),
                    Map.entry(Items.COOKED_COD, Items.COD),
                    Map.entry(Items.COOKED_SALMON, Items.SALMON),

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

                    // Mob Drops
                    Map.entry(Items.BLAZE_ROD, Items.BLAZE_POWDER),
                    Map.entry(Items.PRISMARINE_SHARD, Items.PRISMARINE_CRYSTALS),
                    Map.entry(Items.PHANTOM_MEMBRANE, Items.LEATHER),
                    Map.entry(Items.SHULKER_SHELL, Items.RABBIT_HIDE),
                    Map.entry(Items.ENDER_PEARL, Items.ENDER_EYE),
                    Map.entry(Items.GHAST_TEAR, Items.GLOWSTONE_DUST),
                    Map.entry(Items.SLIME_BALL, Items.HONEYCOMB),

                    // Plants
                    Map.entry(Items.WHEAT, Items.HAY_BLOCK),
                    Map.entry(Items.SUGAR_CANE, Items.PAPER),
                    Map.entry(Items.CACTUS, Items.GREEN_DYE),
                    Map.entry(Items.KELP, Items.DRIED_KELP),
                    Map.entry(Items.BAMBOO, Items.STICK),
                    Map.entry(Items.SWEET_BERRIES, Items.GLOW_BERRIES),
                    Map.entry(Items.GLOW_BERRIES, Items.SWEET_BERRIES),

                    // Stone Items
                    Map.entry(Items.STONE, Items.COBBLESTONE),
                    Map.entry(Items.COBBLESTONE, Items.DIRT),
                    Map.entry(Items.GRAVEL, Items.SAND),
                    Map.entry(Items.SAND, Items.GRAVEL),
                    Map.entry(Items.CLAY_BALL, Items.BRICK),
                    Map.entry(Items.BRICK, Items.CLAY_BALL),

                    // Wood Items
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

                    // Special Items
                    Map.entry(Items.NETHER_STAR, Items.ELYTRA),
                    Map.entry(Items.HEART_OF_THE_SEA, Items.PRISMARINE_CRYSTALS),
                    Map.entry(Items.TOTEM_OF_UNDYING, Items.GOLDEN_APPLE),
                    Map.entry(Items.ELYTRA, Items.PHANTOM_MEMBRANE),
                    Map.entry(Items.TRIDENT, Items.PRISMARINE_SHARD),
                    Map.entry(Items.NETHERITE_SCRAP, Items.GOLD_INGOT),
                    Map.entry(Items.EXPERIENCE_BOTTLE, Items.GLASS_BOTTLE),

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
                    Map.entry(Items.NETHERITE_CHESTPLATE, Items.DIAMOND_CHESTPLATE),
                    Map.entry(Items.DIAMOND_CHESTPLATE, Items.IRON_CHESTPLATE),
                    Map.entry(Items.IRON_CHESTPLATE, Items.GOLDEN_CHESTPLATE),
                    Map.entry(Items.NETHERITE_LEGGINGS, Items.DIAMOND_LEGGINGS),
                    Map.entry(Items.DIAMOND_LEGGINGS, Items.IRON_LEGGINGS),
                    Map.entry(Items.IRON_LEGGINGS, Items.GOLDEN_LEGGINGS),
                    Map.entry(Items.NETHERITE_BOOTS, Items.DIAMOND_BOOTS),
                    Map.entry(Items.DIAMOND_BOOTS, Items.IRON_BOOTS),
                    Map.entry(Items.IRON_BOOTS, Items.GOLDEN_BOOTS),


                    Map.entry(Items.DRAGON_HEAD, ModItems.TRANSMUTATIONWAND.get())
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