package rockstar.client.internal.core;



import rockstar.client.module.*;
import rockstar.client.*;
import lombok.Generated;

public enum CoreInternal082 {
   internalField0377("Combat", ModuleCategory.COMBAT, CoreInternal120.internalField0939, CoreInternal120.internalField1392),
   internalField0376("Movement", ModuleCategory.MOVEMENT, CoreInternal120.internalField0940, CoreInternal120.internalField1668),
   internalField1137("Visuals", ModuleCategory.VISUALS, CoreInternal120.internalField1395, CoreInternal120.internalField1669),
   internalField1139("Player", ModuleCategory.PLAYER, CoreInternal120.internalField1394, CoreInternal120.internalField1666),
   internalField1138("Other", ModuleCategory.OTHER, CoreInternal120.internalField1393, CoreInternal120.internalField1667);

   private final String internalField0248;
   private final ModuleCategory internalField0405;
   private final CoreInternal120 internalField0939;
   private final CoreInternal120 internalField0940;
   private CoreInternal123 internalField0944;

   @Generated
   public String internalMethod02856() {
      return this.internalField0248;
   }

   @Generated
   public ModuleCategory internalMethod03547() {
      return this.internalField0405;
   }

   @Generated
   public CoreInternal120 internalMethod00605() {
      return this.internalField0939;
   }

   @Generated
   public CoreInternal120 internalMethod01333() {
      return this.internalField0940;
   }

   @Generated
   public CoreInternal123 internalMethod00607() {
      return this.internalField0944;
   }

   @Generated
   private CoreInternal082(String localValue3, ModuleCategory localValue4, CoreInternal120 localValue5, CoreInternal120 localValue6) {
      this.internalField0248 = localValue3;
      this.internalField0405 = localValue4;
      this.internalField0939 = localValue5;
      this.internalField0940 = localValue6;
   }

   @Generated
   public void internalMethod03186(CoreInternal123 localValue1) {
      this.internalField0944 = localValue1;
   }
}
