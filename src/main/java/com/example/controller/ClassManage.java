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
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/organization")
public class ClassManage {


    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/class")
    @ResponseBody
    public String progress( @RequestBody AllBean allBean) throws IOException {
        System.out.println("class");
        Integer oid= allBean.getOid();
        List<AllBean> list= userMapper.findallIdClasstime(oid);
        int lenth=list.size();
        for (int i=0;i<lenth;i++){
            AllBean allBean1=list.get(i);
            //查找aname 并给bean赋值
            allBean1.setAname(userMapper.findaname(allBean1.getAid()));
            //查找sname 并给bean赋上
            allBean1.setSname(userMapper.findsname(allBean1.getSid()));
            //拿到upload信息
            AllBean tempBean=userMapper.findUallMessage(allBean1.getUid());
            allBean1.setUploaddate(tempBean.getUploaddate());
            allBean1.setUploadtime(tempBean.getUploadtime());
            if (tempBean.getUploaddate()!=null){
                allBean1.setUploaddatetime(tempBean.getUploaddate()+"  "+tempBean.getUploadtime());
            }
            allBean1.setUpath(tempBean.getUpath());
            allBean1.setUmessage(tempBean.getUmessage());
            //拿到feed信息
            //如果fid没有也设置为--

                allBean1.setFeedbackdatetime("null");

            if (allBean1.getFid()!=null){
                AllBean tempBean2=userMapper.findFallMessage(allBean1.getFid());
                allBean1.setFeedbackdate(tempBean2.getFeedbackdate());
                allBean1.setFeedbacktime(tempBean2.getFeedbacktime());
                if (tempBean2.getFeedbackdate()!=null){
                    allBean1.setFeedbackdatetime(tempBean2.getFeedbackdate()+" "+tempBean2.getFeedbacktime());
                }
                allBean1.setFpath(tempBean2.getFpath());
                allBean1.setFmessage(tempBean2.getFmessage());
            }


        }


        System.out.println(JSON.toJSONString(list));
        if (list.size()==0){
            return "1";
        }

        return JSON.toJSONString(list);
    }
}
