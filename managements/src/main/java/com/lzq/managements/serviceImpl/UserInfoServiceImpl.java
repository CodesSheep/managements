package com.lzq.managements.serviceImpl;

import com.lzq.managements.dao.UserInfoDao;
import com.lzq.managements.entity.UserInfo;
import com.lzq.managements.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userDao;

    @Override
    public List<UserInfo> getAllUserInfo( String empNo,Integer offset, Integer limit) {

        return userDao.getAllUserInfo(empNo,offset,limit);
    }

    @Override
    public List<UserInfo> getAllDiscard( Integer offset, Integer limit) {
        return userDao.getAllDiscard(offset,limit);
    }

    @Override
    public List<UserInfo> getAllUserInfoByloginTime(String empNo,String Time,Integer offset, Integer limit) {
        return userDao.getAllUserInfoByloginTime(empNo,Time,offset,limit);
    }

    @Override
    public int insertUserinfo(UserInfo userInfo) {
        return userDao.insertUserinfo(userInfo);
    }

    @Override
    public int updateUserinfo(UserInfo userInfo) {
        return userDao.updateUserinfo(userInfo);
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        return userDao.updateUser(userInfo);
    }

    @Override
    public int deleteUserinfo(String[] serial) {
        List<String> list= Arrays.asList(serial);
        return userDao.deleteUserinfo(list);
    }

    @Override
    public UserInfo getOneByUserNo(String userNo) {
        return userDao.getOneByUserNo(userNo);
    }

    @Override
    public List<UserInfo> getOne(String userNo) {
        return userDao.getOne(userNo);
    }

    @Override
    public List<UserInfo> checkUserinfo(String empNo,String userNo, String FirstCreateTime, String LastCreateTime, Integer status,String qqAccount, String state, Integer offset, Integer limit) {
        return userDao.checkUserinfo(empNo,userNo,FirstCreateTime, LastCreateTime, status,qqAccount, state, offset, limit);
    }

    @Override
    public List<UserInfo> checkDiscard(String empNo, String userNo, String FirstCreateTime, String LastCreateTime, Integer status,String qqAccount, String state, Integer offset, Integer limit) {
        return userDao.checkDiscard(empNo,userNo,FirstCreateTime, LastCreateTime, status,qqAccount,  state, offset, limit);
    }

    @Override
    public List<UserInfo> checkUserinfoByLoginTime(String empNo, String userNo,String Time, Integer status,String qqAccount, String state, Integer offset, Integer limit) {
        return userDao.checkUserinfoByLoginTime(empNo,userNo,Time,status,qqAccount,state, offset, limit);
    }

    @Override
    public List<UserInfo> getUpdateTime() {
        return userDao.getUpdateTime();
    }

    @Override
    public int getLocking(String empNo) {
        return userDao.getLocking(empNo);
    }

    @Override
    public int getAllUserInfoCount(String empNo) {
        return userDao.getAllUserInfoCount(empNo);
    }

    @Override
    public int getAllDiscardCount() {
        return userDao.getAllDiscardCount();
    }

    @Override
    public int getAllUserInfoByloginTimeCount(String empNo, String Time) {
        return userDao.getAllUserInfoByloginTimeCount(empNo,Time);
    }

    @Override
    public int checkUserinfoCount(String empNo, String userNo, String FirstCreateTime, String LastCreateTime, Integer status, String qqAccount, String state) {
        return userDao.checkUserinfoCount(empNo, userNo, FirstCreateTime,LastCreateTime,status,qqAccount,state);
    }

    @Override
    public int checkDiscardCount(String empNo, String userNo, String FirstCreateTime, String LastCreateTime, Integer status, String qqAccount, String state) {
        return userDao.checkDiscardCount(empNo, userNo, FirstCreateTime,LastCreateTime,status,qqAccount,state);
    }

    @Override
    public int checkUserinfoByLoginTimeCount(String empNo, String userNo, String Time, Integer status, String qqAccount, String state) {
        return userDao.checkUserinfoByLoginTimeCount(empNo, userNo,Time,status,qqAccount,state);
    }

    @Override
    public int updateTimerToNow(String articleNo) {
        return userDao.updateTimerToNow(articleNo);
    }

    @Override
    public String selectArticleNo() {
        return userDao.selectArticleNo();
    }
}
