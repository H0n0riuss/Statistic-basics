package io.github.H0n0riuss.calculations.frequency;

import io.github.H0n0riuss.calculations.frequency.models.BoxPlotExpatriateModel;
import io.github.H0n0riuss.calculations.frequency.models.BoxPlotModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class BoxPlot {

    private static final Logger logger = LogManager.getLogger(BoxPlot.class);

    public static BoxPlotExpatriateModel boxPlotExpatriate(double[] data) {
        prepareBoxPlot(data);

        var lowerQuantile = simpleQuantileIndexes(data, 0.25f);
        var median = simpleQuantileIndexes(data, 0.5f);
        var higherQuantile = simpleQuantileIndexes(data, 0.75f);

        var expatriateIndexes = expatriateIndexes(data, lowerQuantile, higherQuantile);

        if (expatriateIndexes[0] == -1) {
            logger.info("No lower expatriate");
        }
        if (expatriateIndexes[1] == -1) {
            logger.info("No higher expatriate");
            expatriateIndexes[1] = data.length;
        }

        var lowerExpatriate = Arrays.copyOfRange(data, 0, expatriateIndexes[0] + 1);
        var higherExpatriate = Arrays.copyOfRange(data, expatriateIndexes[1], data.length);
        var mainData = Arrays.copyOfRange(data, expatriateIndexes[0] + 1, expatriateIndexes[1]);

        return BoxPlotExpatriateModel.childBuilder()
                .minimum(data[expatriateIndexes[0] + 1])
                .lowerExpatriates(lowerExpatriate)
                .lowerQuantile(quantile(mainData, 0.25f))
                .median(median)
                .higherQuantile(quantile(mainData, 0.75f))
                .higherExpatriates(higherExpatriate)
                .maximum(data[expatriateIndexes[1] - 1])
                .build();
    }

    public static BoxPlotModel boxPlot(double[] data) throws ArithmeticException {
        prepareBoxPlot(data);

        return BoxPlotModel.builder()
                .minimum(data[0])
                .lowerQuantile(quantile(data, 0.25f))
                .median(quantile(data, 0.5f))
                .higherQuantile(quantile(data, 0.75f))
                .maximum(data[data.length - 1])
                .build();
    }

    private static int[] expatriateIndexes(double[] data, int lowerQuantile, int higherQuantile) {
        var res = new int[]{-1, -1};
        var lowerFound = false;
        var x75 = data[higherQuantile] + 1.5 * (higherQuantile - lowerQuantile);
        var x25 = data[lowerQuantile] - 1.5 * (higherQuantile - lowerQuantile);
        for (int i = 0; i < data.length; ++i) {
            if (!lowerFound && data[i] < x25) {
                res[0] = i;
                lowerFound = true;
            }
            if (data[i] > x75) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    private static void prepareBoxPlot(double[] data) {
        var n = data.length;
        if (n == 0) throw new ArithmeticException("Contains no data.");

        Arrays.sort(data);
    }

    private static double quantile(double[] data, double percentage) {
        var n = data.length;
        var quantile = n * percentage;
        var index = (int) Math.round(quantile);
        return (n % 2 == 0) ? (data[index - 1] + data[index]) / 2 : data[index];
    }

    private static int simpleQuantileIndexes(double[] data, double percentage) {
        var n = data.length;
        return (int) (n * percentage);
    }
}
