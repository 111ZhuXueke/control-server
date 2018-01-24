package com.rui.control.query;

import com.rui.control.domain.ComputerDomain;
import com.rui.web.common.persistence.criteria.QueryCriteria;
import com.rui.web.common.query.Query;
import tk.mybatis.mapper.entity.Example;

/**
 * 用户query
 * @author : zhuxueke
 * @since : 2017-12-08 14:51
 **/
public class ComputerQuery extends Query implements java.io.Serializable{

    private Integer id;
    private String name;
    private String ip;
    private String pwd;

    @Override
    public QueryCriteria toCriteria() {
        QueryCriteria queryCriteria = new QueryCriteria(ComputerDomain.class);
        Example.Criteria criteria = queryCriteria.createCriteria();
        if(valid(id)){
            criteria.andEqualTo("id",id);
        }
        if(valid(name) && valid(pwd)){
            criteria.andEqualTo("name",name);
            criteria.andEqualTo("pwd",pwd);
        }
        if(valid(name) && !valid(pwd)){
            criteria.andEqualTo("name",name);
        }
        if(valid(ip)){
            criteria.andEqualTo("ip",ip);
        }
        return queryCriteria;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
