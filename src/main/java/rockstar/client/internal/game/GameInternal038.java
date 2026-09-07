package rockstar.client.internal.game;


import rockstar.client.*;
import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import rockstar.client.MinecraftClientAccess;

public final class GameInternal038
implements MinecraftClientAccess {
    public static float internalMethod00077(Entity entity, PlayerEntity playerEntity) {
        Vec3d vec3d = new Vec3d(entity.getX(), entity.getY(), entity.getZ());
        Vec3d vec3d2 = playerEntity.getBoundingBox().getCenter();
        double d = vec3d2.distanceTo(vec3d);
        if (d < 0.5) {
            d = 0.0;
        }
        double d2 = 1.0 - MathHelper.clamp((double)(d / 6.0), (double)0.0, (double)1.0);
        boolean bl = playerEntity.getEntityWorld().raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)playerEntity)).getType() != HitResult.Type.MISS;
        float f = bl ? 0.7f : 1.0f;
        return (float)((double)f * (d2 * 24.0 + 1.0));
    }

    @Generated
    private GameInternal038() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

