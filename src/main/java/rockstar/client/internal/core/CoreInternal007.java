package rockstar.client.internal.core;


import rockstar.client.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.profile.Profile;

public class CoreInternal007 {
   public static void internalMethod01636() {
      RockstarClient.internalField0240.initialize();
   }

   public static void internalMethod01639() {
      RockstarClient.internalField0240.shutdown();
   }

   public static void internalMethod06700(CallbackInfoReturnable<String> localValue0) {
      if (!RockstarClient.internalField0240.internalMethod06896()) {
         String localValue1 = "%s %s (%s) \u2014 %s".formatted("Rockstar", "2.1", "Alpha", Profile.getUsername());
         localValue0.setReturnValue(localValue1);
      }
   }
}
