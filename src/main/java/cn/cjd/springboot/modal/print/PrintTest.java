package cn.cjd.springboot.modal.print;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Auther: youq
 * @Date: 2019/11/11 15:13
 * @Description:
 */
public class PrintTest {

    public static void main(String[] args) {

        String url = "D://下载/维修巡检-北侧通道（2号楼东侧）2019-11-07----2019-11-11.xls";
        printTest(url);

//        Workbook wb =null;
//        InputStream is = null;
//        try {
//            is = new FileInputStream(url);
//            wb = new XSSFWorkbook(is);
//            HSSFSheet sheet = (HSSFSheet) wb.getSheetAt(0);
//
//            HSSFPrintSetup printSetup = sheet.getPrintSetup();
//            printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); // 纸张
//            printSetup.setLandscape(true);
//            sheet.setDisplayGridlines(false);
//            sheet.setPrintGridlines(false);
//            sheet.setMargin(HSSFSheet.TopMargin,( double ) 0.2 ); // 上边距
//            sheet.setMargin(HSSFSheet.BottomMargin,( double ) 0.2 ); // 下边距
//            sheet.setMargin(HSSFSheet.LeftMargin,( double ) 0.2 ); // 左边距
//            sheet.setMargin(HSSFSheet.RightMargin,( double ) 0.2 ); // 右边距
//
//            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public static void printTest(String url){
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        PrintService []pservices = PrintServiceLookup.lookupPrintServices(flavor, aset);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(null, 200, 200, pservices, defaultService, flavor, aset);
        if(service != null){
            try {
                DocPrintJob pj =service.createPrintJob();
                FileInputStream fis = new FileInputStream(url);
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das);
                pj.print(doc, aset);
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            } catch (PrintException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("打印失败");
        }
    }

}
