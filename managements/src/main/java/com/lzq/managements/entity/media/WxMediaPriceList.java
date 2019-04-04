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
public class WxMediaPriceList implements Serializable {
    private static final long serialVersionUID = 8078601015723729907L;
    private Long serial;

    private String wxMediaNo;

    private String wxName;

    private String wxNo;

    private String fansNum;
    private String wxIndustryName;
    private String districtClassName;
    private String headlinePrice;
    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date  headlinePriceUpdateTime;
    private String noHeadlinePrice;
    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date  noHeadlinePriceUpdateTime;
    private String tailPrice;
    @JSONField(format = "yy-MM-dd HH:mm:ss")
    private Date  tailPriceUpdateTime;
    private String remark;
    private String Reading;
    private String recentReading;
    private String dispatchInterval;
    private String comprehensiveScore;
    private String describe;
    private String label;
    private String imgURL;
    private String priceType;
    private String noPriceType;
    private String tailPriceType;
    private String readingType;
    private String fansType;
    private String costPrice;
    private String mediaManName;
    private String mediaManPhone;
    private String sort;
    private String order;
    private Integer pageNo;
    private Integer pageSize;

}