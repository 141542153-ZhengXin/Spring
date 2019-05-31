package com.spring.web.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

public class User {

    /**
     * 带有类参数的 @JsonView 注释，该类参数指定要使用的视图类或接口
     */
    //声明一般视图接口 只允许这个视图返回用户名属性
    public interface UserSimpleView{};
    //声明完整视图接口 允许返回用户名密码属性 由于集成了一般视图接口  含义是拥有了一般视图所具有的返回属性
    public interface UserDetailView extends UserSimpleView{};

    @NotBlank(message = "userId不能为空")
    private String userId;
    private String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @JsonView(UserSimpleView.class)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonView(UserDetailView.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
