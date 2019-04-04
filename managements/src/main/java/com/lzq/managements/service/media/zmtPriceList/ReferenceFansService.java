package com.lzq.managements.service.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.ReferenceFans;

import java.util.List;

public interface ReferenceFansService {
    int deleteByPrimaryKey(Long serial);


    int insertReferenceFans(ReferenceFans record);

    ReferenceFans selectByPrimaryKey(Long serial);

    int updateReferenceFans(ReferenceFans record);

    List<ReferenceFans> getAllReferenceFans(Integer page, Integer rows);
}
