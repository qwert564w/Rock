package rockstar.client.internal.script;





import rockstar.client.ui.*;
import rockstar.client.event.*;
import rockstar.client.animation.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.Identifier;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.window.KeyPressEvent;
import rockstar.client.event.EventListener;
import rockstar.client.RockstarClient;
import rockstar.client.animation.AnimatedValue;
import rockstar.client.animation.Easing;
import rockstar.client.ui.ThemeColors;
import rockstar.client.MinecraftClientAccess;

public class ScriptInternal081
implements MinecraftClientAccess {
    private static final AnimatedValue internalField0808 = new AnimatedValue(1000L, Easing.internalField1814);
    private static boolean internalField0277 = true;
    private static final List<Integer> internalField0416 = new ArrayList<Integer>();
    private static boolean internalField0276 = false;
    private static boolean internalField1099 = false;
    private static final int[] internalField0618 = new int[]{67, 68, 74};
    private final EventListener<KeyPressEvent> internalField0157 = keyPressEvent -> {
        int n = keyPressEvent.getKey();
        int n2 = keyPressEvent.getAction();
        if (n == 90) {
            internalField0276 = n2 != 0;
        } else if (n == 86) {
            boolean bl = internalField1099 = n2 != 0;
        }
        if (internalField0276 && internalField1099) {
            this.internalMethod03088();
        }
    };
    private final EventListener<PreHudRenderEvent> internalField0158 = preHudRenderEvent -> {
        if ((double)internalField0808.internalMethod02881() == 1.0 && !internalField0277) {
            internalField0277 = true;
        }
        internalField0808.internalMethod07059(internalField0277 ? 0.0f : 1.0f);
        if (internalField0808.internalMethod02881() == 0.0f && internalField0277) {
            return;
        }
        float f = 200.0f;
        float f2 = ((float)internalField0149.getWindow().getScaledWidth() - f) / 2.0f;
        float f3 = ((float)internalField0149.getWindow().getScaledHeight() - f) / 2.0f;
        Identifier identifier = RockstarClient.id("icons/poshalko.png");
        preHudRenderEvent.getContext().drawTexture(identifier, f2, f3, f, f, ThemeColors.internalField1312.withAlpha(255.0f * internalField0808.internalMethod02881()));
    };

    public ScriptInternal081() {
        RockstarClient.getInstance().internalMethod03317().internalMethod00647(this);
    }

    private void internalMethod03088() {
        internalField0277 = false;
        internalField0808.internalMethod07059(1.0f);
    }
}

