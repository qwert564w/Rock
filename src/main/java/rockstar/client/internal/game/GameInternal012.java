package rockstar.client.internal.game;




import rockstar.client.internal.inventory.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.Items;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.inventory.InventoryInternal007;
import rockstar.client.internal.core.CoreInternal047;

public class GameInternal012
extends InventoryInternal007 {
    public GameInternal012() {
        super("modules.settings.assist.boom_trap", Items.PRISMARINE_SHARD.getDefaultStack(), CoreInternal039.internalField0460);
    }

    @Override
    public boolean internalMethod03236() {
        return CoreInternal047.internalMethod08905();
    }
}

