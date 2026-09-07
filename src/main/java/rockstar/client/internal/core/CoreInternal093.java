package rockstar.client.internal.core;


import rockstar.client.*;
import java.util.Random;

public class CoreInternal093 {
    private final int[] internalField0618 = new int[512];

    public CoreInternal093() {
        this(System.currentTimeMillis());
    }

    public CoreInternal093(long l) {
        int n;
        Random random = new Random(l);
        int[] nArray = new int[256];
        for (n = 0; n < 256; ++n) {
            nArray[n] = n;
        }
        for (n = 0; n < 256; ++n) {
            int n2 = random.nextInt(256 - n) + n;
            int n3 = nArray[n];
            nArray[n] = nArray[n2];
            nArray[n2] = n3;
        }
        for (n = 0; n < 256; ++n) {
            int n4 = nArray[n];
            this.internalField0618[n + 256] = n4;
            this.internalField0618[n] = n4;
        }
    }

    public double internalMethod03107(double d) {
        return this.internalMethod07511(d, 0.0, 0.0);
    }

    public double internalMethod06087(double d, double d2) {
        return this.internalMethod07511(d, d2, 0.0);
    }

    public double internalMethod07511(double d, double d2, double d3) {
        int n = (int)Math.floor(d) & 0xFF;
        int n2 = (int)Math.floor(d2) & 0xFF;
        int n3 = (int)Math.floor(d3) & 0xFF;
        d -= Math.floor(d);
        d2 -= Math.floor(d2);
        d3 -= Math.floor(d3);
        double d4 = CoreInternal093.internalMethod03160(d);
        double d5 = CoreInternal093.internalMethod03160(d2);
        double d6 = CoreInternal093.internalMethod03160(d3);
        int n4 = this.internalField0618[n] + n2;
        int n5 = this.internalField0618[n4] + n3;
        int n6 = this.internalField0618[n4 + 1] + n3;
        int n7 = this.internalField0618[n + 1] + n2;
        int n8 = this.internalField0618[n7] + n3;
        int n9 = this.internalField0618[n7 + 1] + n3;
        return CoreInternal093.internalMethod04388(d6, CoreInternal093.internalMethod04388(d5, CoreInternal093.internalMethod04388(d4, CoreInternal093.internalMethod03367(this.internalField0618[n5], d, d2, d3), CoreInternal093.internalMethod03367(this.internalField0618[n8], d - 1.0, d2, d3)), CoreInternal093.internalMethod04388(d4, CoreInternal093.internalMethod03367(this.internalField0618[n6], d, d2 - 1.0, d3), CoreInternal093.internalMethod03367(this.internalField0618[n9], d - 1.0, d2 - 1.0, d3))), CoreInternal093.internalMethod04388(d5, CoreInternal093.internalMethod04388(d4, CoreInternal093.internalMethod03367(this.internalField0618[n5 + 1], d, d2, d3 - 1.0), CoreInternal093.internalMethod03367(this.internalField0618[n8 + 1], d - 1.0, d2, d3 - 1.0)), CoreInternal093.internalMethod04388(d4, CoreInternal093.internalMethod03367(this.internalField0618[n6 + 1], d, d2 - 1.0, d3 - 1.0), CoreInternal093.internalMethod03367(this.internalField0618[n9 + 1], d - 1.0, d2 - 1.0, d3 - 1.0))));
    }

    private static double internalMethod03160(double d) {
        return d * d * d * (d * (d * 6.0 - 15.0) + 10.0);
    }

    private static double internalMethod04388(double d, double d2, double d3) {
        return d2 + d * (d3 - d2);
    }

    private static double internalMethod03367(int n, double d, double d2, double d3) {
        double d4;
        int n2 = n & 0xF;
        double d5 = d4 = n2 < 8 ? d : d2;
        double d6 = n2 < 4 ? d2 : (n2 == 12 || n2 == 14 ? d : d3);
        return ((n2 & 1) == 0 ? d4 : -d4) + ((n2 & 2) == 0 ? d6 : -d6);
    }
}

