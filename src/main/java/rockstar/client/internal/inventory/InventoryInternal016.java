package rockstar.client.internal.inventory;



import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.inventory.InventoryInternal007;
import rockstar.client.internal.core.CoreInternal047;

public class InventoryInternal016
extends InventoryInternal007 {
    public InventoryInternal016() {
        super("modules.settings.assist.sleeping_potion", Items.SPLASH_POTION.getDefaultStack(), CoreInternal039.internalField1162);
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
        return itemStack.getName().getString().contains("\u0421\u043d\u043e\u0442\u0432\u043e\u0440\u043d\u043e\u0435");
    }
}

