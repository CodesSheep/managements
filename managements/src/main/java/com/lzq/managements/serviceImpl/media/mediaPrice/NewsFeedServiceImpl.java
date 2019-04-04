package com.lzq.managements.serviceImpl.media.mediaPrice;


import com.lzq.managements.dao.media.mediaPrice.NewsFeedDao;
import com.lzq.managements.entity.media.mediaPrice.NewsFeed;
import com.lzq.managements.service.media.mediaPrice.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class NewsFeedServiceImpl implements NewsFeedService {

    @Autowired
    private NewsFeedDao newsFeedDao;

    @Override
    public List<NewsFeed> listNewsFeed(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return newsFeedDao.listNewsFeed(pageNo,pageSize);
    }

    @Override
    public int insertNewsFeed(NewsFeed newsFeed) {
        newsFeed.setNewsFeedNo(UUID.randomUUID().toString());
        return newsFeedDao.insertNewsFeed(newsFeed);
    }

    @Override
    public int deleteNewsFeed(String[] newsFeedNos) {
        List<String> list = Arrays.asList(newsFeedNos);
        return newsFeedDao.deleteNewsFeed(list);
    }
}
