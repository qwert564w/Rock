package rockstar.client.internal.core;



import rockstar.client.module.*;
import rockstar.client.*;
public final class CoreInternal068 {
   private final String internalField0248;
   private final ModuleCategory internalField0405;
   private final int internalField0227;
   private final boolean internalField0277;
   private final boolean internalField0276;
   private final String internalField0247;

   public CoreInternal068(String localValue1, ModuleCategory localValue2, int localValue3, boolean localValue4, boolean localValue5, String localValue6) {
      this.internalField0248 = localValue1;
      this.internalField0405 = localValue2;
      this.internalField0227 = localValue3;
      this.internalField0277 = localValue4;
      this.internalField0276 = localValue5;
      this.internalField0247 = localValue6;
   }

   @Override
   public final String toString() {
      return "typedParameter1029[name=" + this.internalField0248 + ", category=" + this.internalField0405 + ", key=" + this.internalField0227 + ", disableOnQuit=" + this.internalField0277 + ", enabledByDefault=" + this.internalField0276 + ", desc=" + this.internalField0247 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.internalField0248);
      result = 31 * result + java.util.Objects.hashCode(this.internalField0405);
      result = 31 * result + java.util.Objects.hashCode(this.internalField0227);
      result = 31 * result + java.util.Objects.hashCode(this.internalField0277);
      result = 31 * result + java.util.Objects.hashCode(this.internalField0276);
      result = 31 * result + java.util.Objects.hashCode(this.internalField0247);
      return result;
   }

   @Override
   public final boolean equals(Object localValue1) {
      if (this == localValue1) return true;
      if (localValue1 == null || getClass() != localValue1.getClass()) return false;
      CoreInternal068 other = (CoreInternal068) localValue1;
      return java.util.Objects.equals(this.internalField0248, other.internalField0248)
         && java.util.Objects.equals(this.internalField0405, other.internalField0405)
         && java.util.Objects.equals(this.internalField0227, other.internalField0227)
         && java.util.Objects.equals(this.internalField0277, other.internalField0277)
         && java.util.Objects.equals(this.internalField0276, other.internalField0276)
         && java.util.Objects.equals(this.internalField0247, other.internalField0247);
   }

   public String internalMethod02620() {
      return this.internalField0248;
   }

   public ModuleCategory internalMethod04744() {
      return this.internalField0405;
   }

   public int internalMethod07625() {
      return this.internalField0227;
   }

   public boolean internalMethod07626() {
      return this.internalField0277;
   }

   public boolean internalMethod07631() {
      return this.internalField0276;
   }

   public String internalMethod07264() {
      return this.internalField0247;
   }
}
