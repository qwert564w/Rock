package rockstar.client.internal.core;



import rockstar.client.internal.network.*;
import rockstar.client.*;
import rockstar.client.internal.network.NetworkInternal015;

public final class CoreInternal069
extends ClassLoader {
    public CoreInternal069(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    public Class<?> loadClass(String string, boolean bl) throws ClassNotFoundException {
        try {
            NetworkInternal015.internalMethod03423(string);
        }
        catch (NetworkInternal015.InternalType0290 nestedValue0109) {
            throw new ClassNotFoundException(nestedValue0109.getMessage(), nestedValue0109);
        }
        return super.loadClass(string, bl);
    }
}

