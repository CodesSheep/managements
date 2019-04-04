package com.lzq.managements.entity.media.zmtPriceList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatForm implements Serializable {
    private Long serial;

    private String platformNo;

    private String platformName;

    private Date createTime;

    }

