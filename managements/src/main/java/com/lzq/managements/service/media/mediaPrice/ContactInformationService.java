package com.lzq.managements.service.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.ContactInformation;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface ContactInformationService {

    /**
     * 查询
     * */
    List<ContactInformation> listContactInformation(Integer page, Integer rows);

    /**
     * 新增
     * */
    int insertContactInformation(ContactInformation contactInformation);

    /**
     * 删除
     * */
    int deleteContactInformation(String[] advertisingTypeNos);
}
