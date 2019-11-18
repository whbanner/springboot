package com.example.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AllBean {

    /**
     * 登录
     */
    private String one;
    private String username;
    private String password;


    /**
     * 艺术家
     */
    private Integer aid;
    private Integer age;
    private String aname;
    private String object;
    private String honour;
    private String apath;
    private String information;

    /**
     * 机构
     */
    private Integer oid;
    private String organization;

    /**
     * 琴童
     */
    private Integer sid;
    private String sname;
    private String ssex;
    private Integer sage;


    /**
     * 老师
     */
    private Integer tid;
    private String tname;


    /**
     * 上传
     */
    private Integer uid;
    private String uploaddate;
    private String uploadtime;
    private String uploaddatetime;
    private String upath;
    private String umessage;
    private String usong;

    /**
     * 回馈
     */
    private Integer fid;
    private String feedbackdate;
    private String feedbacktime;
    private String feedbackdatetime;
    private String fpath;
    private String fmessage;


    /**
     * 次数
     */
    private Integer cid;
    private Integer classtime;


    /**
     * 标记
     */
    private Integer asid;
    private String sign;
    private String sdate;
    private Integer frequency;


    /**
     *预约
     */
    private String allstudent;
    private String complete;
    private String spectrum;
    private String song;
    private String sudate;
    private String sutime;
    private Integer suid;


    /**
     *学生与老师
     */
    private Integer tsid;
    private String selfallStudent;
    /**
     *艺术家与学生
     */
    private Integer astid;
    private String aallstudent;
}
