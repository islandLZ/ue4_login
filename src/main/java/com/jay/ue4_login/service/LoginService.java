package com.jay.ue4_login.service;

import com.jay.ue4_login.dao.UeUserMapper;
import com.jay.ue4_login.entity.UeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    UeUserMapper  ueUserMapper;

    public Map getUser(String username,String password){

        UeUser ueUser = ueUserMapper.selectByUsername(username);

        Map map = new HashMap();

        if (ueUser != null) {
            //数据库查找结果 与 用户输入的密码 进行比较
            if(ueUser.getPassword().equals(password)){
                //密码正确
                Map map1 = new HashMap();
                map1.put("isLogin", "success");
                Map map2 = new HashMap();
                map2.put("username",ueUser.getUsername());
                map2.put("level",ueUser.getLevel());
                map1.put("userInfo",map2);
                map.put("result",map1);
                //{result={isLogin=success, userInfo={level=null, username=lizhi}}}
                System.out.println("LoginService：账号密码正确"+map.toString());
            }
            else{
                //密码不正确
                Map map1 = new HashMap();
                map1.put("isLogin","fail");
                map.put("result",map1);
                System.out.println("LoginService：账号密码不正确"+map.toString());
            }
        }
        else{
            //数据库查询账号返回null
            Map map1 = new HashMap();
            map1.put("isLogin","fail");
            map.put("result",map1);
            System.out.println("LoginService：账号不存在"+map.toString());
        }

        return map;
    }

}
