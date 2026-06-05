package com.milksplash.mod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryObject;
import net.minecraft.core.registries.Registries;
import com.milksplash.mod.MilkSplashMod;
import com.milksplash.mod.potion.ModPotions;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MilkSplashMod.MOD_ID);

    public static final RegistryObject<Item> MILK_SPLASH_POTION = ITEMS.register("milk_splash_potion",
            () -> {
                Item item = new Item(new Item.Properties()
                        .stacksTo(1));
                return PotionUtils.setPotion(item, ModPotions.MILK_POTION.get());
            });
}