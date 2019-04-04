package com.lzq.managements.dao.file;

import com.lzq.managements.entity.file.FileEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao {
    List<FileEntity> getAllFile(@Param("empNo") String empNo,
                                @Param("offset") Integer offset,
                                @Param("limit") Integer limit);
    int insertFile(FileEntity fileEntity);
    int updateFile(FileEntity fileEntity);
    List<FileEntity> checkFile(@Param("empNo")String empNo,
                                @Param("userNo")String userNo,
                                @Param("fileName")String fileName,
                                @Param("FirstCreateTime") String FirstCreateTime,
                                @Param("LastCreateTime") String LastCreateTime,
                                @Param("fileState") String fileState,
                                @Param("offset") Integer offset,
                                @Param("limit") Integer limit);
}
