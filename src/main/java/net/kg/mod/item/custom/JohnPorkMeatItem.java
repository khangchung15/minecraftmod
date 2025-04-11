package net.kg.mod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class JohnPorkMeatItem extends Item {
    public JohnPorkMeatItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    /*
    Drink:
    @Override
        public UseAnim getUseAnimation(ItemStack pStack) {
            return UseAnim.DRINK    ;
        }
     */
}