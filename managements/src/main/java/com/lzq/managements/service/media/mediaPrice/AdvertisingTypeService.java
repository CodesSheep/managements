package com.lzq.managements.service.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.AdvertisingType;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface AdvertisingTypeService {

    /**
     * 查询
     * */
    List<AdvertisingType> listAdvertisingType(Integer page, Integer rows);

    /**
     * 新增
     * */
    int insertAdvertisingType(AdvertisingType advertisingType);

    /**
     * 删除
     * */
    int deleteAdvertisingType(String[] advertisingTypeNos);
}
