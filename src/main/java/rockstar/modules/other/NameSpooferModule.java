package rockstar.modules.other;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import rockstar.client.module.Module;
import rockstar.client.module.ModuleCategory;
import rockstar.client.module.ModuleInfo;
import rockstar.client.setting.ModeSetting;
import rockstar.client.setting.BooleanSetting;
import rockstar.client.util.ChatUtils;
import rockstar.client.util.Stopwatch;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ModuleInfo(
    name = "Name Spoofer",
    category = ModuleCategory.OTHER,
    internalMethod09633 = "modules.descriptions.namespoofer"
)
public class NameSpooferModule extends Module {
    
    private static final List<String> PRESET_NAMES = Arrays.asList(
        "SpoofedPlayer",
        "Notch",
        "jeb_",
        "Dinnerbone",
        "Grumm",
        "MHF_Steve",
        "MHF_Alex",
        "Custom"
    );
    
    private final ModeSetting nameMode = new ModeSetting(this, "Name Preset", "Select spoofed name", PRESET_NAMES, 0);
    private final BooleanSetting spoofUUID = new BooleanSetting(this, "Spoof UUID", "Generate random UUID", false);
    private final BooleanSetting spoofSkin = new BooleanSetting(this, "Spoof Skin", "Copy skin from selected name", true);
    
    private GameProfile originalProfile;
    private GameProfile spoofedProfile;
    private final Stopwatch updateTimer = new Stopwatch();
    
    public NameSpooferModule() {
        addSettings(nameMode, spoofUUID, spoofSkin);
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
        String name = nameMode.getValue();
        if (name.equals("Custom")) {
            name = "SpoofedPlayer"; // Default fallback
            ChatUtils.warning("Custom name not implemented, using default");
        }
        
        UUID uuid;
        if (spoofUUID.isEnabled()) {
            uuid = UUID.randomUUID();
        } else {
            uuid = originalProfile.getId();
        }
        
        spoofedProfile = new GameProfile(uuid, name);
        
        // Apply spoofed profile
        applySpoof(mc);
        
        ChatUtils.info("Name spoofer enabled! New name: §f" + name);
        if (spoofUUID.isEnabled()) {
            ChatUtils.info("UUID: §f" + uuid.toString());
        }
    }
    
    @Override
    public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (originalProfile != null) {
            restoreProfile(mc);
            ChatUtils.info("Name spoofer disabled, original profile restored");
        }
    }
    
    @Override
    public void internalMethod08229() {
        // Update player list periodically
        if (updateTimer.hasPassed(1000)) {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc != null && mc.getNetworkHandler() != null) {
                updatePlayerList(mc);
            }
            updateTimer.reset();
        }
    }
    
    private void applySpoof(MinecraftClient mc) {
        try {
            // Use reflection to modify session
            java.lang.reflect.Field profileField = mc.getSession().getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(mc.getSession(), spoofedProfile);
            
            // Update player list entries
            updatePlayerList(mc);
            
        } catch (Exception e) {
            ChatUtils.error("Failed to apply spoof: " + e.getMessage());
        }
    }
    
    private void updatePlayerList(MinecraftClient mc) {
        if (mc.getNetworkHandler() == null) return;
        
        try {
            for (PlayerListEntry entry : mc.getNetworkHandler().getPlayerList()) {
                if (entry.getProfile().getId().equals(originalProfile.getId())) {
                    // Update player list entry
                    java.lang.reflect.Field entryProfileField = entry.getClass().getDeclaredField("profile");
                    entryProfileField.setAccessible(true);
                    entryProfileField.set(entry, spoofedProfile);
                }
            }
        } catch (Exception e) {
            // Silently fail on update errors
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
