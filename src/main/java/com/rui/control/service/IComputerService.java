package com.rui.control.service;

import com.rui.control.domain.ComputerDomain;
import com.rui.web.common.service.IBaseService;

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
}