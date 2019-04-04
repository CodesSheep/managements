package com.lzq.managements.serviceImpl.media.mediaPrice;

import com.lzq.managements.dao.media.mediaPrice.PriceListDao;
import com.lzq.managements.entity.media.mediaPrice.PriceList;
import com.lzq.managements.service.media.mediaPrice.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class PriceListServiceImpl implements PriceListService {

    @Autowired
    private PriceListDao priceListDao;

    @Override
    public List<PriceList> listPriceList(PriceList priceList) {
        /*if (page != null && rows != null && page > 0){
            priceList.setPageNo((page - 1) * rows);
            priceList.setPageSize(rows);
        }else {
            priceList.setPageNo(null);
            priceList.setPageSize(null);
        }*/
        return priceListDao.listPriceList(priceList);
    }

    @Override
    public List<PriceList> listPriceListByNos(String[] mediaNos) {
        List<String> list = Arrays.asList(mediaNos);
        return priceListDao.listPriceListByNos(list);
    }

    @Override
    public int insertPriceList(PriceList priceList) {
        String mediaNo = UUID.randomUUID().toString();
        priceList.setMediaNo(mediaNo);
        return priceListDao.insertPriceList(priceList);
    }

    @Override
    public int updatePriceList(PriceList priceList) {
        return priceListDao.updatePriceList(priceList);
    }

    @Override
    public int deletePriceList(String [] mediaNos) {
        List<String> list = Arrays.asList(mediaNos);
        return priceListDao.deletePriceList(list);
    }

    @Override
    public int updateSellingPrice(PriceList priceList) {
        return priceListDao.updateSellingPrice(priceList);
    }

    @Override
    public int getCount(PriceList priceList) {
        return priceListDao.getCount(priceList);
    }


}
