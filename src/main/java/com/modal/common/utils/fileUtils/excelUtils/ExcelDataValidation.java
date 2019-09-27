package com.modal.common.utils.fileUtils.excelUtils;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

@SuppressWarnings("unused")
public class ExcelDataValidation {

    /**
     * 单元格字体样式
     */
    public static CellStyle setCellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);                         // 设置字体加粗
        font.setColor(HSSFColor.BLUE_GREY.index);   // 设置字体颜色
        font.setFontHeightInPoints((short)14);      // 设置字体大小
        cellStyle.setFont(font);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  // 设置垂直居中
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);     // 设置文字水平居中
        return cellStyle;
    }


    /**
     * 设置某一列的类型 文本类型
     */
    public static void setTextType(Workbook workbook, Sheet sheet, int column) {
        DataFormat format = workbook.createDataFormat();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format.getFormat("@"));
        sheet.setDefaultColumnStyle(column, cellStyle);
    }

    /**
     * 设置某一列的类型 数字类型
     */
    public static void setNumberType(Workbook workbook, Sheet sheet, int column) {
        DataFormat format = workbook.createDataFormat();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format.getFormat("0"));
        sheet.setDefaultColumnStyle(column, cellStyle);
    }

    /**
     * 设置某一列的类型 日期类型
     */
    // 进程与线程.txt.yyyy 年份；    yy 年份后两位
    // 2.MM 月份零起始；M 月份非零起始;  mmm[英文月份简写];mmmm[英文月份全称]
    // 3.dd   日零起始；d 日非零起始
    // 4.hh 小时零起始；h 小时非零起始[用于12小时制][12小时制必须在时间后面添加 AM/PM 或 上午/下午]
    // 5.HH 小时零起始；H 小时非零起始[用于24小时制]
    // 6.mm 分钟零起始；m 分钟非零起始
    // 7.ss 秒数零起始；s 秒数非零起始
    // 8.dddd 星期；ddd 星期缩写【英文】
    // 9.aaaa 星期；aaa 星期缩写【中文】
    public static void setDateType(Workbook workbook, Sheet sheet, Cell cell, int column) {
        DataFormat format = workbook.createDataFormat();
        CellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));
//        cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:SS"));
        cellStyle.setDataFormat(format.getFormat("yyyy年MM月dd日 aaaa"));
//        cellStyle.setDataFormat(format.getFormat("yyyy年MM月dd日 dddd"));
//        cellStyle.setDataFormat(format.getFormat("h:mm:ss AM/PM"));
//        cellStyle.setDataFormat(format.getFormat("h:mm:ss 上午/下午"));

//        sheet.setDefaultColumnStyle(column, cellStyle); 这样设置某一列的cell 并不能生效

        cell.setCellStyle(cellStyle);
    }


    /**
     * 数字范围
     *
     */
    public static DataValidation setNumberValidation(Sheet sheet, int firstRow, int endRow, int firstCol, int endCol, String startNum, String endNum) {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        // 设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DataValidationConstraint constraint = helper.createIntegerConstraint(DVConstraint.OperatorType.BETWEEN, startNum, endNum);
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        dataValidation.createErrorBox("错误提示", "数量必须在0~9999之间");
        return dataValidation;
    }

    /**
     * 日期范围
     *
     */
    public static DataValidation setDataValidation(Sheet sheet, int firstRow, int endRow, int firstCol, int endCol, String startData, String endData, String dataFormat) {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        // 设置数据有效性加载在哪个单元格上。四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DataValidationConstraint constraint = helper.createDateConstraint(DVConstraint.OperatorType.BETWEEN, startData, endData, dataFormat);
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        dataValidation.createErrorBox("错误提示", "日期格式为yyyy-MM-dd");
        return dataValidation;
    }

    /**
     * 设置输入长度限制
     *
     */
    public static void setLengthLimit(Sheet sheet, int firstRow, int endRow, int firstCol, int endCol, String minLength, String maxLength) {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        DVConstraint lengthConstraint = DVConstraint.createNumericConstraint(DVConstraint.ValidationType.TEXT_LENGTH, DVConstraint.OperatorType.BETWEEN, minLength, maxLength);
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DataValidation dataValidation = helper.createValidation(lengthConstraint, regions);
        dataValidation.createErrorBox("输入长度限制","长度不能超过5");
        sheet.addValidationData(dataValidation);
    }
}
