package com.lzq.managements.service.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.IndustryType;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface IndustryTypeService {

    /**
     * 查询
     * */
    List<IndustryType> listIndustryType(Integer page, Integer rows);

    /**
     * 新增
     * */
    int insertIndustryType(IndustryType industryType);

    /**
     * 删除
     * */
    int deleteIndustryType(String[] industryTypeNos);
}
