package com.lzq.managements.service.newsorder;

import com.lzq.managements.entity.newsorder.NewsOrder;

import java.util.List;

public interface NewsOrderService {
    List<NewsOrder> getAllNewsOrder(String empNo, Integer offset, Integer limit);
    int insertNewsOrder(NewsOrder newsOrder);
    int updateNewsOrder(NewsOrder newsOrder);
    int deleteNewsOrder(String[] serial);
    List<NewsOrder> checkNewsOrder(String empNo,String userNo,String mediaName,String FirstCreateTime,String LastCreateTime,String state,Integer offset,Integer limit);
}
