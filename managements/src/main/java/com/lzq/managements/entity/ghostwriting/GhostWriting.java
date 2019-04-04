package com.lzq.managements.entity.ghostwriting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GhostWriting implements Serializable{
    private static final long serialVersionUID = 6199275944484441918L;
    private Long serial;

    private String userno;

    private String title;

    private String spreadcompany;

    private String essentials;

    private String remark;

    private String link;

    private BigDecimal price;

    private String state;

    private Date createtime;

    private Date logintime;
    private String empNo;
    private String empName;
    private String contacts;


}