package com.lzq.managements.serviceImpl.media;

import com.lzq.managements.dao.media.RedMediaPriceListDao;
import com.lzq.managements.entity.media.RedMediaPriceList;
import com.lzq.managements.service.media.RedMediaPriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RedMediaPriceListServiceImpl implements RedMediaPriceListService {
    @Autowired
    private RedMediaPriceListDao redMediaPriceListDao;

    @Override
    public int deleteByPrimaryKey(Long serial) {
        return redMediaPriceListDao.deleteByPrimaryKey(serial);
    }

    @Override
    public int insertRedMediaPriceList(RedMediaPriceList record) {
        return redMediaPriceListDao.insertRedMediaPriceList(record);
    }

    @Override
    public RedMediaPriceList selectByPrimaryKey(Long serial) {
        return redMediaPriceListDao.selectByPrimaryKey(serial);
    }

    @Override
    public int updateRedMediaPriceList(RedMediaPriceList record) {
        return redMediaPriceListDao.updateRedMediaPriceList(record);
    }

    @Override
    public List<RedMediaPriceList> getAllRedMediaPriceList(RedMediaPriceList redMediaPriceList, Integer page, Integer rows) {
        if(page !=null && rows !=null && page>0){
            redMediaPriceList.setPageNo((page-1)*rows);
            redMediaPriceList.setPageSize(rows);
        }
        else{
            redMediaPriceList.setPageNo(null);
            redMediaPriceList.setPageSize(null);
        }
        return redMediaPriceListDao.getAllRedMediaPriceList(redMediaPriceList);
    }

    @Override
    public List<RedMediaPriceList> getRedMediaPriceListByNos(String[] redMediaNos) {
        List<String> list= Arrays.asList(redMediaNos);
        return redMediaPriceListDao.getRedMediaPriceListByNos(list);
    }

    @Override
    public int deletePriceList(String[] redMediaNos) {
        List<String> list= Arrays.asList(redMediaNos);
        return redMediaPriceListDao.deletePriceList(list);
    }
}
