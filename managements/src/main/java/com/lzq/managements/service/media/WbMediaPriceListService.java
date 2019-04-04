package com.lzq.managements.service.media;

import com.lzq.managements.entity.media.WbMediaPriceList;

import java.util.List;

public interface WbMediaPriceListService {

    int deleteByPrimaryKey(Long serial);

    int insertWbMediaPriceList(WbMediaPriceList record);

    WbMediaPriceList selectByPrimaryKey(Long serial);

    int updateWbMediaPriceList(WbMediaPriceList record);


    List<WbMediaPriceList> getAllWbMediaPriceList(WbMediaPriceList wbMediaPriceList, Integer page, Integer rows);

    List<WbMediaPriceList> getWbMediaPriceListByNos(String[] wbMediaNo);

    int getCount();

    int deletePriceList(String[] wbMediaNos);
}
