package io.github.H0n0riuss.calculations.arithmetic;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MeanTest {

    @Test
    void calculateMiddleTest() {
        var data = new double[]{10, 24, 100};
        assertEquals(44.7d, Precision.round(Mean.arithmeticMean(data), 1));

        data = new double[]{3690, 3520, 4110};
        assertEquals(3773.3333333333335d, Mean.arithmeticMean(data));

        assertThrows(ArithmeticException.class, () -> Mean.arithmeticMean(new double[]{}));
    }

    @Test
    void calculateWeightedMeanTest() {
        var g = new double[]{50, 30, 55};
        var x = new double[]{1.14f, 1.21f, 1.19f};
        assertEquals(1.1759259524168792d, Mean.weightedMean(g, x));
    }

    @Test
    void calculateHarmonicMeanTest() {
        var data = new double[]{1, 2, 3};
        assertEquals(1.6363636363636365d, Mean.harmonicMean(data));

        data = new double[]{88.1f, 82.9f, 76.4f, 58.8f, 48.85f, 59.02f};
        assertEquals(65.98953306983908d, Mean.harmonicMean(data));

        assertThrows(ArithmeticException.class, () -> Mean.harmonicMean(new double[]{1, 2, -3}));
    }

    @Test
    void calculateGeometricMean() {
        var data = new double[]{2, 3, 5};
        assertEquals(3.1072325059538586d, Mean.geometricMean(data));

        data = new double[]{2, 0, 5};
        assertEquals(0, Mean.geometricMean(data));

        data = new double[]{1.01d, 1.02d};
        assertEquals(1.0149876846543509d, Mean.geometricMean(data));

        assertThrows(ArithmeticException.class, () -> Mean.geometricMean(new double[]{-2, 1}));
        assertThrows(ArithmeticException.class, () -> Mean.geometricMean(new double[]{}));
    }

    @Test
    void calculateClassifiedMeanTest(){
        var data = new double[]{1600, 2000, 2400, 2800};
        var count = new double[]{5, 18, 22, 15};

        assertEquals(2313.3d, Precision.round(Mean.classifiedMean(data, count), 1));

        assertThrows(ArithmeticException.class, () -> Mean.classifiedMean(new double[]{23, 34}, new double[]{4}));
        assertThrows(ArithmeticException.class, () -> Mean.classifiedMean(new double[]{}, new double[]{4}));
    }
}
