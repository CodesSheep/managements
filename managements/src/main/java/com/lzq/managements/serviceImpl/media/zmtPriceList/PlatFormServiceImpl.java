package com.lzq.managements.serviceImpl.media.zmtPriceList;

import com.lzq.managements.dao.media.zmtPriceList.PlatFormDao;
import com.lzq.managements.entity.media.zmtPriceList.PlatForm;
import com.lzq.managements.service.media.zmtPriceList.PlatFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatFormServiceImpl implements PlatFormService {
    @Autowired
    private PlatFormDao platFormDao;

    @Override
    public int deleteByPrimaryKey(Long serial) {
        return platFormDao.deleteByPrimaryKey(serial);
    }

    @Override
    public int insertPlatForm(PlatForm record) {
        return platFormDao.insertPlatForm(record);
    }

    @Override
    public PlatForm selectByPrimaryKey(Long serial) {
        return platFormDao.selectByPrimaryKey(serial);
    }

    @Override
    public int updatePlatForm(PlatForm record) {
        return platFormDao.updatePlatForm(record);
    }

    @Override
    public List<PlatForm> getAllPlatForms(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0) {
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return platFormDao.getAllPlatForms(pageNo,pageSize);
    }
}
