package moscow.rockstar.mixin.sodium;



import rockstar.client.internal.script.*;
import rockstar.client.internal.game.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.internal.script.ScriptInternal149;
import rockstar.client.internal.game.GameInternal046;

@Pseudo
@Mixin(targets={"net.caffeinemc.mods.sodium.client.world.LevelSlice"}, remap=false)
public class LevelSliceMixin {
    @Inject(method={"getBlockState(III)Lnet/minecraft/block/BlockState;", "getBlockState(III)Lnet/minecraft/class_2680;"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void hideCameraClipBlocks(int n, int n2, int n3, CallbackInfoReturnable<BlockState> callbackInfoReturnable) {
        if (ScriptInternal149.internalMethod01361(n, n2, n3)) {
            callbackInfoReturnable.setReturnValue(Blocks.AIR.getDefaultState());
        }
    }

    @Inject(method={"getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;", "method_8320(Lnet/minecraft/class_2338;)Lnet/minecraft/class_2680;"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void hideCameraClipBlocks(BlockPos blockPos, CallbackInfoReturnable<BlockState> callbackInfoReturnable) {
        if (ScriptInternal149.internalMethod00945(blockPos)) {
            callbackInfoReturnable.setReturnValue(Blocks.AIR.getDefaultState());
        }
    }

    @Inject(method={"getLightLevel(Lnet/minecraft/world/LightType;Lnet/minecraft/util/math/BlockPos;)I", "method_8314(Lnet/minecraft/class_1944;Lnet/minecraft/class_2338;)I"}, at={@At(value="RETURN")}, cancellable=true, require=0)
    private void lightCameraClipBlocks(LightType lightType, BlockPos blockPos, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        int n = callbackInfoReturnable.getReturnValueI();
        if (lightType == LightType.BLOCK) {
            n = GameInternal046.internalMethod01092(blockPos, n);
        }
        if (ScriptInternal149.internalMethod00945(blockPos)) {
            n = ScriptInternal149.internalMethod05834(lightType, n);
        }
        callbackInfoReturnable.setReturnValue(n);
    }
}

