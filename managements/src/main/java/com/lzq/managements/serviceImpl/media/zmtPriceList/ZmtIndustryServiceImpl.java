package com.lzq.managements.serviceImpl.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.*;
import com.lzq.managements.dao.media.zmtPriceList.*;
import com.lzq.managements.service.media.zmtPriceList.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZmtIndustryServiceImpl implements ZmtIndustryService {
    @Autowired
    private ZmtIndustryDao zmtIndustryDao;

    @Override
    public int deleteByPrimaryKey(Long serial) {
        return zmtIndustryDao.deleteByPrimaryKey(serial);
    }

    @Override
    public List<ZmtIndustry> getAllZmtIndustry(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0) {
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return zmtIndustryDao.getAllZmtIndustry(pageNo,pageSize);
    }

    @Override
    public int insertZmtIndustry(ZmtIndustry record) {
        return zmtIndustryDao.insertZmtIndustry(record);
    }

    @Override
    public ZmtIndustry selectByPrimaryKey(Long serial) {
        return zmtIndustryDao.selectByPrimaryKey(serial);
    }

    @Override
    public int updateZmtIndustry(ZmtIndustry record) {
        return zmtIndustryDao.updateZmtIndustry(record);
    }
}
