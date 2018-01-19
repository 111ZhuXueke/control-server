package com.rui.control.model;


import com.rui.web.common.model.Query;

/**
 * @author : zhuxueke
 * @since : 2017-12-12 16:22
 **/
public class ComputerModel extends Query implements java.io.Serializable{

    private Integer id;
    private String name;
    private String ip;
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
