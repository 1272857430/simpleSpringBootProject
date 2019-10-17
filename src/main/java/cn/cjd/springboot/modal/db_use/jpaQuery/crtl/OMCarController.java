package cn.cjd.springboot.modal.db_use.jpaQuery.crtl;

import cn.cjd.springboot.modal.db_use.jpaQuery.service.OMCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 170096 on 2018/8/17
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/omCar")
public class OMCarController {

    @Autowired
    private OMCarService omCarService;

    /**
     * 查询所有
     */
    @GetMapping(value = "/queryDate")
    public Object queryDate(){
        return omCarService.queryDate();
    }

    /**
     * 动态查询
     */
    @GetMapping(value = "/dynamicQuery")
    public Object dynamicQuery(){
        return omCarService.dynamicQuery("","","", "");
    }

    /**
     * 自定义查询
     */
    @GetMapping(value = "/predefinedQuery")
    public Object predefinedQuery(){
        return omCarService.predefinedQuery();
    }

    /**
     * 查询表结构(列)
     */
    @GetMapping(value = "/queryTableColumn")
    public Object queryTableColumn(){
        return omCarService.queryTableColumn("METADATA", "BDM_TABLE2");
    }

    /**
     * 查询表结构(列)
     */
    @GetMapping(value = "/queryTableColumn2")
    public Object queryTableColumn2(){
        return omCarService.queryTableColumn2("METADATA", "BDM_TABLE2");
    }

    /**
     * 自定义修改语句
     */
    @GetMapping(value = "/predefinedModified")
    public void predefinedModified(){
        omCarService.predefinedModified();
    }
}
