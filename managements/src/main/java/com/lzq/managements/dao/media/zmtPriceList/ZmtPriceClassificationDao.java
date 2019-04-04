package com.lzq.managements.dao.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZmtPriceClassificationDao {
    int deleteByPrimaryKey(Long serial);

    int insertZmtPriceClassification(ZmtPriceClassification record);

    List<ZmtPriceClassification> getAllZmtPriceClassification(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    ZmtPriceClassification selectByPrimaryKey(Long serial);

    int updateByZmtPriceClassification(ZmtPriceClassification record);
}