package com.lzq.managements.entity.media.zmtPriceList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceFans implements Serializable {
    private static final long serialVersionUID = 1962395591122607194L;
    private Long serial;

    private String referencefansNo;

    private String referencefanstype;

    private Date createTime;


}