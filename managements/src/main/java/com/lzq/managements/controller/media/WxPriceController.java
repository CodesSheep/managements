package com.lzq.managements.controller.media;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.media.WxMediaPriceList;
import com.lzq.managements.service.media.WxMediaPriceListService;
import com.lzq.managements.util.ExcelData;
import com.lzq.managements.util.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("wxpricelist")
public class WxPriceController {

    @Autowired
    private WxMediaPriceListService wxMediaPriceListService;

    @Value("${spring.img.filePath}")
    private String imgLocation;

    @RequestMapping("getAllWxMediaPriceList")
    @Cacheable(value = "wxprice",keyGenerator = "keyGenerator")
    public String getAllWxMediaPriceList(WxMediaPriceList wxMediaPriceList, Integer page, Integer rows){
        JSONObject json = new JSONObject();
        try {
            List<WxMediaPriceList> list = wxMediaPriceListService.getAllWxMediaPriceList(wxMediaPriceList,page,rows);
            for (int i = 0; i <list.size(); i++) {
                WxMediaPriceList wx=list.get(i);
                wx.setImgURL(imgLocation+list.get(i).getImgURL());
            }
            int total = wxMediaPriceListService.getCount();
            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("export")
    @Cacheable(value = "wxprice", keyGenerator = "keyGenerator")
    public String exportSelect(WxMediaPriceList wxMediaPriceList, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        try {

            List<WxMediaPriceList> list = wxMediaPriceListService.getAllWxMediaPriceList(wxMediaPriceList,null,null);
            export( list,response);
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

    @RequestMapping("exportSelected")
    @Cacheable(value = "wxprice", keyGenerator = "keyGenerator")
    public String exportSelected(String[] zmtNos, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        try {
            if (zmtNos == null || zmtNos.length <= 0) {
                json.put("result", false);
                json.put("message", "请选中要导出的数据！");
                return JSON.toJSONString(json);
            }
            List<WxMediaPriceList> list = wxMediaPriceListService.getWxMediaPriceListByNos(zmtNos);
            export( list,response);
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


   private void export(List<WxMediaPriceList> list,HttpServletResponse response) throws Exception {

            ExcelData<WxMediaPriceList> ed = new ExcelData<>();
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
            subtitlelist.add("微信媒体名称");subtitlelist.add("微信号");subtitlelist.add("粉丝量");subtitlelist.add("类别");subtitlelist.add("地区");subtitlelist.add("头条价格");subtitlelist.add("非头条价格");
            subtitlelist.add("尾条价格");subtitlelist.add("发稿间隔时长(天)");
            titlelist.add(subtitlelist);
            ed.setTitlelist(titlelist);
            ed.setData(list);
            ed.setName("最新价格下载");
            List<String> headnums = new ArrayList<>();
            headnums.add("0,0,1,9");
            ed.setHeadnums(headnums);
            List<String> display = new ArrayList<>();
            display.add("wxName");display.add("wxNo");display.add("fansNum");display.add("wxIndustryName");display.add("districtClassName");display.add("headlinePrice");display.add("noHeadlinePrice");display.add("tailPrice");
            display.add("dispatchInterval");
            ed.setDisplay(display);
            PoiUtils.exportExcel(response, "迅媒网-微信资源表.xls", ed);
        }
    @RequestMapping("insertWxMediaPriceList")
    @CacheEvict(value = "wxprice",allEntries = true)
    public String insertWXPricelist( MultipartFile file,WxMediaPriceList wxMediaPriceList){
        JSONObject json = new JSONObject();
        try {
            if (file == null || file.isEmpty()){
                json.put("result",false);
                json.put("message","请选择图片");
                return JSON.toJSONString(json);
            }
            wxMediaPriceListService.insertWxMediaPriceList(file,wxMediaPriceList);
            json.put("result",true);
            json.put("message","新增成功！");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","新增失敗！");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("updateWXPricelist")
    @CacheEvict(value = "wxprice",allEntries = true)
    public String updateWXPricelist(WxMediaPriceList wxPricelist){
        JSONObject json = new JSONObject();
        try {
            wxMediaPriceListService.updateWxMediaPriceList(wxPricelist);
            json.put("result",true);
            json.put("message","修改成功！");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","修改失敗！");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("deletePriceList")
    @CacheEvict(value = "wxprice", allEntries = true)
    public String deletePumpStation(String[] wxMediaNos) {
        JSONObject json = new JSONObject();
        try {
            if (wxMediaNos == null || wxMediaNos.length == 0) {
                json.put("result", false);
                json.put("message", "请选中删除项！");
                return JSON.toJSONString(json);
            }
            wxMediaPriceListService.deletePriceList(wxMediaNos);
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
