package cn.cjd.springboot.modal.system.privilege.service;

import com.modal.system.privilege.bean.Privilege;
import com.modal.system.privilege.dao.PrivilegelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 170096 on 2017/7/28.
 */
@Service
public class PrivilegeService {

    @Autowired
    PrivilegelRepository privilegelRepository;

    /**
     * 新增或则修改权限
     * @param privilege
     * @return
     */
    public Object addOrUpdatePrivilege(Privilege privilege) {
        if(privilege.getId() != null && !"".equals(privilege.getId())){
            updatePrivilege(privilege);
            return "success";
        }else{
            privilegelRepository.save(privilege);
            return "success";
        }
    }

    //更新权限
    private void updatePrivilege(Privilege privilege) {
        Privilege privilege1 = privilegelRepository.findOne(privilege.getId());
        if(privilege.getPriName() != null && !"".equals(privilege.getPriName())){
            privilege1.setPriName(privilege.getPriName());
        }
        if (privilege.getPriDesc() != null && !"".equals(privilege.getPriDesc())){
            privilege1.setPriDesc(privilege.getPriDesc());
        }
    }
}
