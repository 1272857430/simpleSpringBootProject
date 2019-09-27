package cn.cjd.springboot.modal.system.girl.dao;

import cn.cjd.springboot.modal.system.girl.bean.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 170096 on 2017/7/28
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl, String> {

    //模糊查询女生信息
    List<Girl> findByNameLike(String name);

//    //批量删除女生信息
//    @Query(value = "" , nativeQuery = true)
//    void delGirls(@Param(value = "girl_ids") List<String> girl_ids);

//    // 查询权限列表
//    @Query(value = "" ,nativeQuery = true)
//    List<Privilege> findPrivilegeByGirlId(@Param(value = "girlIds") List<String> girlIds );

//    //删除关联关系
//    @Modifying
//    @Transactional
//    @Query(value = "" , nativeQuery = true)
//    void delRelation(@Param( value = "girlId") String grilId);
}
