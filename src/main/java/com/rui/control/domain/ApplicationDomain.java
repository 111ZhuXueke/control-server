package com.rui.control.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 应用程序表
 * @author : zhuxueke
 * @since : 2018-01-26 11:04
 **/
@Table(name = "application")
public class ApplicationDomain implements java.io.Serializable {

    @Id
    private Long id;
    // 计算机用户表主键
    private Long computerId;
    // 应用程序名称
    private String applicationName;
    // 应用程序路径
    private String applicationUrl;
    // 应用程序创建时间
    private Timestamp createTime;
    // 删除标识
    private Integer isclose;
    // 类别
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getComputerId() {
        return computerId;
    }

    public void setComputerId(Long computerId) {
        this.computerId = computerId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getIsclose() {
        return isclose;
    }

    public void setIsclose(Integer isclose) {
        this.isclose = isclose;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
