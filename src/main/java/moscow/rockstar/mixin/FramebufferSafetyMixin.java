package moscow.rockstar.mixin;

import net.minecraft.client.gl.Framebuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.internal.LowEndPCDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mixin(Framebuffer.class)
public class FramebufferSafetyMixin {
    private static final Logger LOGGER = LoggerFactory.getLogger("FramebufferSafety");

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onFramebufferInit(String name, boolean useDepthAttachment, CallbackInfo ci) {
        if (LowEndPCDetector.isLowEndPC()) {
            LOGGER.debug("Framebuffer created on low-end PC: name={}, depth={}", name, useDepthAttachment);
        }
    }
}
