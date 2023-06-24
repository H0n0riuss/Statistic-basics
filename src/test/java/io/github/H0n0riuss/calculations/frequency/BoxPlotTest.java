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
    public void calculateBoxPlotTest() { //TODO überprüfen, wie die Quanitle wirklich berechnet werden
        var data = new double[]{0, 9, 4, 0, 6, 7, 8, 13, 9, 4, 17};

        var res = cut.calculateBoxplot(data);
        assertEquals(0, res.minimum);
        assertEquals(4, res.lowerQuartile);
        assertEquals(7, res.median);
        assertEquals(9, res.higherQuartile);
        assertEquals(17, res.maximum);

        data = new double[]{0, 9, 4, 0, 6, 7, 8, 13, 9, 4, 17};
    }

    @Test
    public void boxPlotThrowsTest() {
        var data = new double[]{};
        assertThrows(ArithmeticException.class, () -> cut.calculateBoxplot(data));
    }
}
