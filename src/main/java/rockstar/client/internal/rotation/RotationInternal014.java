package rockstar.client.internal.rotation;




import rockstar.client.rotation.*;
import rockstar.client.internal.config.*;
import rockstar.client.*;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class RotationInternal014 {
   private static final int internalField0227 = 13;
   private static final int internalField0228 = 0;
   private static final int internalField1053 = 1;
   private static final int internalField1055 = 2;
   private static final int internalField1056 = 3;
   private static final int internalField1054 = 4;
   private static final int internalField1464 = 5;
   private static final int internalField1470 = 6;
   private static final int internalField1465 = 7;
   private static final int internalField1463 = 8;
   private static final int internalField1466 = 9;
   private static final int internalField1467 = 10;
   private static final int internalField1469 = 11;
   private static final int internalField1468 = 12;
   private static final int internalField1740 = 160;
   private static final int internalField1741 = 16;
   private ConfigInternal035 internalField0577;
   private boolean internalField0277;
   private final Map<Integer, ArrayDeque<RotationInternal014.InternalType0138>> internalField0543 = new HashMap<>();

   public boolean internalMethod01080() {
      this.internalMethod08832();
      return this.internalField0577 != null;
   }

   public void internalMethod01079() {
      this.internalField0277 = false;
      this.internalField0577 = null;
      this.internalMethod08832();
   }

   private void internalMethod08832() {
      if (this.internalField0577 == null && !this.internalField0277) {
         this.internalField0277 = true;
         this.internalField0577 = ConfigInternal035.internalMethod06376(internalMethod04381());
      }
   }

   public static Path internalMethod04381() {
      return MinecraftClient.getInstance().runDirectory.toPath().resolve("Rockstar").resolve("posnet").resolve("model.posnet");
   }

   public void internalMethod04196(Iterable<? extends PlayerEntity> localValue1) {
      HashSet localValue2 = new HashSet();

      for (PlayerEntity localValue4 : localValue1) {
         if (localValue4.isAlive()) {
            localValue2.add(localValue4.getId());
            int localValue5 = (localValue4.isOnGround() ? 1 : 0) | (localValue4.isSneaking() ? 2 : 0) | (localValue4.isSprinting() ? 4 : 0) | (localValue4.isGliding() ? 8 : 0);
            ArrayDeque localValue6 = this.internalField0543.computeIfAbsent(localValue4.getId(), localValue0 -> new ArrayDeque<>());
            localValue6.addLast(new RotationInternal014.InternalType0138(localValue4.getX(), localValue4.getY(), localValue4.getZ(), localValue4.getYaw(), localValue4.getPitch(), localValue5));

            while (localValue6.size() > 160) {
               localValue6.removeFirst();
            }
         }
      }

      this.internalField0543.keySet().removeIf(localValue1x -> !localValue2.contains(localValue1x));
   }

   public void internalMethod01082() {
      this.internalField0543.clear();
   }

   public RotationInternal014.InternalType0371 internalMethod02733(PlayerEntity localValue1, int localValue2) {
      this.internalMethod08832();
      if (this.internalField0577 != null && localValue1 != null) {
         ArrayDeque<RotationInternal014.InternalType0138> localValue3 = this.internalField0543.get(localValue1.getId());
         if (localValue3 != null && localValue3.size() >= 16) {
            if (localValue2 <= 0) {
               localValue2 = Math.max(1, this.internalField0577.internalField1464);
            }

            RotationInternal014.InternalType0138[] localValue4 = localValue3.toArray(new RotationInternal014.InternalType0138[0]);
            int localValue5 = localValue4.length;
            int localValue6 = localValue5 - 1;
            int localValue7 = Math.min(localValue6, Math.max(16, this.internalField0577.internalField1054));
            int localValue8 = localValue6 - localValue7;
            float[][] localValue9 = new float[localValue7][13];

            for (int localValue10 = 0; localValue10 < localValue7; localValue10++) {
               localValue9[localValue10] = internalMethod06154(localValue4[localValue8 + localValue10], localValue4[localValue8 + localValue10 + 1]);
            }

            ConfigInternal035.InternalType0137 localValue41 = this.internalField0577.internalMethod04964(localValue9, localValue2);
            RotationInternal014.InternalType0138 localValue11 = localValue4[localValue5 - 1];
            Vec3d localValue12 = new Vec3d(localValue11.internalField0194, localValue11.internalField0193, localValue11.internalField1045);
            Box localValue13 = localValue1.getBoundingBox();
            double localValue14 = (localValue13.maxX - localValue13.minX) / 2.0;
            double localValue16 = localValue13.maxY - localValue13.minY;
            int localValue18 = localValue41.internalField0612.length;
            ArrayList<RotationInternal014.InternalType0139> localValue19 = new ArrayList<>(localValue18);
            double localValue20 = 0.0;
            double localValue22 = 0.0;
            double localValue24 = 0.0;
            double localValue26 = -1.0;
            Vec3d localValue28 = localValue12;

            for (int localValue29 = 0; localValue29 < localValue18; localValue29++) {
               ArrayList<Vec3d> localValue30 = new ArrayList<>(localValue2 + 1);
               localValue30.add(localValue12);
               double localValue31 = localValue11.internalField0194;
               double localValue33 = localValue11.internalField0193;
               double localValue35 = localValue11.internalField1045;

               for (int localValue37 = 0; localValue37 < localValue2; localValue37++) {
                  localValue31 += localValue41.internalField0089[localValue29][localValue37][0];
                  localValue33 += localValue41.internalField0089[localValue29][localValue37][1];
                  localValue35 += localValue41.internalField0089[localValue29][localValue37][2];
                  localValue30.add(new Vec3d(localValue31, localValue33, localValue35));
               }

               Vec3d localValue43 = new Vec3d(localValue31, localValue33, localValue35);
               Box localValue38 = new Box(localValue31 - localValue14, localValue33, localValue35 - localValue14, localValue31 + localValue14, localValue33 + localValue16, localValue35 + localValue14);
               double localValue39 = localValue41.internalField0612[localValue29];
               localValue19.add(new RotationInternal014.InternalType0139(localValue30, localValue43, localValue38, localValue39));
               localValue20 += localValue43.x * localValue39;
               localValue22 += localValue43.y * localValue39;
               localValue24 += localValue43.z * localValue39;
               if (localValue39 > localValue26) {
                  localValue26 = localValue39;
                  localValue28 = localValue43;
               }
            }

            localValue19.sort((localValue0, localValue1x) -> Double.compare(localValue1x.internalMethod01952(), localValue0.internalMethod01952()));
            Vec3d localValue42 = new Vec3d(localValue20, localValue22, localValue24);
            return new RotationInternal014.InternalType0371(localValue19, localValue12, localValue28, localValue42, localValue2);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private static float[] internalMethod06154(RotationInternal014.InternalType0138 localValue0, RotationInternal014.InternalType0138 localValue1) {
      float[] localValue2 = new float[13];
      double localValue3 = localValue1.internalField0194 - localValue0.internalField0194;
      double localValue5 = localValue1.internalField0193 - localValue0.internalField0193;
      double localValue7 = localValue1.internalField1045 - localValue0.internalField1045;
      localValue2[0] = (float)localValue3;
      localValue2[1] = (float)localValue5;
      localValue2[2] = (float)localValue7;
      localValue2[3] = (float)Math.hypot(localValue3, localValue7);
      localValue2[4] = (localValue1.internalField0227 & 1) != 0 ? 1.0F : 0.0F;
      localValue2[5] = (localValue1.internalField0227 & 2) != 0 ? 1.0F : 0.0F;
      localValue2[6] = (localValue1.internalField0227 & 4) != 0 ? 1.0F : 0.0F;
      localValue2[7] = (localValue1.internalField0227 & 8) != 0 ? 1.0F : 0.0F;
      double localValue9 = Math.toRadians(localValue1.internalField0205);
      double localValue11 = Math.toRadians(localValue1.internalField0206);
      localValue2[8] = (float)Math.sin(localValue9);
      localValue2[9] = (float)Math.cos(localValue9);
      localValue2[10] = (float)(internalMethod05858(localValue1.internalField0205 - localValue0.internalField0205) / 180.0);
      localValue2[11] = (float)Math.sin(localValue11);
      localValue2[12] = (float)Math.cos(localValue11);
      return localValue2;
   }

   private static double internalMethod05858(double localValue0) {
      localValue0 %= 360.0;
      if (localValue0 > 180.0) {
         localValue0 -= 360.0;
      }

      if (localValue0 < -180.0) {
         localValue0 += 360.0;
      }

      return localValue0;
   }

   static final class InternalType0138 {
      final double internalField0194;
      final double internalField0193;
      final double internalField1045;
      final float internalField0205;
      final float internalField0206;
      final int internalField0227;

      InternalType0138(double localValue1, double localValue3, double localValue5, float localValue7, float localValue8, int localValue9) {
         this.internalField0194 = localValue1;
         this.internalField0193 = localValue3;
         this.internalField1045 = localValue5;
         this.internalField0205 = localValue7;
         this.internalField0206 = localValue8;
         this.internalField0227 = localValue9;
      }
   }

   public static final class InternalType0139 {
      private final List<Vec3d> internalField0416;
      private final Vec3d internalField0283;
      private final Box internalField0681;
      private final double internalField0194;

      public InternalType0139(List<Vec3d> localValue1, Vec3d localValue2, Box localValue3, double localValue4) {
         this.internalField0416 = localValue1;
         this.internalField0283 = localValue2;
         this.internalField0681 = localValue3;
         this.internalField0194 = localValue4;
      }

      @Override
      public final String toString() {
         return "InternalType0139[path=" + this.internalField0416 + ", endPos=" + this.internalField0283 + ", endBox=" + this.internalField0681 + ", weight=" + this.internalField0194 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.internalField0416);
         result = 31 * result + java.util.Objects.hashCode(this.internalField0283);
         result = 31 * result + java.util.Objects.hashCode(this.internalField0681);
         result = 31 * result + java.util.Objects.hashCode(this.internalField0194);
         return result;
      }

      @Override
      public final boolean equals(Object localValue1) {
         if (this == localValue1) return true;
         if (localValue1 == null || getClass() != localValue1.getClass()) return false;
         RotationInternal014.InternalType0139 other = (RotationInternal014.InternalType0139) localValue1;
         return java.util.Objects.equals(this.internalField0416, other.internalField0416)
            && java.util.Objects.equals(this.internalField0283, other.internalField0283)
            && java.util.Objects.equals(this.internalField0681, other.internalField0681)
            && java.util.Objects.equals(this.internalField0194, other.internalField0194);
      }

      public List<Vec3d> internalMethod05424() {
         return this.internalField0416;
      }

      public Vec3d internalMethod03554() {
         return this.internalField0283;
      }

      public Box internalMethod00880() {
         return this.internalField0681;
      }

      public double internalMethod01952() {
         return this.internalField0194;
      }
   }

   public static final class InternalType0371 {
      private final List<RotationInternal014.InternalType0139> internalField0416;
      private final Vec3d internalField0283;
      private final Vec3d internalField0282;
      private final Vec3d internalField1104;
      private final int internalField0227;

      public InternalType0371(List<RotationInternal014.InternalType0139> localValue1, Vec3d localValue2, Vec3d localValue3, Vec3d localValue4, int localValue5) {
         this.internalField0416 = localValue1;
         this.internalField0283 = localValue2;
         this.internalField0282 = localValue3;
         this.internalField1104 = localValue4;
         this.internalField0227 = localValue5;
      }

      @Override
      public final String toString() {
         return "InternalType0371[hypotheses=" + this.internalField0416 + ", basePos=" + this.internalField0283 + ", mostLikelyEnd=" + this.internalField0282 + ", meanEnd=" + this.internalField1104 + ", steps=" + this.internalField0227 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.internalField0416);
         result = 31 * result + java.util.Objects.hashCode(this.internalField0283);
         result = 31 * result + java.util.Objects.hashCode(this.internalField0282);
         result = 31 * result + java.util.Objects.hashCode(this.internalField1104);
         result = 31 * result + java.util.Objects.hashCode(this.internalField0227);
         return result;
      }

      @Override
      public final boolean equals(Object localValue1) {
         if (this == localValue1) return true;
         if (localValue1 == null || getClass() != localValue1.getClass()) return false;
         RotationInternal014.InternalType0371 other = (RotationInternal014.InternalType0371) localValue1;
         return java.util.Objects.equals(this.internalField0416, other.internalField0416)
            && java.util.Objects.equals(this.internalField0283, other.internalField0283)
            && java.util.Objects.equals(this.internalField0282, other.internalField0282)
            && java.util.Objects.equals(this.internalField1104, other.internalField1104)
            && java.util.Objects.equals(this.internalField0227, other.internalField0227);
      }

      public List<RotationInternal014.InternalType0139> internalMethod00215() {
         return this.internalField0416;
      }

      public Vec3d internalMethod06534() {
         return this.internalField0283;
      }

      public Vec3d internalMethod03583() {
         return this.internalField0282;
      }

      public Vec3d internalMethod07822() {
         return this.internalField1104;
      }

      public int internalMethod05147() {
         return this.internalField0227;
      }
   }
}
