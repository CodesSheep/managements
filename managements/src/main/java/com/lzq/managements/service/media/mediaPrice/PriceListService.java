package com.lzq.managements.service.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.PriceList;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface PriceListService {

    /**
     * 查询
     * */
    List<PriceList> listPriceList(PriceList priceList);

    List<PriceList> listPriceListByNos(String[] mediaNos);

    /**
     * 新增
     * */
    int insertPriceList(PriceList priceList);

    /**
     * 修改
     * */
    int updatePriceList(PriceList priceList);

    /**
     * 删除
     * */
    int deletePriceList(String[] mediaNos);
    /**
     * 修改会员价格
     * */
    int updateSellingPrice(PriceList priceList);

    int getCount(PriceList priceList);
}
