package rockstar.client.internal.core;


import rockstar.client.*;
public class CoreInternal096 {
    private double internalField0194 = 1.0;
    private double internalField0193 = 0.0;
    private double internalField1045 = 1.0;
    private double internalField1043;
    private double internalField1042;
    private double internalField1044 = Double.NaN;
    private double internalField1453 = Double.NaN;

    public CoreInternal096(double d, double d2, double d3, double d4, double d5) {
        this.internalField1043 = d;
        this.internalField1042 = d2;
        this.internalField0194 = d3;
        this.internalField0193 = d4;
        this.internalField1045 = d5;
    }

    public CoreInternal096(double d, double d2) {
        this.internalField1043 = d;
        this.internalField1042 = d2;
    }

    public double internalMethod06780(double d, double d2) {
        if (Double.isNaN(this.internalField1453)) {
            this.internalField1453 = 1.0 / this.internalField1045 * d;
            this.internalField1044 = 1.0 / this.internalField1045 * this.internalField1042 * (1.0 / this.internalField1045);
        } else {
            double d3 = this.internalField0194 * this.internalField1453 + this.internalField0193 * d2;
            double d4 = this.internalField0194 * this.internalField1044 * this.internalField0194 + this.internalField1043;
            double d5 = d4 * this.internalField1045 * (1.0 / (this.internalField1045 * d4 * this.internalField1045 + this.internalField1042));
            this.internalField1453 = d3 + d5 * (d - this.internalField1045 * d3);
            this.internalField1044 = d4 - d5 * this.internalField1045 * d4;
        }
        return this.internalField1453;
    }

    public double internalMethod02400(double d) {
        return this.internalMethod06780(d, 0.0);
    }

    public double internalMethod03254() {
        return this.internalField1453;
    }

    public void internalMethod02401(double d) {
        this.internalField1042 = d;
    }

    public void internalMethod02468(double d) {
        this.internalField1043 = d;
    }
}

