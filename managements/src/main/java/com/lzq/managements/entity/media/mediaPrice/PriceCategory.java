package com.lzq.managements.entity.media.mediaPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceCategory implements Serializable{
    private static final long serialVersionUID = 4469807906666988469L;

    private Long serial;
    private String priceCategoryNo;
    private String priceCategoryName;
    private Date createTime;

    private String cTime;
}
