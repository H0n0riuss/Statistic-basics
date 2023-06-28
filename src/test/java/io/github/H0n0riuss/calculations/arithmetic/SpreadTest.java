package io.github.H0n0riuss.calculations.arithmetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpreadTest {

    @Test
    void averageMeanSpreadTest() {
        var data = new double[]{6120, 1820, 1020, 2280, 6680};
        assertEquals(3584d, Spread.averageMean(data));

        assertThrows(ArithmeticException.class, () -> Spread.averageMean(new double[]{}));
    }

    @Test
    void averageMedianSpreadTest() {
        var data = new double[]{5100, 800, 0, 3300, 7700};
        assertEquals(3380d, Spread.averageMean(data));

        assertThrows(ArithmeticException.class, () -> Spread.averageMean(new double[]{}));
    }

    @Test
    void spanTest() {
        var data = new double[]{-1, 0, 3, 9, 13, 12, 8, 4};
        assertEquals(14, Spread.span(data));

        data = new double[]{
                93, 72, 85, 80, 90, 81, 79, 70, 74, 83, 74,
                83, 74, 74, 73, 65, 90, 78, 64, 90, 73, 85, 82};

        assertEquals(29, Spread.span(data));
    }

    @Test
    void quarterlyDistanceTest() {
        var data = new double[]{
                93, 72, 85, 80, 90, 81, 79, 70, 74, 83, 74,
                83, 74, 74, 73, 65, 90, 78, 64, 90, 73, 85, 82};

        assertEquals(11, Spread.quarterlyDistance(data));
    }

    @Test
    void averageDeviationTest() {
        var data = new double[]{6120, 1820, 1020, 2280, 6680};
        assertEquals(3584, Spread.averageMean(data));

        data = new double[]{5100, 800, 0, 3300, 7700};
        assertEquals(3380, Spread.averageMean(data));
    }

    @Test
    void empiricallyVarianceTest() {
        var data = new double[]{185, 130, 212, 248, 90};
        //assertEquals(4007, Spread.empiricallyVariance(data));
    }
}
