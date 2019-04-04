package com.lzq.managements.service.media.mediaPrice;


import com.lzq.managements.entity.media.mediaPrice.MediaType;

import java.util.List;

/**
 * Created by Administrator on 2018/8/18.
 */
public interface MediaTypeService {

    /**
     * 查询
     * */
    List<MediaType> listMediaType(Integer page, Integer rows);

    /**
     * 新增
     * */
    int insertMediaType(MediaType mediaType);

    /**
     * 删除
     * */
    int deleteMediaType(String[] mediaTypeNos);
}
