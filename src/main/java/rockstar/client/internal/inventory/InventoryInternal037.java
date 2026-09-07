package rockstar.client.internal.inventory;


import rockstar.client.*;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import rockstar.client.internal.inventory.InventoryInternal036;

public final class InventoryInternal037 {
    public static final int internalField0227 = 200;

    private InventoryInternal037() {
    }

    public static int internalMethod02037(BlockState blockState, BlockPos blockPos) {
        boolean bl;
        float f;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null || minecraftClient.player == null) {
            return Integer.MAX_VALUE;
        }
        if (blockState.isAir()) {
            return 0;
        }
        float f2 = blockState.getHardness((BlockView)minecraftClient.world, blockPos);
        if (f2 < 0.0f) {
            return Integer.MAX_VALUE;
        }
        if (f2 == 0.0f) {
            return 1;
        }
        InventoryInternal036.InternalType0256 nestedValue0099 = InventoryInternal036.internalMethod06939(blockState);
        ItemStack itemStack = nestedValue0099 != null ? minecraftClient.player.getInventory().getStack(nestedValue0099.internalMethod07557()) : ItemStack.EMPTY;
        float f3 = InventoryInternal036.internalMethod00662(itemStack, blockState);
        float f4 = f3 / f2 / (f = (bl = InventoryInternal037.internalMethod02000(itemStack, blockState)) ? 30.0f : 100.0f);
        if (f4 <= 0.0f) {
            return Integer.MAX_VALUE;
        }
        int n = (int)Math.ceil(1.0 / (double)f4);
        return n;
    }

    public static int internalMethod05452(BlockState blockState) {
        return InventoryInternal037.internalMethod02037(blockState, BlockPos.ORIGIN);
    }

    public static boolean internalMethod02000(ItemStack itemStack, BlockState blockState) {
        if (!blockState.isToolRequired()) {
            return true;
        }
        return itemStack.isSuitableFor(blockState);
    }
}

