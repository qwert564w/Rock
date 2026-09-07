package moscow.rockstar.mixin.minecraft.client.gui.overlay;



import rockstar.client.server.*;
import rockstar.client.rotation.*;
import moscow.rockstar.mixin.accessors.CameraAccessor;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.render.CameraUpdateEvent;
import rockstar.modules.player.FreeCameraModule;
import rockstar.modules.visual.RemovalsModule;
import rockstar.client.RockstarClient;
import rockstar.client.server.ServerUtils;
import rockstar.client.rotation.Rotation;
import rockstar.modules.combat.AuraModule;
import rockstar.modules.movement.SpeedModule;

@Mixin(value={Camera.class})
public abstract class CameraMixin {
    @Shadow
    private Entity field_18711;
    @Shadow
    private boolean field_18719;
    @Shadow
    private float field_18721;
    @Shadow
    private float field_18722;
    @Unique
    private static final int rockstar$JITTER_FLIPS = 3;
    @Unique
    private static final int rockstar$RESET_TICKS = 10;
    @Unique
    private float rockstar$lastEyeHeight;
    @Unique
    private boolean rockstar$eyeHeightKnown;
    @Unique
    private float rockstar$heldEyeHeight;
    @Unique
    private int rockstar$eyeHeightFlips;
    @Unique
    private int rockstar$ticksSinceFlip;

    @Shadow
    public abstract void method_19322(Vec3d localValue1);

    @Shadow
    public abstract void method_19325(float localValue1, float localValue2);

    @Inject(method={"updateEyeHeight"}, at={@At(value="HEAD")}, cancellable=true)
    private void rockstar$stabilizeEyeHeight(CallbackInfo callbackInfo) {
        if (this.field_18711 == null) {
            return;
        }
        float f = CameraMixin.rockstar$eyeHeight(this.field_18711);
        if (!this.field_18711.isTouchingWater() || !CameraMixin.rockstar$auraOnHolyWorld()) {
            this.rockstar$eyeHeightKnown = false;
            this.rockstar$eyeHeightFlips = 0;
            this.rockstar$ticksSinceFlip = 0;
            this.rockstar$heldEyeHeight = f;
            this.field_18722 = this.field_18721;
            this.field_18721 += (f - this.field_18721) * 0.5f;
            callbackInfo.cancel();
            return;
        }
        if (!this.rockstar$eyeHeightKnown) {
            this.rockstar$eyeHeightKnown = true;
            this.rockstar$lastEyeHeight = f;
            this.rockstar$heldEyeHeight = f;
        }
        if (Math.abs(f - this.rockstar$lastEyeHeight) > 1.0E-4f) {
            this.rockstar$lastEyeHeight = f;
            this.rockstar$ticksSinceFlip = 0;
            ++this.rockstar$eyeHeightFlips;
        } else if (++this.rockstar$ticksSinceFlip >= 10) {
            this.rockstar$eyeHeightFlips = 0;
        }
        this.rockstar$heldEyeHeight = this.rockstar$eyeHeightFlips >= 3 ? Math.max(this.rockstar$heldEyeHeight, f) : f;
        this.field_18722 = this.field_18721;
        this.field_18721 += (this.rockstar$heldEyeHeight - this.field_18721) * 0.5f;
        callbackInfo.cancel();
    }

    @Unique
    private static boolean rockstar$auraOnHolyWorld() {
        AuraModule internalValue0004 = RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class);
        return internalValue0004 != null && internalValue0004.isEnabled() && ServerUtils.internalMethod08700();
    }

    @Unique
    private static float rockstar$eyeHeight(Entity entity) {
        if (entity == MinecraftClient.getInstance().player && entity.getPose() == EntityPose.GLIDING && SpeedModule.internalMethod09257()) {
            return entity.getDimensions(EntityPose.STANDING).eyeHeight();
        }
        return entity.getStandingEyeHeight();
    }

    @Inject(method={"getSubmersionType"}, at={@At(value="HEAD")}, cancellable=true)
    private void getSubmergedFluidState(CallbackInfoReturnable<CameraSubmersionType> callbackInfoReturnable) {
        RemovalsModule typedValue322 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (typedValue322 == null || !typedValue322.isEnabled()) {
            return;
        }
        if (typedValue322.internalMethod09499().isSelected()) {
            callbackInfoReturnable.setReturnValue(CameraSubmersionType.NONE);
            return;
        }
        if (this.field_18719 && typedValue322.internalMethod08111().isSelected() && !this.rockstar$focusedEntitySubmerged()) {
            callbackInfoReturnable.setReturnValue(CameraSubmersionType.NONE);
        }
    }

    @Unique
    private boolean rockstar$focusedEntitySubmerged() {
        return this.field_18711 != null && (this.field_18711.isSubmergedInWater() || this.field_18711.isInLava() || this.field_18711.inPowderSnow);
    }

    @Inject(method={"clipToSpace"}, at={@At(value="HEAD")}, cancellable=true)
    private void onClipToSpace(float f, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        RemovalsModule typedValue322 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        if (typedValue322.internalMethod08111().isSelected() && typedValue322.isEnabled()) {
            callbackInfoReturnable.setReturnValue(Float.valueOf(f));
        }
    }

    @Inject(method={"update"}, at={@At(value="TAIL")})
    private void onUpdate(World world, Entity entity, boolean bl, boolean bl2, float f, CallbackInfo callbackInfo) {
        FreeCameraModule typedValue262 = RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class);
        typedValue262.internalMethod09311();
        if (typedValue262.internalMethod09312()) {
            this.method_19322(typedValue262.internalMethod05835(f));
            Rotation typedValue266 = typedValue262.internalMethod02039(f);
            this.method_19325(typedValue266.internalMethod00169(), typedValue266.internalMethod00171());
            ((CameraAccessor)((Object)this)).setThirdPerson(true);
            return;
        }
        RockstarClient.getInstance().internalMethod03317().internalMethod06883(new CameraUpdateEvent((Camera)(Object)this, entity, bl, bl2, f));
    }
}
