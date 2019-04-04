package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.IntegratedPortal;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface IntegratedPortalDao {

    /**
     * 查询
     * */
    List<IntegratedPortal> listIntegratedPortal(@Param("pageNo") Integer pageNo,
                                                @Param("pageSize") Integer pageSize);

    /**
     * 新增
     * */
    int insertIntegratedPortal(IntegratedPortal integratedPortal);

    /**
     * 删除
     * */
    int deleteIntegratedPortal(List<String> list);
}
