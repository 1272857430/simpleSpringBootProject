package com.modal.testModal.testDatabase;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by 170096 on 2018/8/9
 */
@Component
public class TestDataBase {

    @PersistenceContext
    private EntityManager entityManager;

    public List queryDate() {

        String sql = "SELECT sysdate FROM dual";

        Query query = entityManager.createNativeQuery(sql);

        return query.getResultList();
    }
}
