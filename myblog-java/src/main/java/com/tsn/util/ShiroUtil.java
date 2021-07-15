package com.tsn.util;

import com.tsn.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author tsn
 * @since 2021/7/13
 */
public class ShiroUtil {
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
