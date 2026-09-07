package rockstar.client.internal.script;






import rockstar.client.ui.*;
import rockstar.client.render.*;
import rockstar.client.core.*;
import rockstar.client.animation.*;
import rockstar.client.*;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Supplier;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.ui.UiRenderContext;
import rockstar.client.animation.Motion;
import rockstar.client.render.CornerRadii;
import rockstar.client.ui.UiElement;
import rockstar.client.ui.ThemeColors;
import rockstar.client.core.CursorType;

public class ScriptInternal010
extends UiElement {
    private Function<ScriptInternal010, ColorRGBA> internalField0571 = typedParameter1013 -> ThemeColors.internalField1310;
    private Function<ScriptInternal010, ColorRGBA> internalField0570 = typedParameter1013 -> new ColorRGBA(78.0f, 74.0f, 90.0f);
    private Function<ScriptInternal010, ColorRGBA> internalField1216 = null;

    public ScriptInternal010(BooleanSupplier booleanSupplier) {
        this.size(13.0f, 8.0f);
        this.cursor(CursorType.internalField0567);
        this.bind("on", booleanSupplier, Motion.internalField0913);
    }

    public ScriptInternal010 internalMethod07277(ColorRGBA colorRGBA) {
        this.internalField0571 = typedParameter1013 -> colorRGBA;
        return this;
    }

    public ScriptInternal010 internalMethod04445(Supplier<ColorRGBA> supplier) {
        this.internalField0571 = typedParameter1013 -> (ColorRGBA)supplier.get();
        return this;
    }

    public ScriptInternal010 internalMethod03720(Function<ScriptInternal010, ColorRGBA> function) {
        this.internalField0571 = function;
        return this;
    }

    public ScriptInternal010 internalMethod05163(ColorRGBA colorRGBA) {
        this.internalField0570 = typedParameter1013 -> colorRGBA;
        return this;
    }

    public ScriptInternal010 internalMethod05792(Supplier<ColorRGBA> supplier) {
        this.internalField0570 = typedParameter1013 -> (ColorRGBA)supplier.get();
        return this;
    }

    public ScriptInternal010 internalMethod05119(Function<ScriptInternal010, ColorRGBA> function) {
        this.internalField0570 = function;
        return this;
    }

    public ScriptInternal010 internalMethod08119(ColorRGBA colorRGBA) {
        this.internalField1216 = typedParameter1013 -> colorRGBA;
        return this;
    }

    public ScriptInternal010 internalMethod07995(Supplier<ColorRGBA> supplier) {
        this.internalField1216 = typedParameter1013 -> (ColorRGBA)supplier.get();
        return this;
    }

    public ScriptInternal010 internalMethod07878(Function<ScriptInternal010, ColorRGBA> function) {
        this.internalField1216 = function;
        return this;
    }

    @Override
    public void drawSelf(UiRenderContext iII, float f) {
        float f2 = this.sig("on");
        float f3 = this.x();
        float f4 = this.y();
        float f5 = this.w();
        float f6 = this.h();
        float f7 = 1.5f;
        float f8 = f6 - f7 * 2.0f;
        ColorRGBA colorRGBA = this.internalField0571.apply(this).mix(this.internalField0570.apply(this), 1.0f - f2);
        ColorRGBA colorRGBA2 = this.internalField1216 == null ? ThemeColors.internalMethod01303(colorRGBA) : this.internalField1216.apply(this);
        iII.drawRoundedRect(f3, f4, f5, f6, CornerRadii.internalMethod03908(f6 / 2.0f - 0.5f), colorRGBA);
        iII.drawRoundedRect(f3 + f7 + (f5 - f8 - f7 * 2.0f) * f2, f4 + f7, f8, f8, CornerRadii.internalMethod03908(f8 / 2.0f - 0.5f), colorRGBA2);
    }
}

