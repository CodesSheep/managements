package com.lzq.managements.dao.media;

import com.lzq.managements.entity.media.WbMediaPriceList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WbMediaPriceListDao {
    int deleteByPrimaryKey(Long serial);

    int insertWbMediaPriceList(WbMediaPriceList record);

    WbMediaPriceList selectByPrimaryKey(Long serial);

    int updateWbMediaPriceList(WbMediaPriceList record);

    List<WbMediaPriceList> getAllWbMediaPriceList(WbMediaPriceList wbMediaPriceList);
    List<WbMediaPriceList> getWbMediaPriceListByNos(List<String> list);
    int getCount();
    int deletePriceList(List<String> list);
}