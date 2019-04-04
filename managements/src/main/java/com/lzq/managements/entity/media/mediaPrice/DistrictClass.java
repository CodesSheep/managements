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
public class DistrictClass implements Serializable{
    private static final long serialVersionUID = 7828919948726384971L;

    private Long serial;
    private String districtClassNo;
    private String districtClassName;
    private Date createTime;

    private String cTime;
}
