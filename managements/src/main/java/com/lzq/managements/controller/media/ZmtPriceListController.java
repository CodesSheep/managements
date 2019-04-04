package com.lzq.managements.controller.media;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.lzq.managements.entity.media.mediaPrice.DistrictClass;
import com.lzq.managements.entity.media.zmtPriceList.*;
import com.lzq.managements.service.media.mediaPrice.DistrictClassService;
import com.lzq.managements.service.media.zmtPriceList.*;
import com.lzq.managements.util.BigdecimalValueFilter;
import com.lzq.managements.util.ExcelData;
import com.lzq.managements.util.PoiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("zmt")
public class ZmtPriceListController {
    @Autowired
    private ZmtPriceListService zmtPriceListService;
    @Autowired
    private ZmtIndustryService zmtIndustryService;
    @Autowired
    private PlatFormService platFormService;
    @Autowired
    private ReferenceFansService referenceFansService;
    @Autowired
    private ReferenceReadService referenceReadService;
    @Autowired
    private DistrictClassService districtClassService;
    @Autowired
    private ZmtPriceClassificationService zmtPriceClassificationService;

    @RequestMapping("getAllCondition")
    @Cacheable(value = "zmtCondition", keyGenerator = "keyGenerator")
    public String getAllCondition(){
        Map<String,Object> map=new HashMap<>();
        try{
            List<ZmtIndustry> zmtIndustrieslist=zmtIndustryService.getAllZmtIndustry(null,null);
            List<PlatForm> platFormslist=platFormService.getAllPlatForms(null,null);
            List<ReferenceFans> referenceFanslist=referenceFansService.getAllReferenceFans(null,null);
            List<ReferenceRead> referenceReadlist=referenceReadService.getAllReferenceReads(null,null);
            List<DistrictClass> dislist = districtClassService.listDistrictClass(null, null);
            List<ZmtPriceClassification> zmtPriceClassificationslist=zmtPriceClassificationService.getAllZmtPriceClassification(null,null);
            map.put("zmtIndustrieslist",zmtIndustrieslist);
            map.put("platFormslist",platFormslist);
            map.put("referenceFanslist",referenceFanslist);
            map.put("referenceReadlist",referenceReadlist);
            map.put("dislist",dislist);
            map.put("zmtPriceClassificationslist",zmtPriceClassificationslist);
            return JSON.toJSONString(map);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(null);
        }
    }
    @RequestMapping("getAllZmtPriceList")
    @Cacheable(value = "zmtpricelist", keyGenerator = "keyGenerator")
    public String  getAllZmtPriceList(ZmtPriceList zmtPriceList){
        JSONObject json=new JSONObject();
        try{
            List<ZmtPriceList> list=zmtPriceListService.getAllZmtPriceList(zmtPriceList);
            int total=zmtPriceListService.getCount();
            json.put("rows",list);
            json.put("total",total);
            return JSON.toJSONString(json,new BigdecimalValueFilter(0, BigDecimal.ROUND_HALF_DOWN));
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("insertZmtPriceList")
    @CacheEvict(value = "zmtpricelist", allEntries = true)
    public String insertZmtPriceList(ZmtPriceList zmtPriceList){
        JSONObject json=new JSONObject();
        try{
            zmtPriceListService.insertZmtPriceList(zmtPriceList);
            json.put("result",true);
            json.put("message","新增成功");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","新增失败");
            return JSON.toJSONString(json);
        }

    }
    @RequestMapping("updateZmtPriceList")
    @CacheEvict(value = "zmtpricelist", allEntries = true)
    public String updateZmtPriceList(ZmtPriceList zmtPriceList){
        JSONObject json=new JSONObject();
        try{
            zmtPriceListService.updateZmtPriceList(zmtPriceList);
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

    @RequestMapping("exportExcel")
    @Cacheable(value = "zmtpricelist", keyGenerator = "keyGenerator")
    public void exportExcel(ZmtPriceList zmtPriceList, HttpServletResponse response){
        try {
            List<ZmtPriceList> list = zmtPriceListService.getAllZmtPriceList(zmtPriceList);
            /*for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }*/
            export(response, list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("exportSelected")
    @Cacheable(value = "zmtpricelist", keyGenerator = "keyGenerator")
    public String exportSelected(String[] zmtNos,HttpServletResponse response) {
        JSONObject json = new JSONObject();
        try {
            if (zmtNos == null || zmtNos.length <= 0) {
                json.put("result", false);
                json.put("message", "请选中要导出的数据！");
                return JSON.toJSONString(json);
            }
            List<ZmtPriceList> list = zmtPriceListService.getZmtPriceListByNos(zmtNos);
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
    @RequestMapping("getZmtPriceListByNos")
    public String getZmtPriceListByNos(String[] zmtNos,HttpServletResponse response){
        JSONObject json = new JSONObject();
        try {
            List<ZmtPriceList> list = zmtPriceListService.getZmtPriceListByNos(zmtNos);
            int total=zmtPriceListService.getZmtPriceListByNos(zmtNos).size();
            json.put("rows", list);
            json.put("total",total);
            return JSON.toJSONString(json);
        }catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }


        private void export(HttpServletResponse response, List<ZmtPriceList> list) throws Exception {

        ExcelData<ZmtPriceList> ed = new ExcelData<>();
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
        subtitlelist.add("自媒体名称");subtitlelist.add("平台");subtitlelist.add("行业");subtitlelist.add("地区");subtitlelist.add("黄金会员");subtitlelist.add("白银会员");
        subtitlelist.add("普通会员");subtitlelist.add("市场价");subtitlelist.add("阅读量");subtitlelist.add("粉丝量");
        subtitlelist.add("备注");subtitlelist.add("自媒体链接");subtitlelist.add("个人链接");
        titlelist.add(subtitlelist);
        ed.setTitlelist(titlelist);
        ed.setData(list);
        ed.setName("最新价格下载");
        List<String> headnums = new ArrayList<>();
        headnums.add("0,0,1,9");
        ed.setHeadnums(headnums);
        List<String> display = new ArrayList<>();
        display.add("zmtName");display.add("platformName");display.add("industryName");display.add("advancedPrice");display.add("ordinaryPrice");
        display.add("ordinaryVipPrice");display.add("retailPrice");display.add("districtClassName");display.add("referencefanstype");
        display.add("referencereadtype");display.add("remark");display.add("zmtURL");display.add("zmtpersonURL");
        ed.setDisplay(display);
        ed.setLinkFieldName("zmtName");
        ed.setUrlFieldName("zmtURL");
        PoiUtils.exportExcel(response, "迅媒网-新闻资源表.xls", ed);
    }

    @RequestMapping("deletePriceList")
    @CacheEvict(value = "zmtpricelist", allEntries = true)
    public String deletePumpStation(String[] zmtNos) {
        JSONObject json = new JSONObject();
        try {
            if (zmtNos == null || zmtNos.length == 0) {
                json.put("result", false);
                json.put("message", "请选中删除项！");
                return JSON.toJSONString(json);
            }
            zmtPriceListService.deletePriceList(zmtNos);
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
