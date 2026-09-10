package rockstar.modules.other.spoof.bypass;

import rockstar.modules.other.spoof.SpoofManager;

/**
 * Bypass method 1: Intercepts GameProfile requests at the entity level.
 */
public class ProfileBypass implements SpoofBypass {
    @Override
    public String getBypassName() {
        return "Profile Interception";
    }

    @Override
    public boolean isActive() {
        return SpoofManager.isSpoofing;
    }

    @Override
    public void apply(String newName) {
        // Logic is handled by NameSpoofMixin, this class represents the method
    }

    @Override
    public void reset() {
        // State reset handled by SpoofManager
    }
}
