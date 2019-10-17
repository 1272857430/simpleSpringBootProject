package cn.cjd.springboot.modal.db_use.nutz.nutzdao.page;

public interface Paginable {
    int getTotalCount();

    int getTotalPage();

    int getPageSize();

    int getPageNo();

    boolean isFirstPage();

    boolean isLastPage();

    int getNextPage();

    int getPrePage();
}
