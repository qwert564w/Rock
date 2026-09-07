package rockstar.client.internal.ui;





import rockstar.client.util.*;
import rockstar.client.notification.*;
import rockstar.client.i18n.*;
import rockstar.client.*;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import globals.client.Information;
import java.io.File;
import java.nio.file.Files;
import lombok.Generated;
import net.coobird.thumbnailator.Thumbnails;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.glfw.GLFWDropCallbackI;

public final class UiInternal017 implements MinecraftClientAccess {
   private static boolean internalField0277;

   public static void internalMethod05313() {
      if (!internalField0277) {
         internalField0277 = true;
         long localValue0 = internalField0149.getWindow().getHandle();
         GLFWDropCallbackI[] localValue2 = new GLFWDropCallbackI[1];
         GLFWDropCallbackI localValue3 = (localValue1, localValue3x, localValue4) -> {
            if (localValue2[0] != null) {
               localValue2[0].invoke(localValue1, localValue3x, localValue4);
            }

            for (int localValue6 = 0; localValue6 < localValue3x; localValue6++) {
               String localValue7 = GLFWDropCallback.getName(localValue4, localValue6);
               internalMethod02049(localValue7);
            }
         };
         localValue2[0] = GLFW.glfwSetDropCallback(localValue0, localValue3);
      }
   }

   private static void internalMethod02049(String localValue0) {
      try {
         File localValue1 = new File(localValue0);
         if (!localValue1.isFile()) {
            return;
         }

         if (localValue1.getName().endsWith(".rock")) {
            JsonElement localValue2 = JsonParser.parseString(Files.readString(localValue1.toPath()));
            if (!localValue2.isJsonObject()) {
               ClientMessages.internalMethod09025(Text.of(LanguageManager.internalMethod07214("config.delete_error")));
               return;
            }

            String localValue3 = localValue1.getName().substring(0, localValue1.getName().lastIndexOf(46));
            RockstarClient.getInstance().internalMethod02152().internalMethod04975(localValue3, localValue2.getAsJsonObject());
            ClientMessages.internalMethod01809(Text.of(LanguageManager.internalMethod00160("config.loaded", localValue3)));
            RockstarClient.getInstance()
               .internalMethod02503()
               .internalMethod04075(NotificationType.internalField0704, Text.translatable("configs.loaded").getString());
         }

         if (localValue1.getName().endsWith(".png") && Information.getPreferUser() != null) {
            if (!localValue1.exists()) {
               System.err.println("File not selected or missing.");
               return;
            }

            if (Information.getPreferUser().password() == null) {
               ClientMessages.internalMethod01809(Text.of(LanguageManager.internalMethod07214("rocknet.avatar.site_only")));
               return;
            }

            File localValue7 = new File(System.getProperty("java.io.tmpdir"));
            File localValue8 = new File(localValue7, "avatar.png");
            Thumbnails.of(new File[]{localValue1}).size(36, 36).toFile(localValue8);
            HttpRequest localValue4 = HttpRequest.post("https://api.rockstar.moscow/minecraft/v1/auth/avatar.php");
            localValue4.part("login", Information.getPreferUser().username());
            localValue4.part("password", Information.getPreferUser().password());
            localValue4.part("avatar", "avatar.png", localValue8);
            int localValue5 = localValue4.code();
            System.out.println("Upload status: " + localValue5);
            if (localValue5 == 200) {
               System.out.println(localValue4.body());
            }

            Information.clearAvatars();
         }
      } catch (Exception localValue6) {
         localValue6.printStackTrace();
      }
   }

   @Generated
   private UiInternal017() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
