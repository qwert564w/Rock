package rockstar.client.internal.core;



import rockstar.client.network.*;
import rockstar.client.*;
import lombok.Generated;
import rockstar.client.network.RockstarHttpResponse;
import rockstar.client.internal.core.CoreInternal033;

public class CoreInternal013
extends CoreInternal033 {
    public static final int internalField0227 = 6002;
    private final int internalField0228;

    public CoreInternal013(RockstarHttpResponse typedValue035, int n, String string) {
        super(typedValue035, String.valueOf(n), string);
        this.internalField0228 = n;
    }

    @Generated
    public int internalMethod06987() {
        return this.internalField0228;
    }
}

