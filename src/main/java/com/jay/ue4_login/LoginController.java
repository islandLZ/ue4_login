package com.jay.ue4_login;

import com.jay.ue4_login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Map ueLogin(@RequestParam("account")String account,
                       @RequestParam("password")String password){

        System.out.println("客户端发送的请求参数：");
        System.out.println("账号："+account);
        System.out.println("密码："+password);

        Map result = loginService.getUser(account,password);
        //数据库manage_sys,表ue_user,只有一条用户数据,account=9527,password=123456,username=lizhi

        return result;
    }
}
