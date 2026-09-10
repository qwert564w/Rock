package moscow.rockstar.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import rockstar.modules.other.spoof.SpoofManager;

@Mixin(net.minecraft.client.render.entity.LivingEntityRenderer.class)
public class NameTagRenderMixin {
    @ModifyVariable(
        method = "renderLabelIfPresent",
        at = @At("HEAD"),
        argsOnly = true
    )
    private Text modifyRenderedName(Text originalText, Entity entity) {
        if (SpoofManager.isSpoofing && entity instanceof PlayerEntity && SpoofManager.targetName != null) {
            return Text.literal(SpoofManager.targetName);
        }
        return originalText;
    }
}
