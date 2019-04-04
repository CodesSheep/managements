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
public class IndustryType implements Serializable{
    private static final long serialVersionUID = 2237334609071595495L;

    private Long serial;
    private String industryTypeNo;
    private String industryTypeName;
    private Date createTime;

    private String cTime;
}
