package com.lzq.managements.util;

import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * @author : huhy on 2018/7/20.
 * @Project_name:pumpingstation
 * @LOCAL:com.xf.station.utils
 * @description:文件的工具类
 */
public class FilesUtils {

   /**
    * @author huhy
    * @ClassName:FilesUtils
    * @date 2018/7/21 11:09 
    * @Description: 实现文件上传
    */
    public static List<String> fileUploadSimple(MultipartFile file, String path, String projectPath){
        //获取原始文件名
        String orgName = file.getOriginalFilename();
        //获取文件后缀
        String ext=orgName.substring(orgName.lastIndexOf(".")+1);
        //文件名MD5加密,获得新文件名
        String newFileName= DigestUtils.md5DigestAsHex((orgName+new Random().nextInt(Integer.MAX_VALUE)).getBytes());
        /*String newFileName= orgName;*/
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //存入数据库的路径
        String dbpath =path+"\\"+year+"\\"+month+"\\"+day+"\\"+newFileName+"."+ext;
        //物理路径不存在就创建
        File dir=new File(projectPath+path+"\\"+year+"\\"+month+"\\"+day+"\\");
        //路径不存在时，创建文件夹
        if (!dir.exists()||!dir.isDirectory()){
            dir.mkdirs();
        }
        File newfile = new File(projectPath+dbpath);
        //上传文件
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list=new ArrayList<>();
        list.add(newFileName);
        list.add(orgName);
        list.add(dbpath);
        return list;
    }

    /**
     * @param path 数据库存储的图片路径
     * @param orgName 原始文件名
     *  下载
     * */
    public static void DownloadFile(String path, String orgName, String projectPath, HttpServletResponse response) throws IOException {
        //获取文件绝对路径
        String filePath=projectPath+path;
        //设置头为原始文件名
        response.setHeader("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(orgName, "UTF-8"));
        InputStream is=new FileInputStream(filePath);
        OutputStream os=response.getOutputStream();
        int len;
        byte[] byt=new byte[1024];
        while (-1 != (len=is.read(byt))){
            os.write(byt,0,len);
        }
        os.flush();
        is.close();
        os.close();
    }
//    /**
//     * @author huhy
//     * @ClassName:FilesUtils
//     * @date 2018/7/21 10:10
//     * @Description: 获取项目保存文件的路径
//     */
//    public static String projectPath(){
//        //截取字符串
//        String replceStr = "target/classes/";
//        String path = null;
//        try {
//            path = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath().replace(replceStr, ""),"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return path;
//    }

    /**
     * 文件删除
     * */
    public static void deleat(File file) {
        if(!file.exists()){
            return;
        }
        //如果是文件，就删除文件
        if(file.isFile()){
            file.delete();
            return;
        }
        //是文件夹
        if(file.isDirectory()){
            //循环所有文件夹里面的内容并删除
            File[] files=file.listFiles();
            if (files!=null) {
                for (File f : files) {
                    //迭代删除
                    deleat(f);
                }
            }
            //删除自己
            file.delete();
        }
    }

}
