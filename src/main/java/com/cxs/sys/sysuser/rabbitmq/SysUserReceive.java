package com.cxs.sys.sysuser.rabbitmq;

import com.core.utils.LogUtil;
import com.cxs.sys.sysuser.service.SysUserService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ChenXS
 * 系统级用户消息队列
 */
@Component
public class SysUserReceive {

    private final SysUserService sysUserService;

    @Autowired
    public SysUserReceive(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 监听 getUser 消息队列
     *
     * @param loginName 用户名
     */
    @RabbitListener(queues = "getUser")
    @RabbitHandler
    public void getUser(String loginName, Channel channel, Message message) {
        try {
            LogUtil.info("[RabbitMq]: 接收到消息,消息参数: " + loginName);
            System.out.println(sysUserService.getUserModelWithBlurry(loginName));
            // 告诉服务器已收到消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            LogUtil.error("[RabbitMq]: 出错,错误信息: " + e.getMessage());
        }
    }
}
