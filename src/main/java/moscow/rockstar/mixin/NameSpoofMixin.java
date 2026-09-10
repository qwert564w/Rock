package moscow.rockstar.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.modules.other.spoof.SpoofManager;

@Mixin(PlayerEntity.class)
public class NameSpoofMixin {
    @Inject(method = "getGameProfile", at = @At("HEAD"), cancellable = true)
    private void onGetGameProfile(CallbackInfoReturnable<GameProfile> cir) {
        if (SpoofManager.isSpoofing && SpoofManager.targetName != null && SpoofManager.targetUUID != null) {
            cir.setReturnValue(new GameProfile(SpoofManager.targetUUID, SpoofManager.targetName));
        }
    }
}
