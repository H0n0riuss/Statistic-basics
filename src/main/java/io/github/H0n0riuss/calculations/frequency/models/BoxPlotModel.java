package io.github.H0n0riuss.calculations.frequency.models;

import lombok.Builder;

@Builder
public class BoxPlotModel {

    public final double minimum;
    public final double lowerQuantile;
    public final double median;
    public final double higherQuantile;
    public final double maximum;
}
