package com.lzq.managements.util;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.math.BigDecimal;

/**
 * Created by hjl on 2018/8/18.
 * 针对fastjson转json时，设置Bigdecimal的小数点保留位数
 */
public class BigdecimalValueFilter implements ValueFilter{

    private Integer scale;
    private Integer roundingMode;

    public BigdecimalValueFilter() {
    }

    public BigdecimalValueFilter(Integer scale, Integer roundingMode) {
        this.scale = scale;
        this.roundingMode = roundingMode;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Integer getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(Integer roundingMode) {
        this.roundingMode = roundingMode;
    }

    @Override
    public Object process(Object object, String name, Object value) {
        if(null != value && value instanceof BigDecimal) {
            String str = ((BigDecimal) value).setScale(scale,roundingMode).toString();
            return str;
        }
        return value;
    }
}
