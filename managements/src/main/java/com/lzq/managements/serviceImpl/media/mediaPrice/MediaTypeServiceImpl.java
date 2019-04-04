package com.lzq.managements.serviceImpl.media.mediaPrice;


import com.lzq.managements.dao.media.mediaPrice.MediaTypeDao;
import com.lzq.managements.entity.media.mediaPrice.MediaType;
import com.lzq.managements.service.media.mediaPrice.MediaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class MediaTypeServiceImpl implements MediaTypeService {

    @Autowired
    private MediaTypeDao mediaTypeDao;

    @Override
    public List<MediaType> listMediaType(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return mediaTypeDao.listMediaType(pageNo,pageSize);
    }

    @Override
    public int insertMediaType(MediaType mediaType) {
        mediaType.setMediaTypeNo(UUID.randomUUID().toString());
        return mediaTypeDao.insertMediaType(mediaType);
    }

    @Override
    public int deleteMediaType(String[] mediaTypeNos) {
        List<String> list = Arrays.asList(mediaTypeNos);
        return mediaTypeDao.deleteMediaType(list);
    }
}
