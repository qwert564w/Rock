package rockstar.client.internal.core;


import rockstar.client.*;
import lombok.Generated;
import rockstar.client.internal.core.CoreInternal109;

public final class CoreInternal106
extends CoreInternal109 {
    private final double internalField0194;

    public CoreInternal106(double d) {
        super(1);
        this.internalField0194 = d;
    }

    public CoreInternal106(char[] cArray, int n, int n2) {
        this(Double.parseDouble(String.valueOf(cArray, n, n2)));
    }

    @Generated
    public double internalMethod02759() {
        return this.internalField0194;
    }
}

