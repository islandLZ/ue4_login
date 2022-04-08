package com.jay.ue4_login.controller;

import com.jay.ue4_login.entity.UeUser;
import com.jay.ue4_login.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChangeController {

    @Autowired
    ChangeService changeService;

    @GetMapping("/change")
    public Map change(UeUser ueUser){
        //  根据id来更改用户的其它数据(account,username,password,level)
        Map change = changeService.change(ueUser);

        System.out.println("ChangeController:客户端发送的请求参数：");
        System.out.println("ChangeController:id："+ueUser.getId());
        System.out.println("ChangeController:用户名："+ueUser.getUsername());
        System.out.println("ChangeController:密码："+ueUser.getPassword());
        System.out.println("ChangeController:等级："+ueUser.getLevel());
        System.out.println("ChangeController:响应："+change.toString());

        return change;
    }
}
