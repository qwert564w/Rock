package rockstar.client.internal.core;





import rockstar.client.bot.*;
import rockstar.client.internal.inventory.*;
import rockstar.client.internal.game.*;
import rockstar.client.*;
import rockstar.client.internal.inventory.InventoryInternal022;
import rockstar.client.internal.core.CoreInternal066;
import rockstar.client.internal.game.GameInternal001;
import rockstar.client.internal.core.CoreInternal036;
import rockstar.client.bot.BotTargetManager;

public class CoreInternal035
implements CoreInternal066 {
    private final InventoryInternal022 internalField0173;
    private int internalField0227;
    private boolean internalField0277;

    public CoreInternal035(int n) {
        this.internalField0173 = new InventoryInternal022(n, 1);
    }

    @Override
    public void internalMethod07229(BotTargetManager typedValue055) {
        if (typedValue055 == null || !typedValue055.internalMethod07697()) {
            return;
        }
        if (this.internalField0277) {
            typedValue055.internalMethod09733();
            ++this.internalField0227;
            if (this.internalField0227 >= Math.max(1, typedValue055.internalMethod06687().internalMethod07750())) {
                typedValue055.internalMethod05456(new GameInternal001());
            }
            return;
        }
        this.internalField0173.internalMethod07229(typedValue055);
        if (typedValue055.internalMethod06738() instanceof CoreInternal036) {
            this.internalField0277 = true;
            this.internalField0227 = 0;
            typedValue055.internalMethod05456(this);
        }
    }

    @Override
    public String internalMethod06553() {
        return "CyclicRebreakWithRejoin";
    }
}

