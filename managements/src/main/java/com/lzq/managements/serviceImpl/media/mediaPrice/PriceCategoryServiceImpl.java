package com.lzq.managements.serviceImpl.media.mediaPrice;


import com.lzq.managements.dao.media.mediaPrice.PriceCategoryDao;
import com.lzq.managements.entity.media.mediaPrice.PriceCategory;
import com.lzq.managements.service.media.mediaPrice.PriceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class PriceCategoryServiceImpl implements PriceCategoryService {

    @Autowired
    private PriceCategoryDao priceCategoryDao;

    @Override
    public List<PriceCategory> listPriceCategory(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return priceCategoryDao.listPriceCategory(pageNo,pageSize);
    }

    @Override
    public int insertPriceCategory(PriceCategory priceCategory) {
        priceCategory.setPriceCategoryNo(UUID.randomUUID().toString());
        return priceCategoryDao.insertPriceCategory(priceCategory);
    }

    @Override
    public int deletePriceCategory(String[] priceCategoryNos) {
        List<String> list = Arrays.asList(priceCategoryNos);
        return priceCategoryDao.deletePriceCategory(list);
    }
}
