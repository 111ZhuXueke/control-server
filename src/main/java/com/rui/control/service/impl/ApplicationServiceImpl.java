package com.rui.control.service.impl;

import com.rui.control.domain.ApplicationDomain;
import com.rui.control.mapper.IApplicationMapper;
import com.rui.control.service.IApplicationService;
import com.rui.web.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : zhuxueke
 * @since : 2018-01-31 9:45
 **/
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class ApplicationServiceImpl extends BaseServiceImpl<ApplicationDomain> implements IApplicationService  {

    @Autowired
    IApplicationMapper applicationMapper;

    @Override
    public Long getMaxId() {
        return applicationMapper.getMaxId();
    }


}
