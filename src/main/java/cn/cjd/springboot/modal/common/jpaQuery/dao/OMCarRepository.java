package cn.cjd.springboot.modal.common.jpaQuery.dao;

import cn.cjd.springboot.modal.common.jpaQuery.bean.OMCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 170096 on 2018/8/17
 */
@Repository
public interface OMCarRepository extends JpaRepository<OMCar, String>, JpaSpecificationExecutor<OMCar> {

    // 查询某张表的主键
    @Modifying
    @Query(value = "select a.column_name from user_cons_columns a, user_constraints b where a.constraint_name = b.constraint_name and b.constraint_type = 'P' and a.table_name = : tableName", nativeQuery = true)
    String findIdColumnByTableName(@Param("tableName") String tableName);
}
