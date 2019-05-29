package com.spring.web.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/web4")
@Api(value = "WebController4", description = "Spring Web Learn")
public class WebController4 {

    private final static Logger logger = LoggerFactory.getLogger(WebController4.class);

    @ModelAttribute
    public void initRequest(HttpServletRequest request) {
       request.setAttribute("id","1");
    }

    /**
     * @RequestAttribute 注释可用于访问由过滤器或拦截器创建的预先存在的请求属性
     * @param id
     * @return
     */
    @RequestMapping("/requestExample")
    public String requestExample(@RequestAttribute String id) {
        logger.info("id:" + id);
        return "web4/requestExample2";
    }

}
