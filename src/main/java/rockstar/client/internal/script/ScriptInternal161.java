package rockstar.client.internal.script;







import rockstar.client.rotation.*;
import rockstar.client.internal.rotation.*;
import rockstar.client.internal.game.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.command.*;
import rockstar.client.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import rockstar.client.internal.command.CommandInternal001;
import rockstar.client.internal.game.GameInternal054;
import rockstar.client.internal.core.CoreInternal127;
import rockstar.client.internal.core.CoreInternal129;
import rockstar.client.internal.core.CoreInternal130;
import rockstar.client.internal.rotation.RotationInternal017;
import rockstar.client.internal.game.GameInternal061;
import rockstar.client.internal.game.GameInternal065;
import rockstar.client.internal.script.ScriptInternal171;
import rockstar.client.internal.rotation.RotationInternal024;
import rockstar.client.internal.game.GameInternal070;
import rockstar.client.internal.core.CoreInternal146;

public final class ScriptInternal161
implements GameInternal054 {
    private final List<CoreInternal129> internalField0416 = new CopyOnWriteArrayList<CoreInternal129>();

    @Override
    public void internalMethod02230(BlockPos blockPos) {
        this.internalMethod00530(new GameInternal061(blockPos));
    }

    @Override
    public void internalMethod01013(BlockPos blockPos, boolean bl) {
        if (bl) {
            this.internalMethod03517(blockPos);
        } else {
            this.internalMethod02230(blockPos);
        }
    }

    @Override
    public void internalMethod00530(GameInternal065 typedValue302) {
        RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03441(new RotationInternal024(typedValue302));
    }

    @Override
    public void internalMethod03517(BlockPos blockPos) {
        RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03441(new ScriptInternal171(blockPos));
    }

    @Override
    public void internalMethod02016(Identifier identifier) {
        Block block = (Block)Registries.BLOCK.get(identifier);
        RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03441(new GameInternal070(block));
    }

    @Override
    public void internalMethod00136() {
        RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03476();
    }

    @Override
    public boolean internalMethod00137() {
        return RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03477();
    }

    @Override
    public Optional<CoreInternal127> internalMethod06302() {
        return RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03684().map(this::internalMethod02658);
    }

    @Override
    public boolean internalMethod06067(String string) {
        CommandInternal001 typedValue128 = RotationInternal017.internalMethod00114().internalMethod06865();
        return typedValue128.internalMethod04610(typedValue128.internalMethod03606() + " " + string);
    }

    @Override
    public void internalMethod00456(CoreInternal129 typedValue282) {
        this.internalField0416.add(typedValue282);
    }

    @Override
    public void internalMethod05471(CoreInternal129 typedValue282) {
        this.internalField0416.remove(typedValue282);
    }

    public void internalMethod07208(CoreInternal130 typedValue283) {
        for (CoreInternal129 typedValue282 : this.internalField0416) {
            try {
                typedValue282.internalMethod01502(typedValue283);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    private CoreInternal127 internalMethod02658(final CoreInternal146 typedValue308) {
        return new CoreInternal127(){

            @Override
            public String internalMethod00915() {
                return typedValue308.internalMethod01129();
            }

            @Override
            public String internalMethod05621() {
                return typedValue308.internalMethod05788();
            }

            @Override
            public boolean internalMethod03344() {
                return typedValue308.internalMethod04090();
            }

            @Override
            public void internalMethod03343() {
                typedValue308.internalMethod04089();
            }

            @Override
            public void internalMethod03349() {
                typedValue308.internalMethod08146();
            }

            @Override
            public void internalMethod08765() {
                typedValue308.internalMethod04086();
            }
        };
    }
}

