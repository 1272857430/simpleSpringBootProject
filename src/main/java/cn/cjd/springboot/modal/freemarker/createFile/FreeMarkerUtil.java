package cn.cjd.springboot.modal.freemarker.createFile;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

public class FreeMarkerUtil {

    public static void createTestCaseFile(Map<String, Object> dataMap, String modelPath, String classPath){
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(modelPath));
            // step3 创建数据模型
//            Map<String, Object> dataMap = BeanUtils.transBean2Map(modelDataVo);
            // step4 加载模版文件
            Template template = configuration.getTemplate("model.ftl");
            // step5 生成数据
            File docFile = new File( classPath + "/" + dataMap.get("className") + ".java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^" + dataMap.get("className") + ".java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
