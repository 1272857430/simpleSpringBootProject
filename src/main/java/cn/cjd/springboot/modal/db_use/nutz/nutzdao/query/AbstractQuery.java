package cn.cjd.springboot.modal.db_use.nutz.nutzdao.query;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.sql.Criteria;

import java.io.Serializable;
import java.util.List;


public abstract class AbstractQuery<T extends Query<?, ?>, U> implements Query<T, U>, Serializable {
//    protected Criteria criteria = Cnd.cri();
//    public static final String SORTORDER_ASC = "asc";
//    public static final String SORTORDER_DESC = "desc";
//    protected AbstractQuery.ResultType resultType;
//    protected QueryProperty orderProperty;
//    protected transient Dao dao;
//    protected Class<U> uClass;
//
//    public AbstractQuery(Dao dao, Class<U> uClass) {
//        this.dao = dao;
//        this.uClass = uClass;
//    }
//
//    public T asc() {
//        return this.direction(Direction.ASCENDING);
//    }
//
//    public T desc() {
//        return this.direction(Direction.DESCENDING);
//    }
//
//    public T orderBy(QueryProperty property) {
//        this.orderProperty = property;
//        return this;
//    }
//
//    public T direction(Direction direction) {
//        if (this.orderProperty == null) {
//            throw new IllegalArgumentException("You should call any of the orderBy methods first before specifying a direction");
//        } else {
//            this.criteria.getOrderBy().orderBy(this.orderProperty.getName(), direction.getName());
//            this.orderProperty = null;
//            return this;
//        }
//    }
//
//    protected void checkQueryOk() {
//        if (this.orderProperty != null) {
//            throw new IllegalArgumentException("Invalid query: call asc() or desc() after using orderByXX()");
//        }
//    }
//
//    public long count() {
//        return (long)this.dao.count(this.uClass, this.criteria);
//    }
//
//    public U singleResult() {
//        return this.dao.fetch(this.uClass, this.criteria);
//    }
//
//    public List<U> list() {
//        this.dao.query(this.uClass, this.criteria);
//        return null;
//    }
//
//    public List<U> listPage(int firstResult, int maxResults) {
//        return null;
//    }
//
//    public static enum ResultType {
//        LIST,
//        LIST_PAGE,
//        SINGLE_RESULT,
//        COUNT;
//
//        private ResultType() {
//        }
//    }
}
