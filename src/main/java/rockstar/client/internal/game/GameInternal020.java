package rockstar.client.internal.game;




import rockstar.client.internal.inventory.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.Items;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.inventory.InventoryInternal007;

public class GameInternal020
extends InventoryInternal007 {
    public GameInternal020() {
        super("modules.settings.assist.snow", Items.SNOWBALL.getDefaultStack(), CoreInternal039.internalField0460);
    }

    @Override
    public boolean internalMethod03236() {
        return true;
    }
}

