package cn.cjd.springboot.modal.system.post.dao;

import com.modal.system.post.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 170096 on 2017/7/28.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    //逻辑删除post
    @Query(value = "UPDATE girl SET is_delete = 1 WHERE id = :post_id" , nativeQuery = true)
    void delteByPost_id(@Param(value = "post_id") String post_id);
}
