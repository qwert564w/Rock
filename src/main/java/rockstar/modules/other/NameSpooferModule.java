package rockstar.modules.other;

import net.minecraft.text.Text;
import rockstar.client.module.Module;
import rockstar.client.module.ModuleCategory;
import rockstar.client.module.ModuleInfo;
import rockstar.client.util.ClientMessages;

@ModuleInfo(
    name = "Name Spoofer",
    category = ModuleCategory.OTHER
)
public class NameSpooferModule extends Module {
    
    public NameSpooferModule() {
        // Simple module placeholder
    }
    
    @Override
    public void onEnable() {
        ClientMessages.internalMethod01809(Text.literal("§cName Spoofer feature coming soon!"));
        ClientMessages.internalMethod01809(Text.literal("§eThis feature requires Minecraft API updates"));
        ClientMessages.internalMethod01809(Text.literal("§eModule will be fully implemented in next version"));
        
        // Disable immediately as it's not fully implemented yet
        toggle();
    }
    
    @Override
    public void onDisable() {
        // Nothing to clean up
    }
}
