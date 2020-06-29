package mod.wastelanddevelopment.thegateway.init;

import mod.wastelanddevelopment.thegateway.TheGateway;
import mod.wastelanddevelopment.thegateway.blocks.BlockItemBase;
import mod.wastelanddevelopment.thegateway.items.ItemBase;
import mod.wastelanddevelopment.thegateway.items.ItemSpecial;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TheGateway.MOD_ID);

    //ITEMS
    public static final RegistryObject<Item> DEVSTONE = ITEMS.register("dev_stone", ItemSpecial::new);
    public static final RegistryObject<Item> RAWSPARITE = ITEMS.register("raw_sparite", ItemBase::new);
    public static final RegistryObject<Item> KEVARGEM = ITEMS.register("kevar_gem", ItemBase::new);
    public static final RegistryObject<Item> SPARITE = ITEMS.register("sparite", ItemBase::new);

    //BLOCK ITEMS
    public static final RegistryObject<Item> SPARITE_ORE_BLOCK_ITEM = ITEMS.register("sparite_ore", () -> new BlockItemBase(ModBlocks.SPARITE_ORE_BLOCK.get()));
    public static final RegistryObject<Item> KATH_STONE_BLOCK_ITEM = ITEMS.register("kath_stone", () -> new BlockItemBase(ModBlocks.KATH_STONE_BLOCK.get()));

    public static void registerItems(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
