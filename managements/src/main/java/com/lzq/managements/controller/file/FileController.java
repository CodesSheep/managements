package com.lzq.managements.controller.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.file.FileEntity;
import com.lzq.managements.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping("getAllFile")
    @Cacheable(value = "file",keyGenerator = "keyGenerator")
    public String getAllFile(String empNo,Integer offset, Integer limit){
        JSONObject json =new JSONObject();
        try{
            List<FileEntity> list =fileService.getAllFile(empNo,offset,limit);
            int total=fileService.checkCount(empNo,null,null,null, null, null);
            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }

    }


    @RequestMapping("checkFile")
    @Cacheable(value = "file",keyGenerator = "keyGenerator")
    public String checkUserinfo(String empNo, String userNo,String fileName,String FirstCreateTime, String LastCreateTime, String fileState, Integer offset, Integer limit){
        JSONObject json=new JSONObject();
        try{
            List<FileEntity> list=fileService.checkFile(empNo,userNo,fileName,FirstCreateTime, LastCreateTime, fileState, offset, limit);
            int total=fileService.checkCount(empNo,userNo,fileName,FirstCreateTime, LastCreateTime, fileState);

            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONStringWithDateFormat(json,"yy-MM-dd HH:mm:ss");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }
}
