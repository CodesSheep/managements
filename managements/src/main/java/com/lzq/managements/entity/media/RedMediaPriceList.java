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
public class RedMediaPriceList  implements Serializable {
    private static final long serialVersionUID = 2708001181275226866L;
    private Long serial;

    private String redMediaNo;

    private String redMediaName;

    private String redIndustryNo;

    private String redIndustryName;

    private String districtClassNo;

    private String districtClassName;

    private String fansNum;

    private String attention;

    private String averagePraisePoints;

    private String praisePoints;

    private String videoPrice;

    private String graphicPrice;


    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format = "yy-MM-hh HH:mm:ss")
    private Date updateTime;

    private String referenceFansNo;

    private String referencePointsNo;

    private String videoPriceType;

    private String graphicPriceType;

    private String imgURL;
    private String costPrice;
    private String mediaManName;
    private String mediaManPhone;
    private String sort;
    private String order;
    private Integer pageNo;
    private Integer pageSize;
}