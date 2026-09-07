package rockstar.client.internal.inventory;



import rockstar.client.rotation.*;
import rockstar.client.*;
import rockstar.client.util.LegacyItemTypes;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.EquipmentSlot.Type;
import net.minecraft.entity.decoration.DisplayEntity.TextDisplayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.text.MutableText;
import net.minecraft.text.PlainTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public final class InventoryInternal029 implements MinecraftClientAccess {
   public static Text internalMethod06117(Text localValue0, String localValue1) {
      return localValue0 instanceof MutableText localValue2 ? internalMethod04110(localValue2.copy(), localValue1) : internalMethod04110(localValue0.copy(), localValue1);
   }

   private static MutableText internalMethod04110(MutableText localValue0, String localValue1) {
      if (localValue0.getContent() instanceof PlainTextContent localValue2) {
         String localValue3 = localValue2.string();
         if (localValue3.contains(localValue1)) {
            String localValue11 = localValue3.replace(localValue1, "");
            MutableText localValue14 = Text.literal(localValue11);
            localValue14.setStyle(localValue0.getStyle());

            for (Text localValue17 : localValue0.getSiblings()) {
               localValue14.append(internalMethod06117(localValue17, localValue1));
            }

            return localValue14;
         }
      }

      MutableText localValue8 = Text.empty().setStyle(localValue0.getStyle());
      localValue8.append(localValue0.copy());
      ArrayList localValue9 = new ArrayList();

      for (Text localValue5 : localValue0.getSiblings()) {
         Text localValue6 = internalMethod06117(localValue5, localValue1);
         if (!localValue6.getString().isEmpty()) {
            localValue9.add(localValue6);
         }
      }

      MutableText localValue10 = Text.empty().setStyle(localValue0.getStyle());
      String localValue12 = internalMethod04740(localValue0);
      if (!localValue12.isEmpty()) {
         localValue12 = localValue12.replace(localValue1, "");
         if (!localValue12.isEmpty()) {
            localValue10.append(Text.literal(localValue12).setStyle(localValue0.getStyle()));
         }
      }

      for (Text localValue7 : (Iterable<Text>)(Iterable<?>)localValue9) {
         localValue10.append(localValue7);
      }

      return localValue10;
   }

   private static String internalMethod04740(Text localValue0) {
      return localValue0.getContent() instanceof PlainTextContent localValue1 ? localValue1.string() : "";
   }

   public static void internalMethod01626() {
      for (Entity localValue1 : internalField0149.world.getPlayers()) {
         if (localValue1 instanceof PlayerEntity localValue2) {
            internalMethod00448(localValue2);
         }
      }
   }

   private static void internalMethod07027(PlayerEntity localValue0) {
      for (EquipmentSlot localValue4 : EquipmentSlot.values()) {
         if (localValue4.getType() == Type.HUMANOID_ARMOR || localValue4 == EquipmentSlot.MAINHAND || localValue4 == EquipmentSlot.OFFHAND) {
            ItemStack localValue5 = localValue0.getEquippedStack(localValue4);
            if (!localValue5.isEmpty()) {
               localValue0.getInventory().insertStack(localValue5.copy());
               localValue0.equipStack(localValue4, ItemStack.EMPTY);
            }
         }
      }
   }

   private static void internalMethod00448(PlayerEntity localValue0) {
      for (EquipmentSlot localValue4 : EquipmentSlot.values()) {
         if (localValue4.getType() == Type.HUMANOID_ARMOR) {
            ItemStack localValue5 = localValue0.getEquippedStack(localValue4);
            if (!localValue5.isEmpty()) {
               localValue0.getInventory().insertStack(localValue5.copy());
               localValue0.equipStack(localValue4, ItemStack.EMPTY);
            }
         }
      }
   }

   public static boolean internalMethod05874(String localValue0) {
      MinecraftClient localValue1 = MinecraftClient.getInstance();
      ClientPlayNetworkHandler localValue2 = localValue1.getNetworkHandler();
      if (localValue2 == null) {
         return false;
      } else {
         for (PlayerListEntry localValue4 : localValue2.getPlayerList()) {
            if (localValue4.getProfile().name().equals(localValue0)) {
               return true;
            }
         }

         return false;
      }
   }

   public static String internalMethod01278(String localValue0) {
      try {
         ResourceManager localValue1 = internalField0149.getResourceManager();
         Identifier localValue2 = Identifier.of("minecraft", "models/item/" + localValue0.replace("minecraft:", "") + ".json");
         Optional localValue3 = localValue1.getResource(localValue2);
         if (localValue3.isPresent()) {
            String localValue5;
            try (BufferedReader localValue4 = ((Resource)localValue3.get()).getReader()) {
               localValue5 = localValue4.lines().collect(Collectors.joining("\n"));
            }

            return localValue5;
         } else {
            return null;
         }
      } catch (Exception localValue9) {
         System.err
            .println(
               "\u041e\u0448\u0438\u0431\u043a\u0430 \u043f\u0440\u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0438 \u0441\u0435\u0440\u0432\u0435\u0440\u043d\u043e\u0439 \u043c\u043e\u0434\u0435\u043b\u0438: "
                  + localValue9.getMessage()
            );
         return null;
      }
   }

   public static String internalMethod05031(ItemStack localValue0, WrapperLookup localValue1) {
      NbtCompound localValue3 = LegacyItemTypes.toNbtAllowEmpty(localValue0, localValue1);
      if (localValue3.contains("components")) {
         NbtCompound localValue4 = localValue3.getCompound("components").orElseGet(net.minecraft.nbt.NbtCompound::new);
         if (localValue4.contains("minecraft:item_model")) {
            return localValue4.getString("minecraft:item_model").orElse("");
         }
      }

      return null;
   }

   public static boolean internalMethod03594(Entity localValue0, ClientWorld localValue1, double localValue2) {
      for (Entity localValue5 : localValue1.getEntities()) {
         if (localValue5 instanceof TextDisplayEntity localValue6 && localValue6.getText() != null && !localValue6.getText().getString().isEmpty() && localValue0.distanceTo(localValue6) < localValue2) {
            return true;
         }
      }

      return false;
   }

   public static Rotation internalMethod01437(Vec3d localValue0) {
      Vec3d localValue1 = internalField0149.player.getEyePos();
      double localValue2 = localValue0.x - localValue1.x;
      double localValue4 = localValue0.y - localValue1.y;
      double localValue6 = localValue0.z - localValue1.z;
      double localValue8 = Math.sqrt(localValue2 * localValue2 + localValue6 * localValue6);
      float localValue10 = (float)(Math.toDegrees(Math.atan2(localValue6, localValue2)) - 90.0);
      float localValue11 = (float)(-Math.toDegrees(Math.atan2(localValue4, localValue8)));
      return new Rotation(localValue10, localValue11);
   }

   @Generated
   private InventoryInternal029() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
