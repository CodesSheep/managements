package com.lzq.managements.controller.media;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.media.RedMediaPriceList;
import com.lzq.managements.service.media.RedMediaPriceListService;
import com.lzq.managements.util.ExcelData;
import com.lzq.managements.util.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("redbook")
public class RedMediaPriceListController {
    @Autowired
    private RedMediaPriceListService redMediaPriceListService;
    @Value("${spring.base.filePath}")
    private String uploadLocation;
    @Value("${spring.img.filePath}")
    private String imgLocation;

    @RequestMapping("getAllRedMediaPriceList")
    @Cacheable(value = "redbook", keyGenerator = "keyGenerator")
    public String getAllRedMediaPriceList(RedMediaPriceList redMediaPriceList,Integer page,Integer rows){
        JSONObject json=new JSONObject();
        try{
            List<RedMediaPriceList> list=redMediaPriceListService.getAllRedMediaPriceList(redMediaPriceList,page,rows);
            for (int i = 0; i <list.size(); i++) {
                RedMediaPriceList redbook=list.get(i);
                redbook.setImgURL(imgLocation+list.get(i).getImgURL());
            }
            int total=redMediaPriceListService.getAllRedMediaPriceList(redMediaPriceList,null,null).size();
            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }
    @RequestMapping("insertRedMediaPriceList")
    @CacheEvict(value = "redbookorder", allEntries = true)
    public String insertRedMediaPriceList(RedMediaPriceList redMediaPriceList){
        JSONObject json=new JSONObject();
        try {
            redMediaPriceListService.insertRedMediaPriceList(redMediaPriceList);
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

    @RequestMapping("updateRedMediaPriceList")
    @CacheEvict(value = "redbookorder", allEntries = true)
    public String updateRedMediaPriceList(RedMediaPriceList redMediaPriceList){
        JSONObject json=new JSONObject();
        try {
            redMediaPriceListService.updateRedMediaPriceList(redMediaPriceList);
            json.put("result",true);
            json.put("message","修改成功");
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result",false);
            json.put("message","修改失败");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("exportSelected")
    @Cacheable(value = "redbook", keyGenerator = "keyGenerator")
    public String exportSelected(String[] redMediaNos, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        try {
            if (redMediaNos == null || redMediaNos.length <= 0) {
                json.put("result", false);
                json.put("message", "请选中要导出的数据！");
                return JSON.toJSONString(json);
            }
            List<RedMediaPriceList> list = redMediaPriceListService.getRedMediaPriceListByNos(redMediaNos);

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

    private void export(HttpServletResponse response, List<RedMediaPriceList> list) throws Exception {



        ExcelData<RedMediaPriceList> ed = new ExcelData<>();
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
        subtitlelist.add("媒体名称");subtitlelist.add("行业");subtitlelist.add("地区");subtitlelist.add("粉丝量");subtitlelist.add("点赞量");
        subtitlelist.add("会员等级");subtitlelist.add("视频价格");subtitlelist.add("图文价格");subtitlelist.add("性别");
        subtitlelist.add("创建时间");subtitlelist.add("最近更新时间");
        titlelist.add(subtitlelist);
        ed.setTitlelist(titlelist);
        ed.setData(list);
        ed.setName("最新价格下载");
        List<String> headnums = new ArrayList<>();
        headnums.add("0,0,1,9");
        ed.setHeadnums(headnums);
        List<String> display = new ArrayList<>();
        display.add("redMediaName");display.add("redIndustryName");display.add("districtClassName");display.add("fansNum");
        display.add("praisePoints");display.add("vipLevelZN");display.add("videoPrice");display.add("graphicPrice");
        display.add("createTime");display.add("updateTime");
        ed.setDisplay(display);
        ed.setLinkFieldName("redMediaName");
        PoiUtils.exportExcel(response, "迅媒网-小红书资源表.xls", ed);
    }

    @RequestMapping("deletePriceList")
    @CacheEvict(value = "redbook", allEntries = true)
    public String deletePumpStation(String[] redMediaNos) {
        JSONObject json = new JSONObject();
        try {
            if (redMediaNos == null || redMediaNos.length == 0) {
                json.put("result", false);
                json.put("message", "请选中删除项！");
                return JSON.toJSONString(json);
            }
            redMediaPriceListService.deletePriceList(redMediaNos);
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
