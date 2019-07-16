package com.lzq.managements.dao.emp;

import com.lzq.managements.entity.Team;
import com.lzq.managements.entity.emp.EmpEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDao {
    List<EmpEntity> getAllEmp(@Param("empNo")String empNo,@Param("offset") Integer offset,
                              @Param("limit") Integer limit);
    int getCount(@Param("empNo")String empNo);
    int insertEmp(EmpEntity empEntity);
    int updateEmp(EmpEntity empEntity);
    int deleteEmp(List<String> list);
    EmpEntity findEmp(@Param("empNo")String empNo,@Param("empPassword")  String empPassword);
    EmpEntity findEmpByEmpNo(@Param("empNo")String empNo);
    int insertTeam(Team team);
    int updateTeam(Team team);
    List<EmpEntity> selectEmpByleaderName(@Param("jurisdictionName")String jurisdictionName);
    String selectEmpByempName(String empName);
}
