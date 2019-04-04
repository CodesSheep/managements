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
public class AdvertisingType implements Serializable{
    private static final long serialVersionUID = 5610964480098793630L;

    private Long serial;
    private String advertisingTypeNo;
    private String advertisingTypeName;
    private Date createTime;

    private String cTime;
}
