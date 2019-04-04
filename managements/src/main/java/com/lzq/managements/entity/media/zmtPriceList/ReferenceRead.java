package com.lzq.managements.entity.media.zmtPriceList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceRead implements Serializable {
    private static final long serialVersionUID = -7207796169841019262L;
    private Long serial;

    private String referencereadNo;

    private String referencereadtype;

    private Date createTime;


}