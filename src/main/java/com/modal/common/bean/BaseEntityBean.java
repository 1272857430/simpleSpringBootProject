package com.modal.common.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by 170096 on 2017/8/8
 */
@MappedSuperclass
public class BaseEntityBean {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")//这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @CreationTimestamp
    @Column(name = "create_time", updatable = false)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    @ColumnDefault("0")
    @Generated(GenerationTime.INSERT)
    @Column(name = "is_delete", length = 2, nullable = false)
    private Integer isDelete;

    public String getId() {
        return id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntityBean that = (BaseEntityBean) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return isDelete != null ? isDelete.equals(that.isDelete) : that.isDelete == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }


}
