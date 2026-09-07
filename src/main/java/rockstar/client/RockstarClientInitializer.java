package rockstar.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            // Получаем instance RockstarClient и инициализируем его
            RockstarClient.internalField0240.initialize();
            LOGGER.info("Rockstar Client initialized successfully!");
        } catch (Exception e) {
            LOGGER.error("Failed to initialize Rockstar Client!", e);
            throw new RuntimeException("Rockstar Client initialization failed", e);
        }
    }
}
