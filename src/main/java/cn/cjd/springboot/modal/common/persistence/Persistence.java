package cn.cjd.springboot.modal.common.persistence;

import com.modal.common.jpaQuery.bean.OMCar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by 170096 on 2018/9/28 9:51
 * 持久化
 * @author ${User}
 */
public class Persistence {

    public static void main(String[] args) {
        String a = "进程与线程.txt";
        oneToTwo(a);
        OMCar omCar = new OMCar();
        omCar.setCarNo("1111");
        oneToTwo(omCar);
        Vo vo = new Vo();
        vo.setName("111111");
        oneToTwo(vo);
        Collection<String> stringList = new ArrayList<>();
        oneToTwo(stringList);
        System.out.println(a);
        System.out.println(omCar.getCarNo());
        System.out.println(vo.getName());
        System.out.println(stringList);
        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void oneToTwo( Collection<String> stringList){
        stringList.add("1111111");
        stringList.add("2222222");
    }

    private static void oneToTwo(Vo vo){
        vo.setName("222222");
    }

    private static void oneToTwo(OMCar omCar){
        omCar.setCarNo("22222");
    }

    private static void oneToTwo(String a){
        a += "2";
    }
}
