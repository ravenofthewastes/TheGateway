package mod.wastelanddevelopment.thegateway.blocks;

import mod.wastelanddevelopment.thegateway.TheGateway;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

	public BlockItemBase(Block block) {
		super(block, new Item.Properties().group(TheGateway.TAB));
		
	}

}
