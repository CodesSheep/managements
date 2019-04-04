package com.lzq.managements.dao.wenmu;

import com.lzq.managements.entity.WenMu.WenMu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WenMuDao {

    public List<WenMu> getAllWenMu(@Param("userNo")String userNo,
                                   @Param("qqAccount")String qqAccount,
                                   @Param("FirstCreateTime")String FirstCreateTime,
                                   @Param("LastCreateTime")String LastCreateTime,
                                   @Param("status")Integer status,
                                   @Param("pageNo")Integer pageNo,
                                   @Param("pageSize")Integer pageSize);

}
