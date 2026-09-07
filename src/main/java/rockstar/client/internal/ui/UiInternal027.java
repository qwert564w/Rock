package rockstar.client.internal.ui;







import rockstar.client.util.*;
import rockstar.client.ui.*;
import rockstar.client.setting.*;
import rockstar.client.server.*;
import rockstar.client.internal.framework.*;
import rockstar.client.*;
import rockstar.client.ui.UiRenderContext;
import rockstar.modules.other.NameProtectModule;
import rockstar.client.setting.BooleanSetting;
import rockstar.client.RockstarClient;
import rockstar.client.internal.ui.UiInternal025;
import rockstar.client.internal.framework.FrameworkInternal007;
import rockstar.client.util.TextUtils;
import rockstar.client.server.ServerUtils;

public class UiInternal027
extends UiInternal025 {
    private final FrameworkInternal007 internalField0365;
    private final FrameworkInternal007 internalField0364;
    private final FrameworkInternal007 internalField1134;
    private final BooleanSetting internalField0650;

    public UiInternal027() {
        super("hud.world", "hud/world");
        this.internalField0365 = new FrameworkInternal007(this.internalField0675, "coords");
        this.internalField0364 = new FrameworkInternal007(this.internalField0675, "server");
        this.internalField1134 = new FrameworkInternal007(this.internalField0675, "TPS", "TPS");
        this.internalField0650 = new BooleanSetting(this, "hud.world.compact_server").internalMethod06630();
        this.showing = true;
        this.pos(2.5f, 4.175f);
    }

    @Override
    public void update(UiRenderContext iII) {
        super.update(iII);
        NameProtectModule typedValue207 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
        if (typedValue207 != null && typedValue207.internalMethod09833()) {
            this.internalField0365.internalMethod05700("\u2014 \u2014 \u2014", "\u2014 \u2014 \u2014");
            this.internalField0364.internalMethod05700("\u2014", "\u2014");
            return;
        }
        String string = String.format("%s %s %s", Math.round(UiInternal027.internalField0149.player.getX()), Math.round(UiInternal027.internalField0149.player.getY()), Math.round(UiInternal027.internalField0149.player.getZ()));
        this.internalField0365.internalMethod05700(string, string);
        this.internalField0364.internalMethod05700(ServerUtils.internalMethod06458(this.internalField0650.internalMethod04496()), ServerUtils.internalMethod00929());
        this.internalField1134.internalMethod05945(TextUtils.internalMethod07254(RockstarClient.getInstance().internalMethod06191().internalMethod00956()).replace(",", ".").replace(".0", ""));
    }
}
