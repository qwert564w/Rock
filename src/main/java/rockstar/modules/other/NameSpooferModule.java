package rockstar.modules.other;

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
    
    public static volatile boolean spoofActive = false;
    public static volatile String spoofedName = "";
    public static volatile UUID spoofedUUID = null;

    public NameSpooferModule() {
        // Simple module placeholder
    }
    
    public static boolean isSpoofActive() {
        return spoofActive;
    }

    public static String getSpoofedName() {
        return spoofedName;
    }

    public static UUID getSpoofedUUID() {
        return spoofedUUID;
    }
    
    @Override
    public void onEnable() {
        ClientMessages.internalMethod01809(Text.literal("§aName Spoofer enabled"));
    }
    
    @Override
    public void onDisable() {
        spoofActive = false;
        ClientMessages.internalMethod01809(Text.literal("§cName Spoofer disabled"));
    }
}
