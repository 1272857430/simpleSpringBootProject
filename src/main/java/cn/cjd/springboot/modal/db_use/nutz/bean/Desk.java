package cn.cjd.springboot.modal.db_use.nutz.bean;

import cn.cjd.springboot.modal.db_use.nutz.nutzdao.model.BaseModel;
import lombok.Data;
import org.nutz.dao.entity.annotation.*;

import java.util.Date;

@Data
@Table("desk")
public class Desk extends BaseModel {

    @Column("material")
    @Comment("材料")
    private String material;

    @Column("shaper")
    @Comment("形状")
    private String shaper;

    @Column("length")
    @ColDefine(type = ColType.FLOAT)
    @Comment("长")
    private Double length;

    @Column("width")
    @ColDefine(type = ColType.FLOAT)
    @Comment("宽")
    private Double width;

    @Column("high")
    @ColDefine(type = ColType.FLOAT)
    @Comment("高")
    private Double high;

    @Column("start_use_time")
    @ColDefine(type = ColType.TIMESTAMP)
    @Comment("开始使用时间")
    private Date startUseTime;
}
