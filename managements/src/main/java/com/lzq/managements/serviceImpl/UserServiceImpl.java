package com.lzq.managements.serviceImpl;

import com.lzq.managements.dao.UserDao;
import com.lzq.managements.entity.User;
import com.lzq.managements.service.UserService;
import com.lzq.managements.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUser(String sort, String order, Integer page, Integer rows, String fuzzyQuery) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return userDao.listUser(sort,order,pageNo,pageSize,fuzzyQuery);
    }

    @Override
    public User findByUserNo(String userNo) {
        return userDao.findByUserNo(userNo);
    }

    @Override
    public User findByUserNoAndPassword(String userNo, String password) {
        password = StringUtils.doMD5ManyTimes(password,20);
        return userDao.findByUserNoAndPassword(userNo,password);
    }

    @Override
    public User findByPhoneNo(String phoneNo) {
        return userDao.findByPhoneNo(phoneNo);
    }

    @Override
    public int insertUser(User user) {
        user.setPassword(StringUtils.doMD5ManyTimes(user.getPassword(),20));
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        if (user != null && user.getPassword() != null && user.getPassword().trim() != ""){
            user.setPassword(StringUtils.doMD5ManyTimes(user.getPassword(),20));
        }
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(String[] userNos) {
        List<String> list = Arrays.asList(userNos);
        return userDao.deleteUser(list);
    }

    @Override
    public int updateBalance(User user) {
        return userDao.updateBalance(user);
    }

    @Override
    public int updateFrequencyByUserNo(User user) {
        return userDao.updateFrequencyByUserNo(user);
    }

    @Override
    public User findUser(String empNo) {
        return userDao.findUser(empNo);
    }

    @Override
    public List<User> checkUser(String userNo, String qqAccount, String FirstCreateTime, String LastCreateTime, Integer status,Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return userDao.checkUser(userNo,qqAccount,FirstCreateTime,LastCreateTime,status,pageNo,pageSize);
    }

    @Override
    public List<User> checkUserByLoginTime(String userNo, String qqAccount, String FirstCreateTime, String LastCreateTime, Integer status, Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return userDao.checkUserByLoginTime(userNo,qqAccount,FirstCreateTime,LastCreateTime,status,pageNo,pageSize);
    }
}
