package com.lzq.managements.service;

import com.lzq.managements.entity.UserInfo;

import java.util.Date;
import java.util.List;

public interface UserInfoService {

    List<UserInfo> getAllUserInfo(String empNo,Integer offset, Integer limit);
    List<UserInfo> getAllDiscard(Integer offset, Integer limit);
    List<UserInfo> getAllUserInfoByloginTime(String empNo,String Time, Integer offset, Integer limit);
    int insertUserinfo(UserInfo userInfo);
    int updateUserinfo(UserInfo userInfo);
    int updateUser(UserInfo userInfo);
    int deleteUserinfo(String[] serial);
    UserInfo getOneByUserNo(String userNo);
    List<UserInfo> getOne(String userNo);
    List<UserInfo> checkUserinfo(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String qqAccount,String state,Integer offset,Integer limit);
    List<UserInfo> checkDiscard(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String qqAccount,String state,Integer offset,Integer limit);
    List<UserInfo> checkUserinfoByLoginTime(String empNo,String userNo,String Time,Integer status,String qqAccount,String state,Integer offset,Integer limit);
    List<UserInfo> getUpdateTime();
    int getLocking(String empNo);

    int getAllUserInfoCount(String empNo);

    int getAllDiscardCount();

    int getAllUserInfoByloginTimeCount(String empNo,String Time);
    int checkUserinfoCount(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String qqAccount,String state);

    int checkDiscardCount(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String qqAccount,String state);

    int checkUserinfoByLoginTimeCount(String empNo,String userNo,String Time,Integer status,String qqAccount,String state);

    int updateTimerToNow(String articleNo);

    String selectArticleNo();
}
