package com.lzq.managements.dao.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZmtIndustryDao {
    int deleteByPrimaryKey(Long serial);

    List<ZmtIndustry> getAllZmtIndustry(@Param("pageNo") Integer pageNo,
                                        @Param("pageSize") Integer pageSize);

    int insertZmtIndustry(ZmtIndustry record);

    ZmtIndustry selectByPrimaryKey(Long serial);

    int updateZmtIndustry(ZmtIndustry record);


}