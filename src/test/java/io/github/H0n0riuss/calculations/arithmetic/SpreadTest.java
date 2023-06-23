package io.github.H0n0riuss.calculations.arithmetic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpreadTest {

    private static Spread cut;

    @BeforeAll
    static void prepareCut() {
        cut = new Spread();
    }

    @Test
    void averageMeanSpreadTest() {
        var data = new double[]{6120, 1820, 1020, 2280, 6680};
        assertEquals(3584d, cut.averageMeanSpread(data));

        assertThrows(ArithmeticException.class, () -> cut.averageMeanSpread(new double[]{}));
    }

    @Test
    void averageMedianSpreadTest() {
        var data = new double[]{5100, 800, 0, 3300, 7700};
        assertEquals(3380d, cut.averageMeanSpread(data));

        assertThrows(ArithmeticException.class, () -> cut.averageMeanSpread(new double[]{}));
    }
}
