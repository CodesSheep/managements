package com.lzq.managements.controller.newsorder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.newsorder.NewsOrder;
import com.lzq.managements.service.newsorder.NewsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("newsorder")
public class NewsOrderController {
    @Autowired
    private NewsOrderService newsOrderService;

    @RequestMapping("getAllNewsOrder")
    public String getAllNewsOrder(String empNo,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try{
            List<NewsOrder> list=newsOrderService.getAllNewsOrder(empNo,offset,limit);
            int total=newsOrderService.getAllNewsOrder(empNo,null,null).size();
            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("checkNewsOrder")
    public String checkNewsOrder(String empNo, String userNo,String mediaName,String FirstCreateTime, String LastCreateTime, String state, Integer offset, Integer limit){
        JSONObject json=new JSONObject();
        try{
/*
                if (FirstCreateTime == null || FirstCreateTime.trim() == "") {
                    FirstCreateTime = "2018-8-30 00:00:00";

                }*/
            List<NewsOrder> list=newsOrderService.checkNewsOrder(empNo,userNo,mediaName,FirstCreateTime, LastCreateTime, state, offset, limit);
            int total=newsOrderService.checkNewsOrder(empNo,userNo,mediaName,FirstCreateTime, LastCreateTime, state, null, null).size();

            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }
}
