package com.rui.control.service;

import com.rui.control.domain.ApplicationDomain;
import com.rui.control.domain.ComputerDomain;
import com.rui.web.common.service.IBaseService;
import com.rui.web.controller.robot.model.InformationModel;

/**
 * 用户
 * @author : zhuxueke
 * @since : 2017-12-07 17:28
 **/
public interface IApplicationService extends IBaseService<ApplicationDomain> {
    /**
     * 获取表最大id
     * @author : zhuxueke
     * @since : 2018/1/23 9:45
     */
    Long getMaxId();

}