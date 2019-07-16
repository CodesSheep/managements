package com.lzq.managements.service;

import com.lzq.managements.entity.PhoneInfo;

import java.util.List;

public interface PhoneInfoService {

    int insertPhoneInfo(PhoneInfo record);

    int updatePhoneInfo(PhoneInfo record);

    int updatePhone(PhoneInfo phone);

    List<PhoneInfo> checkPhoneInfo( String phoneNo, String empNo,String qqAccount, String FirstTime, String LastTime,String HZstate, String YXstate,String state, Integer offset, Integer limit);
    int getCount( String phoneNo, String empNo,String qqAccount, String FirstTime, String LastTime,String HZstate, String YXstate,String state);
    List<PhoneInfo> getPhoneInfo(String phoneNo);
}
