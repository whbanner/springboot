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
public class AddSubscribe {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/addsubscribe")
    @ResponseBody
    public String addSub( @RequestBody AllBean allBean){

        allBean.setComplete("0");
        Integer a=userMapper.insertSub(allBean);
        System.out.println(a);
//        userMapper.insertSubscribe(allBean.getAid(),allBean.getAllstudent(),allBean.g)
    return JSON.toJSONString(allBean);
    }
}
