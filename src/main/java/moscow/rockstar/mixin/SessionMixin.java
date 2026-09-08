package moscow.rockstar.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.session.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.modules.other.NameSpooferModule;

@Mixin(Session.class)
public abstract class SessionMixin {
    
    @Inject(method = "getProfile", at = @At("RETURN"), cancellable = true)
    private void onGetProfile(CallbackInfoReturnable<GameProfile> cir) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            // Check if NameSpooferModule is enabled
            NameSpooferModule spoofer = (NameSpooferModule) rockstar.client.RockstarClient.internalField0240
                .internalMethod02441() // Get ModuleManager
                .internalMethod02442(NameSpooferModule.class); // Get module by class
            
            if (spoofer != null && spoofer.isEnabled()) {
                // Return spoofed profile instead of original
                GameProfile spoofedProfile = spoofer.getSpoofedProfile();
                if (spoofedProfile != null) {
                    cir.setReturnValue(spoofedProfile);
                }
            }
        }
    }
}
