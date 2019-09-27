package com.modal.common.utils.fileUtils.excelUtils;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

@SuppressWarnings("JavaDoc")
public class SetSelect {

    /**
     * 下拉列表元素很多的情况 (255以上 的下拉)
     *
     * @param workbook
     * @param sheet
     * @param strFormula strFormula hiddenSheet 名
     * @param firstRow
     * @param endRow
     * @param firstCol
     * @param endCol
     * @param selectData
     */
    public static void SetDataValidation(Workbook workbook, Sheet sheet, String strFormula, int firstRow, int endRow, int firstCol, int endCol, String[] selectData) {
        // 创建一个用于放数据的sheet页
        Sheet hiddenSheet = workbook.createSheet(strFormula);
        Cell cell;
        for (int i = 999; i < 999 + selectData.length; i++) {
            Row row = hiddenSheet.createRow(i);
            for (int j = firstCol; j <= endCol; j++) {
                cell = row.createCell(j);   // 该列要和 下拉框的列对应
                cell.setCellValue(selectData[i - 999]);
            }
        }
        Name name = workbook.createName();
        name.setNameName(strFormula);
        name.setRefersToFormula(strFormula + "!A1000:A" + (selectData.length + 999));
//        workbook.setSheetHidden(进程与线程.txt, true);   // 隐藏sheet
///////////////////////////////////////////第一种比较局限性///////////////////////////////////////////////////////////////////////////////
        // 设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        DVConstraint constraint = DVConstraint.createFormulaListConstraint(strFormula);
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
        dataValidation.createErrorBox("错误提示", "必须在0~9之间");
        sheet.addValidationData(dataValidation);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////第二种可以适用任何版本的sheet/////////////////////////////////////////////////////////////////////////////////
//        DataValidationHelper helper = sheet.getDataValidationHelper();
//        // 设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
//        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
//        DVConstraint constraint = DVConstraint.createFormulaListConstraint(strFormula);
//        DataValidation dataValidation = helper.createValidation(constraint, regions);
//        dataValidation.createErrorBox("Error", "Error");
//        sheet.addValidationData(dataValidation);
    }


    /**
     * 下拉列表元素不多的情况(255以内 的下拉)
     *
     * @param sheet
     * @param textList
     * @param firstRow
     * @param endRow
     * @param firstCol
     * @param endCol
     */
    public static void setDataValidation(Sheet sheet, String[] textList, int firstRow, int endRow, int firstCol, int endCol) {

///////////////////////////////////////////第一种比较局限性///////////////////////////////////////////////////////////////////////////////////
//        //加载下拉列表内容                                                                                                                //
//        DVConstraint constraint = DVConstraint.createExplicitListConstraint(textList);                                                 //
//        //设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列                                                          //
//        CellRangeAddressList regions = new CellRangeAddressList((short) firstRow, (short) endRow, (short) firstCol, (short) endCol);   //
//        //数据有效性对象                                                                                                                 //
//        HSSFDataValidation listValidate = new HSSFDataValidation(regions, constraint);                                                 //
//        sheet.addValidationData(dataValidation);                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////第二种可以适用任何版本的sheet/////////////////////////////////////////////////////////////////////////////////
        DataValidationHelper helper = sheet.getDataValidationHelper();
        //加载下拉列表内容
        DataValidationConstraint constraint = helper.createExplicitListConstraint(textList);
        constraint.setExplicitListValues(textList);
        //设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList((short) firstRow, (short) endRow, (short) firstCol, (short) endCol);
        //数据有效性对象
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        dataValidation.createErrorBox("Error", "Error");
        sheet.addValidationData(dataValidation);
    }

}
