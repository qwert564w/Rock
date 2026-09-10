package rockstar.modules.other.spoof.bypass;

/**
 * Interface for all name spoofing bypass methods.
 */
public interface SpoofBypass {
    String getBypassName();
    boolean isActive();
    void apply(String newName);
    void reset();
}
