package cn.cjd.springboot.modal.system.post.ctrl;

import cn.cjd.springboot.modal.system.post.bean.Post;
import cn.cjd.springboot.modal.system.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 170096 on 2017/7/28.
 */
@RequestMapping(value = "/system/posts")
@RestController
public class PostController {

    @Autowired
    PostService postService;

    /**
     * 新增或则修改岗位
     * @param post
     * @return
     */
    @PostMapping()
    public Object addOrUdatePost(@ModelAttribute Post post){
        return postService.addOrUdatePost(post);
    }

}

