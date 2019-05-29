package com.spring.web.controller;

import com.spring.web.model.User;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用“application / x-www-form-urlencoded”数据
 * 浏览器可以通过HTTP GET或HTTP POST提交表单数据。非浏览器客户端也可以通过HTTP PUT提交表单。
 * 这提出了一个挑战，因为Servlet规范要求 ServletRequest.getParameter*() 系列方法仅支持HTTP POST的表单字段访问，而不支持HTTP PUT。
 * 为了支持HTTP PUT和PATCH请求， spring-web 模块提供了过滤器 HttpPutFormContentFilter ，可以在 web.xml 中进行配置：
 * <filter>
 *  <filter-name>httpPutFormFilter</filter-name>
 *  <filter-class>org.springframework.web.filter.HttpPutFormContentFilter</filter-class>
 * </filter>
 * <filter-mapping>
 *  <filter-name>httpPutFormFilter</filter-name>
 *  <servlet-name>dispatcherServlet</servlet-name>
 * </filter-mapping>
 * <servlet>
 *  <servlet-name>dispatcherServlet</servlet-name>
 *  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 * </servlet>
 *
 */
@Controller
@RequestMapping("/web5")
@Api(value = "WebController5", description = "Spring Web Learn")
public class WebController5 {

    private final static Logger logger = LoggerFactory.getLogger(WebController5.class);

    @RequestMapping("/putIndex")
    public String putIndex() {
        return "web5/putIndex";
    }

    @PutMapping("/putExample")
    @ResponseBody
    public void requestExample(User user) {
        logger.info("user:" + user);
    }

}
