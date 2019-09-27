package com.modal.common.jpaQuery.vo;

/**
 * Created by 170096 on 2018/8/24
 */
public class ColumnAttr {

    // 列名
    private String columnName;

    // 数据类型
    private String dataType;

    // 长度
    private Integer len;

    // 精度
    private Integer precision;

    private String description;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
