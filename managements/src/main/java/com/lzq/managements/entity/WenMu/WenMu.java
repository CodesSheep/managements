package com.lzq.managements.entity.WenMu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WenMu implements Serializable {

    private static final long serialVersionUID = -4982226108195258349L;
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
    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date loginTime;
    private String loginIP;

    private Integer frequency;


}
