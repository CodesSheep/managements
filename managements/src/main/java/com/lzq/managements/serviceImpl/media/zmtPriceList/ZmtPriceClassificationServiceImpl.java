package com.lzq.managements.serviceImpl.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.*;
import com.lzq.managements.dao.media.zmtPriceList.*;
import com.lzq.managements.service.media.zmtPriceList.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZmtPriceClassificationServiceImpl implements ZmtPriceClassificationService {
    @Autowired
    private ZmtPriceClassificationDao zmtPriceClassificationDao;

    @Override
    public int deleteByPrimaryKey(Long serial) {
        return zmtPriceClassificationDao.deleteByPrimaryKey(serial);
    }

    @Override
    public int insertZmtPriceClassification(ZmtPriceClassification record) {
        return zmtPriceClassificationDao.insertZmtPriceClassification(record);
    }

    @Override
    public List<ZmtPriceClassification> getAllZmtPriceClassification(Integer pageNo, Integer pageSize) {
        return zmtPriceClassificationDao.getAllZmtPriceClassification(pageNo,pageSize);
    }

    @Override
    public ZmtPriceClassification selectByPrimaryKey(Long serial) {
        return zmtPriceClassificationDao.selectByPrimaryKey(serial);
    }

    @Override
    public int updateByZmtPriceClassification(ZmtPriceClassification record) {
        return zmtPriceClassificationDao.updateByZmtPriceClassification(record);
    }
}
