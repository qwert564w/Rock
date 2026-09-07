package rockstar.client.internal.ui;













import rockstar.client.ui.*;
import rockstar.client.setting.*;
import rockstar.client.render.*;
import rockstar.client.i18n.*;
import rockstar.client.core.*;
import rockstar.client.animation.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.game.*;
import rockstar.client.internal.framework.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import rockstar.client.ui.UiRenderContext;
import rockstar.client.render.Fonts;
import rockstar.client.setting.Setting;
import rockstar.client.render.CornerRadii;
import rockstar.client.ui.MouseButton;
import rockstar.client.internal.script.ScriptInternal101;
import rockstar.client.i18n.LanguageManager;
import rockstar.client.RockstarClient;
import rockstar.client.animation.AnimatedValue;
import rockstar.client.animation.Easing;
import rockstar.client.ui.ThemeColors;
import rockstar.client.core.CursorType;
import rockstar.client.core.CursorManager;
import rockstar.client.ui.UiUtils;
import rockstar.client.internal.game.GameInternal039;
import rockstar.client.ui.LegacyUiElement;
import rockstar.client.render.ScissorStack;
import rockstar.client.internal.framework.FrameworkInternal001;
import rockstar.client.internal.framework.FrameworkInternal002;
import rockstar.client.internal.core.CoreInternal051;
import rockstar.client.internal.config.ConfigInternal025;
import rockstar.client.internal.config.ConfigInternal026;

public class UiInternal015
extends LegacyUiElement {
    private final AnimatedValue internalField0808 = new AnimatedValue(300L, Easing.internalField0812);
    private final GameInternal039 internalField0004 = new GameInternal039();
    private final ScriptInternal101 internalField0936;
    private final AnimatedValue internalField0809 = new AnimatedValue(300L, Easing.internalField0811);

    public UiInternal015() {
        this.internalField0936 = new ScriptInternal101(Fonts.internalField1154.internalMethod01432(8.0f));
        this.internalField0936.internalMethod09000(LanguageManager.internalMethod07214("type_name"));
    }

    @Override
    public void internalMethod05619(UiRenderContext iII) {
        boolean bl;
        float f;
        FrameworkInternal001 typedValue108 = RockstarClient.getInstance().internalMethod00061();
        ConfigInternal026 internalValue0003 = RockstarClient.getInstance().internalMethod01001();
        List<ConfigInternal025> list = internalValue0003.internalMethod01720();
        float f2 = this.internalField0205 + 8.0f;
        float f3 = this.internalField0206 - 1.0f;
        float f4 = this.internalField1048 - 16.0f;
        this.internalField0004.internalMethod02322();
        iII.drawRoundedRect(f2 - 1.0f, f3 + 7.0f, f4 + 2.0f, 8.0f + this.internalField1047 - 46.0f, CornerRadii.internalMethod03908(6.0f), ThemeColors.internalMethod07738().withAlpha(76.5f));
        ScissorStack.internalMethod06303(iII.getMatrices(), f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.internalField1047 - 46.0f);
        float f5 = 0.0f;
        for (CoreInternal051 object : RockstarClient.getInstance().internalMethod00061().internalMethod05754()) {
            f = (float)((double)(f3 + 14.0f + f5) - this.internalField0004.internalMethod02321());
            bl = UiUtils.internalMethod06450(f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.internalField1047 - 46.0f, iII) && UiUtils.internalMethod05786(f2 - 1.0f, f - 4.0f, f4 + 2.0f, 12.0, iII.internalMethod05259(), iII.internalMethod05261());
            object.internalMethod03126().internalMethod07062(bl);
            object.internalMethod03867().internalMethod07062(Objects.equals(object.internalMethod02665(), typedValue108.internalMethod02484()));
            iII.drawFadeoutText(Fonts.internalField1154.internalMethod01432(7.0f), LanguageManager.internalMethod07214(object.internalMethod02665()), f2 + 7.0f, f + 0.5f, ThemeColors.internalMethod08459().withAlpha(255.0f * (0.75f + 0.25f * object.internalMethod03126().internalMethod02881() + 0.25f * object.internalMethod03867().internalMethod02881())), 0.8f, 1.0f, f4 - 12.0f - object.internalMethod03867().internalMethod02881() * 10.0f);
            if (bl) {
                CursorManager.internalMethod06882(CursorType.internalField0567);
            }
            if (object.internalMethod03867().internalMethod02881() >= 0.0f) {
                iII.drawIcon("check", f2 + f4 - 11.0f - object.internalMethod03867().internalMethod02881() * 2.0f, f, 6.0f, ThemeColors.internalMethod08459().withAlpha(object.internalMethod03867().internalMethod02881() * 255.0f));
            }
            f5 += 12.0f;
        }
        for (ConfigInternal025 typedValue117 : list) {
            if (typedValue117.internalMethod02141().equals("autosave")) continue;
            f = (float)((double)(f3 + 14.0f + f5) - this.internalField0004.internalMethod02321());
            bl = UiUtils.internalMethod06450(f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.internalField1047 - 46.0f, iII) && UiUtils.internalMethod05786(f2 - 1.0f, f - 4.0f, f4 + 2.0f, 12.0, iII.internalMethod05259(), iII.internalMethod05261());
            typedValue117.internalMethod06902().internalMethod07062(bl);
            typedValue117.internalMethod07599().internalMethod07062(Objects.equals(typedValue117.internalMethod02141(), typedValue108.internalMethod02484()));
            iII.drawFadeoutText(Fonts.internalField1154.internalMethod01432(7.0f), typedValue117.internalMethod02141(), f2 + 7.0f + 10.0f * typedValue117.internalMethod06902().internalMethod02881(), f + 0.5f, ThemeColors.internalMethod08459().withAlpha(255.0f * (0.75f + 0.25f * typedValue117.internalMethod06902().internalMethod02881() + 0.25f * typedValue117.internalMethod07599().internalMethod02881())), 0.8f, 1.0f, f4 - 12.0f - typedValue117.internalMethod07599().internalMethod02881() * 10.0f - 10.0f * typedValue117.internalMethod06902().internalMethod02881());
            if (bl) {
                CursorManager.internalMethod06882(CursorType.internalField0567);
            }
            if (typedValue117.internalMethod06902().internalMethod02881() >= 0.0f) {
                iII.drawIcon("trash", f2 + 7.0f * typedValue117.internalMethod06902().internalMethod02881(), f, 6.0f, ThemeColors.internalMethod08459().withAlpha(typedValue117.internalMethod06902().internalMethod02881() * 255.0f));
            }
            if (typedValue117.internalMethod07599().internalMethod02881() >= 0.0f) {
                iII.drawIcon("check", f2 + f4 - 11.0f - typedValue117.internalMethod07599().internalMethod02881() * 2.0f, f, 6.0f, ThemeColors.internalMethod08459().withAlpha(typedValue117.internalMethod07599().internalMethod02881() * 255.0f));
            }
            f5 += 12.0f;
        }
        ScissorStack.internalMethod07643();
        iII.drawRoundedRect(f2 - 1.0f, f3 + this.internalField1047 - 25.0f, f4 + 2.0f, 20.0f, CornerRadii.internalMethod03908(6.0f), ThemeColors.internalMethod07738().mulAlpha(0.3f));
        iII.drawIcon("plus", f2 + f4 - 2.0f * this.internalField0808.internalMethod02881() - 10.0f, f3 + this.internalField1047 - 25.0f + 6.0f, 8.0f, ThemeColors.internalMethod08459().mulAlpha(this.internalField0808.internalMethod02881()));
        this.internalField0936.internalMethod05191(f2 - 1.0f, f3 + this.internalField1047 - 25.0f, f4 + 2.0f - 12.0f, 20.0f);
        this.internalField0936.internalMethod08627(1.0f);
        this.internalField0936.internalMethod03398(iII);
        this.internalField0808.internalMethod07062(!this.internalField0936.internalMethod06202().isBlank());
        if (UiUtils.internalMethod06450(f2 + f4 - 2.0f - 10.0f, f3 + this.internalField1047 - 25.0f + 6.0f, 8.0, 8.0, iII) && this.internalField0808.internalMethod02881() > 0.0f) {
            CursorManager.internalMethod06882(CursorType.internalField0567);
        }
        this.internalField0004.internalMethod04308(-f5 + this.internalField1047 - 20.0f - 25.0f);
    }

    @Override
    public void internalMethod01643(double d, double d2, MouseButton typedParameter1015) {
        boolean bl;
        float f;
        this.internalField0936.internalMethod01643(d, d2, typedParameter1015);
        FrameworkInternal001 typedValue108 = RockstarClient.getInstance().internalMethod00061();
        ConfigInternal026 internalValue0003 = RockstarClient.getInstance().internalMethod01001();
        List<ConfigInternal025> list = internalValue0003.internalMethod01720();
        float f2 = this.internalField0205 + 8.0f;
        float f3 = this.internalField0206 - 1.0f;
        float f4 = this.internalField1048 - 16.0f;
        float f5 = 0.0f;
        for (CoreInternal051 object : RockstarClient.getInstance().internalMethod00061().internalMethod05754()) {
            f = (float)((double)(f3 + 14.0f + f5) - this.internalField0004.internalMethod02321());
            boolean bl2 = bl = UiUtils.internalMethod05785(f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.internalField1047 - 46.0f, d, d2) && UiUtils.internalMethod05785(f2 - 1.0f, f - 4.0f, f4 + 2.0f, 12.0, d, d2);
            if (bl && typedParameter1015 == MouseButton.internalField0102) {
                typedValue108.internalMethod01403(object);
            }
            f5 += 12.0f;
        }
        for (ConfigInternal025 typedValue117 : new ArrayList<ConfigInternal025>(list)) {
            if (typedValue117.internalMethod02141().equals("autosave")) continue;
            f = (float)((double)(f3 + 14.0f + f5) - this.internalField0004.internalMethod02321());
            boolean bl3 = bl = UiUtils.internalMethod05785(f2 - 1.0f, f3 + 7.5f, f4 + 2.0f, 7.0f + this.internalField1047 - 46.0f, d, d2) && UiUtils.internalMethod05785(f2 - 1.0f, f - 4.0f, f4 + 2.0f, 12.0, d, d2);
            if (bl && UiUtils.internalMethod05785(f2 + 7.0f, f, 6.0, 6.0, d, d2) && typedParameter1015 == MouseButton.internalField0102) {
                typedValue117.internalMethod07672();
            } else if (bl && typedParameter1015 == MouseButton.internalField0102) {
                if (internalValue0003.internalMethod02695() != null) {
                    internalValue0003.internalMethod02695().internalMethod03767();
                }
                typedValue108.internalMethod06192(typedValue117.internalMethod02141());
                typedValue117.internalMethod03765();
            }
            f5 += 12.0f;
        }
        if (UiUtils.internalMethod05785(f2 + f4 - 2.0f - 10.0f, f3 + this.internalField1047 - 25.0f + 6.0f, 8.0, 8.0, d, d2) && !this.internalField0936.internalMethod06202().isBlank()) {
            this.internalMethod04289();
        }
    }

    private void internalMethod04289() {
        FrameworkInternal002.InternalType0500 nestedValue2065;
        ConfigInternal026 internalValue0003 = RockstarClient.getInstance().internalMethod01001();
        FrameworkInternal001 typedValue108 = RockstarClient.getInstance().internalMethod00061();
        typedValue108.internalMethod05663().internalMethod06395(0.5f, 1.0f).internalMethod06615(0.5f, 0.0f);
        typedValue108.internalMethod05664().internalMethod04836(true);
        typedValue108.internalMethod03324().internalMethod04736(2.0f);
        for (Setting typedValue157 : RockstarClient.getInstance().internalMethod00061().internalMethod04274().getSettings()) {
            if (!(typedValue157 instanceof FrameworkInternal002.InternalType0500)) continue;
            nestedValue2065 = (FrameworkInternal002.InternalType0500)typedValue157;
            nestedValue2065.internalMethod04736(0.0f);
        }
        for (Setting typedValue157 : RockstarClient.getInstance().internalMethod00061().internalMethod05639().getSettings()) {
            if (!(typedValue157 instanceof FrameworkInternal002.InternalType0500)) continue;
            nestedValue2065 = (FrameworkInternal002.InternalType0500)typedValue157;
            nestedValue2065.internalMethod04736(0.0f);
        }
        typedValue108.internalMethod06192(this.internalField0936.internalMethod06202());
        internalValue0003.internalMethod07525(this.internalField0936.internalMethod06202());
        internalValue0003.internalMethod06262(this.internalField0936.internalMethod06202()).internalMethod03765();
        this.internalField0936.internalMethod09126();
    }

    @Override
    public void internalMethod02863(double d, double d2, MouseButton typedParameter1015) {
        this.internalField0936.internalMethod02863(d, d2, typedParameter1015);
    }

    @Override
    public void internalMethod05727(int n, int n2, int n3) {
        if (n == 257 && !this.internalField0936.internalMethod06202().isBlank()) {
            this.internalMethod04289();
            return;
        }
        this.internalField0936.internalMethod05727(n, n2, n3);
        if (this.internalMethod04933(UiUtils.internalMethod03634().x(), UiUtils.internalMethod03634().y())) {
            this.internalField0004.internalMethod04250(n);
        }
    }

    @Override
    public boolean internalMethod05413(char c, int n) {
        this.internalField0936.internalMethod05413(c, n);
        return super.internalMethod05413(c, n);
    }

    @Override
    public void internalMethod02890(double d, double d2, double d3, double d4) {
        this.internalField0004.internalMethod04249(d4);
    }

    @Override
    public float internalMethod07809() {
        ConfigInternal026 internalValue0003 = RockstarClient.getInstance().internalMethod01001();
        List<ConfigInternal025> list = internalValue0003.internalMethod01720();
        this.internalField1047 = this.internalField0809.internalMethod07059(Math.min(list.size() * 12 + RockstarClient.getInstance().internalMethod00061().internalMethod05754().size() * 12 - 12, 182) + 46);
        return this.internalField1047;
    }
}

