package rockstar.client.internal.core;


import rockstar.client.*;
import lombok.Generated;

public enum CoreInternal120 {
   internalField0939(CoreInternal121.internalField0942),
   internalField0940(CoreInternal121.internalField0942),
   internalField1395(CoreInternal121.internalField0942),
   internalField1394(CoreInternal121.internalField0942),
   internalField1393(CoreInternal121.internalField0942),
   internalField1392(CoreInternal121.internalField0941),
   internalField1668(CoreInternal121.internalField0941),
   internalField1669(CoreInternal121.internalField0941),
   internalField1666(CoreInternal121.internalField0941),
   internalField1667(CoreInternal121.internalField0941),
   internalField1662(CoreInternal121.internalField1396),
   internalField1665(CoreInternal121.internalField1396),
   internalField1664(CoreInternal121.internalField1396),
   internalField1663(CoreInternal121.internalField0942);

   private final CoreInternal121 internalField0942;
   public final float internalField0205;

   private CoreInternal120(CoreInternal121 localValue3) {
      this.internalField0942 = localValue3;
      this.internalField0205 = localValue3.internalField0205;
      localValue3.internalField0205 = localValue3.internalField0205 + localValue3.internalMethod08819();
   }

   @Generated
   public CoreInternal121 internalMethod03213() {
      return this.internalField0942;
   }

   @Generated
   public float internalMethod01651() {
      return this.internalField0205;
   }
}
