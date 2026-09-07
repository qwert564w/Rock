package rockstar.modules.other;







import rockstar.client.util.*;
import rockstar.client.setting.*;
import rockstar.client.module.*;
import rockstar.client.i18n.*;
import rockstar.client.event.*;
import rockstar.client.animation.*;
import rockstar.client.*;
import rockstar.client.module.Module;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.nio.file.FileSystems;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pyrock.events.render.PreHudRenderEvent;

@ModuleInfo(
   name = "Russian Roulette",
   category = ModuleCategory.OTHER,
   internalMethod09633 = "modules.descriptions.russian_roulette",
   enabledByDefault = true
)
public class RussianRouletteModule extends Module {
   private ModeSetting internalField0668;
   private RussianRouletteModule.InternalType0223 internalField0542;
   private RussianRouletteModule.InternalType0223 internalField0541;
   private final SecureRandom internalField0858 = new SecureRandom();
   private volatile Identifier internalField0354;
   private final AnimatedValue internalField0808 = new AnimatedValue(5000L, Easing.internalField1814);
   private volatile boolean internalField0277;
   private final EventListener<PreHudRenderEvent> internalField0157 = localValue1 -> {
      if (this.internalField0354 != null) {
         if (this.internalField0808.internalMethod02881() == 1.0 && !this.internalField0277) {
            this.internalField0277 = true;
         }

         this.internalField0808.internalMethod07059(this.internalField0277 ? 0.0F : 1.0F);
      }
   };

   public RussianRouletteModule() {
      this.internalMethod09479();
   }

   private void internalMethod09479() {
      this.internalField0668 = new ModeSetting(
         this, "modules.settings.russian_roulette.difficulty", "modules.settings.russian_roulette.difficulty.description"
      );
      this.internalField0542 = new RussianRouletteModule.InternalType0223(this.internalField0668, "modules.settings.russian_roulette.easy") {
         @Override
         void internalMethod01180() {
            MinecraftClientAccess.internalField0149.stop();
         }
      };
      this.internalField0541 = new RussianRouletteModule.InternalType0223(this.internalField0668, "modules.settings.russian_roulette.very_hard") {
         @Override
         void internalMethod01180() {
         }
      };
   }

   @Override
   public final void onEnable() {
      if (internalField0149.world != null && internalField0149.player != null) {
         boolean localValue1 = this.internalMethod09482();
         this.internalMethod08614(localValue1);
         this.internalMethod09481();
         super.onEnable();
      }
   }

   private boolean internalMethod09482() {
      int[] localValue1 = new int[6];
      Arrays.setAll(localValue1, localValue0 -> localValue0 == 5 ? 1 : 0);
      return localValue1[this.internalField0858.nextInt(localValue1.length)] == 0;
   }

   private void internalMethod08614(boolean localValue1) {
      boolean localValue2 = this.internalField0541.isSelected();
      String localValue3 = localValue1 ? "rroulette.luck" : "rroulette.unlucky";
      ClientMessages.internalMethod01809(
         Text.of(localValue2 ? LanguageManager.internalMethod07214(localValue3 + ".prize") : LanguageManager.internalMethod07214(localValue3 + ".simple"))
      );
      if (localValue2) {
         this.internalMethod01144(localValue1 ? "https://4lapy.ru/journal/info/taksa-osobennosti-porody-kharakter-soderzhanie/" : "https://pornhub.com");
      }
   }

   private void internalMethod09481() {
      if (this.internalField0542.isSelected()) {
         this.internalField0542.internalMethod01180();
      }
   }

   private void internalMethod01144(String localValue1) {
      CompletableFuture.runAsync(() -> {
         try {
            BitMatrix localValue2 = new MultiFormatWriter().encode(localValue1, BarcodeFormat.QR_CODE, 300, 300);
            BufferedImage localValue3 = MatrixToImageWriter.toBufferedImage(localValue2);
            NativeImage localValue4 = this.internalMethod01249(localValue3);
            String localValue5 = FileSystems.getDefault().getSeparator();
            internalField0149.execute(() -> {
               if (this.internalField0354 != null) {
                  internalField0149.getTextureManager().destroyTexture(this.internalField0354);
               }

               Identifier localValue3x = RockstarClient.id("temp" + localValue5 + "qr" + localValue5 + UUID.randomUUID());
               internalField0149.getTextureManager().registerTexture(localValue3x, new NativeImageBackedTexture(() -> "Rockstar roulette", localValue4));
               this.internalField0354 = localValue3x;
               this.internalField0808.internalMethod07059(1.0F);
               this.internalField0277 = false;
            });
         } catch (Exception localValue6) {
         }
      });
   }

   private NativeImage internalMethod01249(BufferedImage localValue1) {
      int localValue2 = localValue1.getWidth();
      int localValue3 = localValue1.getHeight();
      NativeImage localValue4 = new NativeImage(localValue2, localValue3, true);
      int[] localValue5 = localValue1.getRGB(0, 0, localValue2, localValue3, null, 0, localValue2);

      for (int localValue6 = 0; localValue6 < localValue5.length; localValue6++) {
         int localValue7 = localValue6 % localValue2;
         int localValue8 = localValue6 / localValue2;
         localValue4.setColorArgb(localValue7, localValue8, localValue5[localValue6]);
      }

      return localValue4;
   }

   @Generated
   public Identifier internalMethod03268() {
      return this.internalField0354;
   }

   @Generated
   public AnimatedValue internalMethod04763() {
      return this.internalField0808;
   }

   @Generated
   public boolean internalMethod09480() {
      return this.internalField0277;
   }

   abstract static class InternalType0223 extends ModeSetting.InternalType0088 {
      public InternalType0223(ModeSetting localValue1, String localValue2) {
         super(localValue1, localValue2);
      }

      abstract void internalMethod01180();
   }
}
