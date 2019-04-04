package com.lzq.managements.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HuiFang implements Serializable {
    private static final long serialVersionUID = -8963465746589362826L;
    private Long serial;

    private String empNo;

    private Integer alreadyCooperate;

    private Integer noCooperate;

    private Integer huiFangNumber;
    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date huiFangTime;
    private String empName;

    private String FirstCreateTime;

    private Integer alreadyCooperateNumber;

    private Integer noCooperateNumber;

    private Integer allCustomerNumber;


}