package com.lzq.managements.entity.newsorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsOrder implements Serializable {
    private static final long serialVersionUID = 1159482310831513573L;
    private Long serial;
    private String userNo;
    private String mediaNo;
    private String mediaName;
    private Integer vipLevel;
    private String vipLevelZN;
    private Date createTime;
    private BigDecimal grossPrice;
    private String state;
    private String fileState;
    private String empNo;
    private String empName;
    private String contacts;
}
