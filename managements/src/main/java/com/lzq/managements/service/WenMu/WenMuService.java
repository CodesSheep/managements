package com.lzq.managements.service.WenMu;

import com.lzq.managements.entity.WenMu.WenMu;

import java.util.List;

public interface WenMuService {
    public List<WenMu> getAllWenMu(String userNo,String qqAccount,String FirstCreateTime,String LastCreateTime,Integer status,Integer page,Integer rows);
}
