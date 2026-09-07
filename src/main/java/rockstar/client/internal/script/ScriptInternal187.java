package rockstar.client.internal.script;



import rockstar.client.internal.core.*;
import rockstar.client.*;
import lombok.Generated;
import pyrock.utility.render.ColorRGBA;

public enum ScriptInternal187 {
   internalField0432(
      "success",
      new ColorRGBA(237.0F, 255.0F, 249.0F),
      new ColorRGBA(98.0F, 255.0F, 0.0F),
      new ColorRGBA(171.0F, 255.0F, 132.0F),
      CoreInternal120.internalField1662
   ),
   internalField0431("error", ColorRGBA.RED, ColorRGBA.RED, ColorRGBA.RED, CoreInternal120.internalField1665),
   internalField1151(
      "info",
      new ColorRGBA(234.0F, 179.0F, 8.0F),
      new ColorRGBA(234.0F, 179.0F, 8.0F),
      new ColorRGBA(234.0F, 179.0F, 8.0F),
      CoreInternal120.internalField1664
   );

   private final String internalField0248;
   private final ColorRGBA internalField0777;
   private final ColorRGBA internalField0776;
   private final ColorRGBA internalField1311;
   private final CoreInternal120 internalField0939;

   public static ScriptInternal187 internalMethod02036(String localValue0) {
      for (ScriptInternal187 localValue4 : values()) {
         if (localValue4.internalMethod06848().equalsIgnoreCase(localValue0)) {
            return localValue4;
         }
      }

      return internalField1151;
   }

   @Generated
   public String internalMethod06848() {
      return this.internalField0248;
   }

   @Generated
   public ColorRGBA internalMethod00111() {
      return this.internalField0777;
   }

   @Generated
   public ColorRGBA internalMethod04485() {
      return this.internalField0776;
   }

   @Generated
   public ColorRGBA internalMethod07827() {
      return this.internalField1311;
   }

   @Generated
   public CoreInternal120 internalMethod01298() {
      return this.internalField0939;
   }

   @Generated
   private ScriptInternal187(String localValue3, ColorRGBA localValue4, ColorRGBA localValue5, ColorRGBA localValue6, CoreInternal120 localValue7) {
      this.internalField0248 = localValue3;
      this.internalField0777 = localValue4;
      this.internalField0776 = localValue5;
      this.internalField1311 = localValue6;
      this.internalField0939 = localValue7;
   }
}
