package rockstar.client.internal.game;




import rockstar.client.internal.inventory.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import net.minecraft.item.Items;
import rockstar.client.internal.core.CoreInternal039;
import rockstar.client.internal.core.CoreInternal047;
import rockstar.client.internal.inventory.InventoryInternal013;

public class GameInternal014
extends InventoryInternal013 {
    public GameInternal014() {
        super("modules.settings.assist.dark_pulse", Items.FIREWORK_STAR, CoreInternal039.internalField0460, "\u0442\u0435\u043c\u043d", "\u043f\u0443\u043b\u044c\u0441");
    }

    @Override
    public boolean internalMethod03236() {
        return CoreInternal047.internalMethod08904();
    }
}

