package pyrock.classes;








import rockstar.client.rotation.*;
import rockstar.client.internal.script.*;
import rockstar.client.internal.rotation.*;
import rockstar.client.internal.inventory.*;
import rockstar.client.internal.game.*;
import rockstar.client.internal.core.*;
import rockstar.client.internal.command.*;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import rockstar.client.internal.command.CommandInternal001;
import rockstar.client.internal.core.CoreInternal126;
import rockstar.client.internal.game.GameInternal055;
import rockstar.client.internal.rotation.RotationInternal017;
import rockstar.client.internal.game.GameInternal056;
import rockstar.client.internal.core.CoreInternal138;
import rockstar.client.internal.game.GameInternal059;
import rockstar.client.internal.game.GameInternal061;
import rockstar.client.internal.game.GameInternal062;
import rockstar.client.internal.game.GameInternal063;
import rockstar.client.internal.game.GameInternal064;
import rockstar.client.internal.game.GameInternal065;
import rockstar.client.internal.rotation.RotationInternal019;
import rockstar.client.internal.script.ScriptInternal171;
import rockstar.client.internal.game.GameInternal069;
import rockstar.client.internal.inventory.InventoryInternal038;
import rockstar.client.internal.rotation.RotationInternal024;
import rockstar.client.internal.game.GameInternal070;
import rockstar.client.internal.core.CoreInternal146;

public class PyNewton {
    public boolean ready() {
        return RotationInternal017.internalMethod00010();
    }

    public boolean active() {
        return this.ready() && RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03477();
    }

    public boolean goTo(int n, int n2, int n3) {
        return this.start(new RotationInternal024(new GameInternal061(new BlockPos(n, n2, n3))));
    }

    public boolean goToNear(int n, int n2, int n3, int n4) {
        return this.start(new RotationInternal024(new GameInternal062(new BlockPos(n, n2, n3), Math.max(0, n4))));
    }

    public boolean goToXZ(int n, int n2) {
        return this.start(new RotationInternal024(new GameInternal063(n, n2)));
    }

    public boolean goToY(int n) {
        return this.start(new RotationInternal024(new GameInternal064(n)));
    }

    public boolean flyTo(int n, int n2, int n3, boolean bl) {
        return this.start(new ScriptInternal171(n, n2, n3, bl));
    }

    public boolean mine(String string) {
        Block block = GameInternal056.internalMethod05431(string);
        if (block == null) {
            return false;
        }
        return this.start(new GameInternal070(block));
    }

    public boolean excavate(int n, int n2, int n3, int n4, int n5, int n6, @Nullable String string) {
        Block block = null;
        if (string != null && !string.isEmpty() && (block = GameInternal056.internalMethod05431(string)) == null) {
            return false;
        }
        return this.start(new GameInternal069(PyNewton.min(n, n2, n3, n4, n5, n6), PyNewton.max(n, n2, n3, n4, n5, n6), block));
    }

    public boolean fill(int n, int n2, int n3, int n4, int n5, int n6, String string) {
        Block block = GameInternal056.internalMethod05431(string);
        if (block == null) {
            return false;
        }
        return this.start(new InventoryInternal038(PyNewton.min(n, n2, n3, n4, n5, n6), PyNewton.max(n, n2, n3, n4, n5, n6), block));
    }

    public void cancel() {
        if (!this.ready()) {
            return;
        }
        RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03476();
        RotationInternal017.internalMethod00114().internalMethod00183().internalMethod01287();
    }

    public boolean pause() {
        CoreInternal146 typedValue308 = this.current();
        if (typedValue308 == null) {
            return false;
        }
        typedValue308.internalMethod04089();
        return true;
    }

    public boolean resume() {
        CoreInternal146 typedValue308 = this.current();
        if (typedValue308 == null) {
            return false;
        }
        typedValue308.internalMethod08146();
        return true;
    }

    public boolean paused() {
        CoreInternal146 typedValue308 = this.current();
        return typedValue308 != null && typedValue308.internalMethod04090();
    }

    @Nullable
    public String process() {
        CoreInternal146 typedValue308 = this.current();
        return typedValue308 == null ? null : typedValue308.internalMethod01129();
    }

    @Nullable
    public String status() {
        CoreInternal146 typedValue308 = this.current();
        return typedValue308 == null ? null : typedValue308.internalMethod05788();
    }

    public boolean command(String string) {
        if (!this.ready() || string == null || string.isBlank()) {
            return false;
        }
        try {
            CommandInternal001 typedValue128 = RotationInternal017.internalMethod00114().internalMethod06865();
            return typedValue128.internalMethod04610(typedValue128.internalMethod03606() + " newton " + string);
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public int pathSteps() {
        CoreInternal138 typedValue294 = this.executor();
        return typedValue294 == null ? 0 : typedValue294.internalMethod00712().internalMethod02878().size();
    }

    public int pathStep() {
        CoreInternal138 typedValue294 = this.executor();
        return typedValue294 == null ? 0 : typedValue294.internalMethod03485();
    }

    public int @Nullable [] nextNode() {
        CoreInternal138 typedValue294 = this.executor();
        if (typedValue294 == null) {
            return null;
        }
        List<RotationInternal019> list = typedValue294.internalMethod00712().internalMethod02878();
        int n = typedValue294.internalMethod03485();
        if (n >= list.size()) {
            return null;
        }
        GameInternal059 typedValue296 = list.get(n).internalMethod02540();
        return new int[]{typedValue296.internalMethod02945(), typedValue296.internalMethod02949(), typedValue296.internalMethod07945()};
    }

    public double @Nullable [] goalPos() {
        double[] dArray;
        GameInternal065 typedValue302;
        CoreInternal138 typedValue294 = this.executor();
        GameInternal065 typedValue303 = typedValue302 = typedValue294 == null ? null : typedValue294.internalMethod00771();
        if (typedValue302 == null) {
            return null;
        }
        Vec3d vec3d = typedValue302.internalMethod07298();
        if (vec3d == null) {
            dArray = null;
        } else {
            double[] dArray2 = new double[3];
            dArray2[0] = vec3d.x;
            dArray2[1] = vec3d.y;
            dArray = dArray2;
            dArray2[2] = vec3d.z;
        }
        return dArray;
    }

    public void select(int n, int n2, int n3) {
        GameInternal055.internalMethod00889().internalMethod04566(new BlockPos(n, n2, n3));
    }

    public void selectClear() {
        GameInternal055.internalMethod00889().internalMethod05224();
    }

    public int @Nullable [] selection() {
        GameInternal055 typedValue288 = GameInternal055.internalMethod00889();
        if (!typedValue288.internalMethod05225()) {
            return null;
        }
        BlockPos blockPos = typedValue288.internalMethod08346();
        BlockPos blockPos2 = typedValue288.internalMethod09055();
        return new int[]{blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ()};
    }

    public boolean excavateSelection(@Nullable String string) {
        GameInternal055 typedValue288 = GameInternal055.internalMethod00889();
        if (!typedValue288.internalMethod05225()) {
            return false;
        }
        BlockPos blockPos = typedValue288.internalMethod08346();
        BlockPos blockPos2 = typedValue288.internalMethod09055();
        return this.excavate(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), string);
    }

    public boolean fillSelection(String string) {
        GameInternal055 typedValue288 = GameInternal055.internalMethod00889();
        if (!typedValue288.internalMethod05225()) {
            return false;
        }
        BlockPos blockPos = typedValue288.internalMethod08346();
        BlockPos blockPos2 = typedValue288.internalMethod09055();
        return this.fill(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), string);
    }

    public boolean safewalk() {
        return CoreInternal126.internalField0277;
    }

    public void setSafewalk(boolean bl) {
        CoreInternal126.internalField0277 = bl;
    }

    public boolean logging() {
        return CoreInternal126.internalField1099;
    }

    public void setLogging(boolean bl) {
        CoreInternal126.internalField1099 = bl;
    }

    private boolean start(CoreInternal146 typedValue308) {
        if (!this.ready()) {
            return false;
        }
        try {
            RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03441(typedValue308);
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    @Nullable
    private CoreInternal146 current() {
        return this.ready() ? (CoreInternal146)RotationInternal017.internalMethod00114().internalMethod06401().internalMethod03684().orElse(null) : null;
    }

    @Nullable
    private CoreInternal138 executor() {
        return this.ready() ? RotationInternal017.internalMethod00114().internalMethod01484() : null;
    }

    private static BlockPos min(int n, int n2, int n3, int n4, int n5, int n6) {
        return new BlockPos(Math.min(n, n4), Math.min(n2, n5), Math.min(n3, n6));
    }

    private static BlockPos max(int n, int n2, int n3, int n4, int n5, int n6) {
        return new BlockPos(Math.max(n, n4), Math.max(n2, n5), Math.max(n3, n6));
    }
}

