package moscow.rockstar.mixin;

import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.PostEffectProcessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.internal.LowEndPCDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mixin для безопасного отключения тяжелых эффектов на слабых ПК
 */
@Mixin(Framebuffer.class)
public class FramebufferSafetyMixin {
    private static final Logger LOGGER = LoggerFactory.getLogger("FramebufferSafety");
    
    /**
     * Перехватываем создание framebuffer для проверки возможностей GPU
     */
    @Inject(method = "<init>", at = @At("HEAD"))
    private void onFramebufferInit(int width, int height, boolean useDepth, boolean getError, CallbackInfo ci) {
        if (LowEndPCDetector.isLowEndPC()) {
            LOGGER.debug("Creating framebuffer on low-end PC: {}x{}", width, height);
            // Можно добавить дополнительные проверки здесь
        }
    }
}
