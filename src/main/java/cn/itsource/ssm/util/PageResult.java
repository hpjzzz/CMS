package cn.itsource.ssm.util;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> {
    private  Long total=0L;//分页的总条数
    private List<T> rows=new ArrayList<>();//分页数据

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
