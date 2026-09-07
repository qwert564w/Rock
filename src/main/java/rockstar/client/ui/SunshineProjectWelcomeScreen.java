package rockstar.client.ui;

import net.minecraft.client.gui.screen.Screen;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.render.CornerRadii;
import rockstar.client.render.Fonts;
import rockstar.client.render.SizedFont;

/** One-time welcome displayed once per client process before the main menu. */
public final class SunshineProjectWelcomeScreen extends RockstarScreen {
   private static final String MESSAGE_TOP = "Подпишись на наш ТГК — порты и сливы сурсов";
   private static final String MESSAGE_BOTTOM = "там выходят быстрее";
   private final Screen nextScreen;

   public SunshineProjectWelcomeScreen(Screen nextScreen) {
      this.nextScreen = nextScreen;
   }

   @Override
   public void render(UiRenderContext context) {
      float cardWidth = Math.min(470.0F, this.width - 28.0F);
      float cardHeight = Math.min(258.0F, this.height - 28.0F);
      float x = (this.width - cardWidth) / 2.0F;
      float y = (this.height - cardHeight) / 2.0F;
      float centerX = this.width / 2.0F;
      ColorRGBA cyan = new ColorRGBA(80.0F, 211.0F, 255.0F, 255.0F);
      ColorRGBA purple = new ColorRGBA(143.0F, 104.0F, 255.0F, 255.0F);

      context.drawRoundedRect(
         0.0F,
         0.0F,
         this.width,
         this.height,
         CornerRadii.internalField0098,
         new HorizontalColorGradient(new ColorRGBA(4.0F, 10.0F, 18.0F), new ColorRGBA(17.0F, 7.0F, 28.0F))
      );
      context.drawShadow(x - 10.0F, y - 10.0F, cardWidth + 20.0F, cardHeight + 20.0F, 38.0F, CornerRadii.internalMethod03908(22.0F), purple.withAlpha(90.0F));
      context.drawRoundedRect(x, y, cardWidth, cardHeight, CornerRadii.internalMethod03908(18.0F), new ColorRGBA(9.0F, 14.0F, 24.0F, 245.0F));
      context.drawRoundedRect(x, y, cardWidth, 5.0F, CornerRadii.internalMethod03908(2.5F), new HorizontalColorGradient(cyan, purple));

      SizedFont title = Fonts.internalField1156.internalMethod01432(Math.min(38.0F, Math.max(27.0F, cardWidth / 12.0F)));
      SizedFont subtitle = Fonts.internalField1157.internalMethod01432(12.0F);
      SizedFont body = Fonts.internalField1154.internalMethod01432(13.0F);
      SizedFont link = Fonts.internalField0449.internalMethod01432(12.0F);
      SizedFont button = Fonts.internalField1157.internalMethod01432(13.0F);

      context.drawCenteredText(title, "SunShine Project", centerX, y + 28.0F, ColorRGBA.WHITE);
      context.drawCenteredText(subtitle, "ported by Lokets547", centerX, y + 72.0F, new ColorRGBA(163.0F, 180.0F, 204.0F));
      context.drawCenteredText(body, MESSAGE_TOP, centerX, y + 105.0F, new ColorRGBA(225.0F, 231.0F, 240.0F));
      context.drawCenteredText(body, MESSAGE_BOTTOM, centerX, y + 124.0F, new ColorRGBA(225.0F, 231.0F, 240.0F));

      boolean linkHovered = this.linkHovered(context.internalMethod05259(), context.internalMethod05261(), x, y, cardWidth);
      context.drawCenteredText(link, PortBranding.TELEGRAM_URL, centerX, y + 136.0F, linkHovered ? ColorRGBA.WHITE : cyan);

      float buttonWidth = Math.min(210.0F, cardWidth - 48.0F);
      float buttonX = centerX - buttonWidth / 2.0F;
      float buttonY = y + cardHeight - 54.0F;
      boolean buttonHovered = this.buttonHovered(context.internalMethod05259(), context.internalMethod05261(), buttonX, buttonY, buttonWidth);
      if (buttonHovered) {
         context.drawShadow(buttonX, buttonY, buttonWidth, 34.0F, 18.0F, CornerRadii.internalMethod03908(10.0F), cyan.withAlpha(115.0F));
      }
      context.drawRoundedRect(
         buttonX,
         buttonY,
         buttonWidth,
         34.0F,
         CornerRadii.internalMethod03908(10.0F),
         new HorizontalColorGradient(buttonHovered ? new ColorRGBA(99.0F, 221.0F, 255.0F) : cyan, buttonHovered ? new ColorRGBA(165.0F, 124.0F, 255.0F) : purple)
      );
      context.drawCenteredText(button, "Продолжить", centerX, buttonY + 9.0F, new ColorRGBA(8.0F, 12.0F, 20.0F));
   }

   @Override
   public void onMouseClicked(double mouseX, double mouseY, MouseButton button) {
      if (button.internalMethod02957() != 0) {
         return;
      }

      float cardWidth = Math.min(470.0F, this.width - 28.0F);
      float cardHeight = Math.min(258.0F, this.height - 28.0F);
      float x = (this.width - cardWidth) / 2.0F;
      float y = (this.height - cardHeight) / 2.0F;
      if (this.linkHovered(mouseX, mouseY, x, y, cardWidth)) {
         PortBranding.openTelegram();
         return;
      }

      float buttonWidth = Math.min(210.0F, cardWidth - 48.0F);
      float buttonX = this.width / 2.0F - buttonWidth / 2.0F;
      float buttonY = y + cardHeight - 54.0F;
      if (this.buttonHovered(mouseX, mouseY, buttonX, buttonY, buttonWidth)) {
         this.openNextScreen();
      }
   }

   @Override
   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
      if (keyCode == 256 || keyCode == 257 || keyCode == 32) {
         this.openNextScreen();
         return true;
      }
      return super.keyPressed(keyCode, scanCode, modifiers);
   }

   @Override
   public boolean shouldCloseOnEsc() {
      return false;
   }

   private void openNextScreen() {
      if (this.client != null) {
         this.client.setScreen(this.nextScreen);
      }
   }

   private boolean linkHovered(double mouseX, double mouseY, float x, float y, float cardWidth) {
      SizedFont font = Fonts.internalField0449.internalMethod01432(12.0F);
      float width = font.internalMethod00965(PortBranding.TELEGRAM_URL);
      float linkX = x + cardWidth / 2.0F - width / 2.0F;
      return mouseX >= linkX && mouseX <= linkX + width && mouseY >= y + 133.0F && mouseY <= y + 151.0F;
   }

   private boolean buttonHovered(double mouseX, double mouseY, float x, float y, float width) {
      return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 34.0F;
   }
}


