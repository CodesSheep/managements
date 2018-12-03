package com.lzq.managements.serviceImpl.newsorder;

import com.lzq.managements.dao.newsorder.NewsOrderDao;
import com.lzq.managements.entity.newsorder.NewsOrder;
import com.lzq.managements.service.newsorder.NewsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NewsOrderServiceImpl implements NewsOrderService{
    @Autowired
    private NewsOrderDao newsOrderDao;

    @Override
    public List<NewsOrder> getAllNewsOrder(String empNo, Integer offset, Integer limit) {
        return newsOrderDao.getAllNewsOrder(empNo,offset,limit);
    }

    @Override
    public int insertNewsOrder(NewsOrder newsOrder) {
        return newsOrderDao.insertNewsOrder(newsOrder);
    }

    @Override
    public int updateNewsOrder(NewsOrder newsOrder) {
        return newsOrderDao.updateNewsOrder(newsOrder);
    }

    @Override
    public int deleteNewsOrder(String[] serial) {
        List<String> list= Arrays.asList(serial);
        return newsOrderDao.deleteNewsOrder(list);
    }

    @Override
    public List<NewsOrder> checkNewsOrder(String empNo, String userNo, String mediaName, String FirstCreateTime, String LastCreateTime, String state, Integer offset, Integer limit) {
        return newsOrderDao.checkNewsOrder(empNo,userNo,mediaName,FirstCreateTime,LastCreateTime,state,offset,limit);
    }
}
