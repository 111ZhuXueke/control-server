package com.rui.web.schedule.robot;

import com.rui.control.domain.ComputerDomain;
import com.rui.control.query.ComputerQuery;
import com.rui.control.service.IComputerService;
import com.rui.web.cache.CacheManagerImpl;
import com.rui.web.controller.robot.util.ServerSocketThread;
import com.rui.web.controller.robot.util.SingleServerSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.sql.Timestamp;

/**
 * @author : zhuxueke
 * @since : 2018-01-23 10:17
 **/
@Component
public class ScheduleComputer {
    CacheManagerImpl cacheManager = new CacheManagerImpl();

    @Autowired
    IComputerService computerService;

}
