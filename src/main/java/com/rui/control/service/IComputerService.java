package com.rui.control.service;

import com.rui.control.domain.ComputerDomain;
import com.rui.web.common.service.IBaseService;
import com.rui.web.controller.robot.model.InformationModel;

/**
 * 用户
 * @author : zhuxueke
 * @since : 2017-12-07 17:28
 **/
public interface IComputerService extends IBaseService<ComputerDomain> {
    /**
     * 获取表最大id
     * @author : zhuxueke
     * @since : 2018/1/23 9:45
     */
    Long getMaxId();

    /**
     * 获取计算机本地信息
     * @author : zhuxueke
     * @since : 2018/1/26 14:36
     */
    InformationModel getComputerInfo();
}