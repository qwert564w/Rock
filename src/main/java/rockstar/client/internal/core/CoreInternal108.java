package rockstar.client.internal.core;


import rockstar.client.*;
import lombok.Generated;
import rockstar.client.internal.core.CoreInternal100;
import rockstar.client.internal.core.CoreInternal109;

public class CoreInternal108
extends CoreInternal109 {
    private final CoreInternal100 internalField0379;

    public CoreInternal108(CoreInternal100 typedValue239) {
        super(2);
        if (typedValue239 == null) {
            throw new IllegalArgumentException("Operator is unknown for token.");
        }
        this.internalField0379 = typedValue239;
    }

    @Generated
    public CoreInternal100 internalMethod02443() {
        return this.internalField0379;
    }
}

