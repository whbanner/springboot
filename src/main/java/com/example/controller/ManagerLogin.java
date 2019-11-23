package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.domain.AllBean;
import com.example.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/organization")
public class ManagerLogin {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login")
    @ResponseBody
        public String addSub( @RequestBody AllBean allBean){
        System.out.println("login");
        String b = "f";
        String username1=allBean.getUsername();
        String password1= allBean.getPassword();
        AllBean allBean1 = userMapper.findManager(allBean.getOid());
            if (username1.equals(allBean1.getUsername())&password1.equals(allBean1.getPassword())){
                b=allBean1.getOne();
            }

        return JSON.toJSONString(b);
    }
}
