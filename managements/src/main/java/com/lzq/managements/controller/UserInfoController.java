package com.lzq.managements.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lzq.managements.entity.Feedback;
import com.lzq.managements.entity.HuiFang;
import com.lzq.managements.entity.User;
import com.lzq.managements.entity.UserInfo;
import com.lzq.managements.entity.emp.EmpEntity;
import com.lzq.managements.service.FeedbackService;
import com.lzq.managements.service.HuiFangService;
import com.lzq.managements.service.UserInfoService;
import com.lzq.managements.service.UserService;
import com.lzq.managements.service.emp.EmpService;
import com.lzq.managements.util.StringUtils;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Autowired
    private UserService userService;
    @Autowired
    private HuiFangService huiFangService;

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
                userInfo.setLocking("0");
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
    public String getAllUserInfoByloginTime(String empNo,String Time, Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try {
            List<UserInfo> list = userInfoService.getAllUserInfoByloginTime(empNo,Time,offset, limit);
            int total = userInfoService.getAllUserInfoByloginTime(empNo,Time,null, null).size();
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
            if(!userInfo.getFeedback().equals("") && userInfo.getFeedback() !=null ){
                Feedback feedback=new Feedback();
                feedback.setUserNo(userInfo.getUserNo());
                feedback.setEmpName(userInfo.getEmpName());
                feedback.setFeedback(userInfo.getFeedback());
                feedbackService.insertFeedback(feedback);
                String empNo=empService.selectEmpByempName(userInfo.getEmpName());
                insert(empNo,userInfo.getUserNo());

                userInfoService.updateUser(userInfo);
                if(userInfo.getDiscard().equals("1")){
                    feedbackService.deleteFeedback(userInfo.getUserNo());
                    userInfo.setFeedback("调库");
                }
                userInfoService.updateUserinfo(userInfo);
            }
            else{
                Feedback feedback=feedbackService.selectFeedbackBycreateTime(userInfo.getUserNo());
                if(feedback!=null){
                    userInfo.setFeedback(feedback.getFeedback());
                }

                userInfoService.updateUser(userInfo);

                if(userInfo.getDiscard().equals("1")){
                    feedbackService.deleteFeedback(userInfo.getUserNo());
                    userInfo.setFeedback("调库");
                }
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
    public String checkUserinfo(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String qqAccount,String state,Integer offset,Integer limit){
            JSONObject json=new JSONObject();
            try{
/*
                if (FirstCreateTime == null || FirstCreateTime.trim() == "") {
                    FirstCreateTime = "2018-8-30 00:00:00";

                }*/
                List<UserInfo> list=userInfoService.checkUserinfo(empNo,userNo,FirstCreateTime, LastCreateTime, status,qqAccount, state, offset, limit);
                int total=userInfoService.checkUserinfo(empNo,userNo,FirstCreateTime, LastCreateTime, status,qqAccount, state, null, null).size();

                json.put("rows",list);
                json.put("total",total);
                return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss",SerializerFeature.WriteMapNullValue);
            }catch (Exception e){
                e.printStackTrace();
                return JSON.toJSONString(json);
            }
    }

    @RequestMapping("checkDiscard")
    public String checkDiscard(String empNo,String userNo,String FirstCreateTime,String LastCreateTime,Integer status,String qqAccount,String state,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try{
            List<UserInfo> list=userInfoService.checkDiscard(empNo,userNo,FirstCreateTime, LastCreateTime, status,qqAccount, state, offset, limit);
            int total=userInfoService.checkDiscard(empNo,userNo,FirstCreateTime, LastCreateTime, status,qqAccount, state, null, null).size();

            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss",SerializerFeature.WriteMapNullValue);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("checkUserinfoByLoginTime")
    public String checkUserinfoByLoginTime(String empNo,String userNo,String Time,Integer status,String qqAccount,String state,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try{
            List<UserInfo> list=userInfoService.checkUserinfoByLoginTime(empNo,userNo,Time,status,qqAccount, state, offset, limit);
            int total=userInfoService.checkUserinfoByLoginTime(empNo,userNo,Time, status,qqAccount, state, null, null).size();

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
                    userInfo.setLocking("0");
                    userInfo.setRemark(" ");
                    userInfoService.insertUserinfo(userInfo);
                    userInfo.setEmpNo(empNo);
                    userInfo.setDiscard(discard);
                    userInfo.setAdjustTime(new Date());

                    if(discard.equals("1")){
                        feedbackService.deleteFeedback(userNo[i]);
                        userInfo.setFeedback("调库");
                    }
                    userInfoService.updateUserinfo(userInfo);
                }else {
                    userInfo.setUserNo(userNo[i]);
                    userInfo.setEmpNo(empNo);
                    userInfo.setDiscard(discard);
                    userInfo.setLocking("0");
                    userInfo.setRemark(" ");
                    userInfo.setAdjustTime(new Date());
                    if(discard.equals("1")){
                        feedbackService.deleteFeedback(userNo[i]);
                        userInfo.setFeedback("调库");
                    }
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

    @RequestMapping("insertUser")
    public String insertUser(User user){
        JSONObject json = new JSONObject();
        try {
            if (user.getPhoneNo() == null || user.getPhoneNo().trim() == "" || !StringUtils.rightPhoneNoPattern(user.getPhoneNo())){
                json.put("result",false);
                json.put("message","请输入正确的手机号！");
                return JSON.toJSONString(json);
            }
            User finduser = userService.findByUserNo(user.getUserNo());
            if (finduser != null){
                json.put("result",false);
                json.put("message","该用户已存在");
                return JSON.toJSONString(json);
            }
            int rows = userService.insertUser(user);
            if (rows > 0){
                json.put("result",true);
                json.put("message","新增成功");
                return JSON.toJSONString(json);
            }
            json.put("result",false);
            json.put("message","新增失败");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","新增失败");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("updateUser")
    public String updateUser(User user){
        JSONObject json = new JSONObject();
        try {

            userService.updateUser(user);

            json.put("result",true);
            json.put("message","修改成功");
            return JSON.toJSONString(json);


        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","修改失败");
            return JSON.toJSONString(json);
        }
    }



        /**每分钟启动
         *cron运行顺序：   秒 分 时 月 天 星期 年（可空）
         * 每天的8点50和19点50进行定时任务
          * */
        @Scheduled(cron = "0 37 9,19 * * ?")
        //@Scheduled(cron = "0 0/1 *  * * ?")
        public void timerToNow(){
            List<UserInfo> oldTime=userInfoService.getUpdateTime();
            for (int i = 0; i < oldTime.size(); i++) {
                Date state =oldTime.get(i).getUpdateTime();
                Date end  =new Date();
                long stateTimeLong = state.getTime();
                long endTimeLong = end.getTime();
                long day = (endTimeLong-stateTimeLong)/(24*60*60*1000);
                if (day>30){
                    UserInfo userInfo=new UserInfo();
                    userInfo.setUserNo(oldTime.get(i).getUserNo());
                    userInfo.setDiscard("1");
                    userInfo.setFeedback("超时自动调库");
                    userInfo.setAdjustTime(new Date());
                    feedbackService.deleteFeedback(oldTime.get(i).getUserNo());
                    userInfoService.updateUserinfo(userInfo);
                   //* System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                }
            }
        }


    /**
     * create by: lzq
     * description: TODO
     * create time: 2019-03-05 15:11
     *
      * @Param: userNo
     * @return java.lang.String
     */
    @RequestMapping("getLocking")
    public String getLocking(String[] userNo,String empNo){
            JSONObject json=new JSONObject();
            try{
                int a =userInfoService.getLocking(empNo);
                if (a>50){
                    json.put("result",false);
                    json.put("message","超额锁库");
                    return JSON.toJSONString(json);
                }
                for (int i = 0; i <userNo.length; i++) {
                    UserInfo userInfo=new UserInfo();
                    userInfo.setUserNo(userNo[i]);
                    userInfo.setLocking("1");
                    userInfo.setEmpNo(empNo);
                    userInfoService.updateUserinfo(userInfo);
                }
                json.put("result",true);
                json.put("message","锁库成功");
                return JSON.toJSONString(json);
            }catch (Exception e){
                e.printStackTrace();
                return JSON.toJSONString(json);
            }
    }

    @RequestMapping("getUnLocking")
    public String getUnLocking(String[] userNo,String empNo){
        JSONObject json=new JSONObject();
        try{
            for (int i = 0; i <userNo.length; i++) {
                UserInfo userInfo=new UserInfo();
                userInfo.setUserNo(userNo[i]);
                userInfo.setLocking("0");
                userInfo.setEmpNo(empNo);
                userInfoService.updateUserinfo(userInfo);
            }
            json.put("result",true);
            json.put("message","解库成功");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }


    private void insert(String empNo,String userNo){
        String FirstCreateTime=new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(new Date());
        List<HuiFang> ar=huiFangService.getAllHuiFang(empNo,FirstCreateTime,null,null,null);
        HuiFang huiFang=new HuiFang();
        if(ar.size()==0){
            User u=userService.findUser(empNo);
            huiFang.setAlreadyCooperateNumber(u.getAlreadyCooperateNumber());
            huiFang.setAllCustomerNumber(u.getAllCustomerNumber());
            huiFang.setNoCooperate(u.getNoCooperateNumber());
            huiFang.setEmpNo(empNo);
            huiFangService.insertHuiFang(huiFang);
            List<HuiFang> ars=huiFangService.getAllHuiFang(empNo,FirstCreateTime,null,null,null);
            for (int i = 0; i <ars.size(); i++) {
                huiFang=ars.get(i);
            }
        }
        else{
            for (int i = 0; i < ar.size(); i++) {
                huiFang = ar.get(i);
            }
        }
        List<User> arlist=userService.checkUser(userNo,null,null,null,null,null,null);
            for (int i = 0; i < arlist.size(); i++) {
                User userinfo=arlist.get(i);
                if (userinfo.getStatus()==1){
                    huiFang.setAlreadyCooperate(huiFang.getAlreadyCooperate()+1);
                }
                if (userinfo.getStatus()==0){
                    huiFang.setNoCooperate(huiFang.getNoCooperate()+1);
                }
                huiFang.setHuiFangNumber(huiFang.getHuiFangNumber()+1);
                huiFang.setHuiFangTime(new Date());
                huiFang.setFirstCreateTime(FirstCreateTime);
                User u=userService.findUser(empNo);
                huiFang.setAlreadyCooperateNumber(u.getAlreadyCooperateNumber());
                huiFang.setAllCustomerNumber(u.getAllCustomerNumber());
                huiFang.setNoCooperateNumber(u.getNoCooperateNumber());
                huiFangService.updateHuiFang(huiFang);

        }

    }
    @RequestMapping("test")
    public String delete(String userNo,String empNo){
        JSONObject json=new JSONObject();
        List<HuiFang> ar=huiFangService.getAllHuiFang(empNo,null,null,null,null);

        json.put("rows",ar);

        return JSON.toJSONString(json);

    }

}
