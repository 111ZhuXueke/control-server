package com.rui.control.service.impl;

import com.rui.control.domain.ComputerDomain;
import com.rui.control.mapper.IComputerMapper;
import com.rui.control.service.IComputerService;
import com.rui.web.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : zhuxueke
 * @since : 2017-12-07 17:32
 **/
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class ComputerServiceImpl extends BaseServiceImpl<ComputerDomain> implements IComputerService {

    @Autowired
    private IComputerMapper computerMapper;


}
