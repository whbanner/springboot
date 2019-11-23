package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.domain.AllBean;
import com.example.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/organization")
public class AllOController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/alloid")
    @ResponseBody
    public String addOMessage(){
        System.out.println("alloid");
        List<AllBean> list = userMapper.findOMessage();
        System.out.println("xxx");
        return JSON.toJSONString(list);
    }
}
