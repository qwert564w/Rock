package rockstar.client.internal.inventory;



import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.inventory.InventoryInternal007;
import rockstar.client.internal.core.CoreInternal047;

public class InventoryInternal015
extends InventoryInternal007 {
    public InventoryInternal015() {
        super("modules.settings.assist.radiation_potion", Items.SPLASH_POTION.getDefaultStack(), CoreInternal039.internalField1162);
    }

    @Override
    public boolean internalMethod03236() {
        return CoreInternal047.internalMethod06293();
    }

    @Override
    public boolean internalMethod05467(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty() || itemStack.getItem() != Items.SPLASH_POTION) {
            return false;
        }
        return itemStack.getName().getString().contains("\u0417\u0435\u043b\u044c\u0435 \u0420\u0430\u0434\u0438\u0430\u0446\u0438\u0438");
    }
}

