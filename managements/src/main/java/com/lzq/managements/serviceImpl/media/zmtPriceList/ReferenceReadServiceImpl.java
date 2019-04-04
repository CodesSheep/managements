package com.lzq.managements.serviceImpl.media.zmtPriceList;

import com.lzq.managements.entity.media.zmtPriceList.*;
import com.lzq.managements.dao.media.zmtPriceList.*;
import com.lzq.managements.service.media.zmtPriceList.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceReadServiceImpl implements ReferenceReadService {
        @Autowired
        private ReferenceReadDao referenceReadDao;

        @Override
        public int deleteByPrimaryKey(Long serial) {
            return referenceReadDao.deleteByPrimaryKey(serial);
        }

        @Override
        public int insertReferenceRead(ReferenceRead record) {
            return referenceReadDao.insertReferenceRead(record);
        }

        @Override
        public ReferenceRead selectByPrimaryKey(Long serial) {
            return referenceReadDao.selectByPrimaryKey(serial);
        }

        @Override
        public int updateReferenceRead(ReferenceRead record) {
            return referenceReadDao.updateReferenceRead(record);
        }

        @Override
        public List<ReferenceRead> getAllReferenceReads(Integer page, Integer rows) {
            Integer pageNo = null;
            Integer pageSize = null;
            if (page != null && rows != null && page > 0) {
                pageNo = (page - 1) * rows;
                pageSize = rows;
            }
            return referenceReadDao.getAllReferenceReads(pageNo,pageSize);
        }
}
