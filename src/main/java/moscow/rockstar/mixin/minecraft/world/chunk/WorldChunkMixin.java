package moscow.rockstar.mixin.minecraft.world.chunk;


import rockstar.client.internal.game.*;
import java.util.Map;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.internal.game.GameInternal036;

@Mixin(value={WorldChunk.class})
public abstract class WorldChunkMixin {
    @Shadow
    public abstract World method_12200();

    @Shadow
    public abstract Map<BlockPos, BlockEntity> method_12214();

    @Inject(method={"setBlockEntity"}, at={@At(value="INVOKE", target="Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;")})
    private void onLoadBlockEntity(BlockEntity blockEntity, CallbackInfo callbackInfo) {
        if (this.method_12200().isClient()) {
            GameInternal036.internalMethod04676(blockEntity);
        }
    }

    @Inject(method={"removeBlockEntity"}, at={@At(value="INVOKE", target="Lnet/minecraft/block/entity/BlockEntity;markRemoved()V")})
    private void onRemoveBlockEntity(BlockPos blockPos, CallbackInfo callbackInfo) {
        GameInternal036.internalMethod07047(blockPos);
    }

    @Inject(method={"clear"}, at={@At(value="HEAD")})
    private void onClearBlockEntities(CallbackInfo callbackInfo) {
        if (!this.method_12200().isClient()) {
            return;
        }
        for (BlockPos blockPos : this.method_12214().keySet()) {
            GameInternal036.internalMethod07047(blockPos);
        }
    }
}

