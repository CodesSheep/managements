package com.lzq.managements.entity.media.zmtPriceList;

import java.util.Date;

public class ZmtPriceClassification {
    private Long serial;

    private String priceNo;

    private String priceName;

    private Date createTime;

    public ZmtPriceClassification(Long serial, String priceNo, String priceName, Date createTime) {
        this.serial = serial;
        this.priceNo = priceNo;
        this.priceName = priceName;
        this.createTime = createTime;
    }

    public ZmtPriceClassification() {
        super();
    }

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public String getPriceNo() {
        return priceNo;
    }

    public void setPriceNo(String priceNo) {
        this.priceNo = priceNo == null ? null : priceNo.trim();
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName == null ? null : priceName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}