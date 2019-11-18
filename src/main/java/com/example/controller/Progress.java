package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.domain.AllBean;
import com.example.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/organization")
public class Progress {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/progress")
    public String progress(  @RequestBody AllBean allBean) throws IOException {
        Integer oid= allBean.getOid();
        Integer zclasstime=userMapper.findzclasstime(oid);
        AllBean allBean1 = new AllBean();
        allBean1.setClasstime(zclasstime);

        List<AllBean> lis=userMapper.findtidtname(oid);
        int size =lis.size();
        for (int i=0;i<size;i++){
            AllBean ab=lis.get(i);
            Integer tid = ab.getTid();
            Integer[] classtime=userMapper.findclasstime(tid);
            ab.setClasstime(classtime.length);
        }
        lis.add(allBean1);

//        System.out.println(JSON.toJSONString(lis));



        return  JSON.toJSONString(lis);
    }

}
