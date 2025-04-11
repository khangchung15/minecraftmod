package net.kg.mod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties JOHNPORKMEAT = new FoodProperties.Builder() .nutrition(5) .saturationModifier(3f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 50000, 1, false,false, true), 1)
            .effect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 50000, 10), 1)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 50000, 10), 1).build();
}
