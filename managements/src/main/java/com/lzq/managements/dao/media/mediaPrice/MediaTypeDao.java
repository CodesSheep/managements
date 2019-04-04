package com.lzq.managements.dao.media.mediaPrice;

import com.lzq.managements.entity.media.mediaPrice.MediaType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/16.
 */
@Repository
public interface MediaTypeDao {

    /**
     * 查询
     * */
    List<MediaType> listMediaType(@Param("pageNo") Integer pageNo,
                                  @Param("pageSize") Integer pageSize);

    /**
     * 新增
     * */
    int insertMediaType(MediaType mediaType);

    /**
     * 删除
     * */
    int deleteMediaType(List<String> list);
}
