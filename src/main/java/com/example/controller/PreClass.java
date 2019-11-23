package com.example.controller;


import com.alibaba.fastjson.JSON;
import com.example.domain.AllBean;
import com.example.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/organization")
public class PreClass {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/subscribe")
    @ResponseBody
    public String progress( @RequestBody AllBean allBean) throws IOException {
        System.out.println("subscribe");
        Integer oid= allBean.getOid();

        List<AllBean> list =userMapper.findSubscribe(oid);
        int length= list.size();
        for (int i=0;i<length;i++){
            AllBean allBean1= list.get(i);
            allBean1.setAname(userMapper.findaname( allBean1.getAid()));
            String stus=allBean1.getAllstudent();
            String[] pstu=stus.split(",");
            int len=pstu.length;
            String a="";
            for (int j=0;j<len;j++){
                a=a+userMapper.findsname(Integer.parseInt(pstu[j]));
                if(j!=(len-1)){
                    a = a+",";
                }
            }
            allBean1.setSname(a);


        }

        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }
}
