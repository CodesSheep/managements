package com.lzq.managements.service;

import com.lzq.managements.entity.User;

import java.util.List;

public interface UserService {

    List<User> listUser(String sort, String order, Integer page, Integer rows, String fuzzyQuery);

    User findByUserNo(String userNo);

    User findByUserNoAndPassword(String userNo, String password);

    User findByPhoneNo(String phoneNo);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(String[] userNos);
    int updateBalance(User user);

    int updateFrequencyByUserNo(User user);
    User  findUser(String empNo);
    List<User> checkUser(String userNo, String qqAccount, String FirstCreateTime, String LastCreateTime, Integer status, Integer page, Integer rows);
    List<User> checkUserByLoginTime(String userNo, String qqAccount, String FirstCreateTime, String LastCreateTime, Integer status, Integer page, Integer rows);

}
