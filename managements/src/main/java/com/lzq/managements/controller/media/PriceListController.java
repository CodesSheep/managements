package com.lzq.managements.controller.media;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.managements.entity.media.mediaPrice.*;
import com.lzq.managements.service.media.mediaPrice.*;
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

/**
 * Created by Administrator on 2018/8/18.
 */
@RestController
@RequestMapping("price")
public class PriceListController {

    @Autowired
    private PriceListService priceListService;
    @Autowired
    private AdvertisingTypeService advertisingTypeService;
    @Autowired
    private ContactInformationService contactInformationService;
    @Autowired
    private DistrictClassService districtClassService;
    @Autowired
    private IndustryTypeService industryTypeService;
    @Autowired
    private IntegratedPortalService integratedPortalService;
    @Autowired
    private MediaTypeService mediaTypeService;
    @Autowired
    private NewsFeedService newsFeedService;
    @Autowired
    private PriceCategoryService priceCategoryService;


    @RequestMapping("getAllCondition")
    @Cacheable(value = "mediaCondition", keyGenerator = "keyGenerator")
    public String getAllCondition() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<AdvertisingType> advlist = advertisingTypeService.listAdvertisingType(null, null);
            List<ContactInformation> conlist = contactInformationService.listContactInformation(null, null);
            List<DistrictClass> dislist = districtClassService.listDistrictClass(null, null);
            List<IndustryType> indlist = industryTypeService.listIndustryType(null, null);
            List<IntegratedPortal> intlist = integratedPortalService.listIntegratedPortal(null, null);
            List<MediaType> medlist = mediaTypeService.listMediaType(null, null);
            List<NewsFeed> newlist = newsFeedService.listNewsFeed(null, null);
            List<PriceCategory> prilist = priceCategoryService.listPriceCategory(null, null);
            map.put("advlist", advlist);
            map.put("conlist", conlist);
            map.put("dislist", dislist);
            map.put("indlist", indlist);
            map.put("intlist", intlist);
            map.put("medlist", medlist);
            map.put("newlist", newlist);
            map.put("prilist", prilist);
            return JSON.toJSONString(map);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(null);
        }
    }

    @RequestMapping("listPriceList")
    @Cacheable(value = "mediaprice", keyGenerator = "keyGenerator")
    public String listPriceList(PriceList priceList) {
        JSONObject json = new JSONObject();
        try {
            List<PriceList> list = priceListService.listPriceList(priceList);
            int total = priceListService.getCount(priceList);
            json.put("rows", list);
            json.put("total", total);
            BigdecimalValueFilter filter = new BigdecimalValueFilter(0,  BigDecimal.ROUND_HALF_DOWN);
            return JSON.toJSONString(json, filter);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("insertPriceList")
    @CacheEvict(value = "mediaprice", allEntries = true)
    public String insertPriceList(PriceList priceList) {
        JSONObject json = new JSONObject();
        try {
            priceListService.insertPriceList(priceList);
            json.put("result", true);
            json.put("message", "新增成功！");
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result", false);
            json.put("message", "新增失败！");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("updatePriceList")
    @CacheEvict(value = "mediaprice", allEntries = true)
    public String updatePriceList(PriceList priceList) {
        JSONObject json = new JSONObject();
        try {
            priceListService.updatePriceList(priceList);
            json.put("result", true);
            json.put("message", "修改成功！");
            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("result", false);
            json.put("message", "修改失败！");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("deletePriceList")
    @CacheEvict(value = "mediaprice", allEntries = true)
    public String deletePumpStation(String[] mediaNos) {
        JSONObject json = new JSONObject();
        try {
            if (mediaNos == null || mediaNos.length == 0) {
                json.put("result", false);
                json.put("message", "请选中删除项！");
                return JSON.toJSONString(json);
            }
            priceListService.deletePriceList(mediaNos);
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


    @RequestMapping("exportSelected")
    @Cacheable(value = "mediaprice",keyGenerator = "keyGenerator")
    public String exportSelected(String[] mediaNos,HttpServletResponse response){
        JSONObject json=new JSONObject();
        try {
            if (mediaNos == null || mediaNos.length <= 0){
                json.put("result",false);
                json.put("message","请选中要导出的数据！");
                return JSON.toJSONString(json);
            }
            List<PriceList> list = priceListService.listPriceListByNos(mediaNos);
            export(response, list);
            json.put("result",true);
            json.put("message","导出成功！");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("message","导出失败！");
            return JSON.toJSONString(json);
        }
    }

    @RequestMapping("exportExcel")
    @Cacheable(value = "mediaprice",keyGenerator = "keyGenerator")
    public void exportExcel(PriceList priceList,HttpServletResponse response){
        try {
            List<PriceList> list = priceListService.listPriceList(priceList);
            export(response, list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void export(HttpServletResponse response, List<PriceList> list) throws Exception {
        ExcelData<PriceList> ed = new ExcelData<>();
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
        subtitlelist.add("媒体分类");
        subtitlelist.add("媒体名称");
        subtitlelist.add("黄金会员");
        subtitlelist.add("白银会员");
        subtitlelist.add("普通会员");
        subtitlelist.add("市场价");
        subtitlelist.add("入口");
        subtitlelist.add("联系方式");
        subtitlelist.add("新闻源");
        subtitlelist.add("备注");
        subtitlelist.add("成本价");
        subtitlelist.add("媒体人联系方式");
        titlelist.add(subtitlelist);
        ed.setTitlelist(titlelist);
        ed.setData(list);
        ed.setName("最新价格下载");
        List<String> headnums = new ArrayList<>();
        headnums.add("0,0,1,9");
        ed.setHeadnums(headnums);
        List<String> display = new ArrayList<>();
        display.add("mediaClassificationName");
        display.add("mediaName");
        display.add("advancedPrice");
        display.add("ordinaryPrice");
        display.add("ordinaryVipPrice");
        display.add("retailPrice");
        display.add("entranceZN");
        display.add("contactInformationName");
        display.add("newsFeedName");
        display.add("remark");
        display.add("costPrice");
        display.add("mediaManPhone");
        ed.setDisplay(display);
        ed.setLinkFieldName("mediaName");
        ed.setUrlFieldName("mediaUrl");
        PoiUtils.exportExcel(response, "迅媒网-新闻资源表.xls", ed);
    }
    @RequestMapping("updateSellingPrice")
    @CacheEvict(value = "mediaprice", allEntries = true)
    public String updateSellingPrice(String mediaNo,String mediaUrl,BigDecimal advancedPrice,BigDecimal ordinaryPrice,BigDecimal ordinaryVipPrice){
        JSONObject json=new JSONObject();
        try{
            PriceList priceList=new PriceList();
            priceList.setMediaNo(mediaNo);
            priceList.setMediaUrl(mediaUrl);
            priceList.setAdvancedPrice(advancedPrice);
            priceList.setOrdinaryPrice(ordinaryPrice);
            priceList.setOrdinaryVipPrice(ordinaryVipPrice);
            priceListService.updateSellingPrice(priceList);
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
    /**
     * create by: lzq
     * description: TODO
     * create time: 2019-03-07 16:29
     * ==作用于基本数据类型时，比较的是两者的值；作用于引用类型时，比较的是两者的内存地址，即是否指向同一对象
     * equals不能作用于基本数据类型，如果没有重写equals方法，则等同于==比较的是所指对象的地址；诸如String,Date等对equals方法重写，
     * equals方法比较的是所指对象的内容
     */
    /*public static void main(String[] args) {
        String a="abc";
        String b="abc";
        String c=new String("def");
        String d=new String("def");
        String e=new String("abc");
        System.out.println(a==b);//true
        System.out.println(a.equals(b));//true
        System.out.println(c==d);//false
        System.out.println(c.equals(d));//true
        System.out.println(a==c);//false
        System.out.println(a.equals(e));//true
    }*/
}

    

