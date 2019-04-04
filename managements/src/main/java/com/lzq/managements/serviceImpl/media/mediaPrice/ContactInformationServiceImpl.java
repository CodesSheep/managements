package com.lzq.managements.serviceImpl.media.mediaPrice;

import com.lzq.managements.dao.media.mediaPrice.ContactInformationDao;
import com.lzq.managements.entity.media.mediaPrice.ContactInformation;
import com.lzq.managements.service.media.mediaPrice.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/18.
 */
@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    @Autowired
    private ContactInformationDao contactInformationDao;

    @Override
    public List<ContactInformation> listContactInformation(Integer page, Integer rows) {
        Integer pageNo = null;
        Integer pageSize = null;
        if (page != null && rows != null && page > 0){
            pageNo = (page - 1) * rows;
            pageSize = rows;
        }
        return contactInformationDao.listContactInformation(pageNo,pageSize);
    }

    @Override
    public int insertContactInformation(ContactInformation contactInformation) {
        contactInformation.setContactInformationNo(UUID.randomUUID().toString());
        return contactInformationDao.insertContactInformation(contactInformation);
    }

    @Override
    public int deleteContactInformation(String[] advertisingTypeNos) {
        List<String> list = Arrays.asList(advertisingTypeNos);
        return contactInformationDao.deleteContactInformation(list);
    }
}
