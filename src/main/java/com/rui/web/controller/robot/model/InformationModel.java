package com.rui.web.controller.robot.model;

import java.sql.Timestamp;

/**
 * 计算机信息统计model
 * @author : zhuxueke
 * @since : 2018-01-26 14:12
 **/
public class InformationModel implements java.io.Serializable{
    // 计算机名称
    private String computerName;
    // ipv4 地址
    private String ipv4;
    // 子网掩码
    private String subneMask;
    // 网关
    private String gateway;
    // 占用的端口
    private String port;
    // 当前程序所在文件夹
    private String thisAtMkdir;
    // 操作系统以及版本
    private String operationSystem;
    // 系统所在文件夹
    private String systemAtMkdir;
    // 登录过期时间（分钟）
    private Integer signOutTime;
    // 当前时间
    private Timestamp nowTime;
    // 系统逻辑盘符
    private String letters;
    // cpu 总数
    private Integer cpuCount;
    // 当前sessionId
    private String sessionId;
    // 计算机域名
    private String computerDomain;

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getSubneMask() {
        return subneMask;
    }

    public void setSubneMask(String subneMask) {
        this.subneMask = subneMask;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getThisAtMkdir() {
        return thisAtMkdir;
    }

    public void setThisAtMkdir(String thisAtMkdir) {
        this.thisAtMkdir = thisAtMkdir;
    }

    public String getSystemAtMkdir() {
        return systemAtMkdir;
    }

    public void setSystemAtMkdir(String systemAtMkdir) {
        this.systemAtMkdir = systemAtMkdir;
    }

    public Integer getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Integer signOutTime) {
        this.signOutTime = signOutTime;
    }

    public Timestamp getNowTime() {
        return nowTime;
    }

    public void setNowTime(Timestamp newTime) {
        this.nowTime = newTime;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public Integer getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }


    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getComputerDomain() {
        return computerDomain;
    }

    public void setComputerDomain(String computerDomain) {
        this.computerDomain = computerDomain;
    }
}
