package rockstar.modules.other;

import net.minecraft.text.Text;
import rockstar.client.module.Module;
import rockstar.client.module.ModuleCategory;
import rockstar.client.module.ModuleInfo;
import rockstar.client.util.ClientMessages;
import rockstar.modules.other.spoof.SpoofManager;

@ModuleInfo(
    name = "[SHIELD] Name Spoofer",
    category = ModuleCategory.OTHER
)
public class NameSpooferModule extends Module {
    
    public NameSpooferModule() {
        super();
    }
    
    @Override
    public void onEnable() {
        if (SpoofManager.isProcessing || SpoofManager.isSpoofing) {
            ClientMessages.internalMethod01809(Text.literal("§cSpoof is already active or processing!"));
            toggle();
            return;
        }
        
        String newName = "SpoofedUser_" + System.currentTimeMillis() % 10000;
        SpoofManager.startSpoofProcess(newName);
        ClientMessages.internalMethod01809(Text.literal("§aStarting spoof process for: §f" + newName));
        
        // Note: Actual progress bar UI would be rendered in a custom Screen. 
        // For module toggle, we simulate the background process.
        new Thread(() -> {
            while (SpoofManager.isProcessing) {
                SpoofManager.updateProgress();
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
            if (SpoofManager.isSpoofing) {
                mc.execute(() -> ClientMessages.internalMethod01809(Text.literal("§a[SHIELD] Spoof successfully applied!")));
            }
        }).start();
    }
    
    @Override
    public void onDisable() {
        SpoofManager.reset();
        ClientMessages.internalMethod01809(Text.literal("§c[SHIELD] Spoof disabled and reset."));
    }
}
