package rockstar.client.internal.render;


import rockstar.client.*;
import rockstar.client.compat.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import rockstar.client.internal.render.RenderInternal001;

public class RenderInternal015
extends RenderInternal001 {
    private GlUniform internalField0855;

    public RenderInternal015(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    public void internalMethod02391(float f) {
        if (this.internalField0855 != null) {
            this.internalField0855.set(f);
        }
    }

    @Override
    public void internalMethod06856() {
        this.internalField0855 = this.internalMethod05981("Floor");
        super.internalMethod06856();
    }
}

