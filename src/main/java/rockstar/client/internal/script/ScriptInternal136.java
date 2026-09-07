package rockstar.client.internal.script;






import rockstar.client.ui.*;
import rockstar.client.render.*;
import rockstar.client.core.*;
import rockstar.client.animation.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.ui.LayoutAlignment;
import rockstar.client.render.SizedFont;
import rockstar.client.ui.LayeredRockstarScreen;
import rockstar.client.render.Fonts;
import rockstar.client.ui.TextAlignment;
import rockstar.client.animation.Motion;
import rockstar.client.render.CornerRadii;
import rockstar.client.ui.UiTransition;
import rockstar.client.ui.UiElement;
import rockstar.client.animation.Easing;
import rockstar.client.ui.ThemeColors;
import rockstar.client.core.CursorType;
import rockstar.client.ui.DragConstraint;
import rockstar.client.ui.UiContainer;

public class ScriptInternal136
extends LayeredRockstarScreen {
    private static final String[] internalField0359 = new String[]{"Combat", "Movement", "Visuals", "Misc"};
    private final SizedFont internalField0447 = Fonts.internalField0449.internalMethod01432(7.0f);
    private final SizedFont internalField0448 = Fonts.internalField1154.internalMethod01432(6.0f);
    private String internalField0248 = internalField0359[0];
    private UiContainer internalField0634;

    @Override
    public void init() {
        super.init();
        this.clearRoots();
        float f = 360.0f;
        float f2 = 252.0f;
        float f3 = 10.0f;
        float f4 = 22.0f;
        float f5 = 8.0f;
        UiContainer typedValue007 = new UiContainer().internalMethod01863().internalMethod07351(f3).internalMethod03062(f5).internalMethod08487(6.0f).internalMethod09018(10.0f).internalMethod06812(typedValue006 -> ThemeColors.internalMethod07738().withAlpha(235.0f)).internalMethod03995(f, f2).internalMethod09784().internalMethod03715(DragConstraint.internalField0631);
        UiContainer typedValue008 = new UiContainer().internalMethod05895().internalMethod03062(6.0f).internalMethod09609().internalMethod09266(f4).internalMethod07607(LayoutAlignment.internalField1377).internalMethod03715(DragConstraint.internalField0631);
        for (String string : internalField0359) {
            typedValue008.internalMethod03907(this.internalMethod04038(string));
        }
        this.internalField0634 = new UiContainer().internalMethod02070(2).internalMethod03062(6.0f).internalMethod09609().internalMethod09266(f2 - f3 * 2.0f - f4 - f5).internalMethod08755().internalMethod08163(220.0f).internalMethod07108(this.internalMethod03758(this.internalField0248));
        typedValue007.internalMethod03907(typedValue008);
        typedValue007.internalMethod03907(this.internalField0634);
        this.add(typedValue007);
    }

    private UiElement internalMethod04038(String string) {
        float f = this.internalField0447.internalMethod00965(string) + 18.0f;
        return new UiElement().height(22.0f).width(f).radius(6.0f).bind("sel", () -> this.internalField0248.equals(string)).background(typedParameter1002 -> ThemeColors.internalMethod02531().mulAlpha(0.1f + 0.2f * typedParameter1002.sig("sel") + 0.1f * typedParameter1002.hover())).border(1.0f, typedParameter1002 -> ThemeColors.internalMethod02531().mulAlpha(0.0f + 0.7f * typedParameter1002.sig("sel"))).text(this.internalField0447, string, typedParameter1002 -> ThemeColors.internalMethod08459().mix(ThemeColors.internalMethod02531(), typedParameter1002.sig("sel")).mulAlpha(0.6f + 0.4f * Math.max(typedParameter1002.sig("sel"), typedParameter1002.hover()))).textAlign(TextAlignment.internalField0621).cursor(CursorType.internalField0567).onClick(() -> this.internalMethod06621(string)).enter(UiTransition.internalField1389).exit(UiTransition.internalField1389);
    }

    private void internalMethod06621(String string) {
        if (this.internalField0248.equals(string)) {
            return;
        }
        this.internalField0248 = string;
        this.internalField0634.internalMethod07849(this.internalMethod03758(this.internalField0248));
    }

    private List<UiElement> internalMethod03758(String string) {
        ArrayList<UiElement> arrayList = new ArrayList<UiElement>(100);
        for (int i = 0; i < 100; ++i) {
            int n = i;
            ColorRGBA colorRGBA = ColorRGBA.fromHSB(((float)(string.hashCode() & 0xFF) / 255.0f + (float)i * 0.041f) % 1.0f, 0.55f, 0.95f);
            String string2 = string + " #" + (i + 1);
            arrayList.add(new UiElement().fillWidth().height(34.0f).radius(6.0f).cursor(CursorType.internalField0567).background(typedParameter1002 -> ThemeColors.internalMethod08573().mulAlpha(0.25f + 0.2f * typedParameter1002.hover())).textInset(18.0f).text(this.internalField0447, string2, typedParameter1002 -> ThemeColors.internalMethod08459().mulAlpha(0.85f)).paint((iII, typedParameter1002) -> {
                iII.drawRoundedRect(typedParameter1002.x() + 7.0f, typedParameter1002.y() + typedParameter1002.h() / 2.0f - 4.0f, 4.0f, 8.0f, CornerRadii.internalMethod03908(2.0f), colorRGBA);
                iII.drawText(this.internalField0448, "element index " + n, typedParameter1002.x() + 18.0f, typedParameter1002.y() + typedParameter1002.h() / 2.0f + 1.5f, ThemeColors.internalMethod08459().mulAlpha(0.4f));
            }).lifeMotion(Motion.internalMethod01328(500L, Easing.internalField0812)).enter(UiTransition.internalMethod02229(-30.0f)).exit(UiTransition.internalMethod02229(-30.0f)));
        }
        return arrayList;
    }
}
