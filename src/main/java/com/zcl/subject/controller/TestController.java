package com.zcl.subject.controller;

import com.zcl.subject.bean.WindowBean;
import com.zcl.subject.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by jlm on 2019-07-05 14:09
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public WindowBean getData(Integer id){
        return testService.getData(id);
    }

}
