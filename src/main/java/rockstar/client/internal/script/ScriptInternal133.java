package rockstar.client.internal.script;





import rockstar.client.ui.*;
import rockstar.client.event.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.client.MinecraftClient;
import pyrock.events.render.HudRenderEvent;
import rockstar.client.ui.UiRenderContext;
import rockstar.modules.visual.MenuModule;
import rockstar.client.event.EventListener;
import rockstar.client.RockstarClient;
import rockstar.client.internal.core.CoreInternal081;
import rockstar.client.internal.script.ScriptInternal137;
import rockstar.client.internal.script.ScriptInternal138;
import rockstar.client.MinecraftClientAccess;

public class ScriptInternal133
implements MinecraftClientAccess {
    private final EventListener<HudRenderEvent> internalField0157 = hudRenderEvent -> {
        boolean bl;
        CoreInternal081 typedValue204 = RockstarClient.getInstance().internalMethod04334();
        if (ScriptInternal133.internalField0149.currentScreen == null && RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class).internalMethod01968().isSelected() && !(typedValue204 instanceof ScriptInternal137)) {
            RockstarClient.getInstance().internalMethod02331(new ScriptInternal137());
        }
        boolean bl2 = bl = ScriptInternal133.internalField0149.currentScreen instanceof CoreInternal081 || ScriptInternal133.internalField0149.currentScreen instanceof ScriptInternal138;
        if (!bl && RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class).isEnabled()) {
            RockstarClient.getInstance().getModuleManager().getModule(MenuModule.class).internalMethod05084(false);
        }
        if (typedValue204 == null) {
            return;
        }
        typedValue204.getMenuAnimation().internalMethod07059(typedValue204.isClosing() ? 0.0f : 1.0f);
        if (!(typedValue204 instanceof ScriptInternal137) && typedValue204.getMenuAnimation().internalMethod02881() > 0.1f && !(ScriptInternal133.internalField0149.currentScreen instanceof CoreInternal081) && typedValue204.isClosing()) {
            UiRenderContext iII = UiRenderContext.internalMethod02316(hudRenderEvent.getContext(), -1, -1, MinecraftClient.getInstance().getRenderTickCounter().getTickProgress(false));
            typedValue204.render(iII);
        }
    };

    public ScriptInternal133() {
        RockstarClient.getInstance().internalMethod03317().internalMethod00647(this);
    }
}
