package com.lzq.managements.serviceImpl.media;

import com.lzq.managements.dao.media.WbMediaPriceListDao;
import com.lzq.managements.entity.media.WbMediaPriceList;
import com.lzq.managements.service.media.WbMediaPriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WbMediaPriceListServiceImpl implements WbMediaPriceListService {
    @Autowired
    private WbMediaPriceListDao wbMediaPriceListDao;

    @Override
    public int deleteByPrimaryKey(Long serial) {
        return wbMediaPriceListDao.deleteByPrimaryKey(serial);
    }

    @Override
    public int insertWbMediaPriceList(WbMediaPriceList record) {
        return wbMediaPriceListDao.insertWbMediaPriceList(record);
    }

    @Override
    public WbMediaPriceList selectByPrimaryKey(Long serial) {
        return wbMediaPriceListDao.selectByPrimaryKey(serial);
    }

    @Override
    public int updateWbMediaPriceList(WbMediaPriceList record) {
        return wbMediaPriceListDao.updateWbMediaPriceList(record);
    }

    @Override
    public List<WbMediaPriceList> getAllWbMediaPriceList(WbMediaPriceList wbMediaPriceList, Integer page, Integer rows) {
        if(page !=null && rows !=null && page>0){
            wbMediaPriceList.setPageNo((page-1)*rows);
            wbMediaPriceList.setPageSize(rows);
        }else{
            wbMediaPriceList.setPageNo(null);
            wbMediaPriceList.setPageSize(null);
        }
        return wbMediaPriceListDao.getAllWbMediaPriceList(wbMediaPriceList);
    }

    @Override
    public List<WbMediaPriceList> getWbMediaPriceListByNos(String[] wbMediaNos) {
        List<String> list= Arrays.asList(wbMediaNos);
        return wbMediaPriceListDao.getWbMediaPriceListByNos(list);
    }

    @Override
    public int getCount() {
        return wbMediaPriceListDao.getCount();
    }

    @Override
    public int deletePriceList(String[] wbMediaNos) {
        List<String> list= Arrays.asList(wbMediaNos);
        return wbMediaPriceListDao.deletePriceList(list);
    }
}
