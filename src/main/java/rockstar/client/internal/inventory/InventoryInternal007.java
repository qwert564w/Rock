package rockstar.client.internal.inventory;




import rockstar.client.setting.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.item.ItemStack;
import rockstar.client.setting.Setting;
import rockstar.client.setting.SettingOwner;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.inventory.InventoryInternal008;

public abstract class InventoryInternal007
implements SettingOwner,
InventoryInternal008 {
    private final String internalField0248;
    private final ItemStack internalField0878;
    private final CoreInternal039 internalField0459;
    private int internalField0227 = -1;
    private final List<Setting> internalField0416 = new ArrayList<Setting>();

    public InventoryInternal007(String string, ItemStack itemStack, CoreInternal039 typedValue100) {
        this.internalField0248 = string;
        this.internalField0878 = itemStack;
        this.internalField0459 = typedValue100;
    }

    @Override
    public void internalMethod03235() {
    }

    @Override
    public boolean internalMethod03236() {
        return true;
    }

    @Override
    @Generated
    public String internalMethod06026() {
        return this.internalField0248;
    }

    @Override
    @Generated
    public ItemStack internalMethod06489() {
        return this.internalField0878;
    }

    @Override
    @Generated
    public CoreInternal039 internalMethod06886() {
        return this.internalField0459;
    }

    @Override
    @Generated
    public int internalMethod03234() {
        return this.internalField0227;
    }

    @Override
    @Generated
    public void internalMethod01910(int n) {
        this.internalField0227 = n;
    }

    @Override
    @Generated
    public List<Setting> getSettings() {
        return this.internalField0416;
    }
}

