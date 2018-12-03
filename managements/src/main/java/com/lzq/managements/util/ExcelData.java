package com.lzq.managements.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : huhy on 2018/7/21.
 * @Project_name:pumpingstation
 * @LOCAL:com.xf.station.common.poi.model
 * @description:{todo}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExcelData<T> implements Serializable{

    private static final long serialVersionUID = -2460136807551080029L;

    //logo
    private byte[] logo;

    //公司名称或者大标题
    private String title;

    //二级表头
    private List<List<String>> titlelist;

    // 数据
    private List<T> data;

    // 页签名称
    private String name;

    //多级表头需要合并的参数
    //如："2,3,1,1","2,2,1,2"（四个数字以逗号分隔组成的字符串，对应excel中的行和列，下标从0开始{"开始行,结束行,开始列,结束列"}
    private List<String> headnums;

    //T对象中需要展示的字段
    private List<String> display = new ArrayList<>();

    //需要加超链接的字段
    private String linkFieldName;
    //存储超链接的字段
    private String urlFieldName;
}
