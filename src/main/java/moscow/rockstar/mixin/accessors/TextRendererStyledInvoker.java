package moscow.rockstar.mixin.accessors;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.text.OrderedText;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={TextRenderer.class})
public interface TextRendererStyledInvoker {
    @Invoker(value="drawInternal")
    public int rockstar$drawInternal(OrderedText localValue1, float localValue2, float localValue3, int localValue4, boolean localValue5, Matrix4f localValue6, VertexConsumerProvider localValue7, TextRenderer.TextLayerType localValue8, int localValue9, int localValue10, boolean localValue11);
}

