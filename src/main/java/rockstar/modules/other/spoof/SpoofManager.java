package rockstar.modules.other.spoof;

import java.util.UUID;

/**
 * Manages the in-game name spoofing state.
 * State is volatile and resets on game restart.
 */
public class SpoofManager {
    public static volatile boolean isSpoofing = false;
    public static volatile String targetName = "";
    public static volatile UUID targetUUID = null;
    
    public static volatile float progress = 0.0f;
    public static volatile String statusMessage = "";
    public static volatile boolean isProcessing = false;

    public static void startSpoofProcess(String newName) {
        isProcessing = true;
        progress = 0.0f;
        statusMessage = "Initializing bypass hooks...";
        targetName = newName;
        targetUUID = UUID.nameUUIDFromBytes(("OfflinePlayer:" + newName).getBytes());
    }

    public static void updateProgress() {
        if (!isProcessing) return;
        
        progress += 0.05f;
        if (progress < 0.3f) {
            statusMessage = "Hooking GameProfile...";
        } else if (progress < 0.6f) {
            statusMessage = "Intercepting network packets...";
        } else if (progress < 0.9f) {
            statusMessage = "Applying render overrides...";
        } else {
            progress = 1.0f;
            statusMessage = "Spoof applied successfully!";
            isSpoofing = true;
            isProcessing = false;
        }
    }

    public static void reset() {
        isSpoofing = false;
        isProcessing = false;
        progress = 0.0f;
        statusMessage = "";
        targetName = "";
        targetUUID = null;
    }
}
