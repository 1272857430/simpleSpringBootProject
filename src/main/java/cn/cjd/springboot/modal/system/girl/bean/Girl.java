package cn.cjd.springboot.modal.system.girl.bean;

import cn.cjd.springboot.modal.common.bean.BaseEntityBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by 170096 on 2017/8/8
 */
@Entity
@Table(name = "GIRL")
public class Girl extends BaseEntityBean {

    @Column(name = "NAME" ,length = 20 , nullable = false)
    private String name;

    @Column(name = "CUP_SIZE" , length = 20 , nullable = false)
    private String cupSize;

    @Min(value = 18 , message = "未成年")
    @Column(name = "AGE" , length = 200 , nullable = false)
    private Integer age;

    @Column(name = "START_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date startTime;

    //实体类中使用了@Table注解后，想要添加表中不存在字段，就要使用@Transient这个注解了
    @Transient
    private String test;

//    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE} , optional = false)
//    //将属性optional设置为true(默认为true)，这可以使得即使外键为空时仍可以向表中添加数据（前提数据库字段设置为：允许为空）
//    @JoinColumn(name = "POST_ID")
//    private Post post;
//
//    @ManyToMany(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
//    @JoinTable(name = "GIRL_PRI" ,
//            joinColumns = {@JoinColumn(name = "GIRL_ID")} ,
//            inverseJoinColumns = {@JoinColumn(name = "PRI_ID")})
//    private Set<Privilege> privileges;
//
//    public Set<Privilege> getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(Set<Privilege> privileges) {
//        this.privileges = privileges;
//    }
//
//    //配置权限
//    public void addPrivilege(Privilege privilege){
//        if(this.privileges.contains(privilege)){
//            privileges.add(privilege);
//        }
//    }
//
//    //删除权限
//    public void removePrivilege(Privilege privilege){
//        if(this.privileges.contains(privilege)){
//            privileges.remove(privilege);
//        }
//    }
//
//    @OneToMany(cascade = CascadeType.REFRESH , fetch = FetchType.LAZY)
//    @JoinTable(name = "girl_post",
//            joinColumns = {@JoinColumn(name = "girl_id")},
//            inverseJoinColumns = {@JoinColumn(name = "post_id")})
//    private Set<Post> posts;

    public Girl() {

    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
//
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }

}
