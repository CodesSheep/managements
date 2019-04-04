package com.lzq.managements.service.media;

import com.lzq.managements.entity.media.WxMediaPriceList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WxMediaPriceListService {
    int deleteByPrimaryKey(Long serial);

    int insertWxMediaPriceList(MultipartFile file, WxMediaPriceList wxMediaPriceList);

    List<WxMediaPriceList> getAllWxMediaPriceList(WxMediaPriceList wxMediaPriceList, Integer page, Integer rows);

    WxMediaPriceList selectByPrimaryKey(Long serial);


    int updateWxMediaPriceList(WxMediaPriceList record);

    List<WxMediaPriceList> getWxMediaPriceListByNos(String[] wxMediaNo);

    int getCount();

    int deletePriceList(String[] wxMediaNos);
}
