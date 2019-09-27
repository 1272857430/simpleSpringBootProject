package cn.cjd.springboot.modal.common.utils.fileUtils.excelUtils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelCreateUitlTest {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) throws IOException {
        File file = new File("E://test.xls");
        file.createNewFile();
        Workbook workbook = new HSSFWorkbook();
        // 设置sheet头部
        new ExcelCreateUtil().setHeader(workbook);
        // 设置单元格样式  第0、进程与线程.txt、2 列
        new ExcelCreateUtil().setCellStyle(workbook);
        // 设置输入长度限制 第 2 列
        new ExcelCreateUtil().setLengthLimit(workbook);
        // 设置下拉       第3、4 列
        new ExcelCreateUtil().setSelect(workbook);
        // 设置输入范围   第5、6 列
        new ExcelCreateUtil().setInputRange(workbook);
        // 设置锁定样式   第7、8 列
        new ExcelCreateUtil().setLock(workbook);
        // 合并单元格     第11、12 列
        new ExcelCreateUtil().mergedRegion(workbook);

        OutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
        workbook.close();
    }
}
