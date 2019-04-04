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
public class MediaType implements Serializable{
    private static final long serialVersionUID = 6090010163901949641L;

    private Long serial;
    private String mediaTypeNo;
    private String mediaTypeName;
    private Date createTime;

    private String cTime;
}
