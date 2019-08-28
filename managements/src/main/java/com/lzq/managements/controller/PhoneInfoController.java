package com.lzq.managements.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lzq.managements.entity.PhoneInfo;
import com.lzq.managements.entity.emp.EmpEntity;
import com.lzq.managements.service.PhoneInfoService;
import com.lzq.managements.service.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/***
 *      ┌─┐       ┌─┐
 *   ┌──┘ ┴───────┘ ┴──┐
 *   │                 │
 *   │       ───       │
 *   │  ─┬┘       └┬─  │
 *   │                 │
 *   │       ─┴─       │
 *   │                 │
 *   └───┐         ┌───┘
 *       │         │
 *       │         │
 *       │         │
 *       │         └──────────────┐
 *       │                        │
 *       │                        ├─┐
 *       │                        ┌─┘
 *       │                        │
 *       └─┐  ┐  ┌───────┬──┐  ┌──┘
 *         │ ─┤ ─┤       │ ─┤ ─┤
 *         └──┴──┘       └──┴──┘
 *                神兽保佑
 *               代码无BUG!
 *
 *@program: managements
 *@description: lzq
 *@author: 手机端管理
 *@create: 2019-06-03 11:22
 */
@RestController
@RequestMapping("phoneinfo")
public class PhoneInfoController {
    @Autowired
    private PhoneInfoService phoneInfoService;
    @Autowired
    private EmpService empService;

    @RequestMapping("checkPhoneInfo")
    @Cacheable(value = "phoneinfo",keyGenerator = "keyGenerator")
    public String checkPhoneInfo( String phoneNo, String empNo,String qqAccount, String FirstTime, String LastTime,String HZstate,String YXstate, String state, Integer offset, Integer limit){
        JSONObject json=new JSONObject();
        try {
            if (FirstTime == null || FirstTime.trim() == "") {
                FirstTime = "2018-8-30 00:00:00";

            }
            List<PhoneInfo> checkPhoneInfo= phoneInfoService.checkPhoneInfo(phoneNo,empNo,qqAccount,FirstTime,LastTime,HZstate,YXstate,state,offset,limit);
            int total =phoneInfoService.getCount(phoneNo,empNo,qqAccount,FirstTime,LastTime,HZstate,YXstate,state);
            json.put("rows",checkPhoneInfo);
            json.put("total",total);
            return JSON.toJSONString(json, SerializerFeature.WriteMapNullValue);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(e);
        }
    }

    /***
     *                    _ooOoo_
     *                   o8888888o
     *                   88" . "88
     *                   (| -_- |)
     *                    O\ = /O
     *                ____/`---'\____
     *              .   ' \\| |// `.
     *               / \\||| : |||// \
     *             / _||||| -:- |||||- \
     *               | | \\\ - /// | |
     *             | \_| ''\---/'' | |
     *              \ .-\__ `-` ___/-. /
     *           ___`. .' /--.--\ `. . __
     *        ."" '< `.___\_<|>_/___.' >'"".
     *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
     *         \ \ `-. \_ __\ /__ _/ .-` / /
     * ======`-.____`-.___\_____/___.-`____.-'======
     *                    `=---='
     *
     * .............................................
     *          佛祖保佑             永无BUG
     *
     *create by: lzq
     * description:
     * create time: 2019-06-03 14:48
     *
      * @author: 分配信息
     *
     */
    @RequestMapping("distributionPhoneInfo")
    @CacheEvict(value = "phoneinfo",allEntries = true)
    public String distributionPhoneInfo(String phoneNo, String empNo){
        JSONObject json=new JSONObject();
        try {
            List<PhoneInfo> ar=phoneInfoService.getPhoneInfo(phoneNo);
           if(ar.size() ==0){
               PhoneInfo p=new PhoneInfo();
               p.setPhoneNo(phoneNo);
               phoneInfoService.insertPhoneInfo(p);
            }
            PhoneInfo phone=new PhoneInfo();
            phone.setPhoneNo(phoneNo);
            phone.setEmpNo(empNo);
            phone.setUpdateTime(new Date());
            phone.setDiscard("0");
            phoneInfoService.updatePhoneInfo(phone);
            json.put("result",true);
            json.put("message","修改成功！");
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result",false);
            json.put("message","修改失败！");
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("updatePhoneInfo")
    @CacheEvict(value = "phoneinfo",allEntries = true)
    public String updatePhoneInfo(PhoneInfo phoneInfo){
        JSONObject json=new JSONObject();
        try {
            phoneInfo.setUpdateTime(new Date());
            phoneInfoService.updatePhone(phoneInfo);
            phoneInfoService.updatePhoneInfo(phoneInfo);
           json.put("result",true);
           json.put("message","修改成功！");
           return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result",false);
            json.put("message","修改失败！");
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("getOneByphoneNo")
    @Cacheable(value = "phoneinfo",keyGenerator = "keyGenerator")
    public String getOneByphoneNo(String phoneNo,String teamNo){
       JSONObject json = new JSONObject();
        try {
            List<PhoneInfo> arrs=phoneInfoService.getPhoneInfo(phoneNo);
            if(arrs.size() ==0){
                PhoneInfo p=new PhoneInfo();
                p.setPhoneNo(phoneNo);
                phoneInfoService.insertPhoneInfo(p);
            }
            List<EmpEntity> ar= empService.selectEmpByteamNo(teamNo);
            json.put("ar",ar);
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result",false);
            json.put("message","查询失败！");
            return JSON.toJSONString(json);
        }
    }



}
