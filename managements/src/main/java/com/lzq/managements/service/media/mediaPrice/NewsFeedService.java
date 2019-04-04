package com.lzq.managements.service.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.NewsFeed;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface NewsFeedService {

    /**
     * 查询
     * */
    List<NewsFeed> listNewsFeed(Integer page, Integer rows);

    /**
     * 新增
     * */
    int insertNewsFeed(NewsFeed newsFeed);

    /**
     * 删除
     * */
    int deleteNewsFeed(String[] newsFeedNos);
}
