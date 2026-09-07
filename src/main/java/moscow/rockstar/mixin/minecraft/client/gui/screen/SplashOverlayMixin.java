package moscow.rockstar.mixin.minecraft.client.gui.screen;





import rockstar.client.ui.*;
import rockstar.client.animation.*;
import rockstar.client.internal.ui.*;
import rockstar.client.internal.core.*;
import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.resource.ResourceReload;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.ui.UiRenderContext;
import rockstar.client.internal.ui.UiInternal019;
import rockstar.client.RockstarClient;
import rockstar.client.animation.AnimatedValue;
import rockstar.client.animation.Easing;
import rockstar.client.ui.ThemeColors;
import rockstar.client.MinecraftClientAccess;
import rockstar.client.ui.ScreenMetricsAccess;
import rockstar.client.internal.core.CoreInternal117;

@Mixin(value={SplashOverlay.class})
public class SplashOverlayMixin
implements MinecraftClientAccess,
ScreenMetricsAccess {
    @Unique
    private UiInternal019 daunGif;
    @Unique
    private AnimatedValue fadeOutAnimation;
    @Shadow
    private long field_17771;
    @Final
    @Shadow
    private Consumer<Optional<Throwable>> field_18218;
    @Shadow
    @Final
    private ResourceReload field_17767;
    @Shadow
    @Final
    private boolean field_18219;
    @Shadow
    private long field_18220;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    public void init(MinecraftClient minecraftClient, ResourceReload resourceReload, Consumer<Optional<Throwable>> consumer, boolean bl, CallbackInfo callbackInfo) {
        if (RockstarClient.internalField0240.internalMethod06896()) {
            return;
        }
        this.daunGif = new UiInternal019(RockstarClient.id("gifs/loading.gif"), 100.0f, 100.0f, 100.0f, 100.0f);
        this.fadeOutAnimation = new AnimatedValue(3000L, 1.0f, Easing.internalField1814);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void replaceRendering(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        float f2;
        if (RockstarClient.getInstance().internalMethod06896()) {
            return;
        }
        callbackInfo.cancel();
        int n3 = drawContext.getScaledWindowWidth();
        int n4 = drawContext.getScaledWindowHeight();
        UiRenderContext iII = UiRenderContext.internalMethod02316(drawContext, 0, 0, f);
        long l = Util.getMeasuringTimeMs();
        if (this.field_18219 && this.field_18220 == -1L) {
            this.field_18220 = l;
        }
        float f3 = this.field_17771 > -1L ? (float)(l - this.field_17771) / 1000.0f : -1.0f;
        float f4 = f2 = this.field_18220 > -1L ? (float)(l - this.field_18220) / 500.0f : -1.0f;
        if (f3 >= 1.0f) {
            if (SplashOverlayMixin.internalField0149.currentScreen != null) {
                SplashOverlayMixin.internalField0149.currentScreen.render(drawContext, 0, 0, f);
            }
            int n5 = MathHelper.ceil((float)((1.0f - MathHelper.clamp((float)(f3 - 1.0f), (float)0.0f, (float)1.0f)) * 255.0f));
            drawContext.fill(0, 0, n3, n4, ThemeColors.internalField1309.withAlpha(n5).getRGB());
        } else if (this.field_18219 && SplashOverlayMixin.internalField0149.currentScreen != null && f2 < 1.0f) {
            SplashOverlayMixin.internalField0149.currentScreen.render(drawContext, n, n2, f);
            int n6 = MathHelper.ceil((double)(MathHelper.clamp((double)f2, (double)0.15, (double)1.0) * 255.0));
            drawContext.fill(0, 0, n3, n4, ThemeColors.internalField1309.withAlpha(n6).getRGB());
        }
        if (f3 < 1.0f) {
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11 = internalField0389.internalMethod03585();
            float f12 = f11 / (f10 = internalField0389.internalMethod03589());
            if (f12 > (f9 = 1.7777778f)) {
                f8 = f11;
                f7 = f11 / f9;
                f6 = 0.0f;
                f5 = (f10 - f7) / 2.0f;
            } else {
                f7 = f10;
                f8 = f10 * f9;
                f6 = (f11 - f8) / 2.0f;
                f5 = 0.0f;
            }
            this.daunGif.internalMethod05191(f6, f5, f8, f7);
            this.daunGif.internalMethod08944(1.0f);
            CoreInternal117.internalMethod08091();
            try {
                this.daunGif.internalMethod03398(iII);
            }
            finally {
                CoreInternal117.internalMethod08092();
            }
        }
        if (f3 >= 2.0f) {
            internalField0149.setOverlay(null);
            this.daunGif.internalMethod06267();
        }
        if (this.field_17771 == -1L && this.field_17767.isComplete() && (!this.field_18219 || f2 >= 2.0f)) {
            try {
                this.field_17767.throwException();
                this.field_18218.accept(Optional.empty());
            }
            catch (Throwable throwable) {
                this.field_18218.accept(Optional.of(throwable));
            }
            this.field_17771 = l;
            if (SplashOverlayMixin.internalField0149.currentScreen != null) {
                SplashOverlayMixin.internalField0149.currentScreen.init(drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
            }
        }
    }
}
