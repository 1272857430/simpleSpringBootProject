package com.modal.common.jpaQuery.service;

import com.modal.common.jpaQuery.bean.OMCar;
import com.modal.common.jpaQuery.dao.OMCarRepository;
import com.modal.common.jpaQuery.vo.ColumnAttr;
import com.modal.common.jpaQuery.vo.QueryVo;
import com.modal.common.utils.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * Created by 170096 on 2018/8/17
 */
@Service
public class OMCarService {

    @Autowired
    private OMCarRepository omCarRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Object queryDate() {
        return omCarRepository.findAll();
    }

    /**
     * 动态查询
     */
    public Page<OMCar> dynamicQuery (String page, String rows, String carNo, String carColor) {

        int p = StringUtils.isNullOrBlank(page) ? 0 : Integer.valueOf(page) - 1;
        int r = StringUtils.isNullOrBlank(rows) ? 20 : Integer.valueOf(rows);
        final PageRequest pageRequest = new PageRequest(p, r);
        Page<OMCar> beanPage = omCarRepository.findAll((Root<OMCar> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

            Path<String> carNoPath = root.get("carNo");
            Path<String> carColorPath = root.get("carColor");

            // 车牌号
            Predicate carNoPredicate = cb.equal(carNoPath, carNo);
            // 车颜色
            Predicate carColorPPredicate = cb.equal(carColorPath, carColor);

            Predicate all = cb.and(carNoPredicate, carColorPPredicate);

            query.orderBy(cb.desc(carNoPath));
            query.where(all);
            return query.getRestriction();

        }, pageRequest);


        return beanPage;
    }

    /**
     * 自定义查询
     */
    public List<QueryVo> predefinedQuery(){
        String sql = "";
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class)
                .addScalar("purchaseOrderId", StandardBasicTypes.STRING)
                .setResultTransformer(Transformers.aliasToBean(QueryVo.class));

        return query.getResultList();
    }

    /**
     * 查询表结构(列)
     */
    public List<ColumnAttr> queryTableColumn(String userName, String tableName) {

        String sql ="select all_tab_columns.column_name as columnName, all_tab_columns.data_type as dataType, all_tab_columns.data_length as len, all_tab_columns.data_precision as precision, all_col_comments.comments as description " +
                "from all_tab_columns, all_col_comments " +
                "where all_tab_columns.table_name = all_col_comments.table_name and all_tab_columns.owner = all_col_comments.owner and all_tab_columns.column_name = all_col_comments.column_name " +
                "and all_tab_columns.table_name = '" + tableName.toUpperCase() + "' " +
                "and all_tab_columns.owner = '" + userName.toUpperCase() + "'";

        Session session = entityManager.unwrap(Session.class);
        NativeQuery query = session.createNativeQuery(sql);
        query.addScalar("columnName", StandardBasicTypes.STRING);
        query.addScalar("columnName", StandardBasicTypes.STRING);
        query.addScalar("dataType", StandardBasicTypes.STRING);
        query.addScalar("len", StandardBasicTypes.INTEGER);
        query.addScalar("precision", StandardBasicTypes.INTEGER);
        query.addScalar("description", StandardBasicTypes.STRING);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(ColumnAttr.class));

        return (List<ColumnAttr>) query.getResultList();
    }

    /**
     * 查询表结构(列)
     */
    public List<ColumnAttr> queryTableColumn2(String userName, String tableName) {

        String sql ="select all_tab_columns.column_name as columnName, all_tab_columns.data_type as dataType, all_tab_columns.data_length as len, all_tab_columns.data_precision as precision, all_col_comments.comments as description " +
                "from all_tab_columns, all_col_comments " +
                "where all_tab_columns.table_name = all_col_comments.table_name and all_tab_columns.owner = all_col_comments.owner and all_tab_columns.column_name = all_col_comments.column_name " +
                "and all_tab_columns.table_name = '" + tableName.toUpperCase() + "' " +
                "and all_tab_columns.owner = '" + userName.toUpperCase() + "'";

        Session session = entityManager.unwrap(Session.class);
        NativeQuery query = session.createNativeQuery(sql, ColumnAttr.class);

        return query.getResultList();
    }

    /**
     * 自定义修改语句
     */
    public void predefinedModified(){
        String sql = "";
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }

}
