package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.NewsFeed;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface NewsFeedDao {

    /**
     * 查询
     * */
    List<NewsFeed> listNewsFeed(@Param("pageNo") Integer pageNo,
                                @Param("pageSize") Integer pageSize);

    /**
     * 新增
     * */
    int insertNewsFeed(NewsFeed newsFeed);

    /**
     * 删除
     * */
    int deleteNewsFeed(List<String> list);
}
