package com.lzq.managements.entity.media.zmtPriceList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZmtIndustry implements Serializable {
    private static final long serialVersionUID = -1556842604968929823L;
    private Long serial;

    private String industryNo;

    private String industryName;

    private Date createTime;

    }




