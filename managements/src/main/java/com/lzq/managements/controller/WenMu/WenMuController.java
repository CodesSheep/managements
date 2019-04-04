package com.lzq.managements.controller.WenMu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.WenMu.WenMu;
import com.lzq.managements.service.WenMu.WenMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wenmu")
public class WenMuController {
    @Autowired
    private WenMuService wenMuService;

    @RequestMapping("getAllWenMu")
    @Cacheable(value = "wenmu",keyGenerator = "keyGenerator")
    public String getAllWenMu(String userNo,String qqAccount,String FirstCreateTime,String LastCreateTime,Integer status,Integer page,Integer rows){
        JSONObject json=new JSONObject();
        try {
            List<WenMu> list=wenMuService.getAllWenMu(userNo,qqAccount,FirstCreateTime,LastCreateTime,status,page,rows);
            int total=wenMuService.getAllWenMu(userNo,qqAccount,FirstCreateTime,LastCreateTime,status,null,null).size();
            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            return  JSON.toJSONString(json);
        }
    }

}
