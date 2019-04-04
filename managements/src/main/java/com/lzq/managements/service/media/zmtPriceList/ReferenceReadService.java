package com.lzq.managements.service.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.ReferenceRead;

import java.util.List;

public interface ReferenceReadService {
    int deleteByPrimaryKey(Long serial);

    int insertReferenceRead(ReferenceRead record);

    ReferenceRead selectByPrimaryKey(Long serial);

    int updateReferenceRead(ReferenceRead record);

    List<ReferenceRead> getAllReferenceReads(Integer page, Integer rows);
}
