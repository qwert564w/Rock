package rockstar.client.internal.inventory;



import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.ItemStack;

public final class InventoryInternal004 {
   private final String internalField0248;
   private final int internalField0227;
   private final ItemStack internalField0878;
   private final CoreInternal039 internalField0459;

   public InventoryInternal004(String localValue1, int localValue2, ItemStack localValue3, CoreInternal039 localValue4) {
      this.internalField0248 = localValue1;
      this.internalField0227 = localValue2;
      this.internalField0878 = localValue3;
      this.internalField0459 = localValue4;
   }

   @Override
   public final String toString() {
      return "typedParameter1018[name=" + this.internalField0248 + ", key=" + this.internalField0227 + ", icon=" + this.internalField0878 + ", category=" + this.internalField0459 + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.internalField0248);
      result = 31 * result + java.util.Objects.hashCode(this.internalField0227);
      result = 31 * result + java.util.Objects.hashCode(this.internalField0878);
      result = 31 * result + java.util.Objects.hashCode(this.internalField0459);
      return result;
   }

   @Override
   public final boolean equals(Object localValue1) {
      if (this == localValue1) return true;
      if (localValue1 == null || getClass() != localValue1.getClass()) return false;
      InventoryInternal004 other = (InventoryInternal004) localValue1;
      return java.util.Objects.equals(this.internalField0248, other.internalField0248)
         && java.util.Objects.equals(this.internalField0227, other.internalField0227)
         && java.util.Objects.equals(this.internalField0878, other.internalField0878)
         && java.util.Objects.equals(this.internalField0459, other.internalField0459);
   }

   public String internalMethod04325() {
      return this.internalField0248;
   }

   public int internalMethod00960() {
      return this.internalField0227;
   }

   public ItemStack internalMethod01519() {
      return this.internalField0878;
   }

   public CoreInternal039 internalMethod04597() {
      return this.internalField0459;
   }
}
