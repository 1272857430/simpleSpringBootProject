package com.modal.testModal.testDatabase;

import com.modal.RedisApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 170096 on 2018/8/9
 */
public class TestDataBaseTest extends RedisApplicationTest {


    @Autowired
    private TestDataBase testDataBase;

    @Test
    public void testQueryDate(){
        System.out.println(testDataBase.queryDate());
    }

}