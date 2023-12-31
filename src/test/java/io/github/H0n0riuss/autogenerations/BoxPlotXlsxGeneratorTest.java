package io.github.H0n0riuss.autogenerations;

import io.github.H0n0riuss.autogenerations.xlsx.BoxPlotXlsxGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;

public class BoxPlotXlsxGeneratorTest {
    private static final Logger logger = LogManager.getLogger(BoxPlotXlsxGeneratorTest.class);

    @Test
    public void getXlsxBoxPlotTest() {
        try {
            File currDir = new File(".");
            String path = currDir.getAbsolutePath();
            String fileLocation = path.substring(0, path.length() - 1) + "testData/temp.xlsx";

            FileOutputStream outputStream = new FileOutputStream(fileLocation);

            var data = new double[]{0, 9, 4, 0, 6, 7, 8, 13, 9, 4, 17};
            var cut = new BoxPlotXlsxGenerator();
            var workbook = cut.getXlsxBoxPlot(data);

            workbook.write(outputStream);
            workbook.close();
        } catch (Exception ex) {
            logger.debug(ex.getMessage());
        }
    }
}
