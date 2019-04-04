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
public class ContactInformation implements Serializable{
    private static final long serialVersionUID = -5358163446031324324L;

    private Long serial;
    private String contactInformationNo;
    private String contactInformationName;
    private Date createTime;

    private String cTime;
}
