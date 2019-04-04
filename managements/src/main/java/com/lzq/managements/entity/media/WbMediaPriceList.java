package com.lzq.managements.entity.media;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WbMediaPriceList implements Serializable {
    private static final long serialVersionUID = -7279238641090718614L;
    private Long serial;

    private String wbMediaNo;

    private String wbMediaName;

    private String imgURL;
    private String avgReadMonthly;
    private String classInfomation;
    private String represent;
    private String wbIndustryName;
    private String districtClassName;
    private String remark;
    private String authentication;
    private String hardStraightPrice;
    @JSONField(format = "yy-MM-hh HH:mm:ss")
    private Date hardStraightUpdateTime;
    private String hardForwardingPrice;
    @JSONField(format = "yy-MM-hh HH:mm:ss")
    private Date hardForwardingUpdateTime;
    private String softStraightPrice;
    @JSONField(format = "yy-MM-hh HH:mm:ss")
    private Date softStraightUpdateTime;
    private String softForwardingPrice;
    @JSONField(format = "yy-MM-hh HH:mm:ss")
    private Date softForwardingUpdateTime;
    private String hardStraightPriceType;
    private String hardForwardingPriceType;
    private String softStraightPriceType;
    private String softForwardingPriceType;
    private String costPrice;
    private String mediaManName;
    private String mediaManPhone;
    private Integer pageNo;
    private Integer pageSize;
    private String sort;
    private String order;


}