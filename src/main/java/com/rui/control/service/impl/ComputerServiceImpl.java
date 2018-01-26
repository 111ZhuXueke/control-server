package com.rui.control.service.impl;

import com.rui.control.domain.ComputerDomain;
import com.rui.control.mapper.IComputerMapper;
import com.rui.control.service.IComputerService;
import com.rui.web.common.service.impl.BaseServiceImpl;
import com.rui.web.controller.robot.model.InformationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.InetAddress;
import java.sql.Timestamp;

/**
 * @author : zhuxueke
 * @since : 2017-12-07 17:32
 **/
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class ComputerServiceImpl extends BaseServiceImpl<ComputerDomain> implements IComputerService {

    @Autowired
    IComputerMapper computerMapper;

    @Override
    public Long getMaxId() {
        return computerMapper.getMaxId();
    }

    @Override
    public InformationModel getComputerInfo() {
        InformationModel info = new InformationModel();
        try{
            info.setComputerName(System.getenv("COMPUTERNAME"));
            info.setComputerDomain(System.getenv("USERDOMAIN"));
            info.setIpv4(InetAddress.getLocalHost().getHostAddress());
            info.setNowTime(new Timestamp(System.currentTimeMillis()));
            info.setOperationSystem(System.getProperties().getProperty("os.name") + " " + System.getProperties().get("os.version"));
            info.setCpuCount(Runtime.getRuntime().availableProcessors());
            info.setSignOutTime(30);
            info.setLetters(getLetters());
        }catch (Exception e){
            e.printStackTrace();
        }
        return info;
    }

    /**
     * 获取系统盘符
     * @author : zhuxueke
     * @since : 2018/1/26 15:04
     */
    public String getLetters(){
        StringBuilder strb = new StringBuilder();
        try{
            for(char i = 'A'; i <= 'Z'; i ++){
                String path = i + "://";
                File file = new File(path);
                if(file.exists()){
                    strb.append(path + " ");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return strb.toString();
    }
}
