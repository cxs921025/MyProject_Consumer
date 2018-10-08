package com.consumer.web.user.action;

import com.cxs.sys.sysuser.model.SysUserModel;
import com.cxs.sys.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/consumerUser")
public class ConsumerUserAction {

    private final SysUserService sysUserService;

    @Autowired
    public ConsumerUserAction(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping("getUserModelWithBlurry")
    public SysUserModel getUserModelWithBlurry(String name) {
        SysUserModel userModel = sysUserService.getUserModelWithBlurry(name);
        return userModel;
    }
}
