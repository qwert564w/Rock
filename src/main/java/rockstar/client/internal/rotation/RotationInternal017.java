package rockstar.client.internal.rotation;






import rockstar.client.rotation.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.command.*;
import rockstar.client.*;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;
import rockstar.client.internal.command.CommandInternal001;
import rockstar.client.internal.script.ScriptInternal069;
import rockstar.client.RockstarClient;
import rockstar.client.rotation.RotationManager;
import rockstar.client.internal.core.CoreInternal128;
import rockstar.client.internal.script.ScriptInternal161;
import rockstar.client.internal.script.ScriptInternal169;
import rockstar.client.internal.core.CoreInternal138;
import rockstar.client.internal.script.ScriptInternal172;
import rockstar.client.internal.script.ScriptInternal174;
import rockstar.client.internal.script.ScriptInternal175;
import rockstar.client.internal.script.ScriptInternal176;

public final class RotationInternal017 {
    private static RotationInternal017 internalField0774;
    private final ScriptInternal169 internalField0778;
    private final ScriptInternal172 internalField0496;
    private final ScriptInternal174 internalField0497;
    private final ScriptInternal175 internalField0507;
    private final ScriptInternal176 internalField0508;
    private final ScriptInternal161 internalField0772;
    @Nullable
    private CoreInternal138 internalField0906;

    public static RotationInternal017 internalMethod00114() {
        if (internalField0774 == null) {
            throw new IllegalStateException("NewtonCore not initialized yet");
        }
        return internalField0774;
    }

    public static boolean internalMethod00010() {
        return internalField0774 != null;
    }

    public void internalMethod01913(@Nullable CoreInternal138 typedValue294) {
        this.internalField0906 = typedValue294;
    }

    public RotationInternal017() {
        internalField0774 = this;
        this.internalField0778 = ScriptInternal169.internalMethod05429(this);
        this.internalField0496 = ScriptInternal172.internalMethod03333(this);
        this.internalField0497 = ScriptInternal174.internalMethod01422(this);
        this.internalField0507 = ScriptInternal175.internalMethod04562(this);
        this.internalField0508 = ScriptInternal176.internalMethod05327(this);
        this.internalField0772 = new ScriptInternal161();
        CoreInternal128.internalMethod03916(this.internalField0772);
    }

    public ScriptInternal069 internalMethod05035() {
        return RockstarClient.getInstance().internalMethod03317();
    }

    public RotationManager internalMethod03241() {
        return RockstarClient.getInstance().internalMethod02368();
    }

    public CommandInternal001 internalMethod06865() {
        return RockstarClient.getInstance().internalMethod05348();
    }

    @Generated
    public ScriptInternal169 internalMethod00183() {
        return this.internalField0778;
    }

    @Generated
    public ScriptInternal172 internalMethod06401() {
        return this.internalField0496;
    }

    @Generated
    public ScriptInternal174 internalMethod06402() {
        return this.internalField0497;
    }

    @Generated
    public ScriptInternal175 internalMethod06456() {
        return this.internalField0507;
    }

    @Generated
    public ScriptInternal176 internalMethod06457() {
        return this.internalField0508;
    }

    @Generated
    public ScriptInternal161 internalMethod00112() {
        return this.internalField0772;
    }

    @Nullable
    @Generated
    public CoreInternal138 internalMethod01484() {
        return this.internalField0906;
    }
}

