package io.github.H0n0riuss.calculations.arithmetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedianTest {
    
    @Test
    void calculateMedianTest() {
        var data = new double[]{9, 3, 1, 7, 4};
        assertEquals(4, Median.median(data));

        data = new double[]{3, 1, 4, 5};
        assertEquals(3.5d, Median.median(data));
    }

    @Test
    void calculateUndefinedMedianTest() {
        var data = new double[]{1, 1, 4, 4, 4, 4, 4, 5, 6, 8, 8, 8, 11, 18, 22};

        var res = Median.undefinedMedian(data);
        assertEquals(4, res[0]);
        assertEquals(5, res[1]);

        assertThrows(IllegalArgumentException.class,
                () -> Median.undefinedMedian(new double[]{1, 1, 4, 4, 4, 4, 4, 5, 6, 8, 8, 8, 11, 18}));
    }
}
