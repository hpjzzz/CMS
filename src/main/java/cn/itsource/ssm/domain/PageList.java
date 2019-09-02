package cn.itsource.ssm.domain;

import java.util.List;

public class PageList<T> {

    private Integer currentPage;
    private Integer firstPage=1;
    private Integer prePage;
    private Integer nextPage;
    private Integer lastPage;
    private Integer totalPage;
    private Integer totalData;
    private Integer pageSize=5;
    private List<T> list;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalData() {
        return totalData;
    }

    public void setTotalData(Integer totalData) {
        this.totalData = totalData;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageList(Integer currentPage, Integer totalData, Integer pageSize, List<T> list) {
        this.currentPage = currentPage;
        this.totalData = totalData;
        this.pageSize = pageSize;
        this.list = list;
        //总页数
        this.totalPage = totalData%pageSize==0?totalData/pageSize:totalData/pageSize+1;
        //尾页
        this.lastPage = this.totalPage;
        //下一页
        this.nextPage = this.currentPage>=this.lastPage?this.lastPage:this.currentPage+1;
        //上一页
        this.prePage = this.currentPage<=1?1:this.currentPage-1;
    }
}
