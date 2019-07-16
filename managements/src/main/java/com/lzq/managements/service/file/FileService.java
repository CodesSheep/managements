package com.lzq.managements.service.file;

import com.lzq.managements.entity.file.FileEntity;

import java.util.List;

public interface FileService {
    List<FileEntity> getAllFile(String empNo, Integer offset, Integer limit);

    int insertFile(FileEntity fileEntity);

    int updateFile(FileEntity fileEntity);

    List<FileEntity> checkFile(String empNo,
                               String userNo,
                               String fileName,
                               String FirstCreateTime,
                               String LastCreateTime,
                               String fileState,
                               Integer offset,
                               Integer limit);

    int checkCount(String empNo,
                   String userNo,
                   String fileName,
                   String FirstCreateTime,
                   String LastCreateTime,
                   String fileState);
}
