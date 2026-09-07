package rockstar.client.internal.script;




import rockstar.client.event.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lombok.Generated;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import pyrock.events.render.HudRenderEvent;
import pyrock.utility.render.ColorRGBA;

public class ScriptInternal186 {
   private final List<ScriptInternal185> internalField0416 = new ArrayList<>();
   private final EventListener<HudRenderEvent> internalField0157 = localValue1 -> {
      EnumMap localValue2 = new EnumMap<>(ScriptInternal186.InternalType0113.class);

      for (ScriptInternal186.InternalType0113 localValue6 : ScriptInternal186.InternalType0113.values()) {
         localValue2.put(localValue6, 0.0F);
      }

      for (ScriptInternal185 localValue8 : this.internalField0416) {
         ScriptInternal186.InternalType0113 localValue9 = internalMethod07425(localValue8);
         float localValue10 = (Float)localValue2.get(localValue9);
         localValue8.internalMethod01988();
         localValue8.internalMethod06653(localValue1.getContext(), localValue10);
         if (localValue8.internalField0808.internalMethod02881() >= 0.5F) {
            localValue2.put(localValue9, localValue10 + 30.0F);
         }
      }

      this.internalField0416.removeIf(ScriptInternal185::internalMethod01989);
   };

   public ScriptInternal186() {
      RockstarClient.getInstance().internalMethod03317().internalMethod00647(this);
   }

   public final void internalMethod05599(ScriptInternal187 localValue1, String localValue2) {
      this.internalField0416.add(new ScriptInternal189(localValue1, localValue2));
   }

   public final void internalMethod05519(ScriptInternal187 localValue1, String localValue2, String localValue3) {
      this.internalField0416.add(new ScriptInternal188(localValue1, localValue2, localValue3));
   }

   public final void internalMethod01571(Packets.InternalType0451 localValue1, String localValue2) {
      if (MinecraftClientAccess.internalField0149.player != null) {
         this.internalField0416.add(new ScriptInternal079(localValue1, localValue2));
         CoreInternal125.internalField1017.internalMethod03864(1.0F);
      }
   }

   public final void internalMethod06281(String localValue1, ItemStack localValue2) {
      this.internalField0416.add(new ScriptInternal080(localValue1, localValue2));
   }

   public final void internalMethod02479(String localValue1, String localValue2, RegistryEntry<StatusEffect> localValue3) {
      this.internalField0416.add(new ScriptInternal080(localValue1, localValue2, localValue3));
   }

   public final void internalMethod00760(String localValue1, String localValue2, ItemStack localValue3, ColorRGBA localValue4) {
      this.internalField0416.add(new ScriptInternal080(localValue1, localValue2, localValue3, localValue4));
   }

   public final void internalMethod06838(String localValue1, String localValue2, ItemStack localValue3) {
      this.internalField0416.add(new ScriptInternal080(localValue1, localValue2, localValue3));
   }

   private static ScriptInternal186.InternalType0113 internalMethod07425(ScriptInternal185 localValue0) {
      if (localValue0 instanceof ScriptInternal079) {
         return ScriptInternal186.InternalType0113.internalField1305;
      } else {
         return localValue0 instanceof ScriptInternal188 ? ScriptInternal186.InternalType0113.internalField0760 : ScriptInternal186.InternalType0113.internalField0759;
      }
   }

   @Generated
   public List<ScriptInternal185> internalMethod04949() {
      return this.internalField0416;
   }

   @Generated
   public EventListener<HudRenderEvent> internalMethod07397() {
      return this.internalField0157;
   }

   static enum InternalType0113 {
      internalField0759,
      internalField0760,
      internalField1305;
   }
}
