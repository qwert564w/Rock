package rockstar.client.internal.render;



import rockstar.client.render.*;
import rockstar.client.*;
import rockstar.client.compat.RenderSystem;
import rockstar.client.compat.ShaderProgram;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import rockstar.client.render.FontFamily;
import rockstar.client.internal.render.RenderInternal020;
import rockstar.client.internal.render.RenderInternal034;

public class RenderInternal037
extends RenderInternal034 {
    public FontFamily internalField0450;
    private float internalField0205;
    private float internalField0206;
    private float internalField1048;
    private float internalField1047;

    public RenderInternal037(VertexFormat vertexFormat, FontFamily typedValue022, float f, float f2, float f3, float f4) {
        super(VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        this.internalField0450 = typedValue022;
        this.internalField0205 = f;
        this.internalField0206 = f2;
        this.internalField1048 = f3;
        this.internalField1047 = f4;
    }

    @Override
    public void internalMethod09053() {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        ShaderProgram shaderProgram = RenderInternal020.internalMethod07504(0.0f);
        shaderProgram.getUniform("EnableFadeout").set(1);
        shaderProgram.getUniform("FadeoutStart").set(this.internalField0205);
        shaderProgram.getUniform("FadeoutEnd").set(this.internalField0206);
        shaderProgram.getUniform("MaxWidth").set(this.internalField1048);
        shaderProgram.getUniform("TextPosX").set(this.internalField1047);
        this.internalMethod00851();
        RenderInternal020.internalMethod04918();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        this.internalMethod00854();
    }
}

