package com.rui.web.controller.webapi;

import com.alibaba.fastjson.JSONObject;
import com.rui.control.service.IComputerService;
import com.rui.web.controller.robot.ComputerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

/**
 * 本地接口，用于服务端通过本地 local.txt 验证
 * @author : zhuxueke
 * @since : 2018-01-25 9:36
 **/
@Controller
@RequestMapping(value = "/web")
public class localFileController {

    private static Logger logger = LoggerFactory.getLogger(localFileController.class);

    @Autowired
    IComputerService computerService;

    @Value("${server.lcoal}")
    private String path;

    /**
     * 本地文件校验
     * @author : zhuxueke
     * @since : 2018/1/25 9:48
     */
    @RequestMapping(value = "/getLocalFile", method = RequestMethod.GET)
    @ResponseBody
    public String getLocalFile(String code){
        JSONObject json = new JSONObject();
        try{
            if("".equals(code) || code == null){
                json.put("status", "error");
                json.put("message","标识字符串不能为空!");
            }
            File file = new File(path);
            if(file.exists()){
                json.put("status", "success");
                InputStream input = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int len = 0;
                StringBuffer buffer = new StringBuffer();
                while ((len = input.read(bytes)) != -1){
                    buffer.append(new String(bytes));
                }
                String value = new String(buffer);

                if(code.equals(buffer.toString())){
                    json.put("message","验证通过!");
                }else{
                    // name、pwd相同、mac 不同
                    json.put("message","请和计算机处在同一局域网中!");
                }
            }else{
                json.put("status", "fail");
                json.put("message","本地文件未创建!");
            }
        }catch (Exception e){
            logger.error("web/getLocalFile " + e.getMessage());
            json.put("status", "error");
            json.put("message","数据异常!");
        }
        return json.toJSONString();
    }
}
