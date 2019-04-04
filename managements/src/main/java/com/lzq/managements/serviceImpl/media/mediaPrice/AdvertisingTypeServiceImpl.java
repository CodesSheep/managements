package com.lzq.managements.serviceImpl.media.mediaPrice;


import com.lzq.managements.dao.media.mediaPrice.AdvertisingTypeDao;
import com.lzq.managements.entity.media.mediaPrice.AdvertisingType;
import com.lzq.managements.service.media.mediaPrice.AdvertisingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class AdvertisingTypeServiceImpl implements AdvertisingTypeService {

    @Autowired
    private AdvertisingTypeDao advertisingTypeDao;

    @Override
    public List<AdvertisingType> listAdvertisingType(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return advertisingTypeDao.listAdvertisingType(pageNo,pageSize);
    }

    @Override
    public int insertAdvertisingType(AdvertisingType advertisingType) {
        advertisingType.setAdvertisingTypeNo(UUID.randomUUID().toString());
        return advertisingTypeDao.insertAdvertisingType(advertisingType);
    }

    @Override
    public int deleteAdvertisingType(String[] advertisingTypeNos) {
        List<String> list = Arrays.asList(advertisingTypeNos);
        return advertisingTypeDao.deleteAdvertisingType(list);
    }
}
