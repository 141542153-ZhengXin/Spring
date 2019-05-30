package com.spring.web.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/web7")
@Api(value = "WebController7", description = "Spring Web Learn")
public class WebController7 {

    private final static Logger logger = LoggerFactory.getLogger(WebController7.class);


    /**
     * 使用@InitBinder自定义数据绑定
     * 使用 @InitBinder 注释控制器方法允许您直接在控制器类中配置Web数据绑定。
     * @InitBinder 标识初始化 WebDataBinder 的方法，该方法将用于填充带注释的处理程序方法的命令和表单对象参数。
     * 这样的init-binder方法支持 @RequestMapping 方法支持的所有参数，但命令/表单对象和相应的验证结果对象除外。
     * Init-binder方法不能有返回值。因此，它们通常被声明为 void 。
     * 典型的参数包括 WebDataBinder 与 WebRequest 或 java.util.Locale 的组合，允许代码注册特定于上下文的编辑器。
     * @param binder
     */
    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //设置指定日期/时间解析是否宽松解析字符串。
		//默认true：宽松解析字符串，输入“33/12/2011”，用SimpleDateFormat parse()方法，转化为Date(2012,01,02)。
		//false：严格解析字符串，输入必须是正常格式，不进位转换。
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }*/

    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }*/

    @RequestMapping("/binderExample")
    @ResponseBody
    public void binderExample(@RequestParam("time") Date date) {
        logger.info("date:" + date);
    }
}
