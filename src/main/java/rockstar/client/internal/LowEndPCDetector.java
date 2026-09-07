package rockstar.client.internal;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import org.lwjgl.opengl.GL11;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Утилита для проверки возможностей GPU и оптимизации для слабых ПК
 */
public class LowEndPCDetector {
    private static final Logger LOGGER = LoggerFactory.getLogger("LowEndPCDetector");
    private static boolean isLowEndPC = false;
    private static boolean detected = false;

    /**
     * Определяет, является ли ПК слабым
     */
    public static boolean isLowEndPC() {
        if (!detected) {
            detectCapabilities();
        }
        return isLowEndPC;
    }

    /**
     * Проверяет возможности GPU и определяет, слабый ли ПК
     */
    private static void detectCapabilities() {
        try {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client == null) {
                LOGGER.warn("MinecraftClient is null, assuming low-end PC");
                isLowEndPC = true;
                detected = true;
                return;
            }

            // Получаем информацию о GPU
            String renderer = GL11.glGetString(GL11.GL_RENDERER);
            String vendor = GL11.glGetString(GL11.GL_VENDOR);
            String version = GL11.glGetString(GL11.GL_VERSION);
            
            LOGGER.info("GPU Detection:");
            LOGGER.info("  Renderer: {}", renderer);
            LOGGER.info("  Vendor: {}", vendor);
            LOGGER.info("  Version: {}", version);

            // Проверяем, интегрированная ли графика (Intel, AMD iGPU)
            boolean isIntegrated = renderer != null && (
                renderer.toLowerCase().contains("intel") ||
                renderer.toLowerCase().contains("hd graphics") ||
                renderer.toLowerCase().contains("uhd graphics") ||
                renderer.toLowerCase().contains("iris") ||
                renderer.toLowerCase().contains("amd radeon") && renderer.toLowerCase().contains("vega")
            );

            // Проверяем framebuffer
            Framebuffer framebuffer = client.getFramebuffer();
            int fbWidth = framebuffer != null ? framebuffer.textureWidth : 0;
            int fbHeight = framebuffer != null ? framebuffer.textureHeight : 0;
            
            LOGGER.info("Framebuffer: {}x{}", fbWidth, fbHeight);

            // Определяем, слабый ли ПК
            isLowEndPC = isIntegrated || 
                        (fbWidth < 1920 && fbHeight < 1080) ||
                        renderer == null ||
                        renderer.toLowerCase().contains("software");

            if (isLowEndPC) {
                LOGGER.warn("⚠️ Low-end PC detected! Shaders and heavy effects will be disabled.");
                LOGGER.warn("   Detected GPU: {}", renderer);
                LOGGER.warn("   Integrated graphics: {}", isIntegrated);
            } else {
                LOGGER.info("✅ High-end PC detected. All features enabled.");
            }

        } catch (Exception e) {
            LOGGER.error("Failed to detect GPU capabilities, assuming low-end PC", e);
            isLowEndPC = true;
        } finally {
            detected = true;
        }
    }

    /**
     * Проверяет, должны ли быть включены шейдеры
     */
    public static boolean shouldEnableShaders() {
        return !isLowEndPC();
    }

    /**
     * Проверяет, должны ли быть включены framebuffer эффекты
     */
    public static boolean shouldEnableFramebuffer() {
        return !isLowEndPC();
    }

    /**
     * Проверяет, должны ли быть включены пост-процессинг эффекты
     */
    public static boolean shouldEnablePostProcessing() {
        return !isLowEndPC();
    }

    /**
     * Сбрасывает детектирование (для тестирования)
     */
    public static void reset() {
        detected = false;
        isLowEndPC = false;
    }
}
