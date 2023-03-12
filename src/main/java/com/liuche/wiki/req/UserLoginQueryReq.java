package com.liuche.wiki.req;

import javax.validation.constraints.NotEmpty;

public class UserLoginQueryReq extends PageReq {

    @NotEmpty(message = "【用户名】不能为空")
    private String loginName;
    @NotEmpty(message = "【密码】不能为空")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    @Override
    public String toString() {
        return "UserLoginQueryReq{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
