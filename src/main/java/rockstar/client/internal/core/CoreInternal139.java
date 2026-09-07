package rockstar.client.internal.core;






import rockstar.client.rotation.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.rotation.*;
import rockstar.client.internal.game.*;
import rockstar.client.*;
import net.minecraft.client.network.ClientPlayerEntity;
import rockstar.client.internal.script.ScriptInternal169;
import rockstar.client.internal.game.GameInternal057;
import rockstar.client.internal.game.GameInternal059;
import rockstar.client.internal.rotation.RotationInternal019;

public class CoreInternal139
extends RotationInternal019 {
    public CoreInternal139(GameInternal059 typedValue296, GameInternal059 typedValue297) {
        super(typedValue296, typedValue297);
    }

    @Override
    public double internalMethod01349() {
        return 1.6;
    }

    @Override
    public int internalMethod01346() {
        return 80;
    }

    @Override
    public boolean internalMethod04946(GameInternal057 typedValue292) {
        double d;
        int n = this.internalField0924.internalMethod02949() - this.internalField0923.internalMethod02949();
        if (n < 0 || n > 1) {
            return false;
        }
        if (Math.abs(this.internalField0924.internalMethod02945() - this.internalField0923.internalMethod02945()) + Math.abs(this.internalField0924.internalMethod07945() - this.internalField0923.internalMethod07945()) != 1) {
            return false;
        }
        double d2 = typedValue292.internalMethod05956(this.internalField0923.internalMethod02945(), this.internalField0923.internalMethod02949(), this.internalField0923.internalMethod07945());
        double d3 = typedValue292.internalMethod05956(this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod02949(), this.internalField0924.internalMethod07945());
        if (Double.isNaN(d3)) {
            return false;
        }
        if (Double.isNaN(d2)) {
            d2 = this.internalField0923.internalMethod02949();
        }
        if ((d = d3 - d2) <= 0.62 || d > 1.3) {
            return false;
        }
        this.internalMethod01515(d2, d3);
        return typedValue292.internalMethod03056(this.internalField0923.internalMethod02945(), this.internalField0923.internalMethod07945(), this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod07945(), d3 + 0.05, d3 + 1.8);
    }

    @Override
    public RotationInternal019.InternalType0058 internalMethod04014() {
        boolean bl;
        ClientPlayerEntity clientPlayerEntity = CoreInternal139.internalMethod03778();
        if (clientPlayerEntity == null) {
            return RotationInternal019.InternalType0058.internalField1160;
        }
        double d = clientPlayerEntity.getY();
        if (this.internalMethod05161(0.4) && d >= this.internalField1045 - 0.1) {
            return RotationInternal019.InternalType0058.internalField0454;
        }
        if (d < this.internalField0193 - 1.2 && !clientPlayerEntity.isClimbing() && !clientPlayerEntity.isTouchingWater()) {
            return RotationInternal019.InternalType0058.internalField1160;
        }
        double d2 = (double)this.internalField0924.internalMethod02945() + 0.5;
        double d3 = (double)this.internalField0924.internalMethod07945() + 0.5;
        double d4 = d2 - clientPlayerEntity.getX();
        double d5 = d3 - clientPlayerEntity.getZ();
        this.internalMethod01443(d2, d3);
        ScriptInternal169 typedValue290 = CoreInternal139.internalMethod00577();
        this.internalMethod06359(typedValue290, RotationInternal019.InternalType0057.internalField0452);
        boolean bl2 = bl = d < this.internalField1045 - 0.1;
        if (clientPlayerEntity.isTouchingWater()) {
            typedValue290.internalMethod08359(bl);
        } else {
            boolean bl3 = clientPlayerEntity.horizontalCollision || Math.hypot(d4, d5) < 1.05;
            typedValue290.internalMethod08359(bl && clientPlayerEntity.isOnGround() && bl3);
        }
        return RotationInternal019.InternalType0058.internalField0453;
    }

    @Override
    public void internalMethod01347() {
        ScriptInternal169 typedValue290 = CoreInternal139.internalMethod00577();
        typedValue290.internalMethod03508(false);
        typedValue290.internalMethod08359(false);
        typedValue290.internalMethod09358(false);
    }
}

