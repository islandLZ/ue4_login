package com.jay.ue4_login.service;

import com.jay.ue4_login.dao.UeUserMapper;
import com.jay.ue4_login.entity.UeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChangeService {

    @Autowired
    UeUserMapper ueUserMapper;

    public Map change(UeUser ueUser){
        //  根据id来更改用户的其它数据(account,username,password,level)

        Map map1 = new HashMap();
        String text = null;

        try{
            int i = ueUserMapper.updateByPrimaryKeySelective(ueUser);

            if(i > 0){
                map1.put("success","success");
                text = "用户修改成功：";
            }
            else{
                //修改失败
                map1.put("success","fail");
                text = "用户修改失败：";
            }
        }
        catch (Exception e){
            //修改失败
            map1.put("success","fail");
            text = "用户修改失败：";
            e.getStackTrace();
        }

        System.out.println("ChangeService:"+text+map1.toString());

        return map1;
    }
}
