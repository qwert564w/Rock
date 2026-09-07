package rockstar.modules.player;







import rockstar.client.setting.*;
import rockstar.client.module.*;
import rockstar.client.event.*;
import rockstar.client.internal.ui.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.inventory.*;
import rockstar.client.*;

import lombok.Generated;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.ScreenHandler;
import pyrock.events.window.KeyPressEvent;
import rockstar.client.internal.script.ScriptInternal177;
import rockstar.client.internal.script.ScriptInternal178;
import rockstar.client.internal.script.ScriptInternal179;
import rockstar.client.internal.inventory.InventoryInternal039;
import rockstar.client.internal.script.ScriptInternal180;
import rockstar.client.internal.script.ScriptInternal181;
import rockstar.client.internal.ui.UiInternal040;
import rockstar.client.internal.script.ScriptInternal182;
import rockstar.client.internal.script.ScriptInternal183;
import rockstar.client.internal.script.ScriptInternal184;
import rockstar.client.setting.ModeSetting;
import rockstar.client.event.EventListener;
import rockstar.client.module.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.module.ModuleInfo;
import rockstar.client.module.Module;

@ModuleInfo(name="Auto Farm", category=ModuleCategory.PLAYER, internalMethod09633="modules.descriptions.auto_farm")
public class AutoFarmModule
extends Module {
    private final ScriptInternal184 internalField0849 = new ScriptInternal184(this::internalMethod02711);
    private ModeSetting internalField0668;
    private ScriptInternal177 internalField0680;
    private ScriptInternal183 internalField0846;
    private ScriptInternal182 internalField0699;
    private UiInternal040 internalField0698;
    private ScriptInternal179 internalField0693;
    private ScriptInternal181 internalField0697;
    private ScriptInternal180 internalField0696;
    private ScriptInternal178 internalField0692;
    private InventoryInternal039 internalField0694;
    private final EventListener<KeyPressEvent> internalField0157 = keyPressEvent -> {
        if (keyPressEvent.getKey() != 256 || keyPressEvent.getAction() != 1) {
            return;
        }
        if (!(AutoFarmModule.internalField0149.currentScreen instanceof HandledScreen) || AutoFarmModule.internalField0149.player == null) {
            return;
        }
        ScreenHandler screenHandler = AutoFarmModule.internalField0149.player.currentScreenHandler;
        if (screenHandler != null && screenHandler != AutoFarmModule.internalField0149.player.playerScreenHandler) {
            this.disable();
        }
    };

    public AutoFarmModule() {
        this.internalMethod09512();
    }

    private void internalMethod09512() {
        this.internalField0668 = new ModeSetting(this, "modules.settings.auto_farm.mode");
        this.internalField0680 = new ScriptInternal177(this, this.internalField0668);
        this.internalField0846 = new ScriptInternal183(this, this.internalField0668);
        this.internalField0699 = new ScriptInternal182(this, this.internalField0668);
        this.internalField0698 = new UiInternal040(this, this.internalField0668);
        this.internalField0693 = new ScriptInternal179(this, this.internalField0668);
        this.internalField0697 = new ScriptInternal181(this, this.internalField0668);
        this.internalField0696 = new ScriptInternal180(this, this.internalField0668);
        this.internalField0692 = new ScriptInternal178(this, this.internalField0668);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.internalField0694 = this.internalMethod03394();
        this.internalField0849.internalMethod01589();
        RockstarClient.getInstance().internalMethod03317().internalMethod00647(this.internalField0849);
        if (this.internalField0694 != null) {
            RockstarClient.getInstance().internalMethod03317().internalMethod00647(this.internalField0694);
            this.internalField0694.internalMethod04694();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.internalField0849.internalMethod01595();
        RockstarClient.getInstance().internalMethod03317().internalMethod07237(this.internalField0849);
        if (this.internalField0694 != null) {
            this.internalField0694.internalMethod04697();
            RockstarClient.getInstance().internalMethod03317().internalMethod07237(this.internalField0694);
            this.internalField0694 = null;
        }
    }

    @Override
    public void internalMethod08229() {
        super.internalMethod08229();
        this.internalField0849.internalMethod08497();
        InventoryInternal039 typedValue313 = this.internalMethod03394();
        if (typedValue313 != this.internalField0694) {
            if (this.internalField0694 != null) {
                this.internalField0694.internalMethod04697();
                RockstarClient.getInstance().internalMethod03317().internalMethod07237(this.internalField0694);
            }
            this.internalField0694 = typedValue313;
            if (this.internalField0694 != null) {
                RockstarClient.getInstance().internalMethod03317().internalMethod00647(this.internalField0694);
                this.internalField0694.internalMethod04694();
            }
        }
        if (this.internalField0694 != null) {
            this.internalField0694.internalMethod08382();
        }
    }

    private InventoryInternal039 internalMethod03394() {
        InventoryInternal039 typedValue313;
        ModeSetting.InternalType0088 nestedValue2011 = this.internalField0668.internalMethod07418();
        return nestedValue2011 instanceof InventoryInternal039 ? (typedValue313 = (InventoryInternal039)nestedValue2011) : null;
    }

    public InventoryInternal039 internalMethod02711() {
        return this.internalField0694;
    }

    @Generated
    public ScriptInternal184 internalMethod03987() {
        return this.internalField0849;
    }
}
