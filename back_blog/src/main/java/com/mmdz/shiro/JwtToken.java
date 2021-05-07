package com.mmdz.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author MMDZ
 * @description: TODO
 * @date 2021/5/6 12:31
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
