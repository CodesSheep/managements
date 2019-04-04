package com.lzq.managements.dao.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.PlatForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatFormDao {
    int deleteByPrimaryKey(Long serial);

    int insertPlatForm(PlatForm record);

    PlatForm selectByPrimaryKey(Long serial);

    int updatePlatForm(PlatForm record);

    List<PlatForm> getAllPlatForms(@Param("pageNo") Integer pageNo,
                                   @Param("pageSize") Integer pageSize);
}