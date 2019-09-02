package cn.itsource.ssm.domain;

public class Condition {
    private Integer currentPage=1;
    private Integer pageSize=5;
    //分页查询的条件
    private Integer offset;
    private Integer limit;
    //生成静态页面的条件
    private String template;
    private String output;

    //区分前后台
    private Boolean flag;

    //职位搜索的条件
    private String title;

    //工作时间
    private Integer workingTime=1;


    public Integer getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Integer workingTime) {
        this.workingTime = workingTime;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Integer getOffset() {
        return (currentPage-1)*pageSize;
    }

    public Integer getLimit() {
        return pageSize;
    }


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", limit=" + limit +
                ", template='" + template + '\'' +
                ", output='" + output + '\'' +
                ", flag=" + flag +
                ", title='" + title + '\'' +
                ", workingTime=" + workingTime +
                '}';
    }
}
