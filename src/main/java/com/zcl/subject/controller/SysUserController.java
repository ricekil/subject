package com.zcl.subject.controller;

import com.zcl.subject.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jlm on 2019-07-05 15:19
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @RequestMapping("/login")
    public void login(String loginName,String password){
        try {
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            subject.login(token);
            System.out.println("2222");
        } catch (UnknownAccountException | LockedAccountException e) {
            System.out.println("2222");
            System.out.println("3333");
            return;
        }
        System.out.println("登录成功");
    }

}
