package com.mmdz.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.mmdz.entity.User;
import com.mmdz.service.UserService;
import com.mmdz.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MMDZ
 * @description: TODO   AccountRealm是 Shiro 进行登录或者权限校验的逻辑所在，算是核心了，我们需要重写3个方法，分别是
 *                          supports：为了让realm支持jwt的凭证校验
 *                          doGetAuthorizationInfo：权限校验
 *                          doGetAuthenticationInfo：登录认证校验
 *
 * @date 2021/5/6 12:25
 */
@Slf4j
@Component
public class AccountRealm  extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;

        log.info("jwt----------------->{}", jwt);

        String userId = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();

        User user = userService.getById(Long.parseLong(userId));
        if(user == null) {
            throw new UnknownAccountException("账户不存在！");
        }

        if(user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定！");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        log.info("profile----------------->{}", profile.toString());
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());
    }

}
