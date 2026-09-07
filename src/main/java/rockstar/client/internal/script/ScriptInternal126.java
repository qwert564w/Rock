package rockstar.client.internal.script;






import rockstar.client.util.*;
import rockstar.client.setting.*;
import rockstar.client.server.*;
import rockstar.client.i18n.*;
import rockstar.client.*;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.setting.MultiSelectSetting;
import rockstar.client.i18n.LanguageManager;
import rockstar.client.internal.script.ScriptInternal112;
import rockstar.client.internal.script.ScriptInternal117;
import rockstar.client.util.GameUtils;
import rockstar.client.server.ServerUtils;

public class ScriptInternal126
extends ScriptInternal117 {
    public ScriptInternal126(MultiSelectSetting typedValue173) {
        super(typedValue173, "pvp");
    }

    @Override
    public void prepare(ScriptInternal112 typedValue201) {
        this.internalMethod03185("s", ServerUtils.internalField0227, LanguageManager.internalMethod07214("hud.pvp_mode"), new ColorRGBA(185.0f, 28.0f, 28.0f));
        super.prepare(typedValue201);
    }

    @Override
    public boolean canShow() {
        return ServerUtils.internalField0277 && GameUtils.internalMethod00471();
    }
}

