package io.github.H0n0riuss.calculations.arithmetic;

import io.github.H0n0riuss.assertions.Assert;

public class Mean {

    public float calculateMean(float[] data) throws ArithmeticException {
        if (data.length == 0) throw new ArithmeticException("Contains no data.");

        var res = 0f;
        for (var entry : data) {
            res += entry;
        }
        return res / data.length;
    }

    public float calculateWeightedMean(float[] g, float[] x) {
        if (g.length == 0 || x.length == 0 || g.length != x.length) throw new ArithmeticException("invalid data");

        var counter = 0f;
        var denominator = 0f;
        for (var i = 0; i < g.length; ++i) {
            counter += g[i] * x[i];
            denominator += g[i];
        }
        if (denominator <= 0) throw new ArithmeticException("denominator is less or equals 0");
        return counter / denominator;
    }

    public float calculateHarmonicMean(float[] x) {
        var n = (float)x.length;

        if (n == 0) throw new ArithmeticException("Contains no data.");
        if (!Assert.assertPositiveNumbers(x)) throw new ArithmeticException("Data contains negative data.");

        var res = 0f;
        for (var y : x) {
            res += 1 / y;
        }
        return n / res;
    }
}
