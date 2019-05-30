package com.spring.web.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 实现Converter接口来实现自定义参数转换
 */
public class StringTrimConverter implements Converter<String, String> {

    @Override
    public String convert(String source) {
        try {
            //去掉字符串两边空格，如果去除后为空设置为null
            if(source!=null){
                source = source.trim();
                if(source.equals("")){
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }
}
