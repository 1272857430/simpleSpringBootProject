package cn.cjd.springboot.modal.simple_orm.privilege.dao;

import cn.cjd.springboot.modal.simple_orm.privilege.bean.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 170096 on 2017/7/28.
 */
@Repository
public interface PrivilegelRepository extends JpaRepository<Privilege,String> {

//    // 查询权限列表
//    @Query(value = "" ,nativeQuery = true)
//    List<Privilege> findPrivilegeByGirlId(@Param(value = "girlIds") List<String> girlIds );
}
