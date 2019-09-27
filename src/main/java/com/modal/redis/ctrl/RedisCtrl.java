package com.modal.redis.ctrl;

import com.modal.redis.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 170099 on 2017/7/27.
 */
@RestController
@RequestMapping("/api/redis")
@EnableAutoConfiguration
public class RedisCtrl {

    @Autowired
    private RedisUtils redisUtil;

    @RequestMapping("/getId")
    public String getId() {
        redisUtil.set("aaa", "测试1",10L);
        System.out.println("-----------------");
        String string = redisUtil.get("aaa").toString();
        return string;
    }

    @RequestMapping("/getExpire")
    public String getExpire() {
        String string = redisUtil.get("aaa").toString();
        return string;
    }

    @RequestMapping("/getValue")
    public String getValue() {
        redisUtil.set("bbb", "测试2");
        System.out.println("-----------------");
        String string = redisUtil.get("bbb").toString();
        return string;
    }


    @RequestMapping("/remove")
    public Boolean remove() {
        redisUtil.remove("aaa,bbb");
        Boolean flag = redisUtil.exists("aaa,bbb");
        return flag;
    }

    @RequestMapping("/removePattern")
    public Boolean removePattern() {
        redisUtil.removePattern("b");
        Boolean flag = redisUtil.exists("b");
        return flag;
    }

}
