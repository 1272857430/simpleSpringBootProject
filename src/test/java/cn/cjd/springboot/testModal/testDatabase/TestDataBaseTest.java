package cn.cjd.springboot.testModal.testDatabase;

import cn.cjd.springboot.modal.testModal.testDatabase.TestDataBase;
import cn.cjd.springboot.testModal.BaseTest.SpringBootTest.ApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 170096 on 2018/8/9
 */
public class TestDataBaseTest extends ApplicationTest {


    @Autowired
    private TestDataBase testDataBase;

    @Test
    public void testQueryDate(){
        System.out.println(testDataBase.queryDate());
    }

}