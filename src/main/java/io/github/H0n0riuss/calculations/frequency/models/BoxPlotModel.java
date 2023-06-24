package io.github.H0n0riuss.calculations.frequency.models;

import lombok.Builder;

@Builder
public class BoxPlotModel {

    public double minimum;
    public double lowerQuartile;
    public double median;
    public double higherQuartile;
    public double maximum;
}
