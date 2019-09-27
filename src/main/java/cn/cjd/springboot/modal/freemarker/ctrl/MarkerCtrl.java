package cn.cjd.springboot.modal.freemarker.ctrl;

import cn.cjd.springboot.modal.freemarker.ser.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by 170096 on 2018/10/8 17:35
 *
 * @author ${User}
 */
@Controller()
public class MarkerCtrl {

    @Autowired
    private MarkerService markerService;

    @GetMapping(value = "/")
    public String getHelloPage(Model model) {
        Map res = markerService.getHelloPage();
        if (null == res) {
            return null;
        }
        model.addAllAttributes(res);
        return "hello";
    }
}
