package com.lzq.managements.dao.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.ZmtPriceList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZmtPriceListDao {
    int deleteByZmtNo(List<String> list);

    int insertZmtPriceList(ZmtPriceList record);


    ZmtPriceList selectByZmtNo(String zmtNo);


    int updateZmtPriceList(ZmtPriceList record);

    List<ZmtPriceList> getAllZmtPriceList(ZmtPriceList zmtPriceList);
    List<ZmtPriceList> getZmtPriceListByNos(List<String> list);

    int getCount();

    int deletePriceList(List<String> list);
}