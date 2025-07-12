package net.tenbris.bank.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties HARD_TACK = new FoodProperties.Builder().nutrition(12).saturationModifier(0.3f).alwaysEdible().fast()
            .effect(()-> new MobEffectInstance(MobEffects.HEALTH_BOOST,400),1.0f).build();
}
