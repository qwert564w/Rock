package rockstar.client.internal.core;





import rockstar.client.rotation.*;
import rockstar.client.internal.rotation.*;
import rockstar.client.internal.game.*;
import rockstar.client.*;
import java.util.ArrayList;
import java.util.List;
import rockstar.client.internal.game.GameInternal057;
import rockstar.client.internal.game.GameInternal059;
import rockstar.client.internal.rotation.RotationInternal019;
import rockstar.client.internal.core.CoreInternal139;
import rockstar.client.internal.rotation.RotationInternal020;
import rockstar.client.internal.rotation.RotationInternal021;
import rockstar.client.internal.rotation.RotationInternal022;
import rockstar.client.internal.game.GameInternal066;
import rockstar.client.internal.game.GameInternal067;
import rockstar.client.internal.core.CoreInternal140;
import rockstar.client.internal.core.CoreInternal141;
import rockstar.client.internal.core.CoreInternal142;
import rockstar.client.internal.core.CoreInternal143;
import rockstar.client.internal.rotation.RotationInternal023;
import rockstar.client.internal.core.CoreInternal144;

public final class CoreInternal145 {
    private static final int[][] internalField0040 = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int[][] internalField0041 = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private CoreInternal145() {
    }

    public static List<RotationInternal019> internalMethod03577(GameInternal059 typedValue296, GameInternal057 typedValue292) {
        ArrayList<RotationInternal019> arrayList = new ArrayList<RotationInternal019>(24);
        boolean bl = typedValue292.internalMethod09396(typedValue296.internalMethod02945(), typedValue296.internalMethod02949(), typedValue296.internalMethod07945());
        boolean bl2 = typedValue292.internalMethod08763(typedValue296.internalMethod02945(), typedValue296.internalMethod02949(), typedValue296.internalMethod07945());
        boolean bl3 = typedValue292.internalMethod07759(typedValue296.internalMethod02945(), typedValue296.internalMethod02949(), typedValue296.internalMethod07945());
        if (bl) {
            CoreInternal145.internalMethod02583(typedValue296, typedValue292, arrayList);
        }
        if (bl3) {
            CoreInternal145.internalMethod04019(typedValue296, typedValue292, arrayList, bl);
        }
        if (bl2) {
            CoreInternal145.internalMethod01096(typedValue296, typedValue292, arrayList, bl);
        }
        if (!(bl || bl2 || bl3)) {
            CoreInternal145.internalMethod02583(typedValue296, typedValue292, arrayList);
            CoreInternal145.internalMethod01096(typedValue296, typedValue292, arrayList, false);
        }
        return arrayList;
    }

    private static void internalMethod02583(GameInternal059 typedValue296, GameInternal057 typedValue292, List<RotationInternal019> list) {
        int n;
        int n2;
        int n3 = typedValue296.internalMethod02945();
        double d = typedValue292.internalMethod05956(n3, n2 = typedValue296.internalMethod02949(), n = typedValue296.internalMethod07945());
        if (Double.isNaN(d)) {
            d = n2;
        }
        for (int[] nArray : internalField0040) {
            int n4;
            int n5;
            int n6 = n3 + nArray[0];
            int n7 = n + nArray[1];
            boolean bl = false;
            for (n5 = 1; n5 >= -1; --n5) {
                n4 = n2 + n5;
                double d2 = typedValue292.internalMethod05956(n6, n4, n7);
                if (Double.isNaN(d2)) continue;
                double d3 = d2 - d;
                GameInternal059 typedValue297 = new GameInternal059(n6, n4, n7);
                if (Math.abs(d3) <= 0.62) {
                    bl |= CoreInternal145.internalMethod07018(new CoreInternal144(typedValue296, typedValue297), typedValue292, list);
                    continue;
                }
                if (d3 > 0.62 && d3 <= 1.3) {
                    bl |= CoreInternal145.internalMethod07018(new CoreInternal139(typedValue296, typedValue297), typedValue292, list);
                    continue;
                }
                if (!(d3 < -0.62) || !(d3 >= -1.3)) continue;
                bl |= CoreInternal145.internalMethod07018(new CoreInternal140(typedValue296, typedValue297), typedValue292, list);
            }
            if (!bl) {
                if (typedValue292.internalMethod06691()) {
                    CoreInternal145.internalMethod07018(new RotationInternal021(typedValue296, new GameInternal059(n6, n2 + 1, n7)), typedValue292, list);
                    CoreInternal145.internalMethod07018(new RotationInternal020(typedValue296, new GameInternal059(n6, n2, n7)), typedValue292, list);
                }
                n5 = 0;
                for (n4 = 2; n4 <= 12; ++n4) {
                    if (!CoreInternal145.internalMethod07018(new CoreInternal142(typedValue296, new GameInternal059(n6, n2 - n4, n7)), typedValue292, list)) continue;
                    n5 = 1;
                    break;
                }
                if (n5 == 0 && typedValue292.internalMethod06691()) {
                    CoreInternal145.internalMethod07018(new RotationInternal022(typedValue296, new GameInternal059(n6, n2 - 1, n7)), typedValue292, list);
                }
                CoreInternal145.internalMethod07018(new RotationInternal023(typedValue296, new GameInternal059(n6, n2, n7), RotationInternal023.InternalType0152.internalField0983), typedValue292, list);
                CoreInternal145.internalMethod07018(new RotationInternal023(typedValue296, new GameInternal059(n6, n2 - 1, n7), RotationInternal023.InternalType0152.internalField0983), typedValue292, list);
                CoreInternal145.internalMethod07018(new CoreInternal144(typedValue296, new GameInternal059(n6, n2, n7), true), typedValue292, list);
                CoreInternal145.internalMethod07018(new CoreInternal144(typedValue296, new GameInternal059(n6, n2 - 1, n7), true), typedValue292, list);
            }
            CoreInternal145.internalMethod07018(new CoreInternal143(typedValue296, new GameInternal059(n3 + nArray[0] * 2, n2, n + nArray[1] * 2)), typedValue292, list);
            CoreInternal145.internalMethod07018(new CoreInternal143(typedValue296, new GameInternal059(n3 + nArray[0] * 3, n2, n + nArray[1] * 3)), typedValue292, list);
        }
        for (int[] nArray : internalField0041) {
            CoreInternal145.internalMethod07018(new CoreInternal141(typedValue296, new GameInternal059(n3 + nArray[0], n2, n + nArray[1])), typedValue292, list);
        }
        if (typedValue292.internalMethod06691()) {
            CoreInternal145.internalMethod07018(new GameInternal066(typedValue296, new GameInternal059(n3, n2 - 1, n)), typedValue292, list);
        }
        if (typedValue292.internalMethod07759(n3, n2, n)) {
            CoreInternal145.internalMethod07018(new GameInternal067(typedValue296, new GameInternal059(n3, n2 + 1, n), GameInternal067.InternalType0062.internalField0690), typedValue292, list);
        }
    }

    private static void internalMethod04019(GameInternal059 typedValue296, GameInternal057 typedValue292, List<RotationInternal019> list, boolean bl) {
        int n;
        int n2;
        int n3 = typedValue296.internalMethod02945();
        boolean bl2 = CoreInternal145.internalMethod07018(new GameInternal067(typedValue296, new GameInternal059(n3, (n2 = typedValue296.internalMethod02949()) + 1, n = typedValue296.internalMethod07945()), GameInternal067.InternalType0062.internalField0690), typedValue292, list);
        if (!bl2) {
            for (int[] nArray : internalField0040) {
                CoreInternal145.internalMethod07018(new GameInternal067(typedValue296, new GameInternal059(n3 + nArray[0], n2 + 1, n + nArray[1]), GameInternal067.InternalType0062.internalField1279), typedValue292, list);
            }
        }
        if (!bl) {
            CoreInternal145.internalMethod07018(new GameInternal067(typedValue296, new GameInternal059(n3, n2 - 1, n), GameInternal067.InternalType0062.internalField0689), typedValue292, list);
            for (int[] nArray : internalField0040) {
                CoreInternal145.internalMethod07018(new CoreInternal144(typedValue296, new GameInternal059(n3 + nArray[0], n2, n + nArray[1])), typedValue292, list);
                CoreInternal145.internalMethod07018(new CoreInternal140(typedValue296, new GameInternal059(n3 + nArray[0], n2 - 1, n + nArray[1])), typedValue292, list);
            }
        }
    }

    private static void internalMethod01096(GameInternal059 typedValue296, GameInternal057 typedValue292, List<RotationInternal019> list, boolean bl) {
        int n = typedValue296.internalMethod02945();
        int n2 = typedValue296.internalMethod02949();
        int n3 = typedValue296.internalMethod07945();
        for (int[] nArray : internalField0040) {
            int n4 = n + nArray[0];
            int n5 = n3 + nArray[1];
            CoreInternal145.internalMethod07018(new RotationInternal023(typedValue296, new GameInternal059(n4, n2, n5), RotationInternal023.InternalType0152.internalField0076), typedValue292, list);
            if (!bl) {
                CoreInternal145.internalMethod07018(new RotationInternal023(typedValue296, new GameInternal059(n4, n2, n5), RotationInternal023.InternalType0152.internalField0982), typedValue292, list);
            }
            CoreInternal145.internalMethod07018(new RotationInternal023(typedValue296, new GameInternal059(n4, n2 + 1, n5), RotationInternal023.InternalType0152.internalField0981), typedValue292, list);
        }
        for (int[] nArray : internalField0041) {
            CoreInternal145.internalMethod07018(new RotationInternal023(typedValue296, new GameInternal059(n + nArray[0], n2, n3 + nArray[1]), RotationInternal023.InternalType0152.internalField0076), typedValue292, list);
        }
        CoreInternal145.internalMethod07018(new RotationInternal023(typedValue296, new GameInternal059(n, n2 + 1, n3), RotationInternal023.InternalType0152.internalField0077), typedValue292, list);
        CoreInternal145.internalMethod07018(new RotationInternal023(typedValue296, new GameInternal059(n, n2 - 1, n3), RotationInternal023.InternalType0152.internalField0984), typedValue292, list);
    }

    private static boolean internalMethod07018(RotationInternal019 typedValue304, GameInternal057 typedValue292, List<RotationInternal019> list) {
        boolean bl;
        if (!typedValue304.internalMethod04946(typedValue292)) {
            return false;
        }
        GameInternal059 typedValue296 = typedValue304.internalMethod02540();
        typedValue304.internalMethod05093(typedValue292.internalMethod02775(typedValue296.internalMethod02945(), typedValue296.internalMethod02949(), typedValue296.internalMethod07945()));
        boolean bl2 = bl = typedValue304 instanceof CoreInternal144 || typedValue304 instanceof CoreInternal141 || typedValue304 instanceof CoreInternal139 || typedValue304 instanceof CoreInternal140;
        if (bl && typedValue292.internalMethod07797(typedValue296.internalMethod02945(), typedValue296.internalMethod02949(), typedValue296.internalMethod07945())) {
            GameInternal059 typedValue297 = typedValue304.internalMethod01873();
            double d = Math.max(1.0, Math.hypot(typedValue296.internalMethod02945() - typedValue297.internalMethod02945(), typedValue296.internalMethod07945() - typedValue297.internalMethod07945()));
            typedValue304.internalMethod05093((typedValue292.internalMethod07797(typedValue296.internalMethod02945(), typedValue296.internalMethod02949() + 1, typedValue296.internalMethod07945()) ? 5.0 : 0.8) * d);
        }
        list.add(typedValue304);
        return true;
    }
}

