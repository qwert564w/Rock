package rockstar.modules.other;






import rockstar.client.util.*;
import rockstar.client.setting.*;
import rockstar.client.server.*;
import rockstar.client.module.*;
import rockstar.client.event.*;
import rockstar.client.*;
import rockstar.client.module.Module;

import java.util.Locale;
import java.util.regex.Pattern;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import pyrock.events.game.WorldChangeEvent;

@ModuleInfo(
   name = "Adminsky",
   category = ModuleCategory.OTHER,
   internalMethod09633 = "modules.descriptions.adminsky"
)
public class AdminskyModule extends Module {
   private static final String internalField0248 = "shard.ac";
   private static final String internalField0247 = "test bots";
   private static final String internalField1077 = "sloth monitor";
   private static final Pattern internalField0293 = Pattern.compile(
      "\u0438\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u0435\\s*:\\s*\u0432\u043a\u043b\u044e\u0447\u0435\u043d\u043e"
   );
   private static final Pattern internalField0294 = Pattern.compile("\u0432\u0435\u0440\u043d\u0443\u0442\u044c\\s+\u0432\\s+\u0438\u0433\u0440\u0443");
   private static final double internalField0194 = 5.0;
   private static final long internalField0229 = 2000L;
   private static final long internalField0230 = 5000L;
   private static final long internalField1059 = 600L;
   private static final int internalField0227 = 3;
   private static final int internalField0228 = 20;
   private BooleanSetting internalField0650;
   private final Stopwatch internalField0519 = new Stopwatch();
   private AdminskyModule.InternalType0402 internalField0843;
   private RegistryKey<World> internalField0595;
   private Vec3d internalField0283;
   private int internalField1053;
   private int internalField1055;
   private final EventListener<WorldChangeEvent> internalField0157;

   public AdminskyModule() {
      this.internalField0843 = AdminskyModule.InternalType0402.internalField0843;
      this.internalField0283 = Vec3d.ZERO;
      this.internalField0157 = localValue1 -> {
         if (this.internalField0843 == AdminskyModule.InternalType0402.internalField1346) {
            this.internalMethod09534();
         } else {
            this.internalField0843 = AdminskyModule.InternalType0402.internalField0843;
         }
      };
      this.internalMethod09334();
   }

   private void internalMethod09334() {
      this.internalField0650 = new BooleanSetting(this, this.internalMethod05374("auto_sloth"));
   }

   @Override
   public void internalMethod08229() {
      if (!this.internalField0650.internalMethod04496()) {
         this.internalField0843 = AdminskyModule.InternalType0402.internalField0843;
      } else if (internalField0149.player != null
         && internalField0149.world != null
         && internalField0149.interactionManager != null
         && ServerUtils.internalMethod06501("shard.ac")) {
         switch (this.internalField0843) {
            case internalField0843:
               this.internalMethod09335();
               break;
            case internalField0844:
               this.internalMethod09526();
               break;
            case internalField1346:
               this.internalMethod09527();
               break;
            case internalField1345:
               this.internalMethod09535();
               break;
            case internalField1344:
               this.internalMethod09952();
               break;
            case internalField1343:
               this.internalMethod09953();
               break;
            case internalField1633:
               this.internalMethod09954();
            case internalField1632:
         }
      }
   }

   private void internalMethod09335() {
      this.internalField0843 = AdminskyModule.InternalType0402.internalField0844;
      this.internalField1053 = 0;
      this.internalField1055 = 0;
      this.internalField0519.internalMethod00701();
   }

   private void internalMethod09526() {
      if (this.internalField0519.internalMethod02365(2000L)) {
         Entity localValue1 = this.internalMethod07336();
         if (localValue1 != null) {
            if (internalField0149.targetedEntity != localValue1 && this.internalField1055++ < 20) {
               this.internalMethod04667(localValue1);
            } else {
               this.internalField0595 = internalField0149.world.getRegistryKey();
               this.internalField0283 = internalField0149.player.getEntityPos();
               this.internalMethod06803(localValue1);
               RockstarClient.internalField0572
                  .info(
                     "[Adminsky] \u043a\u043b\u0438\u043a \u043f\u043e NPC {} \u0432 {} \u0431\u043b\u043e\u043a\u0430\u0445",
                     localValue1.getName().getString(),
                     internalField0149.player.distanceTo(localValue1)
                  );
               this.internalField0843 = AdminskyModule.InternalType0402.internalField1346;
               this.internalField0519.internalMethod00701();
            }
         }
      }
   }

   private void internalMethod06803(Entity localValue1) {
      EntityHitResult localValue2 = new EntityHitResult(localValue1, localValue1.getBoundingBox().getCenter());
      if (!internalField0149.interactionManager.interactEntityAtLocation(internalField0149.player, localValue1, localValue2, Hand.MAIN_HAND).isAccepted()) {
         internalField0149.interactionManager.interactEntity(internalField0149.player, localValue1, Hand.MAIN_HAND);
      }
   }

   private void internalMethod04667(Entity localValue1) {
      Vec3d localValue2 = internalField0149.player.getEyePos();
      Vec3d localValue3 = localValue1.getBoundingBox().getCenter();
      double localValue4 = localValue3.x - localValue2.x;
      double localValue6 = localValue3.y - localValue2.y;
      double localValue8 = localValue3.z - localValue2.z;
      internalField0149.player.setYaw((float)(Math.toDegrees(Math.atan2(localValue8, localValue4)) - 90.0));
      internalField0149.player.setPitch((float)(-Math.toDegrees(Math.atan2(localValue6, Math.sqrt(localValue4 * localValue4 + localValue8 * localValue8)))));
   }

   private void internalMethod09527() {
      if (internalField0149.world.getRegistryKey().equals(this.internalField0595)
         && !(internalField0149.player.getEntityPos().squaredDistanceTo(this.internalField0283) > 4096.0)) {
         if (this.internalField0519.internalMethod02365(5000L)) {
            this.internalField0843 = AdminskyModule.InternalType0402.internalField0844;
            this.internalField1055 = 0;
            this.internalField0519.internalMethod00701();
         }
      } else {
         this.internalMethod09534();
      }
   }

   private void internalMethod09534() {
      this.internalField0843 = AdminskyModule.InternalType0402.internalField1345;
      this.internalField1053 = 0;
      this.internalField0519.internalMethod00701();
   }

   private void internalMethod09535() {
      if (this.internalField0519.internalMethod02365(2000L)) {
         if (this.internalField1053++ >= 3) {
            this.internalField0843 = AdminskyModule.InternalType0402.internalField1632;
         } else {
            internalField0149.player.networkHandler.sendChatCommand("test bots");
            RockstarClient.internalField0572.info("[Adminsky] \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e /{}", "test bots");
            this.internalField0843 = AdminskyModule.InternalType0402.internalField1344;
            this.internalField0519.internalMethod00701();
         }
      }
   }

   private void internalMethod09952() {
      ScreenHandler localValue1 = this.internalMethod01765();
      if (localValue1 == null) {
         if (this.internalField0519.internalMethod02365(5000L)) {
            this.internalField0843 = AdminskyModule.InternalType0402.internalField1345;
            this.internalField0519.internalMethod00701();
         }
      } else {
         int localValue2 = this.internalMethod01254(localValue1);
         if (localValue2 < 0) {
            if (this.internalField0519.internalMethod02365(5000L)) {
               this.internalField0843 = AdminskyModule.InternalType0402.internalField1632;
            }
         } else {
            internalField0149.interactionManager.clickSlot(localValue1.syncId, localValue2, 0, SlotActionType.PICKUP, internalField0149.player);
            RockstarClient.internalField0572
               .info("[Adminsky] \u0432\u044b\u0431\u0440\u0430\u043d \u0431\u043e\u0442 \u0432 \u0441\u043b\u043e\u0442\u0435 {}", localValue2);
            this.internalField0843 = AdminskyModule.InternalType0402.internalField1343;
            this.internalField0519.internalMethod00701();
         }
      }
   }

   private void internalMethod09953() {
      ScreenHandler localValue1 = this.internalMethod01765();
      int localValue2 = localValue1 == null ? -1 : this.internalMethod00343(localValue1);
      if (localValue2 < 0) {
         if (this.internalField0519.internalMethod02365(5000L)) {
            this.internalField0843 = AdminskyModule.InternalType0402.internalField1633;
            this.internalField0519.internalMethod00701();
         }
      } else {
         internalField0149.interactionManager.clickSlot(localValue1.syncId, localValue2, 0, SlotActionType.PICKUP, internalField0149.player);
         RockstarClient.internalField0572
            .info(
               "[Adminsky] \u043a\u043d\u043e\u043f\u043a\u0430 \u00ab\u0412\u0435\u0440\u043d\u0443\u0442\u044c \u0432 \u0438\u0433\u0440\u0443\u00bb \u0432 \u0441\u043b\u043e\u0442\u0435 {}",
               localValue2
            );
         this.internalField0843 = AdminskyModule.InternalType0402.internalField1633;
         this.internalField0519.internalMethod00701();
      }
   }

   private void internalMethod09954() {
      if (this.internalField0519.internalMethod02365(600L)) {
         internalField0149.player.networkHandler.sendChatCommand("sloth monitor");
         RockstarClient.internalField0572.info("[Adminsky] \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e /{}", "sloth monitor");
         this.internalField0843 = AdminskyModule.InternalType0402.internalField1632;
      }
   }

   private Entity internalMethod07336() {
      Entity localValue1 = internalField0149.targetedEntity;
      if (localValue1 != null && localValue1 != internalField0149.player && !this.internalMethod06804(localValue1)) {
         return localValue1;
      } else {
         PlayerEntity localValue2 = this.internalMethod04311(true);
         return localValue2 != null ? localValue2 : this.internalMethod04311(false);
      }
   }

   private PlayerEntity internalMethod04311(boolean localValue1) {
      AbstractClientPlayerEntity localValue2 = null;
      double localValue3 = 25.0;

      for (AbstractClientPlayerEntity localValue6 : internalField0149.world.getPlayers()) {
         if (localValue6 != internalField0149.player && (!localValue1 || !this.internalMethod06804(localValue6))) {
            double localValue7 = internalField0149.player.squaredDistanceTo(localValue6);
            if (!(localValue7 >= localValue3)) {
               localValue2 = localValue6;
               localValue3 = localValue7;
            }
         }
      }

      return localValue2;
   }

   private boolean internalMethod06804(Entity localValue1) {
      return localValue1 instanceof PlayerEntity
         && localValue1.getUuid().version() != 2
         && internalField0149.getNetworkHandler() != null
         && internalField0149.getNetworkHandler().getPlayerListEntry(localValue1.getUuid()) != null;
   }

   private ScreenHandler internalMethod01765() {
      if (!(internalField0149.currentScreen instanceof HandledScreen)) {
         return null;
      } else {
         ScreenHandler localValue1 = internalField0149.player.currentScreenHandler;
         return !(localValue1 instanceof PlayerScreenHandler) && localValue1.slots.size() > 36 ? localValue1 : null;
      }
   }

   private int internalMethod01254(ScreenHandler localValue1) {
      int localValue2 = -1;

      for (int localValue3 = 0; localValue3 < localValue1.slots.size() - 36; localValue3++) {
         ItemStack localValue4 = localValue1.getSlot(localValue3).getStack();
         if (localValue4.isOf(Items.PLAYER_HEAD)) {
            if (localValue2 < 0) {
               localValue2 = localValue3;
            }

            if (internalField0293.matcher(this.internalMethod01893(localValue4)).find()) {
               return localValue3;
            }
         }
      }

      return localValue2;
   }

   private int internalMethod00343(ScreenHandler localValue1) {
      int localValue2 = -1;

      for (int localValue3 = 0; localValue3 < localValue1.slots.size() - 36; localValue3++) {
         ItemStack localValue4 = localValue1.getSlot(localValue3).getStack();
         if (!localValue4.isEmpty()) {
            if (internalField0294.matcher(this.internalMethod01893(localValue4)).find()) {
               return localValue3;
            }

            if (localValue2 < 0 && localValue4.isOf(Items.ORANGE_DYE)) {
               localValue2 = localValue3;
            }
         }
      }

      return localValue2;
   }

   private String internalMethod01893(ItemStack localValue1) {
      StringBuilder localValue2 = new StringBuilder(localValue1.getName().getString());

      try {
         for (Text localValue4 : localValue1.getTooltip(TooltipContext.create(internalField0149.world), internalField0149.player, TooltipType.BASIC)) {
            localValue2.append(' ').append(localValue4.getString());
         }
      } catch (Exception localValue5) {
      }

      return localValue2.toString().replaceAll("\u00a7.", "").replace('\u0451', '\u0435').toLowerCase(Locale.ROOT);
   }

   @Override
   public void onEnable() {
      this.internalField0843 = AdminskyModule.InternalType0402.internalField0843;
      this.internalField1053 = 0;
      this.internalField0519.internalMethod00701();
   }

   static enum InternalType0402 {
      internalField0843,
      internalField0844,
      internalField1346,
      internalField1345,
      internalField1344,
      internalField1343,
      internalField1633,
      internalField1632;
   }
}
