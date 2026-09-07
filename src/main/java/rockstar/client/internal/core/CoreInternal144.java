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

public class CoreInternal144
extends RotationInternal019 {
    private final boolean internalField0277;
    private int internalField0227;
    private double internalField1043 = Double.NaN;

    public CoreInternal144(GameInternal059 typedValue296, GameInternal059 typedValue297) {
        this(typedValue296, typedValue297, false);
    }

    public CoreInternal144(GameInternal059 typedValue296, GameInternal059 typedValue297, boolean bl) {
        super(typedValue296, typedValue297);
        this.internalField0277 = bl;
    }

    @Override
    public double internalMethod01349() {
        return this.internalField0277 ? 2.0 : 1.0;
    }

    @Override
    public boolean internalMethod01348() {
        return !this.internalField0277 || this.internalField0924.internalMethod02949() >= this.internalField0923.internalMethod02949();
    }

    @Override
    public boolean internalMethod04946(GameInternal057 typedValue292) {
        int n = this.internalField0924.internalMethod02949() - this.internalField0923.internalMethod02949();
        if (this.internalField0277 ? n > 0 || n < -1 : Math.abs(n) > 1) {
            return false;
        }
        if (Math.abs(this.internalField0924.internalMethod02945() - this.internalField0923.internalMethod02945()) + Math.abs(this.internalField0924.internalMethod07945() - this.internalField0923.internalMethod07945()) != 1) {
            return false;
        }
        if (this.internalField0277) {
            if (!typedValue292.internalMethod09918(this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod02949(), this.internalField0924.internalMethod07945())) {
                return false;
            }
            double d = typedValue292.internalMethod05956(this.internalField0923.internalMethod02945(), this.internalField0923.internalMethod02949(), this.internalField0923.internalMethod07945());
            double d2 = Double.isNaN(d) ? (double)this.internalField0923.internalMethod02949() : d;
            this.internalMethod01515(d2, this.internalField0924.internalMethod02949());
            return typedValue292.internalMethod03056(this.internalField0923.internalMethod02945(), this.internalField0923.internalMethod07945(), this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod07945(), d2 + 0.05, d2 + 1.8);
        }
        double d = typedValue292.internalMethod05956(this.internalField0923.internalMethod02945(), this.internalField0923.internalMethod02949(), this.internalField0923.internalMethod07945());
        double d3 = typedValue292.internalMethod05956(this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod02949(), this.internalField0924.internalMethod07945());
        if (Double.isNaN(d3)) {
            return false;
        }
        if (Double.isNaN(d)) {
            d = this.internalField0923.internalMethod02949();
        }
        if (Math.abs(d3 - d) > 0.62) {
            return false;
        }
        this.internalMethod01515(d, d3);
        double d4 = Math.max(d, d3);
        return typedValue292.internalMethod03056(this.internalField0923.internalMethod02945(), this.internalField0923.internalMethod07945(), this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod07945(), d4 + 0.05, d4 + 1.8);
    }

    @Override
    public RotationInternal019.InternalType0058 internalMethod04014() {
        ClientPlayerEntity clientPlayerEntity = CoreInternal144.internalMethod03778();
        if (clientPlayerEntity == null) {
            return RotationInternal019.InternalType0058.internalField1160;
        }
        double d = clientPlayerEntity.getY();
        if (this.internalField0277 ? this.internalMethod05161(0.35) && Math.abs(d - (double)this.internalField0924.internalMethod02949()) < 1.2 : this.internalMethod05161(0.4) && Math.abs(d - this.internalField1045) < 0.7) {
            return RotationInternal019.InternalType0058.internalField0454;
        }
        if (d < Math.min(this.internalField0193, this.internalField1045) - 1.2 && !clientPlayerEntity.isClimbing() && !clientPlayerEntity.isTouchingWater()) {
            return RotationInternal019.InternalType0058.internalField1160;
        }
        boolean bl = this.internalMethod00876(clientPlayerEntity.getX(), clientPlayerEntity.getZ());
        if (bl) {
            this.internalMethod01443((double)this.internalField0923.internalMethod02945() + 0.5, (double)this.internalField0923.internalMethod07945() + 0.5);
        } else {
            this.internalMethod05160(0.9);
        }
        ScriptInternal169 typedValue290 = CoreInternal144.internalMethod00577();
        typedValue290.internalMethod08359(false);
        if (bl) {
            this.internalMethod06359(typedValue290, RotationInternal019.InternalType0057.internalField0452);
            return RotationInternal019.InternalType0058.internalField0453;
        }
        double d2 = this.internalMethod01442(clientPlayerEntity.getX(), clientPlayerEntity.getZ());
        double d3 = Double.isNaN(this.internalField1043) ? 1.0 : d2 - this.internalField1043;
        this.internalField1043 = d2;
        this.internalField0227 = clientPlayerEntity.horizontalCollision && clientPlayerEntity.isOnGround() && d3 < 0.01 ? ++this.internalField0227 : 0;
        if (this.internalField0100 != null && !this.internalField0100.internalMethod01348()) {
            this.internalMethod06359(typedValue290, this.internalField0100.internalMethod01351() ? RotationInternal019.InternalType0057.internalField0451 : RotationInternal019.InternalType0057.internalField0452);
        } else {
            this.internalMethod06359(typedValue290, RotationInternal019.InternalType0057.internalField0451);
            this.internalMethod01706(typedValue290);
        }
        if (this.internalField0227 > 3) {
            this.internalMethod06640(typedValue290);
            if (this.internalField0227 % 7 == 0) {
                typedValue290.internalMethod08359(true);
            }
        }
        if (clientPlayerEntity.isTouchingWater() && d < this.internalField1045 - 0.1) {
            typedValue290.internalMethod08359(true);
        } else if (this.internalMethod08659()) {
            typedValue290.internalMethod08359(true);
        }
        return RotationInternal019.InternalType0058.internalField0453;
    }

    private boolean internalMethod00876(double d, double d2) {
        double d3 = this.internalMethod01442(d, d2);
        double d4 = this.internalMethod01513(d, d2);
        return d3 < -0.3 || d4 > 0.9;
    }

    @Override
    public void internalMethod01347() {
        this.internalField0227 = 0;
        this.internalField1043 = Double.NaN;
        ScriptInternal169 typedValue290 = CoreInternal144.internalMethod00577();
        typedValue290.internalMethod03508(false);
        typedValue290.internalMethod03557(false);
        typedValue290.internalMethod09358(false);
        typedValue290.internalMethod08359(false);
        typedValue290.internalMethod08033(false);
        typedValue290.internalMethod08045(false);
    }
}

