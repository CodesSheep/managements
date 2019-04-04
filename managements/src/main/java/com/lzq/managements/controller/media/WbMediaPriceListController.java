package com.lzq.managements.controller.media;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.media.WbMediaPriceList;
import com.lzq.managements.service.media.WbMediaPriceListService;
import com.lzq.managements.util.ExcelData;
import com.lzq.managements.util.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("wb")
public class WbMediaPriceListController {
    @Autowired
    private WbMediaPriceListService wbMediaPriceListService;
    @RequestMapping("getAllWbMediaPriceList")
    @Cacheable(value = "wb", keyGenerator = "keyGenerator")
    public String getAllWbMediaPriceList(WbMediaPriceList wbMediaPriceList,Integer page,Integer rows){
        JSONObject json=new JSONObject();
        try {
            List<WbMediaPriceList> list=wbMediaPriceListService.getAllWbMediaPriceList(wbMediaPriceList,page,rows);
            int total=wbMediaPriceListService.getCount();
            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }


    @RequestMapping("insertWbMediaPriceList")
    @CacheEvict(value = "wb", allEntries = true)
    public String insertRedMediaPriceList(WbMediaPriceList wbMediaPriceList){
        JSONObject json=new JSONObject();
        try {
            wbMediaPriceListService.insertWbMediaPriceList(wbMediaPriceList);
            json.put("result",true);
            json.put("message","新增成功");
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result",false);
            json.put("message","新增失败");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("updateWbMediaPriceList")
    @CacheEvict(value = "wb", allEntries = true)
    public String updateRedMediaPriceList(WbMediaPriceList wbMediaPriceList){
        JSONObject json=new JSONObject();
        try {
            wbMediaPriceListService.updateWbMediaPriceList(wbMediaPriceList);
            json.put("result",true);
            json.put("message","修改成功");
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result",false);
            json.put("message","新增失败");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("exportSelected")
    @Cacheable(value = "wb", keyGenerator = "keyGenerator")
    public String exportSelected(String[] wbMediaNos, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        try {
            if (wbMediaNos == null || wbMediaNos.length <= 0) {
                json.put("result", false);
                json.put("message", "请选中要导出的数据！");
                return JSON.toJSONString(json);
            }
            List<WbMediaPriceList> list = wbMediaPriceListService.getWbMediaPriceListByNos(wbMediaNos);
            export(response, list);
            json.put("result", true);
            json.put("message", "导出成功！");
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result", false);
            json.put("message", "导出失败！");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("exportAll")
    public String exportAll(WbMediaPriceList wbMediaPriceList,HttpServletResponse response){
        JSONObject json=new JSONObject();
        try {
            List<WbMediaPriceList> list=wbMediaPriceListService.getAllWbMediaPriceList(wbMediaPriceList,null,null);
            export(response,list);
            json.put("result", true);
            json.put("message", "导出成功！");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result", false);
            json.put("message", "导出失败！");
            return JSON.toJSONString(json);
        }
    }

    private void export(HttpServletResponse response, List<WbMediaPriceList> list) throws Exception {

        ExcelData<WbMediaPriceList> ed = new ExcelData<>();
        //将logo图片放入工程的file/logo目录下，打开下面注释代码，替换图片名称，即可在导出的excel中加入logo图片
//            File file = new File("files/logo/5.jpg");
//            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
//            try {
//                ImageIO.write(ImageIO.read(file), "jpg", byteArrayOut);
//                ed.setLogo(byteArrayOut.toByteArray());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        ed.setTitle("迅媒网，软文发稿自助平台，官网：www.xm909.com");
        List<List<String>> titlelist = new ArrayList<>();
        List<String> subtitlelist = new ArrayList<>();
        subtitlelist.add("微博号");subtitlelist.add("微博名称");subtitlelist.add("头像");subtitlelist.add("每月平均阅读量");subtitlelist.add("行业");subtitlelist.add("账号认证");subtitlelist.add("类别");subtitlelist.add("地区");
        subtitlelist.add("描述");subtitlelist.add("备注");subtitlelist.add("硬广直发价格");subtitlelist.add("硬广直发价格更新时间");subtitlelist.add("硬广转发价格");subtitlelist.add("硬广转发价格更新价格");
        subtitlelist.add("软广直发价格");subtitlelist.add("软广直发价格更新价格");subtitlelist.add("软广转发价格");subtitlelist.add("软广转发价格更新价格");
        titlelist.add(subtitlelist);
        ed.setTitlelist(titlelist);
        ed.setData(list);
        ed.setName("最新价格下载");
        List<String> headnums = new ArrayList<>();
        headnums.add("0,0,1,9");
        ed.setHeadnums(headnums);
        List<String> display = new ArrayList<>();
        display.add("wbMediaNo");display.add("wbMediaName");display.add("imgURL");display.add("wbIndustryName");display.add("authentication");
        display.add("avgReadMonthly");display.add("classInfomation");display.add("districtClassName");display.add("represent");display.add("remark");
        display.add("hardStraightPrice");display.add("hardStraightUpdateTime");display.add("hardForwardingPrice");display.add("hardForwardingUpdateTime");
        display.add("softStraightPrice");display.add("softStraightUpdateTime");display.add("softForwardingPrice");display.add("softForwardingUpdateTime");
        ed.setDisplay(display);
        PoiUtils.exportExcel(response, "迅媒网-微博资源表.xls", ed);
    }

    @RequestMapping("deletePriceList")
    @CacheEvict(value = "wb", allEntries = true)
    public String deletePumpStation(String[] wbMediaNos) {
        JSONObject json = new JSONObject();
        try {
            if (wbMediaNos == null || wbMediaNos.length == 0) {
                json.put("result", false);
                json.put("message", "请选中删除项！");
                return JSON.toJSONString(json);
            }
            wbMediaPriceListService.deletePriceList(wbMediaNos);
            json.put("result", true);
            json.put("message", "删除成功！");
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result", false);
            json.put("message", "删除失败！");
            return JSON.toJSONString(json);
        }
    }
}
