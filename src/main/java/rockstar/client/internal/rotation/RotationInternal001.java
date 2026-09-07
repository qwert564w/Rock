package rockstar.client.internal.rotation;




import rockstar.client.rotation.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import rockstar.client.RockstarClient;
import rockstar.client.internal.core.CoreInternal044;
import rockstar.client.rotation.RotationBehavior;
import rockstar.client.rotation.Rotation;
import rockstar.client.rotation.RotationManager;
import rockstar.client.rotation.RotationPriority;

public class RotationInternal001
implements CoreInternal044 {
    private final Float internalField0292;
    private final Float internalField0291;
    private final boolean internalField0277;
    private boolean internalField0276 = false;

    public RotationInternal001(Float f, Float f2, boolean bl) {
        this.internalField0292 = f;
        this.internalField0291 = f2;
        this.internalField0277 = bl;
    }

    public static RotationInternal001 internalMethod05600(Float f, Float f2) {
        return new RotationInternal001(f, f2, true);
    }

    public static RotationInternal001 internalMethod01857() {
        return new RotationInternal001(null, null, false);
    }

    @Override
    public void internalMethod01925() {
        if (!this.internalField0277) {
            this.internalField0276 = true;
        }
    }

    @Override
    public boolean internalMethod01926() {
        if (this.internalField0277) {
            RotationManager typedValue269 = RockstarClient.getInstance().internalMethod02368();
            float f = this.internalField0292 != null ? this.internalField0292.floatValue() : typedValue269.internalMethod00024().internalMethod00169();
            float f2 = this.internalField0291 != null ? this.internalField0291.floatValue() : typedValue269.internalMethod00024().internalMethod00171();
            typedValue269.internalMethod00418(new Rotation(f, f2), RotationBehavior.internalField1003, 180.0f, 180.0f, 180.0f, RotationPriority.internalField1012);
            return false;
        }
        return this.internalField0276;
    }

    @Override
    public void internalMethod01928() {
        this.internalField0276 = false;
    }
}

