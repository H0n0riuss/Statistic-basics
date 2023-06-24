package io.github.H0n0riuss.calculations.frequency;

import io.github.H0n0riuss.calculations.frequency.models.BoxPlotModel;

import java.util.Arrays;

public class BoxPlot {

    public BoxPlotModel calculateBoxplot(double[] data) throws ArithmeticException {
        if (data.length == 0) throw new ArithmeticException("Contains no data.");

        Arrays.sort(data);

        return BoxPlotModel.builder()
                .minimum(data[0])
                .lowerQuartile(calculateQuantile(data, 0.25f))
                .median(calculateQuantile(data, 0.5f))
                .higherQuartile(calculateQuantile(data, 0.75f))
                .maximum(data[data.length - 1])
                .build();
    }

    private double calculateQuantile(double[] data, double percentage) {
        var n = data.length;
        var quantile = n * percentage;
        var index = (int) Math.round(quantile);
        return (n % 2 == 0) ? (data[index - 1] + data[index]) / 2 : data[index];
    }
}
