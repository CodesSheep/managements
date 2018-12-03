package com.lzq.managements.serviceImpl.emp;

import com.lzq.managements.dao.emp.EmpDao;
import com.lzq.managements.entity.Team;
import com.lzq.managements.entity.emp.EmpEntity;
import com.lzq.managements.service.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<EmpEntity> getAllEmp(String empNo,Integer offset, Integer limit) {
        return empDao.getAllEmp(empNo,offset,limit);
    }

    @Override
    public int insertEmp(EmpEntity empEntity) {
        return empDao.insertEmp(empEntity);
    }

    @Override
    public int updateEmp(EmpEntity empEntity) {
        return empDao.updateEmp(empEntity);
    }

    @Override
    public int deleteEmp(String[] serial) {
        List<String> list = Arrays.asList(serial);
        return empDao.deleteEmp(list);
    }

    @Override
    public EmpEntity findEmp(String empNo, String empPassword) {
        return empDao.findEmp(empNo,empPassword);
    }

    @Override
    public EmpEntity findEmpByEmpNo(String empNo) {
        return empDao.findEmpByEmpNo(empNo);
    }

    @Override
    public int insertTeam(Team team) {
        return empDao.insertTeam(team);
    }

    @Override
    public int updateTeam(Team team) {
        return empDao.updateTeam(team);
    }

    @Override
    public List<EmpEntity> selectEmpByleaderName(String leaderName,String empNo) {
        return empDao.selectEmpByleaderName(leaderName,empNo);
    }
}
