package rockstar.client.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.render.CornerRadii;
import rockstar.client.render.Fonts;
import rockstar.client.render.SizedFont;

/** Visible port credit shared by the custom and vanilla main menus. */
public final class PortBranding {
   public static final String TELEGRAM_URL = "https://t.me/SunShine_project547";
   public static final String PREFIX = "SunShine Project · ported by Lokets547 and ";
   public static final String LABEL = PREFIX + TELEGRAM_URL;
   private static final float CUSTOM_X = 12.0F;
   private static final float CUSTOM_FONT_SIZE = 9.5F;

   private PortBranding() {
   }

   public static void renderCustom(UiRenderContext context, int width, int height) {
      SizedFont font = Fonts.internalField1154.internalMethod01432(CUSTOM_FONT_SIZE);
      float prefixWidth = font.internalMethod00965(PREFIX);
      float fullWidth = prefixWidth + font.internalMethod00965(TELEGRAM_URL);
      float y = height - 24.0F;
      context.drawShadow(CUSTOM_X - 6.0F, y - 4.0F, fullWidth + 12.0F, 17.0F, 14.0F, CornerRadii.internalMethod03908(6.0F), ColorRGBA.BLACK.withAlpha(105.0F));
      context.drawRoundedRect(
         CUSTOM_X - 6.0F,
         y - 4.0F,
         fullWidth + 12.0F,
         17.0F,
         CornerRadii.internalMethod03908(6.0F),
         new ColorRGBA(8.0F, 12.0F, 18.0F, 178.0F)
      );
      context.drawText(font, PREFIX, CUSTOM_X, y, new ColorRGBA(225.0F, 231.0F, 240.0F, 235.0F));
      context.drawText(font, TELEGRAM_URL, CUSTOM_X + prefixWidth, y, new ColorRGBA(91.0F, 202.0F, 255.0F, 255.0F));
   }

   public static boolean customLinkHovered(double mouseX, double mouseY, int height) {
      SizedFont font = Fonts.internalField1154.internalMethod01432(CUSTOM_FONT_SIZE);
      float linkX = CUSTOM_X + font.internalMethod00965(PREFIX);
      float linkY = height - 24.0F;
      return mouseX >= linkX
         && mouseX <= linkX + font.internalMethod00965(TELEGRAM_URL)
         && mouseY >= linkY - 3.0F
         && mouseY <= linkY + 12.0F;
   }

   public static void renderVanilla(DrawContext context, MinecraftClient client) {
      int x = 8;
      int y = client.getWindow().getScaledHeight() - 20;
      int width = client.textRenderer.getWidth(LABEL);
      context.fill(x - 4, y - 3, x + width + 4, y + 12, 0xA0000000);
      context.drawTextWithShadow(client.textRenderer, Text.literal(PREFIX), x, y, 0xFFE3E9F0);
      context.drawTextWithShadow(client.textRenderer, Text.literal(TELEGRAM_URL), x + client.textRenderer.getWidth(PREFIX), y, 0xFF5BCAFF);
   }

   public static boolean vanillaLinkHovered(double mouseX, double mouseY, MinecraftClient client) {
      int x = 8 + client.textRenderer.getWidth(PREFIX);
      int y = client.getWindow().getScaledHeight() - 20;
      return mouseX >= x
         && mouseX <= x + client.textRenderer.getWidth(TELEGRAM_URL)
         && mouseY >= y - 2
         && mouseY <= y + 11;
   }

   public static void openTelegram() {
      Util.getOperatingSystem().open(TELEGRAM_URL);
   }
}
