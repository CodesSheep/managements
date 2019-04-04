package com.lzq.managements.service.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.DistrictClass;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface DistrictClassService {

    /**
     * 查询
     * */
    List<DistrictClass> listDistrictClass(Integer page, Integer rows);

    /**
     * 新增
     * */
    int insertDistrictClass(DistrictClass districtClass);

    /**
     * 删除
     * */
    int deleteDistrictClass(String[] districtClassNos);
}
