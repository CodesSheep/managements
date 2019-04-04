package com.lzq.managements.serviceImpl.media;

import com.lzq.managements.dao.media.WxMediaPriceListDao;
import com.lzq.managements.entity.media.WxMediaPriceList;
import com.lzq.managements.service.media.WxMediaPriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
public class WxMediaPriceListServiceImpl implements WxMediaPriceListService {
    @Autowired
    private WxMediaPriceListDao wxMediaPriceListDao;
    @Override
    public int deleteByPrimaryKey(Long serial) {
        return 0;
    }

    @Override
    public int insertWxMediaPriceList(MultipartFile file,WxMediaPriceList wxMediaPriceList) {
        /* judgeFileIsOrNotNull( file,wxMediaPriceList);*/
        return  wxMediaPriceListDao.insertWxMediaPriceList(wxMediaPriceList);

    }

  /*private void judgeFileIsOrNotNull(MultipartFile file,WxMediaPriceList wxMediaPriceList) {
        if (file != null && !file.isEmpty()) {
            byte[] qrCode = null;
            try {
                qrCode = file.getBytes();
            } catch (Exception e) {
                e.printStackTrace();
            }
            wxMediaPriceList.setImgURL(qrCode);
        }
    }*/

    @Override
    public List<WxMediaPriceList> getAllWxMediaPriceList(WxMediaPriceList wxMediaPriceList, Integer page, Integer rows) {
        if(page !=null && rows !=null && page>0){
            wxMediaPriceList.setPageNo((page-1)*rows);
            wxMediaPriceList.setPageSize(rows);
        }
        else{
            wxMediaPriceList.setPageNo(null);
            wxMediaPriceList.setPageSize(null);
        }
        return wxMediaPriceListDao.getAllWxMediaPriceList(wxMediaPriceList);
    }

    @Override
    public WxMediaPriceList selectByPrimaryKey(Long serial) {
        return null;
    }

    @Override
    public int updateWxMediaPriceList(WxMediaPriceList record) {
        return 0;
    }

    @Override
    public List<WxMediaPriceList> getWxMediaPriceListByNos(String[] wxMediaNo) {
        List<String> list= Arrays.asList(wxMediaNo);
        return wxMediaPriceListDao.getWxMediaPriceListByNos(list);
    }

    @Override
    public int getCount() {
        return wxMediaPriceListDao.getCount();
    }

    @Override
    public int deletePriceList(String[] wxMediaNos) {
        List<String> list= Arrays.asList(wxMediaNos);
        return wxMediaPriceListDao.deletePriceList(list);
    }
}
