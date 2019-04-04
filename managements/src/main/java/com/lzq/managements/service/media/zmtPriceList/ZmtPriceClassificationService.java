package com.lzq.managements.service.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.ZmtPriceClassification;

import java.util.List;

public interface ZmtPriceClassificationService {
    int deleteByPrimaryKey(Long serial);

    int insertZmtPriceClassification(ZmtPriceClassification record);

    List<ZmtPriceClassification> getAllZmtPriceClassification(Integer pageNo, Integer pageSize);

    ZmtPriceClassification selectByPrimaryKey(Long serial);

    int updateByZmtPriceClassification(ZmtPriceClassification record);
}
