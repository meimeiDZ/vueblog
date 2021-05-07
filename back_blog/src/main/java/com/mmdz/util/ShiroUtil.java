package com.mmdz.util;

import com.mmdz.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @author MMDZ
 * @description: TODO
 * @date 2021/5/6 12:34
 */
public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}
