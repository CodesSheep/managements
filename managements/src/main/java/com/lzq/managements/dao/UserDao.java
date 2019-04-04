package com.lzq.managements.dao;

import com.lzq.managements.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> listUser(@Param("sort") String sort,
                        @Param("order") String order,
                        @Param("pageNo") Integer pageNo,
                        @Param("pageSize") Integer pageSize,
                        @Param("fuzzyQuery") String fuzzyQuery);

    User findByUserNo(String userNo);

    User findByUserNoAndPassword(@Param("userNo") String userNo, @Param("password") String password);

    User findByPhoneNo(String phoneNo);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(List<String> list);

    int updateBalance(User user);

    int updateBalanceByUserNo(User user);

    List<User> checkUser(@Param("userNo") String userNo,
                         @Param("qqAccount") String qqAccount,
                         @Param("FirstCreateTime") String FirstCreateTime,
                         @Param("LastCreateTime") String LastCreateTime,
                         @Param("status") Integer status,
                         @Param("pageNo") Integer pageNo,
                         @Param("pageSize") Integer pageSize);

    List<User> checkUserByLoginTime(@Param("userNo") String userNo,
                                    @Param("qqAccount") String qqAccount,
                                    @Param("FirstCreateTime") String FirstCreateTime,
                                    @Param("LastCreateTime") String LastCreateTime,
                                    @Param("status") Integer status,
                                    @Param("pageNo") Integer pageNo,
                                    @Param("pageSize") Integer pageSize);
    int updateFrequencyByUserNo(User user);
    User findUser(String empNo);
}
