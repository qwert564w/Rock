package rockstar.client.internal.core;


import rockstar.client.*;
import rockstar.client.internal.core.CoreInternal100;

public abstract class CoreInternal101 {
    private static final int internalField0227 = 0;
    private static final int internalField0228 = 1;
    private static final int internalField1053 = 2;
    private static final int internalField1055 = 3;
    private static final int internalField1056 = 4;
    private static final int internalField1054 = 5;
    private static final int internalField1464 = 6;
    private static final int internalField1470 = 7;
    private static final CoreInternal100[] internalField0686 = new CoreInternal100[8];

    public static CoreInternal100 internalMethod00317(char c, int n) {
        switch (c) {
            case '+': {
                if (n != 1) {
                    return internalField0686[0];
                }
                return internalField0686[7];
            }
            case '-': {
                if (n != 1) {
                    return internalField0686[1];
                }
                return internalField0686[6];
            }
            case '*': {
                return internalField0686[2];
            }
            case '/': 
            case '\u00f7': {
                return internalField0686[3];
            }
            case '^': {
                return internalField0686[4];
            }
            case '%': {
                return internalField0686[5];
            }
        }
        return null;
    }

    static {
        CoreInternal101.internalField0686[0] = new CoreInternal100("+", 2, true, 500){

            @Override
            public double internalMethod07375(double ... dArray) {
                return dArray[0] + dArray[1];
            }
        };
        CoreInternal101.internalField0686[1] = new CoreInternal100("-", 2, true, 500){

            @Override
            public double internalMethod07375(double ... dArray) {
                return dArray[0] - dArray[1];
            }
        };
        CoreInternal101.internalField0686[6] = new CoreInternal100("-", 1, false, 5000){

            @Override
            public double internalMethod07375(double ... dArray) {
                return -dArray[0];
            }
        };
        CoreInternal101.internalField0686[7] = new CoreInternal100("+", 1, false, 5000){

            @Override
            public double internalMethod07375(double ... dArray) {
                return dArray[0];
            }
        };
        CoreInternal101.internalField0686[2] = new CoreInternal100("*", 2, true, 1000){

            @Override
            public double internalMethod07375(double ... dArray) {
                return dArray[0] * dArray[1];
            }
        };
        CoreInternal101.internalField0686[3] = new CoreInternal100("/", 2, true, 1000){

            @Override
            public double internalMethod07375(double ... dArray) {
                if (dArray[1] == 0.0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return dArray[0] / dArray[1];
            }
        };
        CoreInternal101.internalField0686[4] = new CoreInternal100("^", 2, false, 10000){

            @Override
            public double internalMethod07375(double ... dArray) {
                return Math.pow(dArray[0], dArray[1]);
            }
        };
        CoreInternal101.internalField0686[5] = new CoreInternal100("%", 2, true, 1000){

            @Override
            public double internalMethod07375(double ... dArray) {
                if (dArray[1] == 0.0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return dArray[0] % dArray[1];
            }
        };
    }
}

