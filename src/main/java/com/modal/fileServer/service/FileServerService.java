package com.modal.fileServer.service;

import com.modal.common.exception.SysUnifiedException;
import com.modal.common.utils.fileUtils.FileHandlerUtils;
import com.modal.common.utils.fileUtils.FileService;
import com.modal.fileServer.bean.FileServerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by 170096 on 2018/10/15 13:57
 *
 * @author ${User}
 */
@Service
public class FileServerService {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     */
    public void upLoadFile(FileServerBean fileServerBean, MultipartFile file) throws Exception {

        if (file == null) {
            throw new SysUnifiedException("请上传文件!");
        }

        fileService.createFile(fileServerBean.getFilePath(), file);
    }

    /**
     * 文件下载
     */
    public void downloadFile(String filePath, String fileName, HttpServletResponse response) throws IOException {

        File file = fileService.readFile(filePath);

        // 获取文件的byte[]数组
        byte[] fileBty = FileHandlerUtils.getBytes(file);

        // 设置编码格式
        response.reset();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.addHeader("Content-Length", "" + fileBty.length);
        response.setContentType("application/octet-stream");

        // 通过文件流的形式写到客户端
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        outputStream.write(fileBty);

        // 写完以后关闭文件流
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 删除文件
     */
    public void deleteFile(String filePath) throws Exception {
        fileService.deleteFile(filePath);
    }

    /**
     * 更新文件
     */
    public void updateFile(FileServerBean fileServerBean, MultipartFile file) throws Exception {
        this.deleteFile(fileServerBean.getFilePath());
        this.upLoadFile(fileServerBean, file);
    }


}
