package cn.cjd.springboot.modal.db_use.nutz.nutzdao.model;

import org.nutz.dao.entity.annotation.*;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.lang.Times;
import org.nutz.lang.random.R;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column
    @Comment("自增长id")
    private Long pid;
    @Column
    @Name
    @ColDefine(
            type = ColType.VARCHAR,
            width = 32
    )
    @Prev(
            els = {@EL("uuid()")}
    )
    private String id;
    @Column("create_time")
    @Comment("创建时间")
    @Prev(
            els = {@EL("$me.now()")}
    )
    @ColDefine(
            customType = "TIMESTAMP(3)",
            type = ColType.TIMESTAMP
    )
    private Date createTime;
    @Column("modify_time")
    @Comment("操作时间")
    @Prev(
            els = {@EL("$me.now()")}
    )
    @ColDefine(
            customType = "TIMESTAMP(3)",
            type = ColType.TIMESTAMP
    )
    private Date modifyTime;

    public BaseModel() {
    }

    public String toString() {
        return Json.toJson(this, JsonFormat.compact());
    }

    public Boolean flag() {
        return false;
    }

    public Date now() {
        return Times.now();
    }

    public String uuid() {
        return R.UU32().toLowerCase();
    }

    public Boolean t() {
        return true;
    }

    public Boolean f() {
        return false;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getPid() {
        return this.pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
