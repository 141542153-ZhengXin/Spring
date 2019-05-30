package com.spring.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实现Converter接口来实现自定义参数转换
 */
public class CustomDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        try {
            //进行日期转换
            return new SimpleDateFormat("yyyy/MM/dd").parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
