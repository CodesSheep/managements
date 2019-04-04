package com.lzq.managements.serviceImpl.WenMu;

import com.lzq.managements.dao.wenmu.WenMuDao;
import com.lzq.managements.entity.WenMu.WenMu;
import com.lzq.managements.service.WenMu.WenMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WenMuServiceImpl implements WenMuService {
    @Autowired
    private WenMuDao wenMuDao;

    @Override
    public List<WenMu> getAllWenMu(String userNo,String qqAccount,String FirstCreateTime,String LastCreateTime,Integer status,Integer page,Integer rows) {
        Integer pageNo=null;
        Integer pageSize=null;
        if(page !=null && rows !=null && page>0){
            pageNo=(page-1)*rows;
            pageSize=rows;
        }
        return wenMuDao.getAllWenMu(userNo,qqAccount,FirstCreateTime,LastCreateTime,status,pageNo,pageSize);
    }
}
