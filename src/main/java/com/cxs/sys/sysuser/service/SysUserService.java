package com.cxs.sys.sysuser.service;

import com.cxs.sys.sysuser.model.SysUserModel;
import org.springframework.stereotype.Component;

/**
 * @author ChenXS
 * 系统级用户服务层
 */
@Component
@SuppressWarnings("unused")
public interface SysUserService {
    /**
     * 获取用户权限
     *
     * @param username 用户名
     * @return 权限名称
     */
    String getRole(String username);

    /**
     * 获取用户密码
     *
     * @param username 用户名
     * @return 查询到的数据
     */
    SysUserModel getUserModelWithBlurry(String username);
}
