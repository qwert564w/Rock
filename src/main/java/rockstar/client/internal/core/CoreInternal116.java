package rockstar.client.internal.core;


import rockstar.client.*;
import lombok.Generated;

public final class CoreInternal116 {
    public static int internalMethod05866(int n) {
        return n >> 16 & 0xFF;
    }

    public static int internalMethod05920(int n) {
        return n >> 8 & 0xFF;
    }

    public static int internalMethod07900(int n) {
        return n & 0xFF;
    }

    public static int internalMethod07905(int n) {
        return n >> 24 & 0xFF;
    }

    public static float internalMethod05865(int n) {
        return (float)CoreInternal116.internalMethod05866(n) / 255.0f;
    }

    public static float internalMethod05919(int n) {
        return (float)CoreInternal116.internalMethod05920(n) / 255.0f;
    }

    public static float internalMethod07899(int n) {
        return (float)CoreInternal116.internalMethod07900(n) / 255.0f;
    }

    public static float internalMethod07904(int n) {
        return (float)CoreInternal116.internalMethod07905(n) / 255.0f;
    }

    public static int[] internalMethod00932(int n) {
        return new int[]{CoreInternal116.internalMethod05866(n), CoreInternal116.internalMethod05920(n), CoreInternal116.internalMethod07900(n), CoreInternal116.internalMethod07905(n)};
    }

    public static int[] internalMethod02647(int n) {
        return new int[]{CoreInternal116.internalMethod05866(n), CoreInternal116.internalMethod05920(n), CoreInternal116.internalMethod07900(n)};
    }

    public static float[] internalMethod00931(int n) {
        return new float[]{CoreInternal116.internalMethod05865(n), CoreInternal116.internalMethod05919(n), CoreInternal116.internalMethod07899(n), CoreInternal116.internalMethod07904(n)};
    }

    public static float[] internalMethod02646(int n) {
        return new float[]{CoreInternal116.internalMethod05865(n), CoreInternal116.internalMethod05919(n), CoreInternal116.internalMethod07899(n)};
    }

    @Generated
    private CoreInternal116() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

