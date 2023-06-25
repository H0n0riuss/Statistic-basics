package io.github.H0n0riuss.calculations.frequency.models;

import lombok.Builder;

public class BoxPlotExpatriateModel extends BoxPlotModel {
    public final double[] lowerExpatriates;
    public final double[] higherExpatriates;

    @Builder(builderMethodName = "childBuilder")
    public BoxPlotExpatriateModel(double minimum, double lowerQuantile, double median, double higherQuantile,
                                  double maximum, double[] lowerExpatriates, double[] higherExpatriates) {
        super(minimum, lowerQuantile, median, higherQuantile, maximum);
        this.lowerExpatriates = lowerExpatriates;
        this.higherExpatriates = higherExpatriates;
    }
}
