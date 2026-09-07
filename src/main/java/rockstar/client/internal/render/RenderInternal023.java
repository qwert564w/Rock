package rockstar.client.internal.render;



import rockstar.client.ui.*;
import rockstar.client.*;
import rockstar.client.compat.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import rockstar.client.internal.render.RenderInternal001;
import rockstar.client.ui.WindowAccess;

public class RenderInternal023
extends RenderInternal001
implements WindowAccess {
    private GlUniform internalField0855;

    public RenderInternal023(Identifier identifier) {
        super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
    }

    public void internalMethod00763(int n, int n2) {
        float f = n > 0 ? 1.0f / (float)n : 0.0f;
        float f2 = n2 > 0 ? 1.0f / (float)n2 : 0.0f;
    }

    @Override
    public void internalMethod06856() {
        this.internalField0855 = this.internalMethod05981("Resolution");
        super.internalMethod06856();
    }
}

