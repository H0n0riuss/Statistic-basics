package io.github.H0n0riuss.calculations.arithmetic;

import io.github.H0n0riuss.calculations.frequency.BoxPlot;

import java.util.Arrays;

public class Spread {
    public static double averageMean(double[] data) {
        var n = data.length;

        if (n == 0) throw new ArithmeticException("Contains no data.");

        var res = 0d;
        for (var x : data) {
            res += x;
        }
        return res / n;
    }

    public static double span(double[] data) {
        var n = data.length;

        if (n == 0) throw new ArithmeticException("Contains no data.");

        Arrays.sort(data);

        return data[n - 1] - data[0];
    }

    public static double quarterlyDistance(double[] data) {
        var boxPlot = BoxPlot.boxPlot(data);
        return boxPlot.higherQuantile - boxPlot.lowerQuantile;
    }

    public static double empiricallyVariance(double[] data) {
        var n = data.length;
        var arithmeticMean = Mean.arithmeticMean(data);
        var res = 0d;
        for (double d : data) {
            res += Math.pow((d - arithmeticMean), 2);
        }
        return res / (n - 1);
    }

    public static double empiricallyVarianceSpread(double[] data) {
        return Math.pow(empiricallyVariance(data), (double) 1 / 2);
    }
}
