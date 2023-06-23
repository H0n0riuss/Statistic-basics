package io.github.H0n0riuss.calculations.arithmetic;

import java.util.Arrays;

public class Median {
    public double calculateMedian(double[] data) {
        var n = data.length;

        Arrays.sort(data);

        var i = n / 2;
        return (n % 2 == 0) ? (data[i - 1] + data[i]) / 2 : data[i];
    }

    public double[] calculateUndefinedMedian(double[] data) {
        var n = data.length;
        if (n % 2 == 0) throw new IllegalArgumentException("Data length is not even.");

        var i = n / 2;

        return new double[]{data[i - 1], data[i]};
    }
}
