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

public class CoreInternal141
extends RotationInternal019 {
    private int internalField0227;
    private double internalField1043 = Double.NaN;

    public CoreInternal141(GameInternal059 typedValue296, GameInternal059 typedValue297) {
        super(typedValue296, typedValue297);
    }

    @Override
    public double internalMethod01349() {
        return 1.4142;
    }

    @Override
    public boolean internalMethod04946(GameInternal057 typedValue292) {
        boolean bl;
        if (this.internalField0924.internalMethod02949() != this.internalField0923.internalMethod02949()) {
            return false;
        }
        if (Math.abs(this.internalField0924.internalMethod02945() - this.internalField0923.internalMethod02945()) != 1 || Math.abs(this.internalField0924.internalMethod07945() - this.internalField0923.internalMethod07945()) != 1) {
            return false;
        }
        double d = typedValue292.internalMethod05956(this.internalField0923.internalMethod02945(), this.internalField0923.internalMethod02949(), this.internalField0923.internalMethod07945());
        double d2 = typedValue292.internalMethod05956(this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod02949(), this.internalField0924.internalMethod07945());
        if (Double.isNaN(d) || Double.isNaN(d2)) {
            return false;
        }
        if (Math.abs(d2 - d) > 0.62) {
            return false;
        }
        boolean bl2 = typedValue292.internalMethod05958(this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod02949(), this.internalField0923.internalMethod07945()) && typedValue292.internalMethod05958(this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod02949() + 1, this.internalField0923.internalMethod07945());
        boolean bl3 = bl = typedValue292.internalMethod05958(this.internalField0923.internalMethod02945(), this.internalField0924.internalMethod02949(), this.internalField0924.internalMethod07945()) && typedValue292.internalMethod05958(this.internalField0923.internalMethod02945(), this.internalField0924.internalMethod02949() + 1, this.internalField0924.internalMethod07945());
        if (!bl2 || !bl) {
            return false;
        }
        this.internalMethod01515(d, d2);
        double d3 = Math.max(d, d2);
        return typedValue292.internalMethod03056(this.internalField0923.internalMethod02945(), this.internalField0923.internalMethod07945(), this.internalField0924.internalMethod02945(), this.internalField0924.internalMethod07945(), d3 + 0.05, d3 + 1.8);
    }

    @Override
    public RotationInternal019.InternalType0058 internalMethod04014() {
        ClientPlayerEntity clientPlayerEntity = CoreInternal141.internalMethod03778();
        if (clientPlayerEntity == null) {
            return RotationInternal019.InternalType0058.internalField1160;
        }
        double d = clientPlayerEntity.getY();
        if (this.internalMethod05161(0.4) && Math.abs(d - this.internalField1045) < 0.7) {
            return RotationInternal019.InternalType0058.internalField0454;
        }
        if (d < Math.min(this.internalField0193, this.internalField1045) - 1.2 && !clientPlayerEntity.isTouchingWater() && !clientPlayerEntity.isClimbing()) {
            return RotationInternal019.InternalType0058.internalField1160;
        }
        this.internalMethod05160(0.9);
        ScriptInternal169 typedValue290 = CoreInternal141.internalMethod00577();
        typedValue290.internalMethod08359(false);
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
        if (this.internalMethod08659()) {
            typedValue290.internalMethod08359(true);
        }
        return RotationInternal019.InternalType0058.internalField0453;
    }

    @Override
    public void internalMethod01347() {
        this.internalField0227 = 0;
        this.internalField1043 = Double.NaN;
        ScriptInternal169 typedValue290 = CoreInternal141.internalMethod00577();
        typedValue290.internalMethod03508(false);
        typedValue290.internalMethod03557(false);
        typedValue290.internalMethod09358(false);
        typedValue290.internalMethod08033(false);
        typedValue290.internalMethod08045(false);
    }
}

