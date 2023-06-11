package io.github.H0n0riuss.arithmetic;

import io.github.H0n0riuss.calculations.arithmetic.ArithmeticMean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticMeanTest {

    @Test
    void calculateArithmeticMiddleTest() {
        var cut = new ArithmeticMean();
        var data = new float[]{10, 24, 100};
        assertEquals(44, cut.calculateArithmeticMean(data));
        assertThrows(ArithmeticException.class, () -> cut.calculateArithmeticMean(new float[]{}));
    }

    @Test
    void calculateWeightedArithmeticMeanTest() {
        var cut = new ArithmeticMean();
        var g = new float[]{50, 30, 55};
        var x = new float[]{1.14f, 1.21f, 1.19f};
        assertEquals(1.1759259700775146, cut.calculateWeightedArithmeticMean(g, x));
    }
}
