package com.rui.web.controller.robot;

import com.rui.control.domain.ComputerDomain;
import com.rui.control.query.ComputerQuery;
import com.rui.control.service.IComputerService;
import com.rui.web.controller.robot.util.BaseDao;
import com.rui.web.controller.robot.util.ServerSocketThread;
import com.rui.web.controller.robot.util.SingleServerSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.sql.Timestamp;

/**
 * @author : zhuxueke
 * @since : 2018-01-19 17:23
 **/
@Controller
@RequestMapping(value = "/computer")
public class ComputerController {
    @Autowired
    IComputerService computerService;

    @RequestMapping(value = "run")
    @ResponseBody
    String ApplicationRun(String pwd, String name){
        try{
            ComputerQuery query = new ComputerQuery();
            query.setPwd(pwd);
            if(name != null){
                query.setName(name);
            }else{
                //获取当前系统时间
                query.setName(System.getenv("USERNAME"));
            }
            ComputerDomain computerDomain = computerService.getFirst(query);
            if(computerDomain != null){
                computerDomain.setIp(InetAddress.getLocalHost().getHostAddress().toString());
                computerDomain.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                computerService.update(computerDomain);
            }else{
                //创建用户 密码默认 123456
                computerDomain = new ComputerDomain();
                computerDomain.setIp(InetAddress.getLocalHost().getHostAddress().toString());
                computerDomain.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                computerDomain.setName(query.getName());
                computerDomain.setPwd("123456");
                computerService.create(computerDomain);
            }
            ServerSocket serverSocket = SingleServerSocket.getInstance(18888);
            System.out.println("---启动成功---");
            while(true){
                new ServerSocketThread(serverSocket.accept()).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}