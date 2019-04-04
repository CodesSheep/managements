package com.lzq.managements.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.HuiFang;
import com.lzq.managements.service.HuiFangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("huifang")
public class HuiFangController {
    @Autowired
    private HuiFangService huiFangService;


    @RequestMapping("getAllHuiFang")
    public String getAllHuiFang(String empNo,String FirstCreateTime,String LastCreateTime,Integer offset,Integer limit){
        JSONObject json=new JSONObject();
        try {
            List<HuiFang> list =huiFangService.getAllHuiFang(empNo,FirstCreateTime,LastCreateTime,offset,limit);
            int total=huiFangService.getCount(empNo,FirstCreateTime,LastCreateTime);
            json.put("rows",list);
            json.put("total",total);
          return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }

}
