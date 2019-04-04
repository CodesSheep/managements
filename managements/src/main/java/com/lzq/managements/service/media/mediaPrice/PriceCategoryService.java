package com.lzq.managements.service.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.PriceCategory;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface PriceCategoryService {

    /**
     * 查询
     * */
    List<PriceCategory> listPriceCategory(Integer page, Integer rows);

    /**
     * 新增
     * */
    int insertPriceCategory(PriceCategory priceCategory);

    /**
     * 删除
     * */
    int deletePriceCategory(String[] priceCategoryNos);
}
