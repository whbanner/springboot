package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.domain.AllBean;
import com.example.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.JavaScriptBaseMessage;

@RestController
@RequestMapping(value = "/organization")
public class UpdatePassword {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/updatepassword")
    @ResponseBody
    public String uodatePassword(@RequestBody AllBean allBean) {
        String username1 = allBean.getUsername();
        String password1 = allBean.getPassword();
        Integer oid = allBean.getOid();
        userMapper.update(username1, password1,oid);

        return JSON.toJSONString("ok");
    }
}
