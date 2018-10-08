package com.cxs.sys.sysuser.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author ChenXS
 * 系统级用户实体
 */
@Data
@Builder
public class SysUserModel {

    /**
     * 主键
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String Email;
    /**
     * 权限表主键
     */
    private String roleId;
    /**
     * 状态
     */
    private String status;
    /**
     * 是否更新密码
     */
    private String isUpdatePwd;
    /**
     * 备注
     */
    private String remark;

}
