package rockstar.modules.other.spoof.bypass;

import rockstar.modules.other.spoof.SpoofManager;

/**
 * Bypass method 2: Intercepts name tag rendering to display the spoofed name.
 */
public class RenderBypass implements SpoofBypass {
    @Override
    public String getBypassName() {
        return "Render Override";
    }

    @Override
    public boolean isActive() {
        return SpoofManager.isSpoofing;
    }

    @Override
    public void apply(String newName) {
        // Logic is handled by NameTagRenderMixin
    }

    @Override
    public void reset() {
        // State reset handled by SpoofManager
    }
}
