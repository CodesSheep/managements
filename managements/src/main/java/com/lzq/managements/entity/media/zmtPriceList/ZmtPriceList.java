package com.lzq.managements.entity.media.zmtPriceList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZmtPriceList implements Serializable {
    private static final long serialVersionUID = -8008385313825526947L;
    private Long serial;

    private String zmtNo;

    private String zmtName;

    private String platformNo;
    private String platformName;
    private String industryNo;
    private String industryName;
    private String districtClassNo;
    private String districtClassName;
    private BigDecimal advancedPrice;

    private BigDecimal ordinaryPrice;

    private BigDecimal ordinaryVipPrice;

    private BigDecimal retailPrice;

    private String state;

    private String referencefansNo;
    private String referencefanstype;
    private String referencereadNo;
    private String referencereadtype;
    private String priceNo;
    private String priceName;
    private String remark;

    private String zmtURL;

    private String zmtpersonURL;
    private String costPrice;
    private String mediaManName;
    private String mediaManPhone;
    private String sort;
    private String order;
    private Integer offset;
    private Integer limit;







}