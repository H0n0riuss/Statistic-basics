package io.github.H0n0riuss.autogenerations.xlsx;

import io.github.H0n0riuss.calculations.frequency.BoxPlot;
import io.github.H0n0riuss.calculations.frequency.models.BoxPlotModel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;

public class BoxPlotXlsxGenerator {

    public XSSFWorkbook getXlsxBoxPlot(double[] data) {
        var boxPlot = new BoxPlot();
        var boxPlotModel = boxPlot.calculateBoxplot(data);

        var workbook = new XSSFWorkbook();
        var sheet = workbook.createSheet("BoxPlot");

        createHeaderRow(sheet);
        createDataRow(sheet, boxPlotModel);
        //createChart(sheet);

        return workbook;
    }

    private void createHeaderRow(XSSFSheet sheet) {
        var header = sheet.createRow(0);
        header.createCell(0).setCellValue("Minimum");
        header.createCell(1).setCellValue("2. Quartile");
        header.createCell(2).setCellValue("Median");
        header.createCell(3).setCellValue("4. Quartile");
        header.createCell(4).setCellValue("Maximum");
    }

    private void createDataRow(XSSFSheet sheet, BoxPlotModel boxPlotModel) {
        var row = sheet.createRow(1);
        row.createCell(0).setCellValue(boxPlotModel.minimum);
        row.createCell(1).setCellValue(boxPlotModel.lowerQuartile);
        row.createCell(2).setCellValue(boxPlotModel.median);
        row.createCell(3).setCellValue(boxPlotModel.higherQuartile);
        row.createCell(4).setCellValue(boxPlotModel.maximum);
    }

    private void createChart(XSSFSheet sheet) {
        var drawing = sheet.createDrawingPatriarch();
        var anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 8, 20);

        var chart = drawing.createChart(anchor);

        var ctChart = chart.getCTChart();
        var ctPlotArea = ctChart.getPlotArea();
        var ctBarChart = ctPlotArea.addNewBarChart();
        var ctBoolean = ctBarChart.addNewVaryColors();
        ctBoolean.setVal(true);
        ctBarChart.addNewBarDir().setVal(STBarDir.COL);

        for (int r = 2; r < 6; r++) {
            var ctBarSer = ctBarChart.addNewSer();
            var ctSerTx = ctBarSer.addNewTx();
            var ctStrRef = ctSerTx.addNewStrRef();
            ctStrRef.setF("Sheet1!$A$" + r);
            ctBarSer.addNewIdx().setVal(r - 2);
            var cttAxDataSource = ctBarSer.addNewCat();
            ctStrRef = cttAxDataSource.addNewStrRef();
            ctStrRef.setF("Sheet1!$B$1:$D$1");
            var ctNumDataSource = ctBarSer.addNewVal();
            var ctNumRef = ctNumDataSource.addNewNumRef();
            ctNumRef.setF("Sheet1!$B$" + r + ":$D$" + r);

            //at least the borderlines in Libreoffice Calc ;-)
            ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0, 0, 0});

        }

        //telling the BarChart that it has axes and giving them Ids
        ctBarChart.addNewAxId().setVal(123456);
        ctBarChart.addNewAxId().setVal(123457);

        //cat axis
        var ctCatAx = ctPlotArea.addNewCatAx();
        ctCatAx.addNewAxId().setVal(123456); //id of the cat axis
        var ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx.addNewDelete().setVal(false);
        ctCatAx.addNewAxPos().setVal(STAxPos.B);
        ctCatAx.addNewCrossAx().setVal(123457); //id of the val axis
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //val axis
        var ctValAx = ctPlotArea.addNewValAx();
        ctValAx.addNewAxId().setVal(123457); //id of the val axis
        ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx.addNewDelete().setVal(false);
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(123456); //id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //legend
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(false);
    }
}
