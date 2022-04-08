package com.jay.ue4_login.controller;

import com.jay.ue4_login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public Map ueLogin(@RequestParam("username")String username,
                       @RequestParam("password")String password){

        System.out.println("LoginController:客户端发送的请求参数：");
        System.out.println("LoginController:用户名："+username);
        System.out.println("LoginController:密码："+password);

        Map result = loginService.getUser(username,password);
        //数据库manage_sys,表ue_user,只有一条用户数据,account=9527,password=123456,username=lizhi
        //{"result":{"isLogin":"success","userInfo":{"level":null,"username":"lizhi"}}}
        System.out.println("LoginController:响应："+result.toString());

        return result;
    }
}
