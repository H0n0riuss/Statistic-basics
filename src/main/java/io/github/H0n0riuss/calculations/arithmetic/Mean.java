package io.github.H0n0riuss.calculations.arithmetic;

import io.github.H0n0riuss.assertions.Assert;

public class Mean {

    public double calculateMean(double[] data) throws ArithmeticException {
        if (data.length == 0) throw new ArithmeticException("Contains no data.");

        var res = 0d;
        for (var entry : data) {
            res += entry;
        }
        return res / data.length;
    }

    public double calculateWeightedMean(double[] g, double[] x) {
        if (g.length == 0 || x.length == 0 || g.length != x.length) throw new ArithmeticException("invalid data");

        var counter = 0d;
        var denominator = 0d;
        for (var i = 0; i < g.length; ++i) {
            counter += g[i] * x[i];
            denominator += g[i];
        }
        if (denominator <= 0) throw new ArithmeticException("denominator is less or equals 0");
        return counter / denominator;
    }

    public double calculateHarmonicMean(double[] x) {
        var n = (double) x.length;

        if (n == 0) throw new ArithmeticException("Contains no data.");
        if (!Assert.assertPositiveNumbers(x)) throw new ArithmeticException("Data contains negative data.");

        var res = 0d;
        for (var y : x) {
            res += 1 / y;
        }
        return n / res;
    }

    public double calculateGeometricMean(double[] data) {
        if (data.length == 0) throw new ArithmeticException("Contains no data");
        if (!Assert.assertPositiveNumbers(data)) throw new ArithmeticException("Data contains negative data.");

        var res = 1d;
        var n = (double) data.length;

        for (var x : data) {
            res *= x;
        }
        return Math.pow(res, 1d / n);
    }
}
