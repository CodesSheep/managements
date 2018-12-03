package com.lzq.managements.dao.newsorder;

import com.lzq.managements.entity.newsorder.NewsOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsOrderDao {
    List<NewsOrder> getAllNewsOrder(@Param("empNo") String empNo,
                                    @Param("offset") Integer offset,
                                    @Param("limit") Integer limit);
    int insertNewsOrder(NewsOrder newsOrder);
    int updateNewsOrder(NewsOrder newsOrder);
    int deleteNewsOrder(List<String> list);
    List<NewsOrder> checkNewsOrder(@Param("empNo") String empNo,
                                   @Param("userNo") String userNo,
                                   @Param("mediaName") String mediaName,
                                   @Param("FirstCreateTime") String FirstCreateTime,
                                   @Param("LastCreateTime") String LastCreateTime,
                                   @Param("state") String state,
                                   @Param("offset") Integer offset,
                                   @Param("limit") Integer limit);
}
