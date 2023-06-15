package io.github.H0n0riuss.calculations.arithmetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MeanTest {

    @Test
    void calculateMiddleTest() {
        var cut = new Mean();
        var data = new float[]{10, 24, 100};
        assertEquals(44.666668f, cut.calculateMean(data));
        assertThrows(ArithmeticException.class, () -> cut.calculateMean(new float[]{}));
    }

    @Test
    void calculateWeightedMeanTest() {
        var cut = new Mean();
        var g = new float[]{50, 30, 55};
        var x = new float[]{1.14f, 1.21f, 1.19f};
        assertEquals(1.1759259700775146, cut.calculateWeightedMean(g, x));
    }
}
