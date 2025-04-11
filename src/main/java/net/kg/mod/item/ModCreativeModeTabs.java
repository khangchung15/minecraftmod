package net.kg.mod.item;

import net.kg.mod.TestMod;
import net.kg.mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> MEME = CREATIVE_MODE_TAB.register("meme",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JOHNPORK.get()))
                    .title(Component.translatable("creativetab.testmod.meme"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.JOHNPORK.get());
                        output.accept(ModItems.JOHNPORKMEAT.get());
                        output.accept(ModBlocks.JOHNPORKBLOCK.get());

                        output.accept(ModItems.OBAMA.get());
                        output.accept(ModItems.OBAMAFUEL.get());
                        output.accept(ModBlocks.OBAMABLOCK.get());
                        output.accept(ModBlocks.OBAMAORE.get());

                        output.accept(ModItems.TRANSMUTATIONWAND.get());
                        output.accept(ModBlocks.TRANSMUTATIONBLOCK.get());
                    })
                    .build());
}
