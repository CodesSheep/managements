package com.lzq.managements.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author :huhongyang  on 2018/7/20.
 * @description:对字符串操作的工具类
 */
public class StringUtils {

    private final static ObjectMapper mapper = new ObjectMapper();
    /**
     * @author huhy
     * @ClassName:StringUtils
     * @date 2018/5/30 17:04 
     * @Description: 把字符串拆开放到list中
     */
    public static List<String> spliteStrToList(String strs){
        List<String> siteNos = new ArrayList<String>();
        //先判断是否含有“,”
        if(strs.indexOf(",") != -1){
            String[] split = strs.split(",");
            //经过asList处理
            siteNos = Arrays.asList(split);
        }else{
            //不存在，说明项目就对应一个集合点
            siteNos.add(strs);
        }
        return siteNos;
    }

    /**
     * @author huhy
     * @ClassName:StringUtils
     * @date 2018/5/31 15:48 
     * @Description: 把对象转成json
     */
    public static String objToJson(Object obj){
        String jsonData = null;
        try {
             jsonData = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {

        }
        return jsonData;
    }
    /**
     * 判断一个字符串是否是null或者空格或者空
     *
     * @param str 字符串
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null && str.trim().length() > 0) {
            return false;
        }
        return true;
    }

    /**
     * 切割集合
     * @param targetSize 目标集合的大小
     * @return
     */
    public static <T> List<List<T>> cutList(List<T> list,int targetSize){
        if (list==null||list.size()==0||targetSize<1){
            return null;
        }else {
            List<List<T>> result=new ArrayList<>();
            int size=list.size();
            int count=size/targetSize;
            for (int i=0;i<=count;i++){
                List<T> sublist=list.subList(i*targetSize,size > (i+1)*targetSize ? (i+1)*targetSize : size);
                result.add(sublist);
            }
            return result;
        }
    }
    /**
     * @author huhy
     * @ClassName:StringUtils
     * @date 2018/7/21 10:05 
     * @Description: 字符串的截取，返回子串
     * oldStr: 原始字符串
     * replceStr：需要截掉的字符串
     */
    public static String spliceStr(String oldStr,String replceStr){
        return oldStr.replace(replceStr,"");
    }

    /**
     * 字符串MD5加密，并首字符为字母(且保证同一个oldStr生成同一个newStr)
     * */
    public static String md5andfirstcharisletter(String oldStr){
        if (oldStr == null){
            return null;
        }else {
            String newStr = DigestUtils.md5DigestAsHex(oldStr.getBytes());
            //return (char)(int)(Math.random()*26 + 97)+newStr;
            int num = newStr.length();
            for (int i = 0; i < newStr.length(); i++) {
                int j = newStr.charAt(i);
                if ((j >= 65 && j <= 90) || (j >= 97 && j <= 122)) {
                    num = i;
                    break;
                }
            }
            return newStr.substring(num);
        }
    }

    /**
     * 验证手机号的正确性
     * */
    public static boolean rightPhoneNoPattern(String phoneNo){
        if (phoneNo == null || phoneNo.trim() == ""){
            return false;
        }
        Pattern p = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");
        Matcher m = p.matcher(phoneNo);
        return m.matches();
    }

    /**
     * 获取随机数字的验证码
     * */
    public static String getVerificationCode(Integer num){
        if (num == null || num == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++){
            Random random = new Random();
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 多次md5加密
     * */
    public static String doMD5ManyTimes(String str,int times){
        if (str == null){
            return null;
        }
        for (int i = 0 ; i < times ; i++){
            str = DigestUtils.md5DigestAsHex(str.getBytes()).toString();
        }
        return str;
    }

    /**
     * 获取请求的ip
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static String getIpAddr(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
