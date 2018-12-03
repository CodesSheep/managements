package com.lzq.managements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback implements Serializable {
    private static final long serialVersionUID = -985054149615372845L;
    private Long serial;
    private String userNo;
    private String empName;
    private String feedback;
    private Date createTime;
}
