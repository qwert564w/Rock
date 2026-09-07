package rockstar.client.internal.script;



import rockstar.client.render.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.ModelPartAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import pyrock.utility.render.ColorRGBA;

public final class ScriptInternal145 {
   public static List<ScriptInternal145.InternalType0132> internalMethod00527(LivingEntity localValue0) {
      ArrayList localValue1 = new ArrayList();
      MinecraftClient localValue2 = MinecraftClient.getInstance();
      EntityRenderManager localValue3 = localValue2.getEntityRenderDispatcher();
      if (!(localValue3.getRenderer(localValue0) instanceof LivingEntityRenderer<?, ?, ?> localValue5)) {
         return localValue1;
      } else {
         EntityModel<?> localValue6 = localValue5.getModel();
         MatrixStack localValue7 = new MatrixStack();
         float localValue8 = localValue2.getRenderTickCounter().getTickProgress(true);
         Vec3d localValue9 = localValue0.getLerpedPos(localValue8);
         localValue7.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-localValue0.bodyYaw + 180.0F));
         internalMethod02380(localValue6.getRootPart(), localValue7, localValue1, localValue9, "root");
         return localValue1;
      }
   }

   private static void internalMethod02380(ModelPart localValue0, MatrixStack localValue1, List<ScriptInternal145.InternalType0132> localValue2, Vec3d localValue3, String localValue4) {
      localValue1.push();
      localValue0.applyTransform(localValue1);
      localValue0.forEachCuboid(
         localValue1,
         (localValue2x, localValue3x, localValue4x, localValue5x) -> {
            Matrix4f localValue6 = localValue2x.getPositionMatrix();
            Vec3d[] localValue7x = new Vec3d[8];
            Vector3f[] localValue8 = new Vector3f[]{
               new Vector3f(localValue5x.minX, localValue5x.minY, localValue5x.minZ),
               new Vector3f(localValue5x.maxX, localValue5x.minY, localValue5x.minZ),
               new Vector3f(localValue5x.minX, localValue5x.maxY, localValue5x.minZ),
               new Vector3f(localValue5x.maxX, localValue5x.maxY, localValue5x.minZ),
               new Vector3f(localValue5x.minX, localValue5x.minY, localValue5x.maxZ),
               new Vector3f(localValue5x.maxX, localValue5x.minY, localValue5x.maxZ),
               new Vector3f(localValue5x.minX, localValue5x.maxY, localValue5x.maxZ),
               new Vector3f(localValue5x.maxX, localValue5x.maxY, localValue5x.maxZ)
            };

            for (int localValue9 = 0; localValue9 < 8; localValue9++) {
               Vector3f localValue10 = new Vector3f(localValue8[localValue9]);
               localValue6.transformPosition(localValue10);
               double localValue11 = 0.0625;
               localValue7x[localValue9] = new Vec3d(localValue3.x + localValue10.x * localValue11, localValue3.y + localValue10.y * localValue11, localValue3.z + localValue10.z * localValue11);
            }

            localValue2.add(new ScriptInternal145.InternalType0132(localValue7x, localValue3x));
         }
      );
      ModelPartAccessor localValue5 = (ModelPartAccessor)(Object)localValue0;

      for (Entry localValue7 : localValue5.rockstar$getChildren().entrySet()) {
         internalMethod02380((ModelPart)localValue7.getValue(), localValue1, localValue2, localValue3, localValue4 + "." + (String)localValue7.getKey());
      }

      localValue1.pop();
   }

   public static void internalMethod01070(ScriptInternal145.InternalType0132 localValue0, VertexConsumer localValue1, MatrixStack localValue2, ColorRGBA localValue3) {
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[0], localValue0.internalField0724[1], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[1], localValue0.internalField0724[3], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[3], localValue0.internalField0724[2], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[2], localValue0.internalField0724[0], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[4], localValue0.internalField0724[5], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[5], localValue0.internalField0724[7], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[7], localValue0.internalField0724[6], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[6], localValue0.internalField0724[4], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[0], localValue0.internalField0724[4], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[1], localValue0.internalField0724[5], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[2], localValue0.internalField0724[6], localValue3);
      internalMethod06480(localValue2, localValue1, localValue0.internalField0724[3], localValue0.internalField0724[7], localValue3);
   }

   private static void internalMethod06480(MatrixStack localValue0, VertexConsumer localValue1, Vec3d localValue2, Vec3d localValue3, ColorRGBA localValue4) {
      Render3DUtils.internalMethod06927(localValue0, localValue1, localValue2, localValue3, localValue4);
   }

   @Generated
   private ScriptInternal145() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static class InternalType0132 {
      public Vec3d[] internalField0724;
      public String internalField0248;

      public InternalType0132(Vec3d[] localValue1, String localValue2) {
         this.internalField0724 = localValue1;
         this.internalField0248 = localValue2;
      }

      public Vec3d internalMethod04808() {
         double localValue1 = 0.0;
         double localValue3 = 0.0;
         double localValue5 = 0.0;

         for (Vec3d localValue10 : this.internalField0724) {
            localValue1 += localValue10.x;
            localValue3 += localValue10.y;
            localValue5 += localValue10.z;
         }

         return new Vec3d(localValue1 / 8.0, localValue3 / 8.0, localValue5 / 8.0);
      }

      public boolean internalMethod06851(Vec3d localValue1) {
         double localValue2 = Double.MAX_VALUE;
         double localValue4 = Double.MAX_VALUE;
         double localValue6 = Double.MAX_VALUE;
         double localValue8 = -Double.MAX_VALUE;
         double localValue10 = -Double.MAX_VALUE;
         double localValue12 = -Double.MAX_VALUE;

         for (Vec3d localValue17 : this.internalField0724) {
            localValue2 = Math.min(localValue2, localValue17.x);
            localValue4 = Math.min(localValue4, localValue17.y);
            localValue6 = Math.min(localValue6, localValue17.z);
            localValue8 = Math.max(localValue8, localValue17.x);
            localValue10 = Math.max(localValue10, localValue17.y);
            localValue12 = Math.max(localValue12, localValue17.z);
         }

         return localValue1.x >= localValue2 && localValue1.x <= localValue8 && localValue1.y >= localValue4 && localValue1.y <= localValue10 && localValue1.z >= localValue6 && localValue1.z <= localValue12;
      }
   }
}
