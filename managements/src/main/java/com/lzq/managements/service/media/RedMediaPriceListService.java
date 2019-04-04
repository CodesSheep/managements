package com.lzq.managements.service.media;

import com.lzq.managements.entity.media.RedMediaPriceList;

import java.util.List;

public interface RedMediaPriceListService {

    int deleteByPrimaryKey(Long serial);

    int insertRedMediaPriceList(RedMediaPriceList record);

    RedMediaPriceList selectByPrimaryKey(Long serial);

    int updateRedMediaPriceList(RedMediaPriceList record);


    List<RedMediaPriceList> getAllRedMediaPriceList(RedMediaPriceList redMediaPriceList, Integer page, Integer rows);

    List<RedMediaPriceList> getRedMediaPriceListByNos(String[] redMediaNos);

    int deletePriceList(String[] redMediaNos);
}
