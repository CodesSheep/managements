package com.lzq.managements.service;

import com.lzq.managements.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> getAllUserInfo(String empNo,Integer offset, Integer limit);
    List<UserInfo> getAllDiscard(Integer offset, Integer limit);
    List<UserInfo> getAllUserInfoByloginTime(String empNo, Integer offset, Integer limit);
    int insertUserinfo(UserInfo userInfo);
    int updateUserinfo(UserInfo userInfo);
    int updateUser(UserInfo userInfo);
    int deleteUserinfo(String[] serial);
    UserInfo getOneByUserNo(String userNo);
    List<UserInfo> getOne(String userNo);
    List<UserInfo> checkUserinfo(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String state,Integer offset,Integer limit);
    List<UserInfo> checkDiscard(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String state,Integer offset,Integer limit);
    List<UserInfo> checkUserinfoByLoginTime(String empNo,String userNo,Integer status,String state,Integer offset,Integer limit);


}
