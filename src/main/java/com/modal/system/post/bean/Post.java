package com.modal.system.post.bean;

import com.modal.common.bean.BaseEntityBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 170096 on 2017/8/8.
 */
@Entity
@Table(name = "POST")
public class Post extends BaseEntityBean {

    @Column(name = "POST_NAME", nullable = false, length = 20)
    private String postName;

    @Column(name = "POST_DESC", nullable = false, length = 20)
    private String postDesc;

//    @ManyToMany(cascade = CascadeType.REFRESH , fetch = FetchType.LAZY)
//    @JoinTable(name = "POST_PRI" ,
//            joinColumns = {@JoinColumn(name = "POST_ID")} ,
//            inverseJoinColumns = {@JoinColumn(name = "PRI_ID")})
//    private Set<Privilege> privileges;
//
//    // orphanRemoval=true配置表明删除无关联的数据。级联更新子结果集时此配置最关键
//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval=true)
//    private List<Girl> girls;
//
//    public void addGirl (Girl girl) {
//        if (girl != null) {
//            this.girls.add(girl);
//        }
//    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

//    public Set<Privilege> getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(Set<Privilege> privileges) {
//        this.privileges = privileges;
//    }
//
//    public List<Girl> getGirls() {
//        return girls;
//    }
//
//    public void setGirls(List<Girl> girls) {
//        this.girls = girls;
//    }
}
