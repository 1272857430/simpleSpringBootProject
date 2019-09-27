package cn.cjd.springboot.modal.fileServer.Ctrl;

import com.modal.common.result.ObjectToResult;
import com.modal.common.utils.simpleUtils.HttpHeaderUtil;
import com.modal.fileServer.bean.FileServerBean;
import com.modal.fileServer.service.FileServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 170096 on 2018/10/15 13:56
 *
 * @author ${User}
 */
@RestController
@RequestMapping(value = "/fileServer")
public class FileServerController {

    @Autowired
    private FileServerService fileServerService;

    /**
     * 文件上传
     */
    @PostMapping(value = "/upLoadFile", consumes = "multipart/form-data")
    public Object upLoadFile(MultipartFile file, FileServerBean fileServerBean) throws Exception{
        fileServerService.upLoadFile(fileServerBean, file);
        return ObjectToResult.getResult(0,"SUCCESS");
    }

    /**
     * 文件下载
     */
    @GetMapping(value = "/downloadFile")
    public Object downloadFile (@RequestParam("filePath") String filePath, @RequestParam("fileName") String fileName) throws Exception {
        fileServerService.downloadFile(filePath, fileName, HttpHeaderUtil.getResponse());
        return ObjectToResult.getResult("SUCCESS");
    }

    /**
     * 更新文件
     */
    @PostMapping(value = "/updateFile", consumes = "multipart/form-data")
    public Object updateFile(MultipartFile file, FileServerBean fileServerBean) throws Exception {
        fileServerService.updateFile(fileServerBean, file);
        return ObjectToResult.getResult("SUCCESS");
    }

    /**
     * 删除文件
     */
    @DeleteMapping(value = "/deleteFile")
    public Object deleteFile(@RequestParam("filePath") String filePath) throws Exception {
        fileServerService.deleteFile(filePath);
        return ObjectToResult.getResult("SUCCESS");
    }

}
