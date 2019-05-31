package com.spring.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spring.web.model.User;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/web8")
@Api(value = "WebController8", description = "Spring Web Learn")
public class WebController8{

    private final static Logger logger = LoggerFactory.getLogger(WebController8.class);
    static List<User> userList;
    static {
        userList = new ArrayList<>();
        userList.add(new User("1","zx1"));
        userList.add(new User("2","zx2"));
        userList.add(new User("3","zx3"));
    }

    @RequestMapping("/jsonViewExample")
    @JsonView(User.UserSimpleView.class)
    @ResponseBody
    public List<User> jsonViewExample() {
        return userList;
    }

    @RequestMapping("/jsonViewExample2")
    @JsonView(User.UserDetailView.class)
    @ResponseBody
    public List<User> jsonViewExample2() {
        return userList;
    }

    /**
     * 对于依赖于视图分辨率的控制器，只需将序列化视图类添加到模型中
     * @param model
     * @return
     */
    @RequestMapping("/jsonViewExample3")
    public String jsonViewExample3(Model model) {
        //TODO 尚未理解
        model.addAttribute("user", new User("eric", "7!jd#h23"));
        model.addAttribute(JsonView.class.getName(), User.UserSimpleView.class);
        return "web8/jsonViewExample3";
    }

}
