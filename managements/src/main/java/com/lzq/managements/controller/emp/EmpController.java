package com.lzq.managements.controller.emp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.Team;
import com.lzq.managements.entity.emp.EmpEntity;
import com.lzq.managements.service.emp.EmpService;
import com.lzq.managements.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("getAllEmp")
    @Cacheable(value = "emp",keyGenerator = "keyGenerator")
    public String getAllEmp(String empNo,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try {
            List<EmpEntity> list =empService.getAllEmp(empNo,offset,limit);
            int total=empService.getAllEmp(empNo,null,null).size();
            json.put("rows",list);
            json.put("total",total);
           return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }catch (Exception e){
            e.printStackTrace();
           return  JSON.toJSONString(json);
        }
    }
    @RequestMapping("updateEmp")
    @CacheEvict(value = "emp",allEntries = true)
    public String updateEmp(EmpEntity empEntity){
        JSONObject json=new JSONObject();
        try{
            empService.updateEmp(empEntity);
            if(empEntity.getTeamNo()!=null){
                Team team=new Team();
                if(empEntity.getTeamNo()=="1")
                {
                    team.setTeamName("主管");
                }
                if(empEntity.getTeamNo()=="2")
                {
                    team.setTeamName("组长");
                }
                if(empEntity.getTeamNo()=="3")
                {
                    team.setTeamName("普通员工");
                }
                team.setTeamNo(empEntity.getTeamNo());
                team.setLeaderName(empEntity.getEmpName());
                empService.updateTeam(team);
            }

            json.put("result",true);
            json.put("message","修改成功！");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","修改失败！");
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("insertEmp")
    @CacheEvict(value = "emp",allEntries = true)
    public String insertEmp(EmpEntity empEntity){
        JSONObject json=new JSONObject();
        try{
            EmpEntity e=empService.findEmpByEmpNo(empEntity.getEmpNo());
            if( e !=null){
                json.put("result",false);
                json.put("message","用户已存在");
                return  JSON.toJSONString(json);
            }
            if(empEntity.getEmpNo()==null || empEntity.getEmpNo().trim()==""){
                json.put("result",false);
                json.put("message","请输入用户名");
                return JSON.toJSONString(json);
            }
            if(empEntity.getEmpPassword()==null || empEntity.getEmpPassword().trim()==""){
                json.put("result",false);
                json.put("message","请输入密码");
                return JSON.toJSONString(json);
            }
            Team team=new Team();
            team.setTeamNo("3");
            team.setTeamName("普通员工");
            team.setLeaderName("管理员");
            empService.insertTeam(team);
            empEntity.setTeamNo("3");
            empService.insertEmp(empEntity);
            json.put("result",true);
            json.put("message","创建成功！");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","创建失败！");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("loginByEmpNo")
    @Cacheable(value = "emp",keyGenerator = "keyGenerator")
    public String loginByEmpNo(String empNo, String empPassword, HttpServletRequest request){
        JSONObject json =new JSONObject();
        try{
            if (empNo == null || empNo.trim() == ""){
                json.put("result",false);
                json.put("message","请输入用户名");
                return JSON.toJSONString(json);
            }
            if (empPassword == null || empPassword.trim() == ""){
                json.put("result",false);
                json.put("message","请输入密码");
                return JSON.toJSONString(json);
            }
            if (empService.findEmpByEmpNo(empNo) == null){
                json.put("result",false);
                json.put("message","该用户不存在");
                return JSON.toJSONString(json);
            }
            EmpEntity emp = empService.findEmp(empNo,empPassword);
            if (emp == null){
                json.put("result",false);
                json.put("message","密码不正确");
                return JSON.toJSONString(json);
            }

            request.getSession().setMaxInactiveInterval(0);
            request.getSession().setAttribute("emp",emp);
            json.put("result",true);
            json.put("message","登陆成功");
            json.put("emp",emp);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result",false);
            json.put("message","登录失败！");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("getCurrentUserInfo")
    public String getCurrentUserInfo(HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();
        EmpEntity empEntity = (EmpEntity)request.getSession().getAttribute("emp");
        if (empEntity != null){
            EmpEntity currentEmp = empService.findEmpByEmpNo(empEntity.getEmpNo());
            //更新最近一次登录时间
            EmpEntity newemp = new EmpEntity();
            String ip = StringUtils.getIpAddr(request);
            newemp.setLoginIP(ip);
            newemp.setEmpNo(empEntity.getEmpNo());
            newemp.setLoginTime(new Date());
            empService.updateEmp(newemp);
            json.put("result",true);
            json.put("currentEmp",currentEmp);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }
        json.put("result",false);
        json.put("currentEmp",null);
        return JSON.toJSONString(json);
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        JSONObject json = new JSONObject();
        try {
            session.invalidate();
            json.put("result",true);
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("selectEmpByleaderName")
    @Cacheable(value = "emp",keyGenerator = "keyGenerator")
    public String selectEmpByleaderName(String leaderName,String empNo){
    JSONObject json = new JSONObject();
    try{
        List<EmpEntity> ar= empService.selectEmpByleaderName(leaderName,empNo);
        json.put("ar",ar);
        return JSON.toJSONString(json);
    }catch (Exception e){
        e.printStackTrace();
        return JSON.toJSONString(json);
    }
}


}
