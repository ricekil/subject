package com.zcl.subject.bean;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: xueshiqi
 * @date: 2018/10/12
 */
public class SysUserBean implements Serializable {

  //用户id
  private Integer userId;
  //用户名或登录名
  private String loginName;
  //真实姓名
  private String userName;
  //用户密码
  private String password;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "SysUserBean{" +
            "userId=" + userId +
            ", loginName='" + loginName + '\'' +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
