package com.cxs.sys.sysuser.service;

import com.cxs.sys.sysuser.model.SysUserModel;

/**
 * @author ChenXS
 * 系统级用户服务层
 */
public interface SysUserService {
    /**
     * 获取用户权限
     *
     * @param username
     * @return
     */
    String getRole(String username);

    /**
     * 获取用户密码
     *
     * @param username
     * @return
     */
    SysUserModel getUserModelWithBlurry(String username);
}
