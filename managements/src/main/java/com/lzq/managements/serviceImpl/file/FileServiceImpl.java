package com.lzq.managements.serviceImpl.file;

import com.lzq.managements.dao.file.FileDao;
import com.lzq.managements.entity.file.FileEntity;
import com.lzq.managements.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public List<FileEntity> getAllFile(String empNo, Integer offset, Integer limit) {
        return fileDao.getAllFile(empNo,offset,limit);
    }

    @Override
    public int insertFile(FileEntity fileEntity) {
        return fileDao.insertFile(fileEntity);
    }

    @Override
    public int updateFile(FileEntity fileEntity) {
        return fileDao.updateFile(fileEntity);
    }

    @Override
    public List<FileEntity> checkFile(String empNo, String userNo, String fileName,String FirstCreateTime, String LastCreateTime, String fileState, Integer offset, Integer limit) {
        return fileDao.checkFile(empNo,userNo,fileName,FirstCreateTime,LastCreateTime,fileState,offset,limit);
    }

    @Override
    public int checkCount(String empNo, String userNo, String fileName, String FirstCreateTime, String LastCreateTime, String fileState) {
        return fileDao.checkCount(empNo,userNo,fileName,FirstCreateTime,LastCreateTime,fileState);
    }
}
