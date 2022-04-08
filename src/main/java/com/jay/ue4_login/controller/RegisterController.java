package com.jay.ue4_login.controller;

import com.jay.ue4_login.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//

@RestController
public class RegisterController {
    
    @Autowired
    RegisterService registerService;
    
    @GetMapping("/register")
    public Map register(@RequestParam("username")String username,
                        @RequestParam("password")String password){

        System.out.println("RegisterController:客户端发送的请求参数：");
        System.out.println("RegisterController:用户名："+username);
        System.out.println("RegisterController:密码："+password);

        Map result = registerService.addUser(username, password);
        //{"result":{"success":"success"}}
        System.out.println("RegisterController:响应："+result.toString());

        return result;
    }

}
