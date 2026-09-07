package rockstar.client.internal.game;


import rockstar.client.*;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public final class GameInternal064 implements GameInternal065 {
   private final int internalField0227;

   public GameInternal064(int localValue1) {
      this.internalField0227 = localValue1;
   }

   @Override
   public boolean internalMethod05088(int localValue1, int localValue2, int localValue3) {
      return this.internalField0227 == localValue2;
   }

   @Override
   public double internalMethod05087(int localValue1, int localValue2, int localValue3) {
      return Math.abs(this.internalField0227 - localValue2);
   }

   @Nullable
   @Override
   public Vec3d internalMethod07298() {
      return null;
   }

   @Override
   public final String toString() {
      return "typedParameter1044[y=" + this.internalField0227 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.internalField0227);
      return result;
   }

   @Override
   public final boolean equals(Object localValue1) {
      if (this == localValue1) return true;
      if (localValue1 == null || getClass() != localValue1.getClass()) return false;
      GameInternal064 other = (GameInternal064) localValue1;
      return java.util.Objects.equals(this.internalField0227, other.internalField0227);
   }

   public int internalMethod06128() {
      return this.internalField0227;
   }
}
