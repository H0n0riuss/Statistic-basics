package io.github.H0n0riuss.calculations.frequency;

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
    public void calculateBoxPlotTest() {
        var data = new double[]{0, 9, 4, 0, 6, 7, 8, 13, 9, 4, 17};

        var res = cut.calculateBoxplot(data);
        assertEquals(0, res.minimum);
        assertEquals(4, res.lowerQuartile);
        assertEquals(8, res.median);
        assertEquals(9, res.higherQuartile);
        assertEquals(17, res.maximum);

        data = new double[]{6.58, 6.61, 6.63, 6.69, 6.74, 6.79, 6.81, 6.95, 7.08, 7.15, 7.17};
        assertEquals(7.08, cut.calculateBoxplot(data).higherQuartile);

        data = new double[]{7.82, 7.86, 7.87, 7.97, 8.05, 8.06, 8.1, 8.17, 8.25, 8.3, 8.37, 8.38};
        assertEquals(8.275, cut.calculateBoxplot(data).higherQuartile);
    }

    @Test
    public void boxPlotThrowsTest() {
        var data = new double[]{};
        assertThrows(ArithmeticException.class, () -> cut.calculateBoxplot(data));
    }
}
