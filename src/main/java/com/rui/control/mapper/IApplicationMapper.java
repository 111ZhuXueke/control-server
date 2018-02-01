package com.rui.control.mapper;

import com.rui.control.domain.ApplicationDomain;
import com.rui.control.domain.ComputerDomain;
import com.rui.web.common.persistence.Mapper;

/**
 * @author : zhuxueke
 * @since : 2017-12-07 17:23
 **/
public interface IApplicationMapper extends Mapper<ApplicationDomain>{
    /**
     * 获取表最大id
     * @author : zhuxueke
     * @since : 2018/1/23 9:45
     */
    Long getMaxId();
}
