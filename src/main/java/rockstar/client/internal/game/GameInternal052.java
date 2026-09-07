package rockstar.client.internal.game;


import rockstar.client.*;
import lombok.Generated;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.joml.Vector3f;

public class GameInternal052
extends Vec3d {
    private final Vec3d internalField0283;

    public GameInternal052(double d, double d2, double d3, Vec3d vec3d) {
        super(d, d2, d3);
        this.internalField0283 = vec3d;
    }

    public GameInternal052(Vector3f vector3f, Vec3d vec3d) {
        super(vector3f);
        this.internalField0283 = vec3d;
    }

    public GameInternal052(Vec3i vec3i, Vec3d vec3d) {
        super(vec3i);
        this.internalField0283 = vec3d;
    }

    @Generated
    public Vec3d internalMethod04225() {
        return this.internalField0283;
    }
}

