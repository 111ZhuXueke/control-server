package com.rui.control.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 本地电脑信息类
 * @author : zhuxueke
 * @since : 2018-01-17 18:29
 **/
@Table(name = "computer")
public class ComputerDomain {
    @Id
    private Long id;
    private String name;
    private String ip;
    private String pwd;
    private Timestamp updateTime;
    private Timestamp createTime;

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
