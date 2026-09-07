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
import rockstar.client.render.UiBatchRenderer;

public class RenderInternal038
extends RenderInternal034 {
    public FontFamily internalField0450;

    public RenderInternal038(VertexFormat vertexFormat, FontFamily typedValue022) {
        super(VertexFormats.POSITION_TEXTURE_COLOR_LIGHT);
        this.internalField0450 = typedValue022;
    }

    @Override
    public void internalMethod09053() {
        float f = 0.0f;
        float f2 = 0.5f;
        float f3 = 0.0f;
        UiBatchRenderer.internalMethod08433();
        RenderSystem.disableCull();
        ShaderProgram shaderProgram = RenderInternal020.internalMethod07504(f);
        shaderProgram.getUniform("EnableFadeout").set(0);
        this.internalMethod00851();
        RenderInternal020.internalMethod04918();
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        this.internalMethod00854();
    }
}

