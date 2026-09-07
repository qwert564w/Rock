package rockstar.client.internal.core;


import rockstar.client.*;
import lombok.Generated;

public class CoreInternal052
extends RuntimeException {
    private final String internalField0248;

    public CoreInternal052(String string) {
        super("%s is not found!".formatted(string));
        this.internalField0248 = string;
    }

    @Generated
    public String internalMethod06184() {
        return this.internalField0248;
    }
}

