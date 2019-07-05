package com.zcl.subject.shiro;

import com.zcl.subject.bean.SysUserBean;
import com.zcl.subject.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;


/**
 * 认证
 * <p>
 * Created by EricShen on 2017/08/22
 */
public class UserRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        logger.info("Shiro开始登录认证");

        String loginName = (String) token.getPrincipal();//用户名
        String password = new String((char[]) token.getCredentials());//密码

        SysUserBean user = new SysUserBean();

        if(!loginName.equals("admin") || !password.equals("123")){
            throw new UnknownAccountException("用户不存在");
        }
        user.setLoginName("admin");
        user.setPassword("123");
        user.setUserId(1);
        return new SimpleAuthenticationInfo(user, password, getName());
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Integer userId = ShiroUtils.getUserId();
        //用户权限
        Set<String> permsSet = null;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }


}
