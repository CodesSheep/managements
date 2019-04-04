package com.lzq.managements.dao.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceFansDao {
    int deleteByPrimaryKey(Long serial);


    int insertReferenceFans(ReferenceFans record);

    ReferenceFans selectByPrimaryKey(Long serial);

    int updateReferenceFans(ReferenceFans record);

    List<ReferenceFans> getAllReferenceFans(@Param("pageNo") Integer pageNo,
                                            @Param("pageSize") Integer pageSize);
}