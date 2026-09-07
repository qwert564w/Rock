package rockstar.client.internal.script;


import rockstar.client.*;
import lombok.Generated;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.internal.script.ScriptInternal185;
import rockstar.client.internal.script.ScriptInternal187;

public class ScriptInternal189
extends ScriptInternal185 {
    private final ScriptInternal187 internalField0432;
    private final String internalField0248;

    public ScriptInternal189(ScriptInternal187 iModuleInfo, String string) {
        super(1000L);
        this.internalField0432 = iModuleInfo;
        this.internalField0248 = string;
    }

    @Override
    public void internalMethod06653(CustomDrawContext customDrawContext, float f) {
    }

    @Generated
    public ScriptInternal187 internalMethod03243() {
        return this.internalField0432;
    }

    @Generated
    public String internalMethod02762() {
        return this.internalField0248;
    }
}

