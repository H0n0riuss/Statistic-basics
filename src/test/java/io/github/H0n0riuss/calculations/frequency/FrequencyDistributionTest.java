package io.github.H0n0riuss.calculations.frequency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequencyDistributionTest {

    @Test
    public void calculateFrequencyDensityTest() {

    }

    @Test
    public void calculateBoxPlotTest() { //TODO überprüfen, wie die Quanitle wirklich berechnet werden
        var data = new float[]{0, 9, 4, 0, 6, 7, 8, 13, 9, 4, 17};

        var cut = new FrequencyDistribution();
        var res = cut.calculateBoxplot(data);
        assertEquals(0, res.minimum);
        assertEquals(4, res.lowerQuartile);
        assertEquals(7, res.median);
        assertEquals(9, res.higherQuartile);
        assertEquals(17, res.maximum);
    }
}
