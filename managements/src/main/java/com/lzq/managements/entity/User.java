package com.lzq.managements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 4215390529965765341L;

    private Long serial;
    private String userNo;
    private String userName;
    private String password;
    private String qqAccount;
    private String phoneNo;
    private Integer status;
    private Integer vipLevel;
    private String vipLevelZN;
    private BigDecimal balance;
    private Date createTime;
    private Date loginTime;
    private String loginIP;

    private String cTime;
    private String lTime;
    private Integer frequency;

    private Integer alreadyCooperateNumber;

    private Integer noCooperateNumber;

    private Integer allCustomerNumber;
}
