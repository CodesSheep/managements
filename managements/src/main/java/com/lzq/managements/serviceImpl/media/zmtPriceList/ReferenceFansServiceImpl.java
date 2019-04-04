package com.lzq.managements.serviceImpl.media.zmtPriceList;

import com.lzq.managements.dao.media.zmtPriceList.ReferenceFansDao;
import com.lzq.managements.entity.media.zmtPriceList.ReferenceFans;
import com.lzq.managements.service.media.zmtPriceList.ReferenceFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceFansServiceImpl implements ReferenceFansService {

    @Autowired
    private ReferenceFansDao referenceFansDao;

    @Override
    public int deleteByPrimaryKey(Long serial) {
        return referenceFansDao.deleteByPrimaryKey(serial);
    }

    @Override
    public int insertReferenceFans(ReferenceFans record) {
        return referenceFansDao.insertReferenceFans(record);
    }

    @Override
    public ReferenceFans selectByPrimaryKey(Long serial) {
        return referenceFansDao.selectByPrimaryKey(serial);
    }

    @Override
    public int updateReferenceFans(ReferenceFans record) {
        return referenceFansDao.updateReferenceFans(record);
    }

    @Override
    public List<ReferenceFans> getAllReferenceFans(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0) {
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return referenceFansDao.getAllReferenceFans(pageNo,pageSize);
    }
}
