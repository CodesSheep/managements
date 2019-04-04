package com.lzq.managements.service;

import com.lzq.managements.entity.HuiFang;

import java.util.List;

public interface HuiFangService {

    List<HuiFang> getAllHuiFang(String empNo,String FirstCreateTime,String LastCreateTime,Integer offset, Integer limit);

    int  getCount(String empNo,String FirstCreateTime,String LastCreateTime);

    int insertHuiFang(HuiFang huiFang);

    int updateHuiFang(HuiFang huiFang);

}
