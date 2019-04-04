package com.lzq.managements.dao.media;

import com.lzq.managements.entity.media.WxMediaPriceList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxMediaPriceListDao {
    int deleteByPrimaryKey(Long serial);

    int insertWxMediaPriceList(WxMediaPriceList record);

    List<WxMediaPriceList> getAllWxMediaPriceList(WxMediaPriceList wxMediaPriceList);

    WxMediaPriceList selectByPrimaryKey(Long serial);

    int updateWxMediaPriceList(WxMediaPriceList record);

    List<WxMediaPriceList> getWxMediaPriceListByNos(List<String> list);
    int getCount();
    int deletePriceList(List<String> list);
}