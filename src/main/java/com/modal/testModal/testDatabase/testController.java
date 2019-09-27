package com.modal.testModal.testDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 170096 on 2018/8/9
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class testController {

    private final TestDataBase testDataBase;

    @Autowired
    public testController(TestDataBase testDataBase) {
        this.testDataBase = testDataBase;
    }

    @GetMapping(value = "/testController")
    public Object testQueryDate(){
        return testDataBase.queryDate();
    }
}
