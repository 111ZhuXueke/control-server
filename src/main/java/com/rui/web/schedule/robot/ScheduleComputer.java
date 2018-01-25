package com.rui.web.schedule.robot;

import com.rui.control.domain.ComputerDomain;
import com.rui.control.query.ComputerQuery;
import com.rui.control.service.IComputerService;
import com.rui.web.cache.CacheManagerImpl;
import com.rui.web.controller.robot.util.ServerSocketThread;
import com.rui.web.controller.robot.util.SingleServerSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.sql.Timestamp;

/**
 * 每秒钟监听一次客户端
 * @author : zhuxueke
 * @since : 2018-01-23 10:17
 **/
@Component
public class ScheduleComputer {

    CacheManagerImpl cacheManager = new CacheManagerImpl();

    /**
     * 监听的端口
     * @author : zhuxueke
     * @since : 2018/1/23 17:27
     */
    @Value("${server.port}")
    private String port;

    @Autowired
    IComputerService computerService;

    /**
     * 用于监听端口，等待服务端连接，单线程状态
     * @author : zhuxueke
     * @since : 2018/1/25 9:31
     */
    @Scheduled(cron = "*/1 * * * * ?")  // 每秒钟执行一次
    public void excute(){
//        ComputerDomain domain = cacheManager.getCacheByKey("user") != null ? (ComputerDomain)cacheManager.getCacheByKey("user").getDatas() : null;
//        if(domain != null){
//            try{
//                ServerSocket serverSocket = SingleServerSocket.getInstance(Integer.parseInt(port));
//                // 避免浪费资源
//                if(SingleServerSocket.socket == null && SingleServerSocket.isClose()){
//                    System.out.println("--------socket 已经启动，等待连接---------");
//                    new ServerSocketThread(serverSocket.accept());
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
    }
}