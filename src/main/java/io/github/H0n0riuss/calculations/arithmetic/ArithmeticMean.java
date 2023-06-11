package io.github.H0n0riuss.calculations.arithmetic;

public class ArithmeticMean {

    public float calculateArithmeticMean(float[] data) throws ArithmeticException {
        if (data.length == 0) throw new ArithmeticException("Contains no data.");

        var res = 0f;
        for (var entry : data) {
            res += entry;
        }
        return res / data.length;
    }

    public float calculateWeightedArithmeticMean(float[] g, float[] x) {
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
}
