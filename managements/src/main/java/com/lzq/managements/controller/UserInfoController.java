package com.lzq.managements.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lzq.managements.entity.Feedback;
import com.lzq.managements.entity.UserInfo;
import com.lzq.managements.entity.emp.EmpEntity;
import com.lzq.managements.service.FeedbackService;
import com.lzq.managements.service.UserInfoService;
import com.lzq.managements.service.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("userinfo")
public class UserInfoController {
    @Autowired
    private EmpService empService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private FeedbackService feedbackService;
    @RequestMapping("getAllUserInfo")
    public String getAllUserInfo(String empNo,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try {
            List<UserInfo> list = userInfoService.getAllUserInfo( empNo,offset, limit);
            int total = userInfoService.getAllUserInfo(empNo,null, null).size();
            json.put("rows", list);
            json.put("total", total);
            return JSON.toJSONStringWithDateFormat(json, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }
    @RequestMapping("getOneByUserNo")
    public String getOneByUserNo(String userNo,String leaderName,String empNo){
        JSONObject json=new JSONObject();
        try{
            List<UserInfo> ars=userInfoService.getOne(userNo);
            if(ars.size()==0){
                UserInfo userInfo=new UserInfo();
                userInfo.setUserNo(userNo);
                userInfoService.insertUserinfo(userInfo);
            }
            List<EmpEntity> ar= empService.selectEmpByleaderName(leaderName,empNo);
            List<Feedback> list=feedbackService.getAllFeedbackByUserNo(userNo);
            json.put("ar",ar);
            json.put("list",list);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("getAllUserInfoByloginTime")
    public String getAllUserInfoByloginTime(String empNo,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try {
            List<UserInfo> list = userInfoService.getAllUserInfoByloginTime(empNo, offset, limit);
            int total = userInfoService.getAllUserInfoByloginTime(empNo,null, null).size();
            json.put("rows", list);
            json.put("total", total);
            return JSON.toJSONStringWithDateFormat(json, "yy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }
    @RequestMapping("updateUserInfo")
    public String updateUserInfo(UserInfo userInfo){
        JSONObject json =new JSONObject();
        try{

            userInfo.setUpdateTime(new Date());
            if(userInfo.getFeedback() != null && userInfo.getFeedback() !=""){
                Feedback feedback=new Feedback();
                feedback.setUserNo(userInfo.getUserNo());
                feedback.setEmpName(userInfo.getEmpName());
                feedback.setFeedback(userInfo.getFeedback());
                feedbackService.insertFeedback(feedback);
                userInfoService.updateUserinfo(userInfo);
                userInfoService.updateUser(userInfo);
            }
            else{
                Feedback feedback=feedbackService.selectFeedbackBycreateTime(userInfo.getUserNo());
                if(feedback!=null){
                    userInfo.setFeedback(feedback.getFeedback());
                }

                userInfoService.updateUser(userInfo);
                userInfoService.updateUserinfo(userInfo);
            }
            json.put("result",true);
            json.put("message","更新成功！");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","更新失败！");
            return JSON.toJSONString(json);
        }
    }
    @RequestMapping("getAllDiscard")
    public String getAllDiscard(Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try{
            List<UserInfo> list = userInfoService.getAllDiscard( offset, limit);
            int total = userInfoService.getAllDiscard(null, null).size();
            json.put("rows", list);
            json.put("total", total);
            return JSON.toJSONStringWithDateFormat(json, "yyyy-MM-dd HH:mm:ss");

        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }

    }

    @RequestMapping("checkUserinfo")
    public String checkUserinfo(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String state,Integer offset,Integer limit){
            JSONObject json=new JSONObject();
            try{
/*
                if (FirstCreateTime == null || FirstCreateTime.trim() == "") {
                    FirstCreateTime = "2018-8-30 00:00:00";

                }*/
                List<UserInfo> list=userInfoService.checkUserinfo(empNo,userNo,FirstCreateTime, LastCreateTime, status, state, offset, limit);
                int total=userInfoService.checkUserinfo(empNo,userNo,FirstCreateTime, LastCreateTime, status, state, null, null).size();

                json.put("rows",list);
                json.put("total",total);
                return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss",SerializerFeature.WriteMapNullValue);
            }catch (Exception e){
                e.printStackTrace();
                return JSON.toJSONString(json);
            }
    }

    @RequestMapping("checkDiscard")
    public String checkDiscard(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String state,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try{
            List<UserInfo> list=userInfoService.checkDiscard(empNo,userNo,FirstCreateTime, LastCreateTime, status, state, offset, limit);
            int total=userInfoService.checkDiscard(empNo,userNo,FirstCreateTime, LastCreateTime, status, state, null, null).size();

            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss",SerializerFeature.WriteMapNullValue);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("checkUserinfoByLoginTime")
    public String checkUserinfoByLoginTime(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String state,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try{
            List<UserInfo> list=userInfoService.checkUserinfoByLoginTime(empNo,userNo, status, state, offset, limit);
            int total=userInfoService.checkUserinfoByLoginTime(empNo,userNo, status, state, null, null).size();

            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss",SerializerFeature.WriteMapNullValue);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("userInfoDistribution")
    public String userInfoDistribution(String[] userNo,String empNo,String discard){
        JSONObject json=new JSONObject();
        try{
            for (int i = 0; i < userNo.length; i++) {
                UserInfo userInfo=new UserInfo();
                List<UserInfo> ars=userInfoService.getOne(userNo[i]);
                if(ars.size()==0){
                    userInfo.setUserNo(userNo[i]);
                    userInfoService.insertUserinfo(userInfo);
                    userInfo.setEmpNo(empNo);
                    userInfo.setDiscard(discard);
                    userInfo.setUpdateTime(new Date());
                    userInfoService.updateUserinfo(userInfo);
                }else {
                    userInfo.setUserNo(userNo[i]);
                    userInfo.setEmpNo(empNo);
                    userInfo.setDiscard(discard);
                    userInfo.setUpdateTime(new Date());
                    userInfoService.updateUserinfo(userInfo);
                }
            }

            json.put("result",true);
            json.put("message","操作成功");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","操作失败");
            return JSON.toJSONString(json);
        }
    }

}
