package rockstar.client.internal.ui;





import rockstar.client.ui.*;
import rockstar.client.data.*;
import rockstar.client.internal.script.*;
import rockstar.client.*;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import rockstar.client.ui.UiRenderContext;
import rockstar.modules.player.GuiMoveModule;
import rockstar.client.ui.MouseButton;
import rockstar.client.RockstarClient;
import rockstar.client.data.AuctionItem;
import rockstar.client.internal.script.ScriptInternal019;
import rockstar.client.internal.script.ScriptInternal020;
import rockstar.client.internal.script.ScriptInternal021;
import rockstar.client.MinecraftClientAccess;
import rockstar.client.ui.ScreenMetricsAccess;
import rockstar.client.ui.RockstarScreen;

public class UiInternal003
extends RockstarScreen
implements MinecraftClientAccess,
ScreenMetricsAccess {
    private final ScriptInternal019 internalField0802 = new ScriptInternal019();
    private final ScriptInternal021 internalField0804 = new ScriptInternal021();
    private final ScriptInternal020 internalField0803 = new ScriptInternal020();

    public final void init() {
        RockstarClient.getInstance().internalMethod03317().internalMethod00647(this);
    }

    @Override
    public void render(UiRenderContext iII) {
        float f;
        float f2;
        float f3;
        boolean bl;
        float f4 = this.internalField0802.internalMethod00717();
        float f5 = 160.0f;
        float f6 = 223.0f;
        float f7 = 10.0f;
        this.internalField0803.internalMethod02005();
        float f8 = this.internalField0803.internalMethod02004();
        float f9 = this.internalField0803.internalMethod02320(f6);
        if (this.internalField0802.internalMethod05082() != null) {
            this.internalField0804.internalMethod04862(this.internalField0802.internalMethod05082());
            this.internalField0804.internalMethod05784(this.internalField0802.internalMethod00457());
        }
        boolean bl2 = this.internalField0804.internalMethod02262() != null;
        float f10 = f8 + f7 + f4;
        if (bl2) {
            f10 += f7 + f5;
        }
        if (bl = this.internalField0803.internalMethod05687(iII, f3 = (f2 = internalField0389.internalMethod03585() / 2.0f - f10 / 2.0f), f = internalField0389.internalMethod03589() / 2.0f - f6 / 2.0f, f8, f9)) {
            f3 += f8 + f7;
        } else {
            f10 = f4;
            if (bl2) {
                f10 += f7 + f5;
            }
            f3 = f2 = internalField0389.internalMethod03585() / 2.0f - f10 / 2.0f;
        }
        this.internalField0802.internalMethod04970(iII, f3, f, f4, f6);
        f3 += f4 + f7;
        if (bl2) {
            this.internalField0804.internalMethod02528(iII, f3, f, f5, f6);
            if (this.internalField0804.internalMethod03728()) {
                ItemStack itemStack = this.internalField0804.internalMethod04458();
                AuctionItem.internalMethod06356(itemStack, this.internalField0804.internalMethod03727(), this.internalField0804.internalMethod00635(), this.internalField0802.internalMethod05162(), this.internalField0804.internalMethod04120(), this.internalField0804.internalMethod03725());
                this.internalField0803.internalMethod02005();
                this.internalField0802.internalMethod07147(itemStack);
                this.internalField0802.internalMethod00718();
                this.internalField0804.internalMethod04862(null);
                this.internalField0804.internalMethod05784(null);
            }
        }
    }

    @Override
    public void onMouseClicked(double d, double d2, MouseButton typedParameter1015) {
        this.internalField0803.internalMethod02446(d, d2, typedParameter1015);
        this.internalField0802.internalMethod07064(d, d2, typedParameter1015);
        this.internalField0804.internalMethod06033(d, d2, typedParameter1015);
        this.internalField0803.internalMethod02005();
        super.onMouseClicked(d, d2, typedParameter1015);
    }

    @Override
    public void onMouseReleased(double d, double d2, MouseButton typedParameter1015) {
        this.internalField0802.internalMethod00304(d, d2, typedParameter1015);
        this.internalField0804.internalMethod04771(d, d2, typedParameter1015);
        super.onMouseReleased(d, d2, typedParameter1015);
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        this.internalField0803.internalMethod06349(mouseX, mouseY, verticalAmount);
        this.internalField0802.internalMethod01976(mouseX, mouseY, verticalAmount);
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        this.internalField0802.internalMethod01983(keyCode, scanCode, modifiers);
        this.internalField0804.internalMethod02590(keyCode, scanCode, modifiers);
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean charTyped(char chr, int modifiers) {
        this.internalField0802.internalMethod04074(chr, modifiers);
        this.internalField0804.internalMethod04096(chr, modifiers);
        return super.charTyped(chr, modifiers);
    }

    public void close() {
        RockstarClient.getInstance().internalMethod03317().internalMethod07237(this);
        super.close();
        internalField0149.setScreen((Screen)RockstarClient.getInstance().internalMethod04334());
    }

    public void tick() {
        GuiMoveModule.internalMethod09597();
        super.tick();
    }

    public boolean shouldPause() {
        return false;
    }

    public boolean shouldCloseOnEsc() {
        return true;
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
    }
}
