package io.github.H0n0riuss.calculations.arithmetic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MeanTest {

    private static Mean cut;

    @BeforeAll
    static void prepareCut() {
        cut = new Mean();
    }

    @Test
    void calculateMiddleTest() {
        var data = new float[]{10, 24, 100};
        assertEquals(44.666668f, cut.calculateMean(data));

        data = new float[]{3690, 3520, 4110};
        assertEquals(3773.3333f, cut.calculateMean(data));

        assertThrows(ArithmeticException.class, () -> cut.calculateMean(new float[]{}));
    }

    @Test
    void calculateWeightedMeanTest() {
        var g = new float[]{50, 30, 55};
        var x = new float[]{1.14f, 1.21f, 1.19f};
        assertEquals(1.1759259700775146, cut.calculateWeightedMean(g, x));
    }

    @Test
    void calculateHarmonicMeanTest() {
        var data = new float[]{1, 2, 3};
        assertEquals(1.6363636f, cut.calculateHarmonicMean(data));

        data = new float[]{88.1f, 82.9f, 76.4f, 58.8f, 48.85f, 59.02f};
        assertEquals(65.98953f, cut.calculateHarmonicMean(data));

        assertThrows(ArithmeticException.class, () -> cut.calculateHarmonicMean(new float[]{1, 2, -3}));
    }
}
