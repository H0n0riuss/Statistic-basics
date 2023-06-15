package io.github.H0n0riuss.autogenerations.xlsx;

import io.github.H0n0riuss.calculations.frequency.FrequencyDistribution;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxGenerator {

    public XSSFWorkbook getXlsxBoxPlot(float[] data) {
        var boxPlot = new FrequencyDistribution();
        var res = boxPlot.calculateBoxplot(data);

        var workbook = new XSSFWorkbook();
        var sheet = workbook.createSheet("BoxPlot");
        var header = sheet.createRow(0);
        header.createCell(0).setCellValue("Minimum");
        header.createCell(1).setCellValue("2. Quartile");
        header.createCell(2).setCellValue("Median");
        header.createCell(3).setCellValue("4. Quartile");
        header.createCell(4).setCellValue("Maximum");


        var row = sheet.createRow(1);
        row.createCell(0).setCellValue(res.minimum);
        row.createCell(1).setCellValue(res.lowerQuartile);
        row.createCell(2).setCellValue(res.median);
        row.createCell(3).setCellValue(res.higherQuartile);
        row.createCell(4).setCellValue(res.maximum);
        return workbook;
    }
}
