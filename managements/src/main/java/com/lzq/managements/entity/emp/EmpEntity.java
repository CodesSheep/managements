package com.lzq.managements.entity.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpEntity implements Serializable {
    private static final long serialVersionUID = -5975935593392126147L;
    private Long serial;
    private String empNo;
    private String empName;
    private String empPassword;
    private Date   createTime;
    private Date   loginTime;
    private String loginIP;
    private String teamNo;
    private String jurisdictionName;
    private String qq;
    private String phone;
    private String imgURL;
}
