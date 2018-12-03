package com.lzq.managements.dao;

import com.lzq.managements.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {
    List<UserInfo> getAllUserInfo( @Param("empNo")String empNo,
                                   @Param("offset") Integer offset,
                                   @Param("limit") Integer limit);
    List<UserInfo> getAllDiscard(@Param("offset") Integer offset,
                                 @Param("limit") Integer limit);
    List<UserInfo> getAllUserInfoByloginTime(@Param("empNo")String empNo,
                                             @Param("offset") Integer offset,
                                             @Param("limit") Integer limit);
    int insertUserinfo(UserInfo userInfo);
    int updateUserinfo(UserInfo userInfo);
    int updateUser(UserInfo userInfo);
    int deleteUserinfo(List<String> list);
    UserInfo getOneByUserNo(String userNo);
    List<UserInfo> getOne(String userNo);
    List<UserInfo> checkUserinfo(@Param("empNo")String empNo,
                                 @Param("userNo")String userNo,
                                 @Param("FirstCreateTime") String FirstCreateTime,
                                 @Param("LastCreateTime") String LastCreateTime,
                                 @Param("status") Integer status,
                                 @Param("state") String state,
                                 @Param("offset") Integer offset,
                                 @Param("limit") Integer limit);
    List<UserInfo> checkDiscard(@Param("empNo")String empNo,
                                 @Param("userNo")String userNo,
                                 @Param("FirstCreateTime") String FirstCreateTime,
                                 @Param("LastCreateTime") String LastCreateTime,
                                 @Param("status") Integer status,
                                 @Param("state") String state,
                                 @Param("offset") Integer offset,
                                 @Param("limit") Integer limit);
    List<UserInfo> checkUserinfoByLoginTime(@Param("empNo")String empNo,
                                 @Param("userNo")String userNo,
                                 @Param("status") Integer status,
                                 @Param("state") String state,
                                 @Param("offset") Integer offset,
                                 @Param("limit") Integer limit);
}
