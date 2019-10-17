package cn.cjd.springboot.modal.db_use.nutz.service;

import cn.cjd.springboot.modal.db_use.nutz.bean.Desk;
import cn.cjd.springboot.modal.db_use.nutz.nutzdao.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.springframework.stereotype.Service;

@Service
public class DeskService extends BaseServiceImpl<Desk> {

    public DeskService(Dao dao) {
        super(dao);
    }

}
