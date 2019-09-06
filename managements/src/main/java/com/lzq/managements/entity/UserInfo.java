package com.lzq.managements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {


    private static final long serialVersionUID = 91376425656836569L;
    private Long serial;
    private String empName;
    private String qqAccount;
    private String phoneNo;
    private Integer status;
    private String vipLevel;
    private String vipLevelZN;
    private BigDecimal balance;
    private Date createTime;
    private Date loginTime;
    private BigDecimal Accumulative;
    private String operation;
    private String contacts;
    private String companyName;
    private String state;
    private String empNo;
    private String userNo;
    private Date updateTime;
    private String planTime;
    private String feedback;
    private String remark;
    private String source;
    private String discard;
    private String locking;
    private Date adjustTime;
    private String teamNo;
}
