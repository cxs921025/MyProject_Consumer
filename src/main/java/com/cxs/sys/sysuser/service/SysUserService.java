package com.cxs.sys.sysuser.service;

import com.cxs.sys.sysuser.model.SysUserModel;
import org.springframework.stereotype.Component;

/**
 * @author ChenXS
 * 系统级用户服务层
 */
@Component
@SuppressWarnings({"unused", "unchecked"})
public interface SysUserService {

    /**
     * 根据id获取数据库中对应的一条数据
     *
     * @param id 数据id
     * @return 数据库中的一条数据, 若无返回null
     */
    SysUserModel getById(String id);

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
     * @param loginName 用户名
     * @return 查询到的数据
     */
    SysUserModel getUserModelWithBlurry(String loginName);
}
