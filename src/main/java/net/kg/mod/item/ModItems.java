package net.kg.mod.item;

import net.kg.mod.TestMod;
import net.kg.mod.item.custom.FuelItem;
import net.kg.mod.item.custom.JohnPorkMeatItem;
import net.kg.mod.item.custom.TransmutationItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> JOHNPORK = ITEMS.register("johnpork",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JOHNPORKMEAT = ITEMS.register("johnporkmeat",
            () -> new JohnPorkMeatItem(new Item.Properties().food(ModFoodProperties.JOHNPORKMEAT).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> OBAMA = ITEMS.register("obama",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBAMAFUEL = ITEMS.register("obamafuel",
            () -> new FuelItem(new Item.Properties(), 40000));

    public static final RegistryObject<Item> TRANSMUTATIONWAND = ITEMS.register("transmutationwand",
            () -> new TransmutationItem(new Item.Properties().durability(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
