package rockstar.client.internal.game;




import rockstar.client.internal.inventory.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.Items;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.core.CoreInternal047;
import rockstar.client.internal.inventory.InventoryInternal013;

public class GameInternal009
extends InventoryInternal013 {
    public GameInternal009() {
        super("modules.settings.assist.anti_flight", Items.FIREWORK_STAR, CoreInternal039.internalField0460, "\u0430\u043d\u0442\u0438", "\u043f\u043e\u043b\u0435\u0442");
    }

    @Override
    public boolean internalMethod03236() {
        return CoreInternal047.internalMethod08904();
    }
}

