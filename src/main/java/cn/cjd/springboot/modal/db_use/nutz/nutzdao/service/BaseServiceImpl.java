package cn.cjd.springboot.modal.db_use.nutz.nutzdao.service;

import cn.cjd.springboot.modal.db_use.nutz.nutzdao.model.BaseModel;
import cn.cjd.springboot.modal.db_use.nutz.nutzdao.page.Pagination;
import org.apache.commons.lang.math.NumberUtils;
import org.nutz.dao.*;
import org.nutz.dao.entity.Record;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.dao.util.Daos;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.service.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl<T> extends EntityService<T> implements BaseService<T> {
    private static int DEFAULT_PAGE_NUMBER = 10;
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public BaseServiceImpl(Dao dao) {
        super(dao);
    }

    public String sql(String key) {
        return this.dao().sqls().get(key);
    }

    public int count(Condition cnd) {
        return this.dao().count(this.getEntityClass(), cnd);
    }

    public int count() {
        return this.dao().count(this.getEntityClass());
    }

    public int count(String tableName, Condition cnd) {
        return this.dao().count(tableName, cnd);
    }

    public int count(String tableName) {
        return this.dao().count(tableName);
    }

    public T fetch(long id) {
        return this.dao().fetch(this.getEntityClass(), id);
    }

    public T fetch(String id) {
        return this.dao().fetch(this.getEntityClass(), id);
    }

    public <T> T fetchLinks(T obj, String regex) {
        return this.dao().fetchLinks(obj, regex);
    }

    public <T> T fetchLinks(T obj, String regex, Condition cnd) {
        return this.dao().fetchLinks(obj, regex, cnd);
    }

    public T fetch(Condition cnd) {
        return this.dao().fetch(this.getEntityClass(), cnd);
    }

    public T fetchx(Object... pks) {
        return this.dao().fetchx(this.getEntityClass(), pks);
    }

    public boolean exists(Object... pks) {
        return null != this.fetchx(pks);
    }

    public <T> T insert(T obj) {
        return this.dao().insert(obj);
    }

    public <T> T insert(T obj, FieldFilter filter) {
        return this.dao().insert(obj, filter);
    }

    public <T> T insertOrUpdate(T obj) {
        if (obj instanceof BaseModel) {
            BaseModel baseModel = (BaseModel)obj;
            if (Strings.isBlank(baseModel.getId())) {
                return this.insert(obj);
            } else {
                BaseModel baseModel1 = (BaseModel)this.fetch(baseModel.getId());
                if (baseModel1 != null) {
                    int res = this.update(baseModel);
                    return res > 0 ? obj : null;
                } else {
                    return this.insert(obj);
                }
            }
        } else {
            return null;
        }
    }

    public <T> T insertOrUpdate(T obj, FieldFilter insertFieldFilter, FieldFilter updateFieldFilter) {
        return this.dao().insertOrUpdate(obj, insertFieldFilter, updateFieldFilter);
    }

    public void insert(String tableName, Chain chain) {
        this.dao().insert(tableName, chain);
    }

    public <T> T fastInsert(T obj) {
        return this.dao().fastInsert(obj);
    }

    public <T> T insertWith(T obj, String regex) {
        return this.dao().insertWith(obj, regex);
    }

    public <T> T insertLinks(T obj, String regex) {
        return this.dao().insertLinks(obj, regex);
    }

    public <T> T insertRelation(T obj, String regex) {
        return this.dao().insertRelation(obj, regex);
    }

    public int update(BaseModel obj) {
        if (Strings.isBlank(obj.getId())) {
            return 0;
        } else {
            FieldMatcher fieldMatcher = FieldMatcher.create(true);
            Chain chain = Chain.from(obj, fieldMatcher);
            Cnd cnd = Cnd.where("id", "=", obj.getId());
            return this.dao().update(obj.getClass(), chain, cnd);
        }
    }

    public int updateIgnoreNull(BaseModel obj) {
        if (Strings.isBlank(obj.getId())) {
            return 0;
        } else {
            FieldMatcher fieldMatcher = FieldMatcher.create(true);
            fieldMatcher.setIgnoreNull(true);
            Chain chain = Chain.from(obj, fieldMatcher);
            Cnd cnd = Cnd.where("id", "=", obj.getId());
            return this.dao().update(obj.getClass(), chain, cnd);
        }
    }

    public int update(Chain chain, Condition cnd) {
        Map map = chain.toMap();
        chain = Chain.from(map, FieldMatcher.create(true));
        return this.dao().update(this.getEntityClass(), chain, cnd);
    }

    public int update(String tableName, Chain chain, Condition cnd) {
        Map map = chain.toMap();
        chain = Chain.from(map, FieldMatcher.create(true));
        return this.dao().update(tableName, chain, cnd);
    }

    public <T> T updateWith(T obj, String regex) {
        return this.dao().updateWith(obj, regex);
    }

    public <T> T updateLinks(T obj, String regex) {
        return this.dao().updateLinks(obj, regex);
    }

    public int updateRelation(Class<?> classOfT, String regex, Chain chain, Condition cnd) {
        Map map = chain.toMap();
        chain = Chain.from(map, FieldMatcher.create(true));
        return this.dao().updateRelation(classOfT, regex, chain, cnd);
    }

    public int updateWithVersion(Object obj) {
        return this.dao().updateWithVersion(obj);
    }

    public int updateWithVersion(Object obj, FieldFilter fieldFilter) {
        return this.dao().updateWithVersion(obj, fieldFilter);
    }

    public int updateAndIncrIfMatch(Object obj, FieldFilter fieldFilter, String fieldName) {
        return this.dao().updateAndIncrIfMatch(obj, fieldFilter, fieldName);
    }

    public int getMaxId() {
        return this.dao().getMaxId(this.getEntityClass());
    }

    public int delete(long id) {
        return this.dao().delete(this.getEntityClass(), id);
    }

    public int delete(int id) {
        return this.dao().delete(this.getEntityClass(), (long)id);
    }

    public int delete(String id) {
        return this.dao().delete(this.getEntityClass(), id);
    }

    public void delete(Integer[] ids) {
        this.dao().clear(this.getEntityClass(), Cnd.where("id", "in", ids));
    }

    public void delete(Long[] ids) {
        this.dao().clear(this.getEntityClass(), Cnd.where("id", "in", ids));
    }

    public void delete(String[] ids) {
        this.dao().clear(this.getEntityClass(), Cnd.where("id", "in", ids));
    }

    public int clear() {
        return this.dao().clear(this.getEntityClass());
    }

    public int clear(String tableName) {
        return this.dao().clear(tableName);
    }

    public int clear(Condition cnd) {
        return this.dao().clear(this.getEntityClass(), cnd);
    }

    public int clear(String tableName, Condition cnd) {
        return this.dao().clear(tableName, cnd);
    }

    public int vDelete(String id) {
        return this.dao().update(this.getEntityClass(), Chain.make("delTag", true), Cnd.where("id", "=", id));
    }

    public int vDelete(String[] ids) {
        return this.dao().update(this.getEntityClass(), Chain.make("delTag", true), Cnd.where("id", "in", ids));
    }

    public T getField(String fieldName, long id) {
        return Daos.ext(this.dao(), FieldFilter.create(this.getEntityClass(), fieldName)).fetch(this.getEntityClass(), id);
    }

    public T getField(String fieldName, int id) {
        return Daos.ext(this.dao(), FieldFilter.create(this.getEntityClass(), fieldName)).fetch(this.getEntityClass(), (long)id);
    }

    public T getField(String fieldName, String name) {
        return Daos.ext(this.dao(), FieldFilter.create(this.getEntityClass(), fieldName)).fetch(this.getEntityClass(), name);
    }

    public T getField(String fieldName, Condition cnd) {
        return Daos.ext(this.dao(), FieldFilter.create(this.getEntityClass(), fieldName)).fetch(this.getEntityClass(), cnd);
    }

    public List<T> query(String fieldName, Condition cnd) {
        return Daos.ext(this.dao(), FieldFilter.create(this.getEntityClass(), fieldName)).query(this.getEntityClass(), cnd);
    }

    public List<T> query(Condition cnd) {
        return this.dao().query(this.getEntityClass(), cnd);
    }

    public List<T> query() {
        return this.dao().query(this.getEntityClass(), (Condition)null);
    }

    public List<T> query(Condition cnd, String linkName) {
        List<T> list = this.dao().query(this.getEntityClass(), cnd);
        if (!Strings.isBlank(linkName)) {
            this.dao().fetchLinks(list, linkName);
        }

        return list;
    }

    public List<T> query(String linkName) {
        return this.query((Condition)null, (String)linkName);
    }

    public List<T> query(Condition cnd, String linkName, Pager pager) {
        List<T> list = this.dao().query(this.getEntityClass(), cnd, pager);
        if (!Strings.isBlank(linkName)) {
            this.dao().fetchLinks(list, linkName);
        }

        return list;
    }

    public List<T> query(Condition cnd, Pager pager) {
        return this.dao().query(this.getEntityClass(), cnd, pager);
    }

    public String getSubPath(String tableName, String cloName, String value) {
        final String val = Strings.sNull(value);
        Sql sql = Sqls.create("select " + cloName + " from " + tableName + " where " + cloName + " like '" + val + "____' order by " + cloName + " desc");
        sql.setCallback(new SqlCallback() {
            public Object invoke(Connection conn, ResultSet rs, Sql sql) throws SQLException {
                String rsvalue = val + "0001";
                if (rs != null && rs.next()) {
                    rsvalue = rs.getString(1);
                    int newvalue = NumberUtils.toInt(rsvalue.substring(rsvalue.length() - 4)) + 1;
                    rsvalue = rsvalue.substring(0, rsvalue.length() - 4) + (new DecimalFormat("0000")).format((long)newvalue);
                }

                return rsvalue;
            }
        });
        this.dao().execute(sql);
        return sql.getString();
    }

    public int count(Sql sql) {
        sql.setCallback(new SqlCallback() {
            public Object invoke(Connection conn, ResultSet rs, Sql sql) throws SQLException {
                int rsvalue = 0;
                if (rs != null && rs.next()) {
                    rsvalue = rs.getInt(1);
                }

                return rsvalue;
            }
        });
        this.dao().execute(sql);
        return sql.getInt();
    }

    public List<Record> list(Sql sql) {
        sql.setCallback(Sqls.callback.records());
        this.dao().execute(sql);
        return sql.getList(Record.class);
    }

    public Map getMap(Sql sql) {
        sql.setCallback(new SqlCallback() {
            public Object invoke(Connection conn, ResultSet rs, Sql sql) throws SQLException {
                HashMap map = new HashMap();

                while(rs.next()) {
                    map.put(Strings.sNull(rs.getString(1)), Strings.sNull(rs.getString(2)));
                }

                return map;
            }
        });
        this.dao().execute(sql);
        return (Map)sql.getObject(Map.class);
    }

    public Pagination listPage(Integer pageNumber, Condition cnd) {
        return this.listPage(pageNumber, DEFAULT_PAGE_NUMBER, cnd);
    }

    public Pagination listPage(Integer pageNumber, Sql sql) {
        return this.listPage(pageNumber, DEFAULT_PAGE_NUMBER, sql);
    }

    public Pagination listPage(Integer pageNumber, String tableName, Condition cnd) {
        return this.listPage(pageNumber, DEFAULT_PAGE_NUMBER, tableName, cnd);
    }

    public Pagination listPage(Integer pageNumber, Integer pageSize, Condition cnd) {
        pageNumber = this.getPageNumber(pageNumber);
        pageSize = this.getPageSize(pageSize);
        Pager pager = this.dao().createPager(pageNumber, pageSize);
        List<T> list = this.dao().query(this.getEntityClass(), cnd, pager);
        pager.setRecordCount(this.dao().count(this.getEntityClass(), cnd));
        return new Pagination(pageNumber, pageSize, pager.getRecordCount(), list);
    }

    public Pagination listPage(Integer pageNumber, Integer pageSize, Condition cnd, String fieldName) {
        pageNumber = this.getPageNumber(pageNumber);
        pageSize = this.getPageSize(pageSize);
        Pager pager = this.dao().createPager(pageNumber, pageSize);
        List<T> list = Daos.ext(this.dao(), FieldFilter.create(this.getEntityClass(), fieldName)).query(this.getEntityClass(), cnd, pager);
        pager.setRecordCount(this.dao().count(this.getEntityClass(), cnd));
        return new Pagination(pageNumber, pageSize, pager.getRecordCount(), list);
    }

    public Pagination listPage(Integer pageNumber, Integer pageSize, String tableName, Condition cnd) {
        pageNumber = this.getPageNumber(pageNumber);
        pageSize = this.getPageSize(pageSize);
        Pager pager = this.dao().createPager(pageNumber, pageSize);
        List<Record> list = this.dao().query(tableName, cnd, pager);
        pager.setRecordCount(this.dao().count(tableName, cnd));
        return new Pagination(pageNumber, pageSize, pager.getRecordCount(), list);
    }

    public Pagination listPage(Integer pageNumber, Integer pageSize, Sql sql) {
        pageNumber = this.getPageNumber(pageNumber);
        pageSize = this.getPageSize(pageSize);
        Pager pager = this.dao().createPager(pageNumber, pageSize);
        pager.setRecordCount((int)Daos.queryCount(this.dao(), sql));
        sql.setPager(pager);
        sql.setCallback(Sqls.callback.records());
        this.dao().execute(sql);
        return new Pagination(pageNumber, pageSize, pager.getRecordCount(), sql.getList(Record.class));
    }

    protected int getPageNumber(Integer pageNumber) {
        return Lang.isEmpty(pageNumber) ? 1 : pageNumber;
    }

    protected int getPageSize(Integer pageSize) {
        if (Lang.isEmpty(pageSize)) {
            return DEFAULT_PAGE_NUMBER;
        } else {
            return pageSize == 0 ? DEFAULT_PAGE_NUMBER : pageSize;
        }
    }

    public List<Record> executeSimpleSql(String sqlKey, Map<String, Object> params) {
        Sql sql = this.dao().sqls().create(sqlKey);
        sql.params().putAll(params);
        sql.setEntity(this.dao().getEntity(Record.class));
        sql.setCallback(Sqls.callback.entities());
        this.dao().execute(sql);
        return sql.getList(Record.class);
    }
}