package rockstar.client.internal.inventory;




import rockstar.client.server.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rockstar.client.server.KnownServer;
import rockstar.client.server.ServerUtils;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.inventory.InventoryInternal007;

public class InventoryInternal018
extends InventoryInternal007 {
    public InventoryInternal018() {
        super("modules.settings.assist.trapka", Items.NETHERITE_SCRAP.getDefaultStack(), CoreInternal039.internalField0460);
    }

    @Override
    public ItemStack internalMethod06489() {
        if (ServerUtils.internalMethod01786(KnownServer.internalField1218) && !ServerUtils.internalMethod06501("holytime")) {
            return Items.POPPED_CHORUS_FRUIT.getDefaultStack();
        }
        return Items.NETHERITE_SCRAP.getDefaultStack();
    }

    @Override
    public boolean internalMethod03236() {
        return true;
    }
}

