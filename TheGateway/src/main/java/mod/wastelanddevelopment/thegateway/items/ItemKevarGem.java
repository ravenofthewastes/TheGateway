package mod.wastelanddevelopment.thegateway.items;

import mod.wastelanddevelopment.thegateway.blocks.KathPortal;
import mod.wastelanddevelopment.thegateway.registries.RegistryBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ItemKevarGem extends ItemMain{

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World worldIn = context.getWorld();
        if(!worldIn.isRemote()) {
            BlockPos pos = context.getPos();
            if (worldIn.dimension.getType() != DimensionType.THE_NETHER) {
                ((KathPortal) RegistryBlocks.KATH_PORTAL.get()).trySpawnPortal(worldIn, pos);
            }
        }
        return super.onItemUse(context);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
