package rockstar.client.internal.game;



import rockstar.client.animation.*;
import rockstar.client.*;
import lombok.NonNull;
import net.minecraft.util.math.Vec3d;
import rockstar.client.animation.AnimatedValue;
import rockstar.client.animation.Easing;

public class GameInternal029 {
    private static final Easing internalField0812 = Easing.internalField1814;
    private final long internalField0229;
    private final AnimatedValue internalField0808;
    private final AnimatedValue internalField0809;
    private final AnimatedValue internalField1321;

    public GameInternal029(long l, Easing typedValue214) {
        this.internalField0229 = l;
        this.internalField0808 = new AnimatedValue(l, typedValue214);
        this.internalField0809 = new AnimatedValue(l, typedValue214);
        this.internalField1321 = new AnimatedValue(l, typedValue214);
    }

    public GameInternal029(long l) {
        this(l, internalField0812);
    }

    public GameInternal029(long l, Vec3d vec3d, Easing typedValue214) {
        this.internalField0229 = l;
        this.internalField0808 = new AnimatedValue(l, (float)vec3d.getX(), typedValue214);
        this.internalField0809 = new AnimatedValue(l, (float)vec3d.getY(), typedValue214);
        this.internalField1321 = new AnimatedValue(l, (float)vec3d.getZ(), typedValue214);
    }

    public GameInternal029(long l, Vec3d vec3d) {
        this(l, vec3d, internalField0812);
    }

    public void internalMethod02645(@NonNull Vec3d vec3d) {
        if (vec3d == null) {
            throw new NullPointerException("vec is marked non-null but is null");
        }
        this.internalField0808.internalMethod07059((float)vec3d.getX());
        this.internalField0809.internalMethod07059((float)vec3d.getY());
        this.internalField1321.internalMethod07059((float)vec3d.getZ());
    }

    public Vec3d internalMethod07199() {
        return new Vec3d((double)this.internalField0808.internalMethod02881(), (double)this.internalField0809.internalMethod02881(), (double)this.internalField1321.internalMethod02881());
    }

    public void internalMethod02951(Easing typedValue214) {
        this.internalField0808.internalMethod06645(typedValue214);
        this.internalField0809.internalMethod06645(typedValue214);
        this.internalField1321.internalMethod06645(typedValue214);
    }

    public void internalMethod02798(long l) {
        this.internalField0808.internalMethod07061(l);
        this.internalField0809.internalMethod07061(l);
        this.internalField1321.internalMethod07061(l);
    }

    public void internalMethod01521(@NonNull Vec3d vec3d) {
        if (vec3d == null) {
            throw new NullPointerException("vec is marked non-null but is null");
        }
        this.internalField0808.internalMethod07060((float)vec3d.getX());
        this.internalField0809.internalMethod07060((float)vec3d.getY());
        this.internalField1321.internalMethod07060((float)vec3d.getZ());
    }
}

