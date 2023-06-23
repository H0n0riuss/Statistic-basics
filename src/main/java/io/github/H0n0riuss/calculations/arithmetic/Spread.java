package io.github.H0n0riuss.calculations.arithmetic;

public class Spread {
    public double averageMeanSpread(double[] data) {
        var n = data.length;

        if (n == 0) throw new ArithmeticException("Contains no data.");

        var res = 0d;
        for (var x : data) {
            res += x;
        }
        return res / n;
    }
}
