package io.github.H0n0riuss.calculations.frequency.models;

import lombok.Builder;

@Builder
public class BoxPlotModel {

    public float minimum;
    public float lowerQuartile;
    public float median;
    public float higherQuartile;
    public float maximum;
}
