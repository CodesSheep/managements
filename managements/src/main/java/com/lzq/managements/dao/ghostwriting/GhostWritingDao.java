package com.lzq.managements.dao.ghostwriting;

import com.lzq.managements.entity.ghostwriting.GhostWriting;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GhostWritingDao {
    List<GhostWriting> getAllGhostWriting(@Param("empNo") String empNo,
                                    @Param("offset") Integer offset,
                                    @Param("limit") Integer limit);
    int insertGhostWriting(GhostWriting GhostWriting);
    int updateGhostWriting(GhostWriting GhostWriting);
    int deleteGhostWriting(List<String> list);
    List<GhostWriting> checkGhostWriting(@Param("empNo") String empNo,
                                   @Param("userNo") String userNo,
                                   @Param("title") String title,
                                   @Param("FirstCreateTime") String FirstCreateTime,
                                   @Param("LastCreateTime") String LastCreateTime,
                                   @Param("state") String state,
                                   @Param("offset") Integer offset,
                                   @Param("limit") Integer limit);
}