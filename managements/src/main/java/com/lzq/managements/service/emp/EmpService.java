package com.lzq.managements.service.emp;


import com.lzq.managements.entity.Team;
import com.lzq.managements.entity.emp.EmpEntity;

import java.util.List;

public interface EmpService {
    List<EmpEntity> getAllEmp(String empNo,Integer offset, Integer limit);
    int getCount(String empNo);
    int insertEmp(EmpEntity empEntity);
    int updateEmp(EmpEntity empEntity);
    int deleteEmp(String[] serial);
    EmpEntity findEmp(String empNo, String empPassword);
    EmpEntity findEmpByEmpNo(String empNo);
    int insertTeam(Team team);
    int updateTeam(Team team);
    List<EmpEntity> selectEmpByleaderName(String jurisdictionName);
    String selectEmpByempName(String empName);
}
