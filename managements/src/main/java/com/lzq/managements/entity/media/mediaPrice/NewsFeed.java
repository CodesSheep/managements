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
public class NewsFeed implements Serializable{
    private static final long serialVersionUID = -2240425677967394503L;

    private Long serial;
    private String newsFeedNo;
    private String newsFeedName;
    private Date createTime;

    private String cTime;
}
