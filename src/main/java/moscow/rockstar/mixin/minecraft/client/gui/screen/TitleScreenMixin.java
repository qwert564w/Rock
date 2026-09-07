package moscow.rockstar.mixin.minecraft.client.gui.screen;


import rockstar.client.internal.script.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Click;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.RockstarClient;
import rockstar.client.internal.script.ScriptInternal130;
import rockstar.client.MinecraftClientAccess;
import rockstar.client.ui.SunshineProjectWelcomeScreen;
import rockstar.client.ui.PortBranding;

@Mixin(value={TitleScreen.class})
public abstract class TitleScreenMixin extends Screen
implements MinecraftClientAccess {
    @Unique
    private static boolean rockstar$welcomeShown;

    protected TitleScreenMixin() {
        super(Text.empty());
    }

    @Inject(method={"init"}, at={@At(value="HEAD")}, cancellable=true)
    public void setCustomScreen(CallbackInfo callbackInfo) {
        if (!rockstar$welcomeShown) {
            rockstar$welcomeShown = true;
            callbackInfo.cancel();
            Screen nextScreen = RockstarClient.internalField0240.internalMethod06896()
                ? (Screen)(Object)this
                : new ScriptInternal130();
            internalField0149.setScreen(new SunshineProjectWelcomeScreen(nextScreen));
            return;
        }

        if (RockstarClient.internalField0240.internalMethod06896()) {
            return;
        }
        callbackInfo.cancel();
        internalField0149.setScreen((Screen)new ScriptInternal130());
    }

    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void rockstar$renderPortBranding(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo callbackInfo) {
        PortBranding.renderVanilla(context, internalField0149);
    }

    @Override
    public boolean mouseClicked(Click click, boolean doubled) {
        if (click.button() == 0 && PortBranding.vanillaLinkHovered(click.x(), click.y(), internalField0149)) {
            PortBranding.openTelegram();
            return true;
        }
        return super.mouseClicked(click, doubled);
    }
}
