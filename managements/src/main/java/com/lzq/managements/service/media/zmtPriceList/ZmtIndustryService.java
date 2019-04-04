package com.lzq.managements.service.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.*;

import java.util.List;

public interface ZmtIndustryService {
    int deleteByPrimaryKey(Long serial);

    List<ZmtIndustry> getAllZmtIndustry(Integer page, Integer rows);

    int insertZmtIndustry(ZmtIndustry record);

    ZmtIndustry selectByPrimaryKey(Long serial);

    int updateZmtIndustry(ZmtIndustry record);
}
