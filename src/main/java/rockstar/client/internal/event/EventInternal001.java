package rockstar.client.internal.event;




import rockstar.client.module.*;
import rockstar.client.event.*;
import rockstar.client.*;
import lombok.Generated;
import rockstar.client.event.ClientEvent;
import rockstar.client.module.ModuleEntry;

public class EventInternal001
extends ClientEvent {
    private final ModuleEntry internalField0403;

    @Generated
    public ModuleEntry internalMethod05415() {
        return this.internalField0403;
    }

    @Generated
    public EventInternal001(ModuleEntry typedValue145) {
        this.internalField0403 = typedValue145;
    }
}

