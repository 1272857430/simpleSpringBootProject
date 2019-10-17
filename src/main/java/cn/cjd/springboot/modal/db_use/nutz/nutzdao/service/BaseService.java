package cn.cjd.springboot.modal.db_use.nutz.nutzdao.service;


import cn.cjd.springboot.modal.db_use.nutz.nutzdao.model.BaseModel;
import cn.cjd.springboot.modal.db_use.nutz.nutzdao.page.Pagination;
import org.nutz.dao.Chain;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.FieldFilter;
import org.nutz.dao.entity.Record;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    Dao dao();

    int count(Condition var1);

    int count();

    int count(String var1, Condition var2);

    int count(String var1);

    T fetch(long var1);

    T fetch(String var1);

    <T> T fetchLinks(T var1, String var2);

    <T> T fetchLinks(T var1, String var2, Condition var3);

    T fetch(Condition var1);

    T fetchx(Object... var1);

    boolean exists(Object... var1);

    <T> T insert(T var1);

    <T> T insert(T var1, FieldFilter var2);

    <T> T insertOrUpdate(T var1);

    <T> T insertOrUpdate(T var1, FieldFilter var2, FieldFilter var3);

    void insert(String var1, Chain var2);

    <T> T fastInsert(T var1);

    <T> T insertWith(T var1, String var2);

    <T> T insertLinks(T var1, String var2);

    <T> T insertRelation(T var1, String var2);

    int update(BaseModel var1);

    int updateIgnoreNull(BaseModel var1);

    int update(Chain var1, Condition var2);

    int update(String var1, Chain var2, Condition var3);

    <T> T updateWith(T var1, String var2);

    <T> T updateLinks(T var1, String var2);

    int updateRelation(Class<?> var1, String var2, Chain var3, Condition var4);

    int updateWithVersion(Object var1);

    int updateWithVersion(Object var1, FieldFilter var2);

    int updateAndIncrIfMatch(Object var1, FieldFilter var2, String var3);

    int getMaxId();

    int delete(long var1);

    int delete(int var1);

    int delete(String var1);

    void delete(Integer[] var1);

    void delete(Long[] var1);

    void delete(String[] var1);

    int clear();

    int clear(String var1);

    int clear(Condition var1);

    int clear(String var1, Condition var2);

    int vDelete(String var1);

    int vDelete(String[] var1);

    T getField(String var1, long var2);

    T getField(String var1, int var2);

    T getField(String var1, String var2);

    T getField(String var1, Condition var2);

    List<T> query(String var1, Condition var2);

    List<T> query(Condition var1);

    List<T> query();

    List<T> query(Condition var1, String var2);

    List<T> query(String var1);

    List<T> query(Condition var1, String var2, Pager var3);

    List<T> query(Condition var1, Pager var2);

    String getSubPath(String var1, String var2, String var3);

    int count(Sql var1);

    List<Record> list(Sql var1);

    Map getMap(Sql var1);

    Pagination listPage(Integer var1, Condition var2);

    Pagination listPage(Integer var1, Sql var2);

    Pagination listPage(Integer var1, String var2, Condition var3);

    Pagination listPage(Integer var1, Integer var2, Condition var3);

    Pagination listPage(Integer var1, Integer var2, Condition var3, String var4);

    Pagination listPage(Integer var1, Integer var2, String var3, Condition var4);

    Pagination listPage(Integer var1, Integer var2, Sql var3);

    List<Record> executeSimpleSql(String var1, Map<String, Object> var2);
}
