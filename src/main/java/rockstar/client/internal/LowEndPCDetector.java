package rockstar.client.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility for safe system capability checks without invoking OpenGL before context initialization.
 */
public class LowEndPCDetector {
    private static final Logger LOGGER = LoggerFactory.getLogger("LowEndPCDetector");
    private static boolean isLowEndPC = false;
    private static boolean detected = false;

    public static boolean isLowEndPC() {
        if (!detected) {
            detectCapabilities();
        }
        return isLowEndPC;
    }

    private static void detectCapabilities() {
        try {
            // Safe check via Java system properties, avoiding GL11 calls which cause native crashes during init
            String osArch = System.getProperty("os.arch", "unknown");
            long maxMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024); // MB
            
            LOGGER.info("System check: Arch={}, MaxMemory={}MB", osArch, maxMemory);

            // Consider PC low-end if allocated memory is under 2GB (2048 MB) or system is 32-bit
            isLowEndPC = maxMemory < 2048 || (osArch.contains("x86") && !osArch.contains("64"));

            if (isLowEndPC) {
                LOGGER.warn("Low-end PC detected (Low Memory or 32-bit)! Heavy effects disabled.");
            } else {
                LOGGER.info("System check passed. Features enabled.");
            }
        } catch (Exception e) {
            LOGGER.error("Failed to detect system capabilities, assuming low-end PC", e);
            isLowEndPC = true;
        } finally {
            detected = true;
        }
    }

    public static boolean shouldEnableShaders() {
        return !isLowEndPC();
    }

    public static boolean shouldEnableFramebuffer() {
        return !isLowEndPC();
    }

    public static boolean shouldEnablePostProcessing() {
        return !isLowEndPC();
    }

    public static void reset() {
        detected = false;
        isLowEndPC = false;
    }
}
