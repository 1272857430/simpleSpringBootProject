package cn.cjd.springboot.modal.system.girl.ctrl;

import cn.cjd.springboot.modal.system.girl.bean.Girl;
import cn.cjd.springboot.modal.system.girl.service.GirlService;
import cn.cjd.springboot.modal.system.result.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by 170096 on 2017/7/28
 */
@RequestMapping(value = "/system/girls")
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    /**
     * 通过id查询女生
     *
     */
    @GetMapping(value = "/{id}")
    public Object queryById(@PathVariable(value = "id", required = true) String id) throws Exception {
        return Results.success(girlService.queryById(id));
    }

    /**
     * 查询全部女生
     *
     */
    @GetMapping()
    public Object queryAllGirls() throws Exception {
        return Results.success(girlService.queryAllGirls());
    }

    /**
     * 查询女生年龄
     *
     */
    @GetMapping(value = "/age/{id}")
    public Object queryGirlAge(@PathVariable(value = "id") String id) throws Exception {
        return Results.success(girlService.queryGirlAge(id));
    }


    /**
     * 新增或则修改女生
     *
     */
    @PostMapping()
    public Object addOrUpdateGirl(@ModelAttribute @Valid Girl girl, BindingResult bindingResult , @RequestParam(value = "id") String id) throws Exception {
        if (bindingResult.hasErrors()) {
            return Results.failed("1", bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.success(girlService.addOrUpdateGirl(girl,id));
    }

    /**
     * 删除女生
     *
     */
    @DeleteMapping(value = "/{id}")
    public Object deleteGirl(@PathVariable(value = "id", required = false) String id) throws Exception {
        if (StringUtils.isEmpty(id)){
            return Results.failed("1","id is null");
        }
        return Results.success(girlService.deleteGirl(id));
    }
}

