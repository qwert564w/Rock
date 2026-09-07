package rockstar.client.internal.game;




import rockstar.client.internal.inventory.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.Items;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.inventory.InventoryInternal007;
import rockstar.client.internal.core.CoreInternal047;

public class GameInternal015
extends InventoryInternal007 {
    public GameInternal015() {
        super("modules.settings.assist.dezorent", Items.ENDER_EYE.getDefaultStack(), CoreInternal039.internalField0460);
    }

    @Override
    public boolean internalMethod03236() {
        return CoreInternal047.internalMethod06293();
    }
}

