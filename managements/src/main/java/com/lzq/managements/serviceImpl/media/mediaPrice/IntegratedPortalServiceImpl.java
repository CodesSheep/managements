package com.lzq.managements.serviceImpl.media.mediaPrice;

import com.lzq.managements.dao.media.mediaPrice.IntegratedPortalDao;
import com.lzq.managements.entity.media.mediaPrice.IntegratedPortal;
import com.lzq.managements.service.media.mediaPrice.IntegratedPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class IntegratedPortalServiceImpl implements IntegratedPortalService {

    @Autowired
    private IntegratedPortalDao integratedPortalDao;

    @Override
    public List<IntegratedPortal> listIntegratedPortal(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return integratedPortalDao.listIntegratedPortal(pageNo,pageSize);
    }

    @Override
    public int insertIntegratedPortal(IntegratedPortal integratedPortal) {
        integratedPortal.setIntegratedPortalNo(UUID.randomUUID().toString());
        return integratedPortalDao.insertIntegratedPortal(integratedPortal);
    }

    @Override
    public int deleteIntegratedPortal(String[] integratedPortalNos) {
        List<String> list = Arrays.asList(integratedPortalNos);
        return integratedPortalDao.deleteIntegratedPortal(list);
    }
}
