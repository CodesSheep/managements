package com.lzq.managements.serviceImpl.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.ZmtPriceList;
import com.lzq.managements.dao.media.zmtPriceList.ZmtPriceListDao;
import com.lzq.managements.service.media.zmtPriceList.ZmtPriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ZmtPriceListServiceImpl implements ZmtPriceListService {
    @Autowired
    private ZmtPriceListDao zmtPriceListDao;

    @Override
    public int deleteByZmtNo(String[] zmtNo) {
        List<String> list= Arrays.asList(zmtNo);
        return zmtPriceListDao.deleteByZmtNo(list);
    }

    @Override
    public int insertZmtPriceList(ZmtPriceList record) {
        String zmtNo=UUID.randomUUID().toString();
        record.setZmtNo(zmtNo);
        return zmtPriceListDao.insertZmtPriceList(record);
    }

    @Override
    public ZmtPriceList selectByZmtNo(String zmtNo) {
        return zmtPriceListDao.selectByZmtNo(zmtNo);
    }

    @Override
    public int updateZmtPriceList(ZmtPriceList record) {
        return zmtPriceListDao.updateZmtPriceList(record);
    }

    @Override
    public List<ZmtPriceList> getAllZmtPriceList(ZmtPriceList zmtPriceList) {

       /* if(page !=null && rows !=null && page>0){
            zmtPriceList.setPageNo((page-1)*rows);
            zmtPriceList.setPageSize(rows);
        }
        else{
            zmtPriceList.setPageNo(null);
            zmtPriceList.setPageSize(null);
        }*/
        return zmtPriceListDao.getAllZmtPriceList(zmtPriceList);
    }

    @Override
    public List<ZmtPriceList> getZmtPriceListByNos(String[] zmtNo) {
        List<String> list=Arrays.asList(zmtNo);
        return zmtPriceListDao.getZmtPriceListByNos(list);
    }

    @Override
    public int getCount() {
        return zmtPriceListDao.getCount();
    }

    @Override
    public int deletePriceList(String[] zmtNos) {
        List<String> list= Arrays.asList(zmtNos);
        return zmtPriceListDao.deletePriceList(list);
    }
}
