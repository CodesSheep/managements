package com.lzq.managements.service.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.IntegratedPortal;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface IntegratedPortalService {

    /**
     * 查询
     * */
    List<IntegratedPortal> listIntegratedPortal(Integer page, Integer rows);

    /**
     * 新增
     * */
    int insertIntegratedPortal(IntegratedPortal integratedPortal);

    /**
     * 删除
     * */
    int deleteIntegratedPortal(String[] integratedPortalNos);
}
