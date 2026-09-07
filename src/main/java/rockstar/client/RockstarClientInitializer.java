package rockstar.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rockstar.client.internal.LowEndPCDetector;

/**
 * Точка входа для Rockstar Client
 * Этот класс инициализирует мод при запуске Minecraft
 */
public class RockstarClientInitializer implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("RockstarClient");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Starting Rockstar Client initialization...");
        
        try {
            // Ждем, пока MinecraftClient будет доступен
            MinecraftClient client = MinecraftClient.getInstance();
            if (client == null) {
                LOGGER.warn("MinecraftClient not ready yet, delaying GPU detection...");
            }
            
            // Определяем возможности GPU
            boolean isLowEnd = LowEndPCDetector.isLowEndPC();
            
            if (isLowEnd) {
                LOGGER.warn("========================================");
                LOGGER.warn("⚠️  LOW-END PC DETECTED");
                LOGGER.warn("========================================");
                LOGGER.warn("Shaders and heavy effects will be disabled");
                LOGGER.warn("to improve performance on your system.");
                LOGGER.warn("========================================");
            }
            
            // Получаем instance RockstarClient и инициализируем его
            RockstarClient.internalField0240.initialize();
            LOGGER.info("Rockstar Client initialized successfully!");
            
        } catch (Exception e) {
            LOGGER.error("Failed to initialize Rockstar Client!", e);
            LOGGER.error("Stack trace:", e);
            throw new RuntimeException("Rockstar Client initialization failed", e);
        }
    }
}
