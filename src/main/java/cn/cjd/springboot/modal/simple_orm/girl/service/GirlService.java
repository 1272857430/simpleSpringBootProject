package cn.cjd.springboot.modal.simple_orm.girl.service;

import cn.cjd.springboot.modal.common.bean.BaseRepository;
import cn.cjd.springboot.modal.simple_orm.girl.bean.Girl;
import cn.cjd.springboot.modal.simple_orm.girl.bean.GirlVO;
import cn.cjd.springboot.modal.simple_orm.girl.dao.GirlRepository;
import cn.cjd.springboot.modal.simple_orm.sysException.EventCode;
import cn.cjd.springboot.modal.simple_orm.sysException.GirlException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 170096 on 2017/7/28
 */
@Service
public class GirlService<T, DAO extends BaseRepository> {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询单个女生
     *
     */
    public Object queryById(String id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        GirlVO girlVO = new GirlVO();
        BeanUtils.copyProperties(girl, girlVO);
        return girlVO;
    }

    /**
     * 查询全部女生
     *
     */
    public Object queryAllGirls() throws Exception{
        List<Girl> girlList = girlRepository.findAll();
        List<GirlVO> girlVOList = new ArrayList<>();
        for (Girl girl : girlList) {
            GirlVO girlVO = new GirlVO();
            BeanUtils.copyProperties(girl, girlVO);
            girlVOList.add(girlVO);
        }
        return girlVOList;
    }

    /**
     * 模糊查询女生信息
     *
     */
    public Object findByNameLike(String name) throws Exception{
        List<Girl> girlList = girlRepository.findByNameLike(name);
        List<GirlVO> girlVOList = new ArrayList<>();
        for (Girl girl : girlList) {
            GirlVO girlVO = new GirlVO();
            BeanUtils.copyProperties(girl, girlVO);
            girlVOList.add(girlVO);
        }
        return girlVOList;
    }

    /**
     * 新增或者修改
     *
     */
    public Object addOrUpdateGirl(Girl g , String id) throws Exception{
        if (id != null && !"".equals(id)) {
            System.out.println("id:  " + g.getId());
            updataGirl(g , id);
        } else {
            girlRepository.save(g);
        }
        GirlVO girlVO = new GirlVO();
        BeanUtils.copyProperties(g, girlVO);
        return girlVO;
    }

    //更新女生信息
    private void updataGirl(Girl g , String id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        if (g.getName() != null) {
            girl.setName(g.getName());
        }
        if (g.getAge() != null) {
            girl.setAge(g.getAge());
        }
        if (g.getCupSize() != null) {
            girl.setCupSize(g.getCupSize());
        }
//        if (g.getPost() != null){
//            girl.setPost(g.getPost());
//        }
        girlRepository.save(girl);
    }

    /**
     * 逻辑删除女生
     *
     */
    public Object deleteGirl(String id) throws Exception {
        Girl girl;
        try {
            girl = girlRepository.findOne(id);
            girl.setIsDelete(1);
            girlRepository.save(girl);
        } catch (Exception e) {
            throw new GirlException(EventCode.FAILD_OPERATION);
        }
        GirlVO girlVO = new GirlVO();
        BeanUtils.copyProperties(girl, girlVO);
        return girlVO;
    }

    /**
     * 查询女生年龄
     *
     */
    public Object queryGirlAge(String id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age <= 10) {
            throw new GirlException(EventCode.PRIMARY_SCHOOL);
        } else if (age > 10 && age <= 16) {
            throw new GirlException(EventCode.MIDDLE_SCHOOL);
        } else {
            return age;
        }
    }
}
