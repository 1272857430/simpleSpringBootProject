package cn.cjd.springboot.modal.system.privilege.bean;


import cn.cjd.springboot.modal.common.bean.BaseEntityBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 170096 on 2017/8/8.
 */
@Entity
@Table(name = "PRIVILEGE")
public class Privilege extends BaseEntityBean {

    @Column(name = "PRI_NAME" , length = 20 , nullable = false)
    private String PriName;

    @Column(name = "PRI_DESC" , length = 50 ,nullable = false)
    private  String priDesc;

    public String getPriName() {
        return PriName;
    }

    public void setPriName(String priName) {
        PriName = priName;
    }

    public String getPriDesc() {
        return priDesc;
    }

    public void setPriDesc(String priDesc) {
        this.priDesc = priDesc;
    }
}
