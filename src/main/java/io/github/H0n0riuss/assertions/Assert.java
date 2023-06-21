package io.github.H0n0riuss.assertions;

public class Assert {

    public static boolean assertPositiveNumbers(float[] x) {
        for (var y : x) {
            if (y < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean assertPositiveNumbers(double[] x) {
        for (var y : x) {
            if (y < 0) {
                return false;
            }
        }
        return true;
    }
}
