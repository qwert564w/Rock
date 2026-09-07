package rockstar.client.internal.script;






import rockstar.client.rotation.*;
import rockstar.client.command.*;
import rockstar.client.internal.rotation.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.util.Optional;
import rockstar.client.command.CommandNode;
import rockstar.client.command.CommandBuilder;
import rockstar.client.command.ParsedCommand;
import rockstar.client.internal.core.CoreInternal126;
import rockstar.client.internal.rotation.RotationInternal017;
import rockstar.client.internal.core.CoreInternal135;
import rockstar.client.internal.script.ScriptInternal163;
import rockstar.client.internal.script.ScriptInternal164;
import rockstar.client.internal.script.ScriptInternal165;
import rockstar.client.internal.script.ScriptInternal166;
import rockstar.client.internal.script.ScriptInternal168;
import rockstar.client.internal.core.CoreInternal136;
import rockstar.client.internal.core.CoreInternal146;

public final class ScriptInternal167 {
    public CommandNode internalMethod03956() {
        return CommandBuilder.internalMethod07482("newton", typedValue125 -> typedValue125.internalMethod06148("commands.newton.description").internalMethod05325("nt").internalMethod04260(new ScriptInternal165().internalMethod06327(), new ScriptInternal166().internalMethod07072(), new ScriptInternal168().internalMethod07275(), new ScriptInternal163().internalMethod06163(), new ScriptInternal164().internalMethod01405(), this.internalMethod05361(), this.internalMethod07875(), this.internalMethod08103(), this.internalMethod07989(), this.internalMethod08241()).internalMethod00262(this::internalMethod04052)).internalMethod04146();
    }

    private CommandNode internalMethod05361() {
        return CommandBuilder.internalMethod07482("stop", typedValue125 -> typedValue125.internalMethod06148("commands.newton.stop").internalMethod05325("cancel", "\u0441\u0442\u043e\u043f").internalMethod00262(typedValue127 -> {
            RotationInternal017 typedValue289 = RotationInternal017.internalMethod00114();
            boolean bl = typedValue289.internalMethod06401().internalMethod03477();
            typedValue289.internalMethod06401().internalMethod03476();
            typedValue289.internalMethod00183().internalMethod01287();
            CoreInternal136.internalMethod00196(bl ? "\u041f\u0440\u043e\u0446\u0435\u0441\u0441 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d" : "\u041d\u0435\u0442 \u0430\u043a\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0430");
        })).internalMethod04146();
    }

    private CommandNode internalMethod07875() {
        return CommandBuilder.internalMethod07482("pause", typedValue125 -> typedValue125.internalMethod06148("commands.newton.pause").internalMethod05325("\u043f\u0430\u0443\u0437\u0430").internalMethod00262(typedValue127 -> ScriptInternal167.internalMethod00885().ifPresentOrElse(typedValue308 -> {
            typedValue308.internalMethod04089();
            CoreInternal136.internalMethod00196("\u041f\u0430\u0443\u0437\u0430");
        }, () -> CoreInternal136.internalMethod06835("\u041d\u0435\u0442 \u0430\u043a\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0430")))).internalMethod04146();
    }

    private CommandNode internalMethod08103() {
        return CommandBuilder.internalMethod07482("resume", typedValue125 -> typedValue125.internalMethod06148("commands.newton.resume").internalMethod05325("\u043f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c").internalMethod00262(typedValue127 -> ScriptInternal167.internalMethod00885().ifPresentOrElse(typedValue308 -> {
            typedValue308.internalMethod08146();
            CoreInternal136.internalMethod00196("\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0430\u0435\u043c");
        }, () -> CoreInternal136.internalMethod06835("\u041d\u0435\u0442 \u0430\u043a\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0430")))).internalMethod04146();
    }

    private CommandNode internalMethod07989() {
        return CommandBuilder.internalMethod07482("status", typedValue125 -> typedValue125.internalMethod06148("commands.newton.status").internalMethod05325("info", "\u0441\u0442\u0430\u0442\u0443\u0441").internalMethod00262(typedValue127 -> ScriptInternal167.internalMethod00885().ifPresentOrElse(typedValue308 -> CoreInternal136.internalMethod00196(typedValue308.internalMethod01129() + ": " + typedValue308.internalMethod05788()), () -> CoreInternal136.internalMethod06835("\u041d\u0435\u0442 \u0430\u043a\u0442\u0438\u0432\u043d\u043e\u0433\u043e \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u0430")))).internalMethod04146();
    }

    private CommandNode internalMethod08241() {
        return CommandBuilder.internalMethod07482("neuro", typedValue125 -> typedValue125.internalMethod06148("commands.newton.neuro").internalMethod05325("\u043d\u0435\u0439\u0440\u043e").internalMethod00262(typedValue127 -> {
            if (CoreInternal126.internalField1100) {
                CoreInternal126.internalField1100 = false;
                CoreInternal136.internalMethod00196("\u041d\u0435\u0439\u0440\u043e-\u0440\u043e\u0442\u0430\u0446\u0438\u044f \u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d\u0430 \u2014 \u043f\u043e\u0432\u043e\u0440\u043e\u0442\u044b \u043b\u0438\u043d\u0435\u0439\u043d\u044b\u0435");
                return;
            }
            if (!CoreInternal135.internalMethod05078()) {
                CoreInternal136.internalMethod06835("\u041c\u043e\u0434\u0435\u043b\u044c \u043d\u0435 \u0437\u0430\u0433\u0440\u0443\u0436\u0435\u043d\u0430 \u2014 \u0441\u043d\u0430\u0447\u0430\u043b\u0430 .neuro load <\u0438\u043c\u044f> (\u0438\u043b\u0438 .neuro train)");
                return;
            }
            CoreInternal126.internalField1100 = true;
            CoreInternal136.internalMethod00196("\u041d\u0435\u0439\u0440\u043e-\u0440\u043e\u0442\u0430\u0446\u0438\u044f \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u0430 \u2014 \u043c\u043e\u0434\u0435\u043b\u044c \u00ab" + CoreInternal135.internalMethod06837() + "\u00bb");
        })).internalMethod04146();
    }

    private static Optional<CoreInternal146> internalMethod00885() {
        return RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03684();
    }

    private void internalMethod04052(ParsedCommand typedValue127) {
        CoreInternal136.internalMethod00196("Newton \u2014 \u043a\u043e\u043c\u0430\u043d\u0434\u044b:");
        CoreInternal136.internalMethod00196(" .newton goto <x> [y] <z> [elytra] \u2014 \u0438\u0434\u0442\u0438 \u043a \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430\u043c");
        CoreInternal136.internalMethod00196(" .newton mine <block> \u2014 \u043a\u043e\u043f\u0430\u0442\u044c \u0431\u043b\u043e\u043a\u0438 \u044d\u0442\u043e\u0433\u043e \u0442\u0438\u043f\u0430");
        CoreInternal136.internalMethod00196(" .newton sel \u2014 \u0432\u044b\u0434\u0435\u043b\u0438\u0442\u044c \u0443\u0433\u043e\u043b \u043e\u0431\u043b\u0430\u0441\u0442\u0438 (\u0441\u043c\u043e\u0442\u0440\u044f \u043d\u0430 \u0431\u043b\u043e\u043a), 2 \u0440\u0430\u0437\u0430");
        CoreInternal136.internalMethod00196(" .newton cleararea [block|stop] \u2014 \u0440\u0430\u0441\u043a\u043e\u043f\u0430\u0442\u044c \u0432\u044b\u0434\u0435\u043b\u0435\u043d\u043d\u0443\u044e \u043e\u0431\u043b\u0430\u0441\u0442\u044c");
        CoreInternal136.internalMethod00196(" .newton fill <block|stop> \u2014 \u0437\u0430\u043f\u043e\u043b\u043d\u0438\u0442\u044c \u0432\u044b\u0434\u0435\u043b\u0435\u043d\u043d\u0443\u044e \u043e\u0431\u043b\u0430\u0441\u0442\u044c");
        CoreInternal136.internalMethod00196(" .newton stop / pause / resume / status \u2014 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u0435 \u043f\u0440\u043e\u0446\u0435\u0441\u0441\u043e\u043c");
        CoreInternal136.internalMethod00196(" .newton neuro \u2014 \u0432\u043a\u043b/\u0432\u044b\u043a\u043b \u043d\u0435\u0439\u0440\u043e-\u0440\u043e\u0442\u0430\u0446\u0438\u044e (\u043d\u0443\u0436\u043d\u0430 \u043c\u043e\u0434\u0435\u043b\u044c \u0438\u0437 .neuro load)");
    }
}

