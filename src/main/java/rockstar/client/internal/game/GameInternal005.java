package rockstar.client.internal.game;




import rockstar.client.bot.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import lombok.Generated;
import net.minecraft.util.math.Vec3d;
import rockstar.client.internal.core.CoreInternal066;
import rockstar.client.internal.core.CoreInternal036;
import rockstar.client.bot.BotTargetManager;

public class GameInternal005
implements CoreInternal066 {
    private final Vec3d internalField0283;
    private final double internalField0194;

    public GameInternal005(Vec3d vec3d, double d) {
        this.internalField0283 = vec3d;
        this.internalField0194 = d;
    }

    public GameInternal005(double d, double d2, double d3) {
        this(new Vec3d(d + 0.5, d2, d3 + 0.5), 0.35);
    }

    @Override
    public void internalMethod07229(BotTargetManager typedValue055) {
        if (typedValue055 == null || this.internalField0283 == null) {
            return;
        }
        if (typedValue055.internalMethod02497(this.internalField0283) <= this.internalField0194) {
            typedValue055.internalMethod05456(new CoreInternal036());
            return;
        }
        typedValue055.internalMethod01196(this.internalField0283, this.internalField0194);
    }

    @Override
    public String internalMethod06553() {
        return "Goto " + Math.round(this.internalField0283.x) + " " + Math.round(this.internalField0283.y) + " " + Math.round(this.internalField0283.z);
    }

    @Generated
    public Vec3d internalMethod04861() {
        return this.internalField0283;
    }

    @Generated
    public double internalMethod05518() {
        return this.internalField0194;
    }
}

