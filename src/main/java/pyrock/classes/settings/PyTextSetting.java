package pyrock.classes.settings;




import rockstar.client.setting.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.core.*;
import lombok.Generated;
import pyrock.classes.PyEspElement;
import pyrock.classes.PyHudElement;
import pyrock.classes.PyModule;
import rockstar.client.internal.script.ScriptInternal083;
import rockstar.client.setting.TextSetting;
import rockstar.client.internal.core.CoreInternal067;

public class PyTextSetting {
    private final TextSetting setting;

    public PyTextSetting(PyModule pyModule, String string) {
        this.setting = new TextSetting(pyModule.getModule(), string);
        this.setting.internalMethod00011("");
        if (!(pyModule.getModule() instanceof CoreInternal067)) {
            ScriptInternal083.internalMethod04663(pyModule.getModule(), this.setting);
        }
    }

    public PyTextSetting(PyHudElement pyHudElement, String string) {
        this.setting = new TextSetting(pyHudElement, string);
        this.setting.internalMethod00011("");
    }

    public PyTextSetting(PyEspElement pyEspElement, String string) {
        this.setting = new TextSetting(pyEspElement.getElement(), string);
        this.setting.internalMethod00011("");
    }

    public PyTextSetting(TextSetting typedValue179) {
        this.setting = typedValue179;
    }

    public PyTextSetting set(String string) {
        ScriptInternal083.internalMethod06468(this.setting);
        this.setting.internalMethod00011(string == null ? "" : string);
        return this;
    }

    public String get() {
        String string = this.setting.internalMethod08926();
        return string == null ? "" : string;
    }

    public PyTextSetting maxLength(int n) {
        this.setting.internalMethod01004(n);
        return this;
    }

    public PyTextSetting numberOnly(boolean bl) {
        this.setting.internalMethod07009(bl);
        return this;
    }

    public boolean isEmpty() {
        return this.get().isEmpty();
    }

    @Generated
    public TextSetting getSetting() {
        return this.setting;
    }
}

