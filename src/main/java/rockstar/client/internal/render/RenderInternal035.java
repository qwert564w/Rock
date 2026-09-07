package rockstar.client.internal.render;



import rockstar.client.render.*;
import rockstar.client.*;
import rockstar.client.compat.RenderSystem;
import rockstar.client.compat.ShaderProgram;
import net.minecraft.client.render.BufferBuilder;
import rockstar.client.compat.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import rockstar.client.render.FontFamily;
import rockstar.client.internal.render.RenderInternal020;

public final class RenderInternal035 {
    private static BufferBuilder internalField0033;
    private static boolean internalField0277;

    public static void internalMethod05638() {
        if (internalField0277) {
            return;
        }
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        internalField0277 = true;
    }

    private static BufferBuilder internalMethod06035(float f) {
        if (internalField0033 == null) {
            ShaderProgram shaderProgram = RenderInternal020.internalMethod07504(f);
            shaderProgram.getUniform("EnableFadeout").set(0);
            internalField0033 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        }
        return internalField0033;
    }

    public static void internalMethod07604(FontFamily typedValue022, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4, float f5, float f6) {
        if (!internalField0277) {
            RenderInternal035.internalMethod05638();
        }
        typedValue022.internalMethod02357(matrix4f, (VertexConsumer)RenderInternal035.internalMethod06035(f5), string, f, f2, f3, f4, n);
    }

    public static void internalMethod04747(FontFamily typedValue022, String string, float f, int n, Matrix4f matrix4f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (!internalField0277) {
            RenderInternal035.internalMethod05638();
        }
        BufferBuilder bufferBuilder = RenderInternal035.internalMethod06035(f5);
        ShaderProgram shaderProgram = RenderSystem.getShader();
        shaderProgram.getUniform("EnableFadeout").set(1);
        shaderProgram.getUniform("FadeoutStart").set(f7);
        shaderProgram.getUniform("FadeoutEnd").set(f8);
        shaderProgram.getUniform("MaxWidth").set(f9);
        shaderProgram.getUniform("TextPosX").set(f10);
        typedValue022.internalMethod02357(matrix4f, (VertexConsumer)bufferBuilder, string, f, f2, f3, f4, n);
    }

    public static void internalMethod05640() {
        if (!internalField0277) {
            return;
        }
        if (internalField0033 != null) {
            BuiltBuffer builtBuffer = internalField0033.endNullable();
            if (builtBuffer != null) {
                BufferRenderer.drawWithGlobalProgram((BuiltBuffer)builtBuffer);
            }
            internalField0033 = null;
        }
        RenderInternal020.internalMethod04918();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        internalField0277 = false;
    }

    static {
        internalField0277 = false;
    }
}

