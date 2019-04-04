package com.lzq.managements.entity.media.mediaPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceList implements Serializable{
    private static final long serialVersionUID = -4510850537041395451L;

    private Long serial;
    private String mediaNo;
    private String mediaClassificationName;
    private String mediaName;
    private String mediaUrl;
    private BigDecimal advancedPrice;
    private BigDecimal ordinaryPrice;
    private BigDecimal ordinaryVipPrice;
    private BigDecimal retailPrice;
    private Integer entrance;
    private String entranceZN;
    private String mediaTypeNo;
    private String advertisingTypeNo;
    private String industryTypeNo;
    private String integratedPortalNo;
    private String priceCategoryNo;
    private String districtClassNo;
    private String newsFeedNo;
    private String contactInformationNo;
    private Date createTime;
    private String cTime;
    private String fuzzyQuery;
    private Integer pageNo;
    private Integer pageSize;
    private String sort;
    private String order;
    private String contactInformationName;
    private String newsFeedName;
    private String remark;
    private String costPrice;
    private String mediaManName;
    private String mediaManPhone;
    private Integer offset;
    private Integer limit;

}
