package rockstar.client.internal.script;








import rockstar.client.ui.*;
import rockstar.client.setting.*;
import rockstar.client.render.*;
import rockstar.client.i18n.*;
import rockstar.client.animation.*;
import rockstar.client.internal.framework.*;
import rockstar.client.*;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.ui.UiRenderContext;
import rockstar.client.render.SizedFont;
import rockstar.client.render.Fonts;
import rockstar.modules.visual.XRayModule;
import rockstar.client.animation.Motion;
import rockstar.client.render.CornerRadii;
import rockstar.client.setting.MultiSelectSetting;
import rockstar.client.i18n.LanguageManager;
import rockstar.client.internal.script.ScriptInternal112;
import rockstar.client.internal.framework.FrameworkInternal005;
import rockstar.client.RockstarClient;
import rockstar.client.ui.ThemeColors;
import rockstar.client.MinecraftClientAccess;
import rockstar.client.ui.UiNode;
import rockstar.client.ui.UiContainer;

public class ScriptInternal127
extends FrameworkInternal005
implements MinecraftClientAccess {
    private static final float internalField0205 = 114.0f;
    private static final float internalField0206 = 15.0f;
    private static final float internalField1048 = 90.0f;
    private static final float internalField1047 = 32.0f;
    private static final float internalField1049 = 25.0f;
    private static final float internalField1046 = 15.0f;
    private static final float internalField1456 = 0.7f;
    static final Item[] internalField0838 = new Item[]{Items.ANCIENT_DEBRIS, Items.DIAMOND_ORE, Items.GOLD_ORE, Items.LAPIS_ORE};
    static final String[] internalField0359 = new String[]{LanguageManager.internalMethod07214("hud.xray.ancient_debris") + ": ", LanguageManager.internalMethod07214("hud.xray.diamond_ore") + ": ", LanguageManager.internalMethod07214("hud.xray.gold_ore") + ": ", LanguageManager.internalMethod07214("hud.xray.lapis_ore") + ": "};
    private UiContainer internalField0634;

    public ScriptInternal127(MultiSelectSetting typedValue173) {
        super(typedValue173, "xray");
    }

    @Override
    public void prepare(ScriptInternal112 typedValue201) {
    }

    public UiContainer internalMethod05360(ScriptInternal112 typedValue201) {
        if (this.internalField0634 == null) {
            this.internalField0634 = new InternalType0225(typedValue201);
        }
        return this.internalField0634;
    }

    @Override
    public boolean canShow() {
        return this.internalMethod03582(this.internalMethod04876());
    }

    public XRayModule internalMethod04876() {
        return RockstarClient.getInstance().getModuleManager().getModule(XRayModule.class);
    }

    public int internalMethod03783(XRayModule iModuleManager, int n) {
        return switch (n) {
            case 0 -> iModuleManager.internalMethod08997();
            case 1 -> iModuleManager.internalMethod08996();
            case 2 -> iModuleManager.internalMethod09006();
            case 3 -> iModuleManager.internalMethod09007();
            default -> 0;
        };
    }

    private int internalMethod03581(XRayModule iModuleManager) {
        int n = 0;
        if (iModuleManager.internalMethod08997() > 0) {
            ++n;
        }
        if (iModuleManager.internalMethod08996() > 0) {
            ++n;
        }
        if (iModuleManager.internalMethod09006() > 0) {
            ++n;
        }
        if (iModuleManager.internalMethod09007() > 0) {
            ++n;
        }
        return n;
    }

    private boolean internalMethod03582(XRayModule iModuleManager) {
        return (iModuleManager.internalMethod08997() > 0 || iModuleManager.internalMethod08996() > 0 || iModuleManager.internalMethod09006() > 0 || iModuleManager.internalMethod09007() > 0) && iModuleManager.isEnabled();
    }

    public float internalMethod03580(XRayModule iModuleManager) {
        String string = LanguageManager.internalMethod07214("hud.xray.found_diamonds") + ": " + iModuleManager.internalMethod08996();
        return Math.min(32.0f + Fonts.internalField0449.internalMethod01432(7.0f).internalMethod00965(string), 90.0f);
    }

    public float internalMethod00482(XRayModule iModuleManager) {
        return 25.0f + (float)this.internalMethod03581(iModuleManager) * 15.0f;
    }

    final class InternalType0225
    extends UiContainer {
        private final ScriptInternal112 internalField0209;
        private final InternalType0516 internalField0768;
        private final InternalType0224 internalField0524;
        private final InternalType0224 internalField0525;
        private final InternalType0517[] internalField0458;

        InternalType0225(ScriptInternal112 typedValue201) {
            this.internalField0768 = new InternalType0516();
            this.internalField0524 = new InternalType0224(ScriptInternal127.this, Fonts.internalField0449.internalMethod01432(7.0f), () -> LanguageManager.internalMethod07214("hud.xray.found_diamonds") + ": " + ScriptInternal127.this.internalMethod04876().internalMethod08996(), () -> ThemeColors.internalMethod08459().withAlpha(255.0f * ScriptInternal127.this.animation.internalMethod02881()), this::internalMethod03962);
            this.internalField0525 = new InternalType0224(ScriptInternal127.this, Fonts.internalField0449.internalMethod01432(7.0f), () -> LanguageManager.internalMethod07214("hud.xray.found") + ": ", () -> ThemeColors.internalMethod08459().withAlpha(255.0f * this.internalMethod09246()), this::internalMethod08967);
            this.internalField0458 = new InternalType0517[]{new InternalType0517(0), new InternalType0517(1), new InternalType0517(2), new InternalType0517(3)};
            this.internalField0209 = typedValue201;
            this.internalMethod03995(48.0f, 15.0f);
            this.internalMethod07853(false);
            this.internalMethod09801();
            this.snapSize();
            this.internalMethod06473(this.internalField0768);
            this.internalMethod06473(this.internalField0524);
            this.internalMethod06473(this.internalField0525);
            for (InternalType0517 nestedValue2068 : this.internalField0458) {
                this.internalMethod06473(nestedValue2068);
            }
        }

        @Override
        protected void measure() {
            XRayModule iModuleManager = ScriptInternal127.this.internalMethod04876();
            this.prefW = this.internalField0209.internalMethod08516() ? 114.0f : ScriptInternal127.this.internalMethod03580(iModuleManager);
            this.prefH = this.internalField0209.internalMethod08516() ? ScriptInternal127.this.internalMethod00482(iModuleManager) : 15.0f;
        }

        @Override
        protected void onTick(float f, float f2, float f3) {
            this.internalMethod01401().removeIf(typedValue004 -> typedValue004.phase() == UiNode.InternalType0146.internalField1090);
            this.internalMethod08139();
            for (UiNode typedValue005 : this.internalMethod01401()) {
                typedValue005.tick(f, f2, f3);
            }
        }

        @Override
        protected void drawChildren(UiRenderContext iII, float f) {
            for (UiNode typedValue004 : this.internalMethod01401()) {
                if (!typedValue004.inFlow()) continue;
                typedValue004.draw(iII, f);
            }
        }

        private void internalMethod08139() {
            float f = ScriptInternal127.this.animation.internalMethod02881();
            float f2 = this.x() + 25.0f;
            this.internalField0768.setSlot(this.x() - 6.0f + 10.0f * f, this.y() + 4.0f, 7.0f, 7.0f);
            String string = LanguageManager.internalMethod07214("hud.xray.found_diamonds") + ": " + ScriptInternal127.this.internalMethod04876().internalMethod08996();
            SizedFont typedValue020 = Fonts.internalField0449.internalMethod01432(7.0f);
            this.internalField0524.setSlot(f2 - 10.0f * f, this.y() + 5.0f, typedValue020.internalMethod00965(string), typedValue020.internalMethod04890());
            SizedFont typedValue021 = Fonts.internalField0449.internalMethod01432(7.0f);
            String string2 = LanguageManager.internalMethod07214("hud.xray.found") + ": ";
            this.internalField0525.setSlot(f2 - 11.0f * f, this.y() + 10.0f, typedValue021.internalMethod00965(string2), typedValue021.internalMethod04890());
            int n = 0;
            for (InternalType0517 nestedValue2068 : this.internalField0458) {
                int n2 = ScriptInternal127.this.internalMethod03783(ScriptInternal127.this.internalMethod04876(), nestedValue2068.internalField0227);
                float f3 = this.y() + 20.0f + (float)n * 15.0f;
                nestedValue2068.setSlot(f2 - 11.0f * f, f3, 89.0f, 15.0f);
                if (n2 <= 0) continue;
                ++n;
            }
        }

        private boolean internalMethod03962() {
            return this.internalMethod09246() == 0.0f;
        }

        private boolean internalMethod08967() {
            return this.internalMethod09246() > 0.7f;
        }

        private float internalMethod09246() {
            return this.internalField0209.internalMethod05767().internalMethod02881();
        }

        private void internalMethod06473(UiNode typedValue004) {
            typedValue004.lifeMotion(Motion.internalMethod01870(1L));
            this.internalMethod03907(typedValue004);
        }
    }

    final class InternalType0517
    extends UiNode {
        final int internalField0227;

        InternalType0517(int n) {
            this.internalField0227 = n;
            this.snapPosition();
            this.snapSize();
            this.interactive(false);
        }

        @Override
        protected void drawSelf(UiRenderContext iII, float f) {
            ScriptInternal112 typedValue201 = RockstarClient.getInstance().internalMethod01271().internalMethod01259();
            if (typedValue201 == null || typedValue201.internalMethod05767().internalMethod02881() <= 0.7f) {
                return;
            }
            XRayModule iModuleManager = ScriptInternal127.this.internalMethod04876();
            int n = ScriptInternal127.this.internalMethod03783(iModuleManager, this.internalField0227);
            if (n == 0) {
                return;
            }
            iII.drawItem(internalField0838[this.internalField0227], this.x() - 1.0f, this.y(), 0.75f);
            iII.drawText(Fonts.internalField0449.internalMethod01432(7.0f), internalField0359[this.internalField0227] + n, this.x() + 15.0f, this.y() + 3.0f, ThemeColors.internalMethod08459().withAlpha(255.0f * typedValue201.internalMethod05767().internalMethod02881() * 0.7f));
        }
    }

    final class InternalType0224
    extends UiNode {
        private final SizedFont internalField0447;
        private final Supplier<String> internalField0017;
        private final Supplier<ColorRGBA> internalField0018;
        private final BooleanSupplier internalField0424;

        InternalType0224(ScriptInternal127 typedValue203, SizedFont typedValue020, Supplier<String> supplier, Supplier<ColorRGBA> supplier2, BooleanSupplier booleanSupplier) {
            this.internalField0447 = typedValue020;
            this.internalField0017 = supplier;
            this.internalField0018 = supplier2;
            this.internalField0424 = booleanSupplier;
            this.snapPosition();
            this.snapSize();
            this.interactive(false);
        }

        @Override
        protected void drawSelf(UiRenderContext iII, float f) {
            if (!this.internalField0424.getAsBoolean()) {
                return;
            }
            String string = this.internalField0017.get();
            if (string != null && !string.isEmpty()) {
                iII.drawText(this.internalField0447, string, this.x(), this.y(), this.internalField0018.get());
            }
        }
    }

    final class InternalType0516
    extends UiNode {
        InternalType0516() {
            this.snapPosition();
            this.snapSize();
            this.interactive(false);
        }

        @Override
        protected void drawSelf(UiRenderContext iII, float f) {
            ScriptInternal112 typedValue201 = RockstarClient.getInstance().internalMethod01271().internalMethod01259();
            if (typedValue201 != null && typedValue201.internalMethod05767().internalMethod02881() != 0.0f) {
                return;
            }
            iII.drawRoundedRect(this.x(), this.y(), this.w(), this.h(), CornerRadii.internalMethod03908(3.0f), new ColorRGBA(115.0f, 0.0f, 255.0f).withAlpha(255.0f * ScriptInternal127.this.animation.internalMethod02881()));
        }
    }
}
