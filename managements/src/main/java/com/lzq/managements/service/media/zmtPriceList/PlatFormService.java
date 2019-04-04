package com.lzq.managements.service.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.PlatForm;

import java.util.List;

public interface PlatFormService {
    int deleteByPrimaryKey(Long serial);

    int insertPlatForm(PlatForm record);

    PlatForm selectByPrimaryKey(Long serial);

    int updatePlatForm(PlatForm record);

    List<PlatForm> getAllPlatForms(Integer page, Integer rows);
}
