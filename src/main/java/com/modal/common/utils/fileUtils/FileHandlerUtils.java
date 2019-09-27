package com.modal.common.utils.fileUtils;

import com.modal.common.exception.SysUnifiedException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 170096 on 2018/5/9
 */
public class FileHandlerUtils {

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static String getFileSeparator() {
        return FILE_SEPARATOR;
    }

    /**
     * 文件路径转化
     */
    public static String getRealFilePath(String path) {
        return path.replace("/", FILE_SEPARATOR).replace("\\", FILE_SEPARATOR);
    }

    /**
     * 文件路径转化
     */
    public static String getHttpURLPath(String path) {
        return path.replace("\\", "/");
    }

    /**
     * 文件转为Byte[]数组
     */
    public static byte[] getBytes(File file) throws IOException {

        InputStream inputStream = new FileInputStream(file);

        long length = file.length();

        if (length < 1) {
            throw new SysUnifiedException("文件不存在!");
        }

        if (length > Integer.MAX_VALUE) {
            throw new SysUnifiedException("文件太大!");
        }

        byte[] fileBty = new byte[(int)length];

        int offset = 0;
        int numRead;

        while (offset < fileBty.length && (numRead=inputStream.read(fileBty, offset, fileBty.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < fileBty.length) {
            throw new SysUnifiedException("文件下载不完全!");
        }
        inputStream.close();

        return fileBty;
    }
}
