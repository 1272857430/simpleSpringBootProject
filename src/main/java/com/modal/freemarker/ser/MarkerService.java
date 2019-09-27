package com.modal.freemarker.ser;

import com.modal.freemarker.vo.Animal;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 170096 on 2018/10/8 17:34
 *
 * @author ${User}
 */
@Service
public class MarkerService {

    public Map getHelloPage() {

        Map<String, Object> res = new HashMap();

        Animal a1 = new Animal();
        a1.setName("小狗");
        a1.setPrice(88);
        Animal a2 = new Animal();
        a2.setName("小喵");
        a2.setPrice(80);
        Animal a3 = new Animal();
        a3.setName("小喵2");
        a3.setPrice(90);

        List<Animal> list = new ArrayList<Animal>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        res.put("user", "用户1");
        res.put("animals", list);
        res.put("templates", "hello");

        return res;
    }
}
