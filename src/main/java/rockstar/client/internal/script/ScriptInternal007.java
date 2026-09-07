package rockstar.client.internal.script;






import rockstar.client.ui.*;
import rockstar.client.render.*;
import rockstar.client.core.*;
import rockstar.client.animation.*;
import rockstar.client.*;
import java.util.function.Function;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.ui.UiRenderContext;
import rockstar.client.animation.Motion;
import rockstar.client.render.CornerRadii;
import rockstar.client.ui.MouseButton;
import rockstar.client.animation.AnimatedFloat;
import rockstar.client.ui.ThemeColors;
import rockstar.client.core.CursorType;
import rockstar.client.ui.UiNode;

public class ScriptInternal007
extends UiNode {
    private final InternalType0348 internalField0889;
    private final InternalType0347 internalField0888;
    private final float internalField0205;
    private final float internalField0206;
    private float internalField1048;
    private Function<ScriptInternal007, ColorRGBA> internalField0571 = typedParameter1010 -> new ColorRGBA(35.0f, 32.0f, 50.0f);
    private Function<ScriptInternal007, ColorRGBA> internalField0570 = typedParameter1010 -> ThemeColors.internalField1310;
    private Function<ScriptInternal007, ColorRGBA> internalField1216 = typedParameter1010 -> ThemeColors.internalField1310;
    private Function<ScriptInternal007, ColorRGBA> internalField1213;
    private float internalField1047 = 2.5f;
    private float internalField1049 = 4.0f;
    private float internalField1046 = 1.2f;
    private final AnimatedFloat internalField0623 = new AnimatedFloat(Motion.internalField0913);
    private boolean internalField0277;

    public ScriptInternal007(InternalType0348 nestedValue2047, InternalType0347 nestedValue2046, float f, float f2) {
        this.internalField0889 = nestedValue2047;
        this.internalField0888 = nestedValue2046;
        this.internalField0205 = f;
        this.internalField0206 = f2;
        this.internalMethod04313(120.0f, 10.0f);
        this.cursor(CursorType.internalField0567);
        this.onClick(this::internalMethod05577);
    }

    public ScriptInternal007 internalMethod07013(float f) {
        this.internalField1048 = f;
        return this;
    }

    public ScriptInternal007 internalMethod06175(ColorRGBA colorRGBA) {
        this.internalField0571 = typedParameter1010 -> colorRGBA;
        return this;
    }

    public ScriptInternal007 internalMethod00551(Function<ScriptInternal007, ColorRGBA> function) {
        this.internalField0571 = function;
        return this;
    }

    public ScriptInternal007 internalMethod06878(ColorRGBA colorRGBA) {
        this.internalField0570 = typedParameter1010 -> colorRGBA;
        return this;
    }

    public ScriptInternal007 internalMethod01909(Function<ScriptInternal007, ColorRGBA> function) {
        this.internalField0570 = function;
        return this;
    }

    public ScriptInternal007 internalMethod07658(ColorRGBA colorRGBA) {
        this.internalField1216 = typedParameter1010 -> colorRGBA;
        return this;
    }

    public ScriptInternal007 internalMethod08213(Function<ScriptInternal007, ColorRGBA> function) {
        this.internalField1216 = function;
        return this;
    }

    public ScriptInternal007 internalMethod07864(ColorRGBA colorRGBA) {
        this.internalField1213 = typedParameter1010 -> colorRGBA;
        return this;
    }

    public ScriptInternal007 internalMethod07911(Function<ScriptInternal007, ColorRGBA> function) {
        this.internalField1213 = function;
        return this;
    }

    public ScriptInternal007 internalMethod00229(float f) {
        this.internalField1047 = f;
        return this;
    }

    public ScriptInternal007 internalMethod08796(float f) {
        this.internalField1049 = f;
        return this;
    }

    public ScriptInternal007 internalMethod09045(float f) {
        this.internalField1046 = f;
        return this;
    }

    public ScriptInternal007 internalMethod07361(Motion typedParameter1004) {
        if (typedParameter1004 != null) {
            this.internalField0623.internalMethod00216(typedParameter1004);
        }
        return this;
    }

    public ScriptInternal007 internalMethod08938(float f) {
        super.width(f);
        return this;
    }

    public ScriptInternal007 internalMethod08206(float f) {
        super.height(f);
        return this;
    }

    public ScriptInternal007 internalMethod04313(float f, float f2) {
        super.size(f, f2);
        return this;
    }

    public ScriptInternal007 internalMethod06319() {
        super.fillWidth();
        return this;
    }

    public ScriptInternal007 internalMethod00051() {
        super.fillHeight();
        return this;
    }

    private void internalMethod05577(MouseButton typedParameter1015, float f, float f2) {
        if (typedParameter1015 != MouseButton.internalField0102) {
            return;
        }
        this.internalField0277 = true;
        this.internalMethod02209(f);
    }

    private void internalMethod02209(float f) {
        float f2 = (f - this.x()) / Math.max(1.0f, this.w());
        f2 = Math.max(0.0f, Math.min(1.0f, f2));
        float f3 = this.internalField0205 + (this.internalField0206 - this.internalField0205) * f2;
        if (this.internalField1048 > 0.0f) {
            f3 = (float)Math.round(f3 / this.internalField1048) * this.internalField1048;
        }
        this.internalField0888.accept(f3);
    }

    @Override
    public void mouseReleased(float f, float f2, MouseButton typedParameter1015) {
        this.internalField0277 = false;
        super.mouseReleased(f, f2, typedParameter1015);
    }

    @Override
    public void onTick(float f, float f2, float f3) {
        this.internalField0623.internalMethod03690(this.internalField0889.get());
        this.internalField0623.internalMethod08946(f);
        if (this.internalField0277 && !this.pressed()) {
            this.internalField0277 = false;
        }
        if (this.internalField0277) {
            this.internalMethod02209(f2);
        }
    }

    @Override
    public void drawSelf(UiRenderContext iII, float f) {
        float f2;
        float f3 = this.x();
        float f4 = this.y();
        float f5 = this.w();
        float f6 = this.h();
        float f7 = this.internalField0206 - this.internalField0205;
        float f8 = this.internalField0623.internalMethod02046();
        float f9 = f7 <= 0.0f ? 0.0f : (f8 - this.internalField0205) / f7;
        f9 = Math.max(0.0f, Math.min(1.0f, f9));
        float f10 = f5 * f9;
        float f11 = f4 + f6 / 2.0f - this.internalField1047 / 2.0f;
        float f12 = this.internalField1047 / 2.0f - 1.0f;
        ColorRGBA colorRGBA = this.internalField0571.apply(this);
        ColorRGBA colorRGBA2 = this.internalField0570.apply(this);
        ColorRGBA colorRGBA3 = this.internalField1216.apply(this);
        ColorRGBA colorRGBA4 = this.internalField1213 != null ? this.internalField1213.apply(this) : colorRGBA;
        float f13 = 2.5f;
        float f14 = Math.max(0.0f, f10 - f13);
        float f15 = f3 + Math.min(f5, f10 + f13);
        float f16 = Math.max(0.0f, f3 + f5 - f15);
        if (f16 > 0.0f && colorRGBA != null && colorRGBA.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f15, f11, f16, this.internalField1047, CornerRadii.internalMethod08088(f12, f12), colorRGBA);
        }
        if (f14 > 0.0f && colorRGBA2 != null && colorRGBA2.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f3, f11, f14, this.internalField1047, CornerRadii.internalMethod07937(f12, f12), colorRGBA2);
        }
        float f17 = f3 + f10;
        float f18 = f4 + f6 / 2.0f;
        if (colorRGBA3 != null && colorRGBA3.getAlpha() > 0.0f) {
            iII.drawRoundedBorder(f17 - this.internalField1049, f18 - this.internalField1049, this.internalField1049 * 2.0f, this.internalField1049 * 2.0f, this.internalField1046 / 2.0f, CornerRadii.internalMethod03908(this.internalField1049), colorRGBA3);
        }
        if ((f2 = this.internalField1049 - this.internalField1046) > 0.0f && colorRGBA4 != null && colorRGBA4.getAlpha() > 0.0f) {
            iII.drawRoundedRect(f17 - f2, f18 - f2, f2 * 2.0f, f2 * 2.0f, CornerRadii.internalMethod03908(f2), colorRGBA4);
        }
    }

    public static interface InternalType0348 {
        public float get();
    }

    public static interface InternalType0347 {
        public void accept(float localValue1);
    }
}

