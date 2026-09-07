package rockstar.client.internal.core;


import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.ApiStatus;
import rockstar.client.internal.core.CoreInternal029;
import rockstar.client.internal.core.CoreInternal030;

public class CoreInternal031 {
    private final List<CoreInternal030> internalField0416 = new ArrayList<CoreInternal030>();

    public synchronized void internalMethod01208(CoreInternal030 typedValue084) {
        this.internalField0416.add(typedValue084);
    }

    public synchronized void internalMethod01206(CoreInternal029 typedValue083) {
        this.internalField0416.add(typedValue083);
    }

    public synchronized boolean internalMethod01209(CoreInternal030 typedValue084) {
        return this.internalField0416.remove(typedValue084);
    }

    public synchronized boolean internalMethod01207(CoreInternal029 typedValue083) {
        return this.internalField0416.remove(typedValue083);
    }

    @ApiStatus.Internal
    public synchronized <T> void internalMethod07273(T t, T t2) {
        if (!Objects.equals(t, t2)) {
            for (CoreInternal030 typedValue084 : this.internalField0416) {
                typedValue084.onChange(t, t2);
            }
        }
    }
}

