package rockstar.client.internal.core;


import rockstar.client.*;
import javax.annotation.Nonnull;
import lombok.Generated;
import rockstar.client.internal.core.CoreInternal023;
import rockstar.client.internal.core.CoreInternal032;

public class CoreInternal019 {
    private int internalField0227;
    private int internalField0228;
    @Nonnull
    private CoreInternal023 internalField0875;

    public CoreInternal019() {
        this(0, 0);
    }

    public CoreInternal019(int n, int n2) {
        this(n, n2, new CoreInternal032());
    }

    public CoreInternal019(int n, int n2, @Nonnull CoreInternal023 typedParameter019) {
        this.internalField0227 = n;
        this.internalField0228 = n2;
        this.internalField0875 = typedParameter019;
    }

    @Generated
    public int internalMethod05746() {
        return this.internalField0227;
    }

    @Generated
    public int internalMethod05749() {
        return this.internalField0228;
    }

    @Nonnull
    @Generated
    public CoreInternal023 internalMethod06818() {
        return this.internalField0875;
    }

    @Generated
    public CoreInternal019 internalMethod07052(int n) {
        this.internalField0227 = n;
        return this;
    }

    @Generated
    public CoreInternal019 internalMethod00292(int n) {
        this.internalField0228 = n;
        return this;
    }

    @Generated
    public CoreInternal019 internalMethod04267(@Nonnull CoreInternal023 typedParameter019) {
        if (typedParameter019 == null) {
            throw new NullPointerException("retryHandler is marked non-null but is null");
        }
        this.internalField0875 = typedParameter019;
        return this;
    }
}

