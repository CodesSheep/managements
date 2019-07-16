package com.lzq.managements.dao;

import com.lzq.managements.entity.PhoneInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PhoneInfoDao {


    int insertPhoneInfo(PhoneInfo record);

    int updatePhoneInfo(PhoneInfo record);

    int updatePhone(PhoneInfo phone);

   List<PhoneInfo> checkPhoneInfo(@Param("phoneNo") String phoneNo,
                                  @Param("empNo") String empNo,
                                  @Param("qqAccount") String qqAccount,
                                  @Param("FirstTime") String FirstTime,
                                  @Param("LastTime") String LastTime,
                                  @Param("hZstate") String HZstate,
                                  @Param("yXstate") String YXstate,
                                  @Param("state") String state,
                                  @Param("offset")Integer offset,
                                  @Param("limit")Integer limit);
    int getCount(@Param("phoneNo") String phoneNo,
                 @Param("empNo") String empNo,
                 @Param("qqAccount") String qqAccount,
                 @Param("FirstTime") String FirstTime,
                 @Param("LastTime") String LastTime,
                 @Param("hZstate") String HZstate,
                 @Param("yXstate") String YXstate,
                 @Param("state") String state);
    List<PhoneInfo> getPhoneInfo(@Param("phoneNo")String phoneNo);

}