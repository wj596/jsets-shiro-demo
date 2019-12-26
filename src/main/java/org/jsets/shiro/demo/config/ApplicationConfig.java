/*
 * Copyright 2017-2018 the original author(https://github.com/wj596)
 * 
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */
package org.jsets.shiro.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.jsets.shiro.api.ShiroCustomizer;
import org.jsets.shiro.demo.service.AccountProviderImpl;
import org.jsets.shiro.demo.service.FilteRulesProviderImpl;
import org.jsets.shiro.demo.service.PasswdRetryLimitHandler;

/**
 * 系统安全配置
 * 继承自JsetsShiroConfigurationAdapter以扩展、定制鉴权组件
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年8月05日 
 */
@Configuration
public class ApplicationConfig{
	// 账号数据提供服务
	@Autowired
	private AccountProviderImpl accountProviderImpl;
	// 自定义的加密实现
	//@Autowired
	//private MyDESPasswordProvider myDESPasswordProvider;
//	// 自定义的验证码实现
//	@Autowired
//	private MyCaptchaService myCaptchaService;
	// 密码输入错误次数超限处理器
	@Autowired
	private PasswdRetryLimitHandler passwdRetryLimitHandler;
	// 鉴权规则数据提供服务
	@Autowired
	private FilteRulesProviderImpl filteRulesProviderImpl;
	// 无状态鉴权(HMAC\JWT)专用的账号数据提供服务
//	@Autowired
//	private StatelessAccountProviderImpl statelessAccountProviderImpl;
//	// 认证监听器实现
//	@Autowired
//	private AuthListenerImpl1 authListenerImpl1;
//	// 认证监听器实现
//	@Autowired
//	private AuthListenerImpl2 authListenerImpl2;
//	// session监听器实现
//	@Autowired
//	private SessionListenerImpl1 sessionListenerImpl1;
//	// session监听器实现
//	@Autowired
//	private SessionListenerImpl2 sessionListenerImpl2;
	
	@Bean
	public ShiroCustomizer shiroCustomizer() {
		ShiroCustomizer customizer = new ShiroCustomizer();
		// 设置账号数据提供服务
		customizer.setShiroAccountProvider(accountProviderImpl); 
		// 设置加密实现
		//customizer.setPasswordProvider(myDESPasswordProvider);
		// 设置验证码实现
//		customizer.setCaptchaProvider(myCaptchaService);
		// 设置密码输入错误次数超限处理器
		customizer.setPasswdRetryLimitListener(passwdRetryLimitHandler);
		// 设置鉴权规则数据提供服务
		customizer.setShiroFilteRulesProvider(filteRulesProviderImpl);
		// 设置无状态鉴权(HMAC\JWT)专用的账号数据提供服务
//		customizer.setShiroStatelessAccountProvider(statelessAccountProviderImpl);
//		// 添加认证监听器
//		customizer.addAuthListener(authListenerImpl1);
//		customizer.addAuthListener(authListenerImpl2);
//		// 添加Session监听器
//		customizer.addSessionListener(sessionListenerImpl1);
//		customizer.addSessionListener(sessionListenerImpl2);
		return customizer;
	}
}