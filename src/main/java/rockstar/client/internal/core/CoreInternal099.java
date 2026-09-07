package rockstar.client.internal.core;


import rockstar.client.*;
import rockstar.client.internal.core.CoreInternal098;

public class CoreInternal099 {
    private static final int internalField0227 = 0;
    private static final int internalField0228 = 1;
    private static final int internalField1053 = 2;
    private static final int internalField1055 = 3;
    private static final int internalField1056 = 4;
    private static final int internalField1054 = 5;
    private static final int internalField1464 = 6;
    private static final int internalField1470 = 7;
    private static final int internalField1465 = 8;
    private static final int internalField1463 = 9;
    private static final int internalField1466 = 10;
    private static final int internalField1467 = 11;
    private static final int internalField1469 = 12;
    private static final int internalField1468 = 13;
    private static final int internalField1740 = 14;
    private static final int internalField1741 = 15;
    private static final int internalField1736 = 16;
    private static final int internalField1735 = 17;
    private static final int internalField1748 = 18;
    private static final int internalField1733 = 19;
    private static final int internalField1738 = 20;
    private static final int internalField1739 = 21;
    private static final int internalField1742 = 22;
    private static final int internalField1743 = 23;
    private static final int internalField1744 = 24;
    private static final int internalField1745 = 25;
    private static final int internalField1746 = 26;
    private static final int internalField1747 = 27;
    private static final int internalField1734 = 28;
    private static final int internalField1737 = 29;
    private static final int internalField1860 = 30;
    private static final CoreInternal098[] internalField0685 = new CoreInternal098[31];

    public static CoreInternal098 internalMethod03979(String string) {
        return switch (string) {
            case "sin" -> internalField0685[0];
            case "cos" -> internalField0685[1];
            case "tan" -> internalField0685[2];
            case "cot" -> internalField0685[5];
            case "asin" -> internalField0685[12];
            case "acos" -> internalField0685[13];
            case "atan" -> internalField0685[14];
            case "sinh" -> internalField0685[6];
            case "cosh" -> internalField0685[7];
            case "tanh" -> internalField0685[8];
            case "abs" -> internalField0685[17];
            case "log" -> internalField0685[25];
            case "log10" -> internalField0685[23];
            case "log2" -> internalField0685[24];
            case "log1p" -> internalField0685[26];
            case "ceil" -> internalField0685[18];
            case "floor" -> internalField0685[19];
            case "sqrt" -> internalField0685[15];
            case "cbrt" -> internalField0685[16];
            case "pow" -> internalField0685[20];
            case "exp" -> internalField0685[21];
            case "expm1" -> internalField0685[22];
            case "signum" -> internalField0685[28];
            case "csc" -> internalField0685[3];
            case "sec" -> internalField0685[4];
            case "csch" -> internalField0685[9];
            case "sech" -> internalField0685[10];
            case "coth" -> internalField0685[11];
            case "toradian" -> internalField0685[29];
            case "todegree" -> internalField0685[30];
            default -> null;
        };
    }

    static {
        CoreInternal099.internalField0685[0] = new CoreInternal098("sin"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.sin(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[1] = new CoreInternal098("cos"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.cos(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[2] = new CoreInternal098("tan"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.tan(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[5] = new CoreInternal098("cot"){

            @Override
            public double internalMethod03000(double ... dArray) {
                double d = Math.tan(dArray[0]);
                if (d == 0.0) {
                    throw new ArithmeticException("Division by zero in cotangent!");
                }
                return 1.0 / d;
            }
        };
        CoreInternal099.internalField0685[25] = new CoreInternal098("log"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.log(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[24] = new CoreInternal098("log2"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.log(dArray[0]) / Math.log(2.0);
            }
        };
        CoreInternal099.internalField0685[23] = new CoreInternal098("log10"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.log10(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[26] = new CoreInternal098("log1p"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.log1p(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[17] = new CoreInternal098("abs"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.abs(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[13] = new CoreInternal098("acos"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.acos(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[12] = new CoreInternal098("asin"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.asin(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[14] = new CoreInternal098("atan"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.atan(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[16] = new CoreInternal098("cbrt"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.cbrt(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[19] = new CoreInternal098("floor"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.floor(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[6] = new CoreInternal098("sinh"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.sinh(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[15] = new CoreInternal098("sqrt"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.sqrt(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[8] = new CoreInternal098("tanh"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.tanh(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[7] = new CoreInternal098("cosh"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.cosh(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[18] = new CoreInternal098("ceil"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.ceil(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[20] = new CoreInternal098("pow", 2){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.pow(dArray[0], dArray[1]);
            }
        };
        CoreInternal099.internalField0685[21] = new CoreInternal098("exp", 1){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.exp(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[22] = new CoreInternal098("expm1", 1){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.expm1(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[28] = new CoreInternal098("signum", 1){

            @Override
            public double internalMethod03000(double ... dArray) {
                if (dArray[0] > 0.0) {
                    return 1.0;
                }
                if (dArray[0] < 0.0) {
                    return -1.0;
                }
                return 0.0;
            }
        };
        CoreInternal099.internalField0685[3] = new CoreInternal098("csc"){

            @Override
            public double internalMethod03000(double ... dArray) {
                double d = Math.sin(dArray[0]);
                if (d == 0.0) {
                    throw new ArithmeticException("Division by zero in cosecant!");
                }
                return 1.0 / d;
            }
        };
        CoreInternal099.internalField0685[4] = new CoreInternal098("sec"){

            @Override
            public double internalMethod03000(double ... dArray) {
                double d = Math.cos(dArray[0]);
                if (d == 0.0) {
                    throw new ArithmeticException("Division by zero in secant!");
                }
                return 1.0 / d;
            }
        };
        CoreInternal099.internalField0685[9] = new CoreInternal098("csch"){

            @Override
            public double internalMethod03000(double ... dArray) {
                if (dArray[0] == 0.0) {
                    return 0.0;
                }
                return 1.0 / Math.sinh(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[10] = new CoreInternal098("sech"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return 1.0 / Math.cosh(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[11] = new CoreInternal098("coth"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.cosh(dArray[0]) / Math.sinh(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[27] = new CoreInternal098("logb", 2){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.log(dArray[1]) / Math.log(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[29] = new CoreInternal098("toradian"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.toRadians(dArray[0]);
            }
        };
        CoreInternal099.internalField0685[30] = new CoreInternal098("todegree"){

            @Override
            public double internalMethod03000(double ... dArray) {
                return Math.toDegrees(dArray[0]);
            }
        };
    }
}

