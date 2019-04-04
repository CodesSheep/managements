package com.lzq.managements.serviceImpl.ghostwriting;

import com.lzq.managements.dao.ghostwriting.GhostWritingDao;
import com.lzq.managements.entity.ghostwriting.GhostWriting;
import com.lzq.managements.service.ghostwriting.GhostWritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GhostWritingServiceImpl implements GhostWritingService {
    @Autowired
    private GhostWritingDao ghostWritingDao;


    @Override
    public List<GhostWriting> getAllGhostWriting(String empNo, Integer offset, Integer limit) {
        return ghostWritingDao.getAllGhostWriting(empNo,offset,limit);
    }

    @Override
    public int insertGhostWriting(GhostWriting GhostWriting) {
        return ghostWritingDao.insertGhostWriting(GhostWriting);
    }

    @Override
    public int updateGhostWriting(GhostWriting GhostWriting) {
        return ghostWritingDao.updateGhostWriting(GhostWriting);
    }

    @Override
    public int deleteGhostWriting(String[] serial) {
        List<String> list= Arrays.asList(serial);
        return ghostWritingDao.deleteGhostWriting(list);
    }

    @Override
    public List<GhostWriting> checkGhostWriting(String empNo, String userNo, String title, String FirstCreateTime, String LastCreateTime, String state, Integer offset, Integer limit) {
        return ghostWritingDao.checkGhostWriting(empNo, userNo, title, FirstCreateTime, LastCreateTime, state, offset, limit);
    }
}
