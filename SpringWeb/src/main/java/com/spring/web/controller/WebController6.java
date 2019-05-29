package com.spring.web.controller;

import com.spring.web.model.User;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web6")
@Api(value = "WebController6", description = "Spring Web Learn")
public class WebController6 {

    private final static Logger logger = LoggerFactory.getLogger(WebController6.class);

    /**
     * @param cookie
     * @CookieValue 注释允许将方法参数绑定到HTTP cookie的值。
     */
    @RequestMapping("/cookieExample")
    @ResponseBody
    public void cookieExample(@CookieValue("JSESSIONID") String cookie) {
        logger.info("cookie:" + cookie);
    }

    /**
     * 1.@RequestHeader 注释允许将方法参数绑定到请求标头。
     * 示例请求标头：
     *   Host                    localhost:8080
     *   Accept                  text/html,application/xhtml+xml,application/xml;q=0.9
     *   Accept-Language         fr,en-gb;q=0.7,en;q=0.3
     *   Accept-Encoding         gzip,deflate
     *   Accept-Charset          ISO-8859-1,utf-8;q=0.7,*;q=0.7
     *   Keep-Alive              300
     *
     *  2.在 Map<String, String> ， MultiValueMap<String, String> 或 HttpHeaders 参数上使用 @RequestHeader 注释时，将使用所有标头值填充 Map 。
     * @param encoding
     * @param keepAlive
     */
    @RequestMapping("/headerExample")
    @ResponseBody
    public void headerExample(@RequestHeader("Accept-Encoding") String encoding,
                              @RequestHeader("Keep-Alive") long keepAlive) {
        logger.info("encoding:" + encoding + ";keepAlive:" + keepAlive);
    }

}
