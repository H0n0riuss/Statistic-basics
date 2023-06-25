package io.github.H0n0riuss.calculations.frequency;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoxPlotTest {
    private static BoxPlot cut;

    @BeforeAll
    public static void prepareCut() {
        cut = new BoxPlot();
    }

    @Test
    void calculateBoxPlotExpatriate() {
        var data = new double[]{15, 25.75, 28.29, 32.79, 33.03, 33.16, 35, 35.52, 39, 47};
        var boxPlot = cut.calculateBoxPlotExpatriate(data);

        assertEquals(30.54, boxPlot.lowerQuantile);
        assertEquals(35.26, Precision.round(boxPlot.higherQuantile, 2));

        assertEquals(data[0], boxPlot.lowerExpatriates[0]);
        assertEquals(data[9], boxPlot.higherExpatriates[0]);

        assertEquals(25.75, boxPlot.minimum);
        assertEquals(39, boxPlot.maximum);

        assertEquals(1, boxPlot.lowerExpatriates.length);
        assertEquals(1, boxPlot.higherExpatriates.length);
    }

    @Test
    void calculateBoxPlotTest() {
        var data = new double[]{0, 9, 4, 0, 6, 7, 8, 13, 9, 4, 17};

        var res = cut.calculateBoxPlot(data);
        assertEquals(0, res.minimum);
        assertEquals(4, res.lowerQuantile);
        assertEquals(8, res.median);
        assertEquals(9, res.higherQuantile);
        assertEquals(17, res.maximum);

        data = new double[]{6.58, 6.61, 6.63, 6.69, 6.74, 6.79, 6.81, 6.95, 7.08, 7.15, 7.17};
        assertEquals(7.08, cut.calculateBoxPlot(data).higherQuantile);

        data = new double[]{7.82, 7.86, 7.87, 7.97, 8.05, 8.06, 8.1, 8.17, 8.25, 8.3, 8.37, 8.38};
        assertEquals(8.275, cut.calculateBoxPlot(data).higherQuantile);
    }

    @Test
    public void boxPlotThrowsTest() {
        var data = new double[]{};
        assertThrows(ArithmeticException.class, () -> cut.calculateBoxPlot(data));
    }
}
