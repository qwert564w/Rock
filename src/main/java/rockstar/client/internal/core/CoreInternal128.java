package rockstar.client.internal.core;



import rockstar.client.internal.game.*;
import rockstar.client.*;
import rockstar.client.internal.game.GameInternal054;

public final class CoreInternal128 {
    private static volatile GameInternal054 internalField0526;

    private CoreInternal128() {
    }

    public static GameInternal054 internalMethod01856() {
        GameInternal054 typedValue281 = internalField0526;
        if (typedValue281 == null) {
            throw new IllegalStateException("Newton API is not initialised yet (initialise after Newton mod is loaded)");
        }
        return typedValue281;
    }

    public static boolean internalMethod05192() {
        return internalField0526 != null;
    }

    public static void internalMethod03916(GameInternal054 typedValue281) {
        if (internalField0526 != null) {
            throw new IllegalStateException("Newton API already installed");
        }
        internalField0526 = typedValue281;
    }
}

