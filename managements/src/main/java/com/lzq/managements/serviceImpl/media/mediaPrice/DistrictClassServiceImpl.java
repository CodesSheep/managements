package com.lzq.managements.serviceImpl.media.mediaPrice;

import com.lzq.managements.dao.media.mediaPrice.DistrictClassDao;
import com.lzq.managements.entity.media.mediaPrice.DistrictClass;
import com.lzq.managements.service.media.mediaPrice.DistrictClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class DistrictClassServiceImpl implements DistrictClassService {

    @Autowired
    private DistrictClassDao districtClassDao;

    @Override
    public List<DistrictClass> listDistrictClass(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return districtClassDao.listDistrictClass(pageNo,pageSize);
    }

    @Override
    public int insertDistrictClass(DistrictClass districtClass) {
        districtClass.setDistrictClassNo(UUID.randomUUID().toString());
        return districtClassDao.insertDistrictClass(districtClass);
    }

    @Override
    public int deleteDistrictClass(String[] districtClassNos) {
        List<String> list = Arrays.asList(districtClassNos);
        return districtClassDao.deleteDistrictClass(list);
    }
}
