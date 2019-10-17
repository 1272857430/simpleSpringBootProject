package cn.cjd.springboot.modal.db_use.nutz.nutzdao.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimplePage implements Serializable, Paginable {
    private static final long serialVersionUID = 1L;
    public static final int DEF_COUNT = 10;
    private List<Integer> localArrayList = new ArrayList();
    protected int totalCount = 0;
    protected int pageSize = 20;
    protected int pageNo = 1;
    int minPage;
    int maxPage;
    int totalPage;

    public List<Integer> getSegment() {
        return this.localArrayList;
    }

    public static int cpn(Integer pageNo) {
        return pageNo != null && pageNo >= 1 ? pageNo : 1;
    }

    public SimplePage() {
        this.minPage = this.pageNo - (int)Math.floor((double)(this.pageSize - 1) / 2.0D);
        this.maxPage = this.pageNo + (int)Math.ceil((double)(this.pageSize - 1) / 2.0D);
        this.totalPage = this.getTotalPage();
    }

    public SimplePage(int pageNo, int pageSize, int totalCount) {
        this.minPage = this.pageNo - (int)Math.floor((double)(this.pageSize - 1) / 2.0D);
        this.maxPage = this.pageNo + (int)Math.ceil((double)(this.pageSize - 1) / 2.0D);
        this.totalPage = this.getTotalPage();
        this.setTotalCount(totalCount);
        this.setPageSize(pageSize);
        this.setPageNo(pageNo);
        this.adjustPageNo();
        int totalPages = this.getTotalPage();
        this.minPage = this.minPage < 1 ? 1 : this.minPage;
        this.maxPage = this.maxPage > totalPages ? totalPages : this.maxPage;

        for(int i = this.minPage; i <= this.maxPage; ++i) {
            this.localArrayList.add(i);
        }

    }

    public void adjustPageNo() {
        if (this.pageNo != 1) {
            int tp = this.getTotalPage();
            if (this.pageNo > tp) {
                this.pageNo = tp;
            }

        }
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        int totalPage = this.totalCount / this.pageSize;
        if (totalPage == 0 || this.totalCount % this.pageSize != 0) {
            ++totalPage;
        }

        return totalPage;
    }

    public boolean isFirstPage() {
        return this.pageNo <= 1;
    }

    public boolean isLastPage() {
        return this.pageNo >= this.getTotalPage();
    }

    public int getNextPage() {
        return this.isLastPage() ? this.pageNo : this.pageNo + 1;
    }

    public int getPrePage() {
        return this.isFirstPage() ? this.pageNo : this.pageNo - 1;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }

    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }

    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }

    }
}