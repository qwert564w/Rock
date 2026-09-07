package moscow.rockstar.mixin.minecraft.client.gui.overlay;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import rockstar.client.RockstarClient;
import rockstar.modules.visual.RemovalsModule;

@Mixin(targets = "net.minecraft.client.render.fog.DarknessEffectFogModifier")
public class DarknessFogModifierMixin {
    @ModifyReturnValue(method = "shouldApply", at = @At("RETURN"))
    private boolean rockstar$removeDarknessFog(boolean original) {
        RemovalsModule module = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        return original && !(module.isEnabled() && module.internalMethod09454().isSelected());
    }
}
