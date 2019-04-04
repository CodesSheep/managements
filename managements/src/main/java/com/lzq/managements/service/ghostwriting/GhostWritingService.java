package com.lzq.managements.service.ghostwriting;

import com.lzq.managements.entity.ghostwriting.GhostWriting;

import java.util.List;

public interface GhostWritingService {
    List<GhostWriting> getAllGhostWriting(String empNo, Integer offset, Integer limit);
    int insertGhostWriting(GhostWriting GhostWriting);
    int updateGhostWriting(GhostWriting GhostWriting);
    int deleteGhostWriting(String[] serial);
    List<GhostWriting> checkGhostWriting(String empNo,String userNo,String title,String FirstCreateTime,String LastCreateTime,String state,Integer offset,Integer limit);
}
