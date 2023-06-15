package io.github.H0n0riuss.calculations.frequency;

import io.github.H0n0riuss.calculations.frequency.models.BoxPlotModel;

import java.util.Arrays;

public class FrequencyDistribution {

    public void calculateFrequencyDensity() {

    }

    public BoxPlotModel calculateBoxplot(float[] data) throws ArithmeticException { //TODO in das richtige package bringen
        if (data.length == 0) throw new ArithmeticException("Contains no data.");

        Arrays.sort(data);

        return BoxPlotModel.builder()
                .minimum(data[0])
                .lowerQuartile(calculateQuantile(data, 0.25f))
                .median(calculateQuantile(data, 0.50f))
                .higherQuartile(calculateQuantile(data, 0.75f))
                .maximum(data[data.length - 1])
                .build();
    }

    private float calculateQuantile(float[] data, float percentage) { //TODO wie wird das Quantil wirklich gebildet (ist es das nächste an 25/75% oder aus der Summe)
        var test = (data.length - 1) * percentage;
        var index = Math.round(test);
        return data[index];
    }
}
