package rockstar.client.internal.render;



import rockstar.client.render.*;
import rockstar.client.*;
import lombok.Generated;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.util.math.MatrixStack;
import rockstar.client.render.CornerRadii;
import rockstar.client.internal.render.RenderInternal001;
import rockstar.client.render.RenderPipeline;
import rockstar.client.internal.render.RenderInternal034;

public class RenderInternal042
extends RenderInternal034 {
    private final MatrixStack internalField0254;
    private final float internalField0205;
    private final float internalField0206;
    private final float internalField1048;
    private final CornerRadii internalField0098;

    public RenderInternal042(VertexFormat vertexFormat, MatrixStack matrixStack, float f, float f2, float f3, CornerRadii typedParameter1014) {
        super(vertexFormat);
        this.internalField0254 = matrixStack;
        this.internalField0205 = f;
        this.internalField0206 = f2;
        this.internalField1048 = f3;
        this.internalField0098 = typedParameter1014;
    }

    @Override
    public void internalMethod09053() {
        RenderInternal001 typedValue017 = RenderPipeline.internalField0104;
        typedValue017.internalMethod01220();
        typedValue017.internalMethod05981("Size").set(this.internalField0205, this.internalField0206);
        typedValue017.internalMethod05981("Radius").set(this.internalField0098.internalMethod05337() * 3.0f, this.internalField0098.internalMethod08942() * 3.0f, this.internalField0098.internalMethod05340() * 3.0f, this.internalField0098.internalMethod08939() * 3.0f);
        typedValue017.internalMethod05981("Smoothness").set(this.internalField1048);
        RenderPipeline.internalMethod09058();
        this.internalMethod00851();
        RenderPipeline.internalMethod09648();
        this.internalMethod00854();
    }

    @Generated
    public MatrixStack internalMethod04935() {
        return this.internalField0254;
    }
}

