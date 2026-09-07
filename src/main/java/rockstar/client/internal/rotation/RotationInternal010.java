package rockstar.client.internal.rotation;




import rockstar.client.rotation.*;
import rockstar.client.animation.*;
import rockstar.client.*;
import lombok.NonNull;
import rockstar.client.animation.AnimatedValue;
import rockstar.client.animation.Easing;
import rockstar.client.rotation.Rotation;

public class RotationInternal010 {
    private static final Easing internalField0812 = Easing.internalField1627;
    private final AnimatedValue internalField0808;
    private final AnimatedValue internalField0809;

    public RotationInternal010(long l, long l2, Easing typedValue214) {
        this.internalField0808 = new AnimatedValue(l, typedValue214);
        this.internalField0809 = new AnimatedValue(l2, typedValue214);
    }

    public RotationInternal010(long l) {
        this(l, l, internalField0812);
    }

    public RotationInternal010(long l, long l2, Rotation typedValue266, Easing typedValue214) {
        this.internalField0808 = new AnimatedValue(l, typedValue266.internalMethod00169(), typedValue214);
        this.internalField0809 = new AnimatedValue(l2, typedValue266.internalMethod00171(), typedValue214);
    }

    public RotationInternal010(long l, Rotation typedValue266) {
        this(l, l, typedValue266, internalField0812);
    }

    public void internalMethod05918(@NonNull Rotation typedValue266) {
        if (typedValue266 == null) {
            throw new NullPointerException("rotation is marked non-null but is null");
        }
        this.internalField0808.internalMethod07059(typedValue266.internalMethod00169());
        this.internalField0809.internalMethod07059(typedValue266.internalMethod00171());
    }

    public Rotation internalMethod05962() {
        return new Rotation(this.internalField0808.internalMethod02881(), this.internalField0809.internalMethod02881());
    }

    public void internalMethod03249(long l) {
        this.internalField0808.internalMethod07061(l);
    }

    public void internalMethod03303(long l) {
        this.internalField0809.internalMethod07061(l);
    }

    public void internalMethod05515(Easing typedValue214) {
        this.internalField0808.internalMethod06645(typedValue214);
        this.internalField0809.internalMethod06645(typedValue214);
    }

    public void internalMethod02753(@NonNull Rotation typedValue266) {
        if (typedValue266 == null) {
            throw new NullPointerException("rotation is marked non-null but is null");
        }
        this.internalField0808.internalMethod07060(typedValue266.internalMethod00169());
        this.internalField0809.internalMethod07060(typedValue266.internalMethod00171());
    }
}

