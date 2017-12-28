package org.jsets.shiro.demo.service;

import org.jsets.shiro.demo.domain.entity.UserEntity;
import org.jsets.shiro.demo.service.UserService;
import org.jsets.shiro.handler.PasswdRetryLimitHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 密码错误次数超限处理器
 * @author wangjie
 */
@Service
public class PasswdRetryLimitHandlerImpl implements PasswdRetryLimitHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(PasswdRetryLimitHandlerImpl.class);

    @Autowired
    private UserService userService;
    
    @Override
    public void handle(String account) {
        //锁定账号
        userService.updateStatus(account, UserEntity.USER_STATUS_LOCKED);
        LOGGER.warn("账号："+account+"密码错误超过5次，已锁定");
    }
}