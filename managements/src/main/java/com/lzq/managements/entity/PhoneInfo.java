package com.lzq.managements.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneInfo implements Serializable {

    private static final long serialVersionUID = 1652373412141077744L;

    private Long serial;

    private String phoneNo;

    private String empNo;

    private String remark;
    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String discard;
    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date createTime;

    private String qqAccount;

    private String phoneName;

    private String empName;
    //合作状态
    private String hZstate;
    //意向等级
    private String yXstate;

    private String state;

    private String contacts;

    private String companyName;

}