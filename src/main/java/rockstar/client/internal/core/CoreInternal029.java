package rockstar.client.internal.core;


import rockstar.client.*;
import rockstar.client.internal.core.CoreInternal030;

@FunctionalInterface
public interface CoreInternal029
extends CoreInternal030 {
    public void internalMethod01701();

    @Override
    default public <T> void onChange(T t, T t2) {
        this.internalMethod01701();
    }
}

