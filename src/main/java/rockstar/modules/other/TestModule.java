package rockstar.modules.other;







import rockstar.client.ui.*;
import rockstar.client.setting.*;
import rockstar.client.module.*;
import rockstar.client.event.*;
import rockstar.client.animation.*;
import rockstar.client.internal.script.*;
import rockstar.client.*;

import com.mojang.blaze3d.opengl.GlStateManager;
import rockstar.client.compat.RenderSystem;
import rockstar.client.compat.ShaderProgramKey;
import rockstar.client.compat.ShaderProgramKeys;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import rockstar.client.compat.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.setting.Vector2Setting;
import rockstar.client.setting.GradientColorSetting;
import rockstar.client.setting.TimeSetting;
import rockstar.client.event.EventListener;
import rockstar.client.module.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.module.ModuleInfo;
import rockstar.client.internal.script.ScriptInternal136;
import rockstar.client.animation.AnimatedValue;
import rockstar.client.animation.Easing;
import rockstar.client.ui.ThemeColors;
import rockstar.client.internal.script.ScriptInternal141;
import rockstar.client.module.Module;
import rockstar.modules.movement.SpeedModule;

@ModuleInfo(name="Test", category=ModuleCategory.OTHER)
public class TestModule
extends Module {
    private GradientColorSetting internalField0666;
    private Vector2Setting internalField0646;
    private TimeSetting internalField0387;
    private TimeSetting internalField0386;
    private final EventListener<Render3DEvent> internalField0157 = render3DEvent -> {
        MatrixStack matrixStack = render3DEvent.getMatrices();
        Camera camera = TestModule.internalField0149.gameRenderer.getCamera();
        Vec3d vec3d = camera.getCameraPos();
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();
        RenderSystem.blendFunc((com.mojang.blaze3d.platform.SourceFactor)com.mojang.blaze3d.platform.SourceFactor.SRC_ALPHA, (com.mojang.blaze3d.platform.DestFactor)com.mojang.blaze3d.platform.DestFactor.ONE);
        RenderSystem.setShader((ShaderProgramKey)ShaderProgramKeys.POSITION_COLOR);
        BufferBuilder bufferBuilder = RenderSystem.renderThreadTesselator().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        SpeedModule typedValue123 = RockstarClient.getInstance().getModuleManager().getModule(SpeedModule.class);
        for (AbstractClientPlayerEntity abstractClientPlayerEntity : TestModule.internalField0149.world.getPlayers()) {
            if (TestModule.internalField0149.player == abstractClientPlayerEntity) continue;
            ScriptInternal141.internalMethod00696(matrixStack, bufferBuilder, abstractClientPlayerEntity.getBoundingBox().offset(abstractClientPlayerEntity.getEntityPos().add(abstractClientPlayerEntity.getEntityPos().subtract(new Vec3d(abstractClientPlayerEntity.lastX, abstractClientPlayerEntity.lastY, abstractClientPlayerEntity.lastZ)).multiply((double)typedValue123.internalMethod00142().internalMethod08576()))).offset(-abstractClientPlayerEntity.getX(), -abstractClientPlayerEntity.getY(), -abstractClientPlayerEntity.getZ()).offset(-vec3d.getX(), -vec3d.getY(), -vec3d.getZ()), ThemeColors.internalMethod02531().withAlpha(100.0f));
        }
        BuiltBuffer builtBuffer = bufferBuilder.endNullable();
        if (builtBuffer != null) {
            BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
        }
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableCull();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    };
    private final AnimatedValue internalField0808 = new AnimatedValue(1000L, Easing.internalField1814);
    private final EventListener<HudRenderEvent> internalField0158 = hudRenderEvent -> {
        CustomDrawContext customDrawContext = hudRenderEvent.getContext();
        this.internalField0808.internalMethod02887();
        float f = 10.0f + this.internalField0808.internalMethod02881() * 340.0f;
        customDrawContext.drawIcon("cube", 100.0f, 100.0f, f, ColorRGBA.WHITE);
    };

    public TestModule() {
        this.internalMethod09919();
    }

    private void internalMethod09919() {
        this.internalField0666 = new GradientColorSetting(this, "\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0439 \u0433\u0440\u0430\u0434\u0438\u0435\u043d\u0442").internalMethod00046(ThemeColors.internalField1310, ThemeColors.internalField1310);
        this.internalField0646 = new Vector2Setting(this, "\u041a\u0443\u0440\u0432\u0430 \u0435\u0431\u0430\u043d\u0430\u044f");
        this.internalField0387 = new TimeSetting(this, "\u0412\u0440\u0435\u043c\u044f").internalMethod08384(7680);
        this.internalField0386 = new TimeSetting(this, "\u0412\u0440\u0435\u043c\u044f \u0431\u0435\u0437 \u0447\u0430\u0441\u043e\u0432").internalMethod04919(false).internalMethod08384(90);
    }

    @Override
    public void onEnable() {
        if (TestModule.internalField0149.currentScreen == null && TestModule.internalField0149.world == null) {
            return;
        }
        internalField0149.setScreen((Screen)new ScriptInternal136());
    }

    @Override
    public void onDisable() {
        if (TestModule.internalField0149.currentScreen instanceof ScriptInternal136) {
            internalField0149.setScreen(null);
        }
    }
}
