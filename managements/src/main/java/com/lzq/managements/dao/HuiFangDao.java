package com.lzq.managements.dao;

import com.lzq.managements.entity.HuiFang;
import com.lzq.managements.entity.PhoneInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HuiFangDao {
    int insertHuiFang(HuiFang record);

    int  getCount(@Param("empNo") String empNo,
                  @Param("FirstCreateTime")  String FirstCreateTime,
                  @Param("LastCreateTime") String LastCreateTime
    );

    List<HuiFang> getAllHuiFang(@Param("empNo") String empNo,
                                @Param("FirstCreateTime")  String FirstCreateTime,
                                @Param("LastCreateTime") String LastCreateTime,
                                @Param("offset") Integer offset,
                                @Param("limit") Integer limit);

    int updateHuiFang(HuiFang record);
}