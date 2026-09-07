package rockstar.client.internal.script;






import rockstar.client.rotation.*;
import rockstar.client.event.*;
import rockstar.client.internal.rotation.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import pyrock.events.newton.NewtonFailedEvent;
import pyrock.events.newton.NewtonFinishedEvent;
import pyrock.events.newton.NewtonNodeEvent;
import pyrock.events.newton.NewtonPathEvent;
import pyrock.events.newton.NewtonStartedEvent;
import rockstar.client.event.ClientEvent;
import rockstar.client.RockstarClient;
import rockstar.client.internal.core.CoreInternal130;
import rockstar.client.internal.core.CoreInternal131;
import rockstar.client.internal.core.CoreInternal132;
import rockstar.client.internal.core.CoreInternal133;
import rockstar.client.internal.core.CoreInternal134;
import rockstar.client.internal.rotation.RotationInternal017;

public final class ScriptInternal162 {
    private ScriptInternal162() {
    }

    public static void internalMethod07616(String string) {
        ScriptInternal162.internalMethod02289(new NewtonStartedEvent(string));
    }

    public static void internalMethod06392(String string, int n) {
        ScriptInternal162.internalMethod02289(new NewtonPathEvent(string, n));
        ScriptInternal162.internalMethod06057(new CoreInternal134(string, n));
    }

    public static void internalMethod00498(String string, int n, int n2, int n3, int n4, int n5) {
        ScriptInternal162.internalMethod02289(new NewtonNodeEvent(string, n, n2, n3, n4, n5));
        ScriptInternal162.internalMethod06057(new CoreInternal131(string, n, n2, n3, n4, n5));
    }

    public static void internalMethod06127(String string) {
        ScriptInternal162.internalMethod02289(new NewtonFinishedEvent(string));
        ScriptInternal162.internalMethod06057(new CoreInternal133(string));
    }

    public static void internalMethod04499(String string, String string2) {
        ScriptInternal162.internalMethod02289(new NewtonFailedEvent(string, string2));
        ScriptInternal162.internalMethod06057(new CoreInternal132(string, string2));
    }

    private static void internalMethod02289(ClientEvent typedValue134) {
        try {
            RockstarClient typedParameter1001 = RockstarClient.getInstance();
            if (typedParameter1001 != null && typedParameter1001.internalMethod03317() != null) {
                typedParameter1001.internalMethod03317().internalMethod06883(typedValue134);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void internalMethod06057(CoreInternal130 typedValue283) {
        try {
            if (RotationInternal017.internalMethod00010()) {
                RotationInternal017.internalMethod00114().internalMethod00112().internalMethod07208(typedValue283);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

