package cn.cjd.springboot.modal.db_use.nutz.nutzdao.query;


import java.util.List;

public interface Query<T extends Query<?, ?>, U> {
    T asc();

    T desc();

    T orderBy(QueryProperty var1);

    long count();

    U singleResult();

    List<U> list();

    List<U> listPage(int var1, int var2);

    public static enum NullHandlingOnOrder {
        NULLS_FIRST,
        NULLS_LAST;

        private NullHandlingOnOrder() {
        }
    }
}
