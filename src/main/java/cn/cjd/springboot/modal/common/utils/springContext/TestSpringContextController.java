package cn.cjd.springboot.modal.common.utils.springContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/springContextUtils")
public class TestSpringContextController {

    @GetMapping(value = "/testGetBean")
    public void testGetBean(){
        TestSpringContextBean testBean = SpringContextUtils.getBean(TestSpringContextBean.class);
        testBean.sayIGet();
    }
}
