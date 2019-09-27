package com.modal.common.utils.fileUtils.excelUtils;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Date;

/**
 *  生成excel
 */
@SuppressWarnings("WeakerAccess")
public class ExcelCreateUtil {

    /**
     * 设置sheet头部
     */
    public void setHeader(Workbook workbook) {
        Sheet sheet = workbook.getSheet("sheet0");
        if (sheet == null) {
            sheet = workbook.createSheet("sheet0");
        }
        Row headerRow = sheet.createRow(0);     //列头
        String[] headers = new String[]{"first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth"};
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
            sheet.setColumnWidth(i, 5000); //设置某一列的宽度
        }
    }

    /**
     * 设置单元格样式
     */
    public void setCellStyle(Workbook workbook) {
        Sheet sheet = workbook.getSheet("sheet0");
        if (sheet == null) {
            sheet = workbook.createSheet("sheet0");
        }

        //设置长宽的长度(表格的默认长宽)
        sheet.setDefaultColumnWidth(25);
        sheet.setDefaultRowHeightInPoints(30);

        DataFormat dataFormat = workbook.createDataFormat();

        CellStyle testStyle = workbook.createCellStyle();
        testStyle.setDataFormat(dataFormat.getFormat("@"));     // 文本类型
        testStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        testStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());     //设置背景色为浅绿色
        testStyle.setLocked(false);

        CellStyle numberStyle = workbook.createCellStyle();
        numberStyle.setDataFormat(dataFormat.getFormat("0"));   // 数据类型
        numberStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        numberStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());  //设置背景色为浅橘色
        numberStyle.setLocked(false);

        for (int i=1; i<50; i++) {
            Row row =  sheet.getRow(i);
            if (row == null) {
                row = sheet.createRow(i);
            }
            for (int j=0; j<2; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    cell = row.createCell(j);
                }
                if (j%2 == 0) {
                    cell.setCellValue("test"+j);
                    cell.setCellStyle(testStyle);
                } else {
                    cell.setCellValue(j);
                    cell.setCellStyle(numberStyle);
                }
            }
        }
    }

    /**
     * 设置输入长度限制
     */
    public void setLengthLimit(Workbook workbook) {
        Sheet sheet = workbook.getSheet("sheet0");
        if (sheet == null) {
            sheet = workbook.createSheet("sheet0");
        }
        // 设置文本类型
        ExcelDataValidation.setTextType(workbook, sheet, 0);
        // 设置长度
        ExcelDataValidation.setLengthLimit(sheet, 1, 50, 2, 2, "进程与线程.txt", "5");
    }

    /**
     * 设置下拉
     */
    public void setSelect(Workbook workbook) {
        Sheet sheet = workbook.getSheet("sheet0");
        if (sheet == null) {
            sheet = workbook.createSheet("sheet0");
        }
        //  第一种通过隐藏sheet实现，当下拉选项超过255的时候必须使用这种方式， 使用注意点   选项列和 隐藏sheet的选项值得列 要对应
        SetSelect.SetDataValidation(workbook, sheet,"hidden",1,50,3,3, new String[]{"0","进程与线程.txt","2","3","4","5","6","7","8","9"});

        // 第二种直接实现 当下拉选项  不超过255
        SetSelect.setDataValidation(sheet, new String[]{"test1", "test3", "test3", "test4"}, 1, 50, 4, 4);
      }

    /**
     * 设置输入范围
     */
    public void setInputRange(Workbook workbook) {

        Sheet sheet = workbook.getSheet("sheet0");
        if (sheet == null) {
            sheet = workbook.createSheet("sheet0");
        }
        Row row =  sheet.getRow(1);
        if (row == null) {
            row = sheet.createRow(1);
        }

        // 第五列设置数字类型
        Cell cell5 = row.getCell(5);
        if (cell5 == null) {
            cell5 = row.createCell(5);
        }
        cell5.setCellValue(999);
        ExcelDataValidation.setNumberType(workbook, sheet, 5);
        // 数字范围
        sheet.addValidationData(ExcelDataValidation.setNumberValidation(sheet,1,50,5,5, "0","9999"));

        // 第六列设置日期类型
        Cell cell6 = row.getCell(6);
        if (cell6 == null) {
            cell6 = row.createCell(6);
        }
        cell6.setCellValue(new Date());
        ExcelDataValidation.setDateType(workbook,sheet, cell6, 6);
        // 日期范围
        sheet.addValidationData(ExcelDataValidation.setDataValidation(sheet,1,50,6,6, "2016-12-12","2099-12-31","yyyy-MM-dd"));
    }


    /**
     * 设置锁定状态
     *
     */
    public void setLock(Workbook workbook) {

        CellStyle lockStyle = workbook.createCellStyle();  // 锁定样式
        lockStyle.setLocked(true);  //  默认锁定状态

        CellStyle unLockStyle = workbook.createCellStyle(); // 非锁定样式
        unLockStyle.setLocked(false);

        Sheet sheet = workbook.getSheet("sheet0");
        if (sheet == null) {
            sheet = workbook.createSheet("sheet0");
        }

        for (int i=1; i<50; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                row= sheet.createRow(i);
            }
            Cell cell7 = row.getCell(7);
            if (cell7 == null) {
                cell7= row.createCell(7);
                cell7.setCellValue("lockValue"+i);
                cell7.setCellStyle(lockStyle);
            }

            Cell cell8 = row.getCell(8);
            if (cell8 == null) {
                cell8 = row.createCell(8);
                cell8.setCellValue("lockValue"+i);
                cell8.setCellStyle(unLockStyle);
            }
        }
        // 将sheet设置为保护状态，锁定和非锁定 才会生效
        sheet.protectSheet("333");

    }

    /**
     * 合并单元格
     */
    public void mergedRegion(Workbook workbook) {
        Sheet sheet = workbook.getSheet("sheet0");
        if (sheet == null) {
            sheet = workbook.createSheet("sheet0");
        }
        CellRangeAddress regions = new CellRangeAddress(2,4,11,12);
        sheet.addMergedRegion(regions);
        Row row = sheet.getRow(2);
        if (row == null) {
            row = sheet.createRow(2);
        }
        Cell cell = row.getCell(11);
        if (cell == null) {
            cell = row.createCell(11);
        }
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);                         // 设置字体加粗
        font.setColor(HSSFColor.BLUE_GREY.index);   // 设置字体颜色
        font.setFontHeightInPoints((short)14);      // 设置字体大小
        cellStyle.setFont(font);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  // 设置垂直居中
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);     // 设置文字水平居中
        cell.setCellValue("梅花香自苦寒来");
        cell.setCellStyle(cellStyle);
    }



}
