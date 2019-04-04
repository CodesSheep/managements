package com.lzq.managements.dao.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceReadDao {
    int deleteByPrimaryKey(Long serial);



    int insertReferenceRead(ReferenceRead record);

    ReferenceRead selectByPrimaryKey(Long serial);

    int updateReferenceRead(ReferenceRead record);

    List<ReferenceRead> getAllReferenceReads(@Param("pageNo") Integer pageNo,
                                             @Param("pageSize") Integer pageSize);

}