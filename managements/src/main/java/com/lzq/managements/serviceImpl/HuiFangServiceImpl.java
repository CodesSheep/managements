package com.lzq.managements.serviceImpl;

import com.lzq.managements.dao.HuiFangDao;
import com.lzq.managements.entity.HuiFang;
import com.lzq.managements.service.HuiFangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HuiFangServiceImpl implements HuiFangService {
    @Autowired
    private HuiFangDao huiFangDao;

    @Override
    public List<HuiFang> getAllHuiFang(String empNo,String FirstCreateTime,String LastCreateTime, Integer offset, Integer limit) {
        return huiFangDao.getAllHuiFang(empNo,FirstCreateTime,LastCreateTime,offset,limit);
    }

    @Override
    public int getCount(String empNo,String FirstCreateTime,String LastCreateTime) {
        return huiFangDao.getCount(empNo,FirstCreateTime,LastCreateTime);
    }

    @Override
    public int insertHuiFang(HuiFang huiFang) {
        return huiFangDao.insertHuiFang(huiFang);
    }

    @Override
    public int updateHuiFang(HuiFang huiFang) {
        return huiFangDao.updateHuiFang(huiFang);
    }
}
