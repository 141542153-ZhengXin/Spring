package com.spring.web.advice;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @ControllerAdvice 注释是一个组件注释，允许通过类路径扫描自动检测实现类。
 * 使用MVC命名空间或MVC Java配置时会自动启用它。
 */
@ControllerAdvice
public class BinderAdvice {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
