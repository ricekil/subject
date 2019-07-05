package com.zcl.subject.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author jlm
 * @date 2018/10/31 0031
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

  private Logger log = LogManager.getLogger(getClass());

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws Exception {
    if (this.isLoginRequest(request, response)) {
      if (this.isLoginSubmission(request, response)) {
        if (log.isTraceEnabled()) {
          log.trace("Login submission detected.  Attempting to execute login.");
        }

        return this.executeLogin(request, response);
      } else {
        if (log.isTraceEnabled()) {
          log.trace("Login page view.");
        }
        return true;
      }
    } else {
      if (log.isTraceEnabled()) {
        log.trace(
            "Attempting to access a path which requires authentication.  Forwarding to the Authentication url ["
                + this.getLoginUrl() + "]");
      }
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = null;
      try {
        out = response.getWriter();
      } catch (IOException e) {
        e.printStackTrace();
      }
      String s = "未登录,无法访问该地址";
      out.println(s);
      out.flush();
      out.close();
      return false;
    }
  }
}
