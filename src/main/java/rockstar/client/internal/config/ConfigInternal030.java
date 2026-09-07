package rockstar.client.internal.config;




import rockstar.client.internal.script.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.io.File;
import lombok.Generated;
import rockstar.client.internal.script.ScriptInternal070;
import rockstar.client.internal.core.CoreInternal061;

public abstract class ConfigInternal030 {
    public final CoreInternal061 internalField0162 = this.getClass().getAnnotation(CoreInternal061.class);
    public final File internalField0148 = new File(ScriptInternal070.internalField0148, this.internalField0162.internalMethod03654() + "." + this.internalField0162.internalMethod00190());

    public abstract void internalMethod07509();

    public abstract void internalMethod07512();

    @Generated
    public CoreInternal061 internalMethod04830() {
        return this.internalField0162;
    }

    @Generated
    public File internalMethod05023() {
        return this.internalField0148;
    }
}

