package cn.cjd.springboot.modal.system.privilege.ctrl;

import cn.cjd.springboot.modal.system.privilege.bean.Privilege;
import cn.cjd.springboot.modal.system.privilege.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 170096 on 2017/7/28.
 */
@RestController
@RequestMapping(value = "/system/privileges")
public class PrivilegeController {

    @Autowired
    PrivilegeService privilegeService;

    /**
     * 新增或则修改权限
     * @param privilege
     * @return
     */
    @PostMapping()
    public Object addOrUpdatePrivilege(@ModelAttribute Privilege privilege){
        return privilegeService.addOrUpdatePrivilege(privilege);
    }
}

