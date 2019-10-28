package com.lzq.managements.controller.ghostwriting;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.ghostwriting.GhostWriting;
import com.lzq.managements.service.ghostwriting.GhostWritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ghostwriting")
public class GhostWritingController {
    @Autowired
    private GhostWritingService getAllGhostWriting;

    @RequestMapping("getAllGhostWriting")
    @Cacheable(value = "ghostwriting",keyGenerator = "keyGenerator")
    public String getAllGhostWriting(String empNo,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try{
            List<GhostWriting> list=getAllGhostWriting.getAllGhostWriting(empNo,offset,limit);
            int total=getAllGhostWriting.getAllGhostWriting(empNo,null,null).size();
            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("checkGhostWriting")
    @Cacheable(value = "ghostwriting",keyGenerator = "keyGenerator")
    public String checkGhostWriting(String empNo, String userNo,String title,String FirstCreateTime, String LastCreateTime, String state, Integer offset, Integer limit){
        JSONObject json=new JSONObject();
        try{
/*
                if (FirstCreateTime == null || FirstCreateTime.trim() == "") {
                    FirstCreateTime = "2018-8-30 00:00:00";

                }*/
            List<GhostWriting> list=getAllGhostWriting.checkGhostWriting(empNo,userNo,title,FirstCreateTime, LastCreateTime, state, offset, limit);
            int total=getAllGhostWriting.checkGhostWriting(empNo,userNo,title,FirstCreateTime, LastCreateTime, state, null, null).size();

            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }

   /* @RequestMapping("excel")*/




}
