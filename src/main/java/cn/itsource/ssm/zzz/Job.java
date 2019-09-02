package cn.itsource.ssm.zzz;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Job implements Serializable {
    private Integer id;
    private String title;
    private Integer address_id;
    private Integer jobnum;
    private Integer treatment;
    private String describes;
    private String requires;
    private Boolean positionType;
    private Boolean enabled;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inputdate = new Date();
    private String htmlurl;

    public String getHtmlurl() {
        return htmlurl;
    }

    public void setHtmlurl(String htmlurl) {
        this.htmlurl = htmlurl;
    }

    //address多对一查询
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Integer getJobnum() {
        return jobnum;
    }

    public void setJobnum(Integer jobnum) {
        this.jobnum = jobnum;
    }

    public Integer getTreatment() {
        return treatment;
    }

    public void setTreatment(Integer treatment) {
        this.treatment = treatment;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getRequires() {
        return requires;
    }

    public void setRequires(String requires) {
        this.requires = requires;
    }

    public Boolean getPositionType() {
        return positionType;
    }

    public void setPositionType(Boolean positionType) {
        this.positionType = positionType;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address_id=" + address_id +
                ", jobnum=" + jobnum +
                ", treatment=" + treatment +
                ", describes='" + describes + '\'' +
                ", requires='" + requires + '\'' +
                ", positionType=" + positionType +
                ", enabled=" + enabled +
                ", inputdate=" + inputdate +
                ", htmlurl='" + htmlurl + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
