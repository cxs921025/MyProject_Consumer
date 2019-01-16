package com.cxs.sys.sysuser.action;

import com.core.exception.ServiceException;
import com.core.utils.LogUtil;
import com.core.vo.ReturnVo;
import com.cxs.sys.sysuser.model.SysUserModel;
import com.cxs.sys.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenXS
 * 系统级用户控制层
 */
@RequestMapping("/sys/sysuser")
@RestController
public class SysUserAction {
    private final SysUserService sysUserService;

    @Autowired
    public SysUserAction(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping("getUser")
    public ReturnVo getUser(String loginName) {
        ReturnVo aj = new ReturnVo();
        try {
            SysUserModel model = sysUserService.getUserModelWithBlurry(loginName);
            aj.setObj(model);
            aj.setMsg("getUser 成功");
        } catch (ServiceException e) {
            LogUtil.error(e);
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
        } catch (Exception e) {
            LogUtil.error(e);
        }
        return aj;
    }
}