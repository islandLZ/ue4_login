package com.jay.ue4_login.service;

import com.jay.ue4_login.dao.UeUserMapper;
import com.jay.ue4_login.entity.UeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterService {

    @Autowired
    UeUserMapper ueUserMapper;

    public Map addUser(String username, String password){
        //构建用户对象
        UeUser ueUser1 = new UeUser();
        long time = System.currentTimeMillis();
        ueUser1.setAccount(String.valueOf(time));
        ueUser1.setUsername(username);
        ueUser1.setPassword(password);

        Map map1 = new HashMap();
        String text = null;
        try{
            int i = ueUserMapper.insertSelective(ueUser1);
            if(i == 1){//插入数据成功
                map1.put("success","success");
                text = "用户创建成功：";
            }
            else{
                map1.put("success","fail");
                text = "用户创建失败：";
            }
        }
        catch (Exception e){
            map1.put("success","fail");
            text = "用户创建成功：";
            e.getStackTrace();
        }

        Map map = new HashMap();
        map.put("result",map1);
        System.out.println("RegisterService："+text+map.toString());

        return map;
    }
}
