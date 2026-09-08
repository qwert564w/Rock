package rockstar.modules.other;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.text.Text;
import rockstar.client.module.Module;
import rockstar.client.module.ModuleCategory;
import rockstar.client.module.ModuleInfo;
import rockstar.client.util.ClientMessages;

import java.util.UUID;

@ModuleInfo(
    name = "Name Spoofer",
    category = ModuleCategory.OTHER
)
public class NameSpooferModule extends Module {
    
    private GameProfile originalProfile;
    private GameProfile spoofedProfile;
    
    public NameSpooferModule() {
        // Simple module without complex settings
    }
    
    @Override
    public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.getSession() == null) {
            ClientMessages.internalMethod09025(Text.literal("Session is null, cannot spoof!"));
            toggle();
            return;
        }
        
        // Save original profile
        originalProfile = mc.getSession().getProfile();
        
        // Create spoofed profile with random name and UUID
        String name = "SpoofedPlayer";
        UUID uuid = UUID.randomUUID();
        
        spoofedProfile = new GameProfile(uuid, name);
        
        // Apply spoofed profile
        applySpoof(mc);
        
        ClientMessages.internalMethod01809(Text.literal("Name spoofer enabled! New name: §f" + name));
        ClientMessages.internalMethod01809(Text.literal("UUID: §f" + uuid.toString()));
    }
    
    @Override
    public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (originalProfile != null) {
            restoreProfile(mc);
            ClientMessages.internalMethod01809(Text.literal("Name spoofer disabled, original profile restored"));
        }
    }
    
    /**
     * Get spoofed profile for use by Mixins
     */
    public GameProfile getSpoofedProfile() {
        return spoofedProfile;
    }
    
    /**
     * Get original profile for restoration
     */
    public GameProfile getOriginalProfile() {
        return originalProfile;
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
            ClientMessages.internalMethod09025(Text.literal("Failed to apply spoof: " + e.getMessage()));
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
            ClientMessages.internalMethod09025(Text.literal("Failed to restore profile: " + e.getMessage()));
        }
    }
}
