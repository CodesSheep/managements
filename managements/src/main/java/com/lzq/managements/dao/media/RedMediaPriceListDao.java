package com.lzq.managements.dao.media;

import com.lzq.managements.entity.media.RedMediaPriceList;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedMediaPriceListDao {
    int deleteByPrimaryKey(Long serial);

    int insertRedMediaPriceList(RedMediaPriceList record);

    RedMediaPriceList selectByPrimaryKey(Long serial);

    int updateRedMediaPriceList(RedMediaPriceList record);

    List<RedMediaPriceList> getAllRedMediaPriceList(RedMediaPriceList redMediaPriceList);

    List<RedMediaPriceList> getRedMediaPriceListByNos(List<String> list);
    int deletePriceList(List<String> list);
}