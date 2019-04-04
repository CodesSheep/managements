package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.PriceList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface PriceListDao {

    /**
     * 查询
     * */
    List<PriceList> listPriceList(PriceList priceList);

    List<PriceList> listPriceListByNos(List<String> list);

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
    int deletePriceList(List<String> list);
    /**
     * 修改会员价格
     * */
    int updateSellingPrice(PriceList priceList);

    int getCount(PriceList priceList);
}
