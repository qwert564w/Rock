package rockstar.client.internal.inventory;



import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.inventory.InventoryInternal007;
import rockstar.client.internal.core.CoreInternal047;

public class InventoryInternal011
extends InventoryInternal007 {
    public InventoryInternal011() {
        super("modules.settings.assist.hlopushka", Items.SPLASH_POTION.getDefaultStack(), CoreInternal039.internalField1162);
    }

    @Override
    public boolean internalMethod03236() {
        return CoreInternal047.internalMethod06293();
    }

    @Override
    public boolean internalMethod05467(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) {
            return false;
        }
        if (itemStack.getItem() != Items.SPLASH_POTION) {
            return false;
        }
        String string = itemStack.getName().getString();
        return string.contains("\u0425\u043b\u043e\u043f\u0443\u0448\u043a\u0430");
    }
}

