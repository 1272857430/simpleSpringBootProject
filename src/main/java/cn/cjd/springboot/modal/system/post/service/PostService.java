package cn.cjd.springboot.modal.system.post.service;

import com.modal.system.post.bean.Post;
import com.modal.system.post.dao.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 170096 on 2017/7/28.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    /**
     * 新增或则修改岗位信息
     *
     * @param post
     * @return
     */
    public Object addOrUdatePost(Post post) {
        if (post.getId() != null && !"".equals(post.getId())) {
            updatePost(post);
            return "success";
        } else {
            postRepository.save(post);
            return "success";
        }
    }

    //更新岗位
    private void updatePost(Post post) {
        Post post1 = postRepository.findOne(post.getId());
        if (post.getPostName() != null && !"".equals(post.getPostName())) {
            post1.setPostName(post.getPostName());
        }
        if (post.getPostDesc() != null && !"".equals(post.getPostDesc())) {
            post1.setPostDesc(post.getPostDesc());
        }
    }


    /**
     * 逻辑删除post
     *
     * @param psot_id
     */
    public void deltePost(String psot_id) {
        postRepository.delteByPost_id(psot_id);
    }
}
