package rockstar.client.internal.ui;






import rockstar.client.ui.*;
import rockstar.client.render.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.inventory.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.Generated;
import rockstar.client.ui.UiRenderContext;
import rockstar.client.render.Fonts;
import rockstar.client.render.CornerRadii;
import rockstar.client.ui.MouseButton;
import rockstar.client.internal.script.ScriptInternal101;
import rockstar.client.internal.inventory.InventoryInternal003;
import rockstar.client.ui.ThemeColors;

public class UiInternal007 {
    private final float internalField0205 = 10.0f;
    private final ScriptInternal101 internalField0936 = new ScriptInternal101(Fonts.internalField1154.internalMethod01432(7.0f));
    private boolean internalField0277 = false;

    public UiInternal007() {
        this.internalField0936.internalMethod09000("\u041f\u043e\u0438\u0441\u043a...");
    }

    public void internalMethod03534(boolean bl) {
        this.internalField0277 = bl;
        if (!bl) {
            this.internalField0936.internalMethod00484("");
        }
    }

    public void internalMethod04235(UiRenderContext iII, float f, float f2, float f3) {
        if (!this.internalField0277) {
            return;
        }
        float f4 = f + 10.0f;
        float f5 = f3 - 20.0f;
        iII.drawRoundedRect(f4, f2, f5, 16.0f, CornerRadii.internalMethod03908(3.0f), ThemeColors.internalMethod08573().mulAlpha(0.6f));
        this.internalField0936.internalMethod05191(f4 + 4.0f, f2 + 2.0f, f5 - 8.0f, 12.0f);
        this.internalField0936.internalMethod00143(ThemeColors.internalMethod08459());
        this.internalField0936.internalMethod03398(iII);
    }

    public List<InventoryInternal003.InternalType0503> internalMethod02786(List<InventoryInternal003.InternalType0503> list) {
        if (!this.internalField0277 || this.internalMethod03886()) {
            return list;
        }
        String string = this.internalField0936.internalMethod06202().toLowerCase(Locale.ROOT);
        ArrayList<InventoryInternal003.InternalType0503> arrayList = new ArrayList<InventoryInternal003.InternalType0503>();
        for (InventoryInternal003.InternalType0503 nestedValue2066 : list) {
            List<InventoryInternal003.InternalType0190> list2 = this.internalMethod06460(nestedValue2066.internalMethod07260(), string);
            if (list2.isEmpty()) continue;
            arrayList.add(new InventoryInternal003.InternalType0503(nestedValue2066.internalMethod04164(), nestedValue2066.internalMethod00725(), list2));
        }
        return arrayList;
    }

    public void internalMethod00537(double d, double d2, MouseButton typedParameter1015) {
        if (this.internalField0277) {
            this.internalField0936.internalMethod01643(d, d2, typedParameter1015);
        }
    }

    public void internalMethod04561(int n, int n2, int n3) {
        if (this.internalField0277) {
            this.internalField0936.internalMethod05727(n, n2, n3);
        }
    }

    public void internalMethod02594(char c, int n) {
        if (this.internalField0277) {
            this.internalField0936.internalMethod05413(c, n);
        }
    }

    public void internalMethod01878(double d, double d2, MouseButton typedParameter1015) {
        if (this.internalField0277) {
            this.internalField0936.internalMethod02863(d, d2, typedParameter1015);
        }
    }

    public float internalMethod03880() {
        return this.internalField0277 ? 16.0f : 0.0f;
    }

    private boolean internalMethod03886() {
        String string = this.internalField0936.internalMethod06202();
        return string == null || string.trim().isEmpty();
    }

    private List<InventoryInternal003.InternalType0190> internalMethod06460(List<InventoryInternal003.InternalType0190> list, String string) {
        ArrayList<InventoryInternal003.InternalType0190> arrayList = new ArrayList<InventoryInternal003.InternalType0190>();
        for (InventoryInternal003.InternalType0190 nestedValue2027 : list) {
            String string2 = nestedValue2027.internalMethod06194() != null ? nestedValue2027.internalMethod06194() : nestedValue2027.internalMethod05752().getName().getString();
            if (!string2.toLowerCase(Locale.ROOT).contains(string)) continue;
            arrayList.add(nestedValue2027);
        }
        return arrayList;
    }

    @Generated
    public boolean internalMethod03881() {
        return this.internalField0277;
    }
}

