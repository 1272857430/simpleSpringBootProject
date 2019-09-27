package cn.cjd.springboot.modal.common.utils.fileUtils;

import com.modal.common.exception.SysUnifiedException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings("unused")
@Service
public class FileService {

    /**
     * 创建文件路径，有则不创建
     */
    public void createDir(String dirPath) {
        File dir = new File(dirPath);
        if (dir.exists()) {
            return;
        }
        if (!dir.mkdirs()) {
            throw new SysUnifiedException("创建目录" + dirPath + "失败！");
        }
    }

    /**
     * 根据给定的路径创建文件
     */
    public void createFile(String destFileName, File file) throws Exception {
        if (file == null) {
            this.createFile(destFileName);
        } else {
            InputStream inputStream = new FileInputStream(file);
            this.createFile(destFileName, inputStream);
        }
    }

    /**
     * 根据给定的路径创建文件
     */
    public void createFile(String destFileName, MultipartFile file) throws Exception {
        if (file == null) {
            this.createFile(destFileName);
        } else {
            this.createFile(destFileName, file.getInputStream());
        }
    }

    /**
     * 根据给定的路径创建文件
     */
    public void createFile(String destFileName, InputStream inputStream) throws Exception {
        File createFile = this.createFile(destFileName);
        OutputStream outputStream = new FileOutputStream(createFile);
        try {
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }
        } catch (Exception ex) {
            throw new SysUnifiedException(ex.getMessage());
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }

    /**
     * 根据给定的路径创建文件及目录
     */
    public File createFile(String destFileName) throws Exception {
        File file = new File(destFileName);
        if (file.exists()) {
            throw new Exception("创建单个文件" + destFileName + "失败，目标文件已存在！");
        }
        if (destFileName.endsWith(File.separator)) {
            throw new Exception("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
        }
        // 判断目标文件所在的目录是否存在
        if (!file.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            createDir(file.getParentFile().getPath());
        }
        // 创建目标文件
        try {
            if (file.createNewFile()) {
                return file;
            } else {
                throw new Exception("创建单个文件" + destFileName + "失败");
            }
        } catch (IOException e) {
            throw new Exception("创建单个文件" + destFileName + "失败");
        }
    }

    /**
     * 根据给定的路径返回文件
     */
    public File readFile(String destFileName) {
        File file = new File(destFileName);
        if (!file.exists() && !file.isFile()) {
            throw new SysUnifiedException("文件不存在！");
        }
        return new File(destFileName);
    }


    /**
     * 根据给定的路径删除文件
     *
     */
    public void deleteFile(String filePath) throws Exception {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            System.gc();
            if (!file.delete()) {
                throw new Exception("文件删除失败!");
            }
        } else {
            throw new Exception("文件不存在!");
        }
    }


    public static void main(String[] args) throws Exception {
        File remoteFile = new File("//192.168.18.218/共享文件夹/新建文本文档.txt");
        // 192.168.7.146是对方机器IP，test是对方那个共享文件夹名字，如果没有共享是访问不到的
        //远程文件其实主要是地址，地址弄对了就和本地文件没什么区别 ，windows里面//或者\\\\开头就表示这个文件是网络路径了其实这个地址就像我们再windows里面，点击开始
        //然后点击运行，然后输入 \\192.168.7.146/test/进程与线程.txt访问远程文件一样的

        BufferedReader br = new BufferedReader(new FileReader(remoteFile));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();
    }
}
