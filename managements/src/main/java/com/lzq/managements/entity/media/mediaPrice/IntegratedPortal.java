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
public class IntegratedPortal implements Serializable{
    private static final long serialVersionUID = 3473510102706544567L;

    private Long serial;
    private String integratedPortalNo;
    private String integratedPortalName;
    private Date createTime;

    private String cTime;
}
