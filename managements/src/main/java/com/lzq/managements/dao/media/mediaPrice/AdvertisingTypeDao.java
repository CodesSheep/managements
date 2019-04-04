package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.AdvertisingType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface AdvertisingTypeDao {

    /**
     * 查询
     * */
    List<AdvertisingType> listAdvertisingType(@Param("pageNo") Integer pageNo,
                                              @Param("pageSize") Integer pageSize);

    /**
     * 新增
     * */
    int insertAdvertisingType(AdvertisingType advertisingType);

    /**
     * 删除
     * */
    int deleteAdvertisingType(List<String> list);
}
