package io.github.H0n0riuss.calculations.arithmetic;

import io.github.H0n0riuss.calculations.frequency.BoxPlot;

import java.util.Arrays;

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

    public double span(double[] data) {
        var n = data.length;

        if (n == 0) throw new ArithmeticException("Contains no data.");

        Arrays.sort(data);

        return data[n - 1] - data[0];
    }

    public double quarterlyDistance(double[] data) {
        var boxPlot = new BoxPlot().calculateBoxPlot(data);
        return boxPlot.higherQuantile - boxPlot.lowerQuantile;
    }
}
