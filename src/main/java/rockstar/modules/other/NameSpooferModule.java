package rockstar.modules.other;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import rockstar.client.module.Module;
import rockstar.client.module.ModuleCategory;
import rockstar.client.module.ModuleInfo;
import rockstar.client.setting.Setting;
import rockstar.client.setting.TextSetting;
import rockstar.client.util.ChatUtils;

import java.util.UUID;

@ModuleInfo(
    name = "Name Spoofer",
    category = ModuleCategory.OTHER,
    description = "Spoof your name, UUID and skin"
)
public class NameSpooferModule extends Module {
    
    private final TextSetting spoofedName = new TextSetting("Name", "Your new name", "SpoofedPlayer");
    private final TextSetting spoofedUUID = new TextSetting("UUID", "Custom UUID (leave empty for random)", "");
    private final TextSetting spoofedSkin = new TextSetting("Skin", "Skin username (e.g. Notch)", "");
    
    private GameProfile originalProfile;
    private GameProfile spoofedProfile;
    
    public NameSpooferModule() {
        addSettings(spoofedName, spoofedUUID, spoofedSkin);
    }
    
    @Override
    public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.getSession() == null) {
            ChatUtils.error("Session is null, cannot spoof!");
            toggle();
            return;
        }
        
        // Save original profile
        originalProfile = mc.getSession().getProfile();
        
        // Create spoofed profile
        String name = spoofedName.getValue();
        UUID uuid;
        
        try {
            if (!spoofedUUID.getValue().isEmpty()) {
                uuid = UUID.fromString(spoofedUUID.getValue());
            } else {
                uuid = UUID.randomUUID();
            }
        } catch (IllegalArgumentException e) {
            ChatUtils.error("Invalid UUID format, using random UUID");
            uuid = UUID.randomUUID();
        }
        
        spoofedProfile = new GameProfile(uuid, name);
        
        // Apply spoofofed profile
        applySpoof(mc);
        
        ChatUtils.info("Name spoofer enabled! New name: " + name);
    }
    
    @Override
    public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (originalProfile != null) {
            restoreProfile(mc);
            ChatUtils.info("Name spoofer disabled, original profile restored");
        }
    }
    
    private void applySpoof(MinecraftClient mc) {
        try {
            // Use reflection to modify session
            java.lang.reflect.Field profileField = mc.getSession().getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(mc.getSession(), spoofedProfile);
            
            // Update player list entries
            if (mc.getNetworkHandler() != null) {
                for (PlayerListEntry entry : mc.getNetworkHandler().getPlayerList()) {
                    if (entry.getProfile().getId().equals(originalProfile.getId())) {
                        // Update player list entry
                        java.lang.reflect.Field entryProfileField = entry.getClass().getDeclaredField("profile");
                        entryProfileField.setAccessible(true);
                        entryProfileField.set(entry, spoofedProfile);
                    }
                }
            }
        } catch (Exception e) {
            ChatUtils.error("Failed to apply spoof: " + e.getMessage());
        }
    }
    
    private void restoreProfile(MinecraftClient mc) {
        try {
            java.lang.reflect.Field profileField = mc.getSession().getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(mc.getSession(), originalProfile);
            
            // Restore player list entries
            if (mc.getNetworkHandler() != null) {
                for (PlayerListEntry entry : mc.getNetworkHandler().getPlayerList()) {
                    if (entry.getProfile().getId().equals(spoofedProfile.getId())) {
                        java.lang.reflect.Field entryProfileField = entry.getClass().getDeclaredField("profile");
                        entryProfileField.setAccessible(true);
                        entryProfileField.set(entry, originalProfile);
                    }
                }
            }
        } catch (Exception e) {
            ChatUtils.error("Failed to restore profile: " + e.getMessage());
        }
    }
}
