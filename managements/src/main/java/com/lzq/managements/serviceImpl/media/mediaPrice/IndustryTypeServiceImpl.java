package com.lzq.managements.serviceImpl.media.mediaPrice;


import com.lzq.managements.dao.media.mediaPrice.IndustryTypeDao;
import com.lzq.managements.entity.media.mediaPrice.IndustryType;
import com.lzq.managements.service.media.mediaPrice.IndustryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class IndustryTypeServiceImpl implements IndustryTypeService {

    @Autowired
    private IndustryTypeDao industryTypeDao;

    @Override
    public List<IndustryType> listIndustryType(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return industryTypeDao.listIndustryType(pageNo,pageSize);
    }

    @Override
    public int insertIndustryType(IndustryType industryType) {
        industryType.setIndustryTypeNo(UUID.randomUUID().toString());
        return industryTypeDao.insertIndustryType(industryType);
    }

    @Override
    public int deleteIndustryType(String[] industryTypeNos) {
        List<String> list = Arrays.asList(industryTypeNos);
        return industryTypeDao.deleteIndustryType(list);
    }
}
