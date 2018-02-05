package com.rui.web.controller.robot;

import com.rui.control.domain.ApplicationDomain;
import com.rui.control.model.ApplicationModel;
import com.rui.control.query.ApplicationQuery;
import com.rui.control.service.IApplicationService;
import com.rui.web.controller.base.AdminBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 应用程序 控制层
 * @author : zhuxueke
 * @since : 2018-01-31 9:42
 **/
@Controller
@RequestMapping(value = "/application")
public class ApplicationController extends AdminBaseController {

    @Autowired
    IApplicationService applicationService;

    /**
     * 应用程序列表
     * @author : zhuxueke
     * @since : 2018/1/31 11:19
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("application/index");
        return modelAndView;
    }

    /**
     * 应用程序列表
     * @author : zhuxueke
     * @since : 2018/1/31 11:19
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody
    public String index(ApplicationQuery query){
        List<ApplicationDomain> list = applicationService.getList(query);
        return listToJsonString(list, query.getPageSize(), query.getPageIndex());
    }

    /**
     * 新增应用程序
     * @author : zhuxueke
     * @since : 2018/1/31 11:19
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView add(Long computerId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("computerId",computerId);
        modelAndView.setViewName("application/add");
        return modelAndView;
    }

    /**
     * 新增应用程序
     * @author : zhuxueke
     * @since : 2018/1/31 11:19
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(ApplicationDomain applicationDomain,Long computerId){
        try{
            applicationDomain.setComputerId(computerId);
            applicationService.create(applicationDomain);
            if(applicationDomain.getId() == null){
                return errorObjectStr("添加失败!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return successObjectStr("添加成功!");
    }
}
