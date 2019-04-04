package com.lzq.managements.service.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.ZmtPriceList;

import java.util.List;

public interface ZmtPriceListService {
    int deleteByZmtNo(String[] zmtNo);

    int insertZmtPriceList(ZmtPriceList zmtPriceList);


    ZmtPriceList selectByZmtNo(String zmtNo);


    int updateZmtPriceList(ZmtPriceList zmtPriceList);

    List<ZmtPriceList> getAllZmtPriceList(ZmtPriceList zmtPriceList);
    List<ZmtPriceList> getZmtPriceListByNos(String[] zmtNo);

    int getCount();
    int deletePriceList(String[] zmtNos);
}
