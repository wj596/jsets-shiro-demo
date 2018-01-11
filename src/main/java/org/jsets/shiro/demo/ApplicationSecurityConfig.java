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
package org.jsets.shiro.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.jsets.shiro.config.FilterChainConfig;
import org.jsets.shiro.config.JsetsShiroConfigurationAdapter;
import org.jsets.shiro.config.SecurityManagerConfig;
import org.jsets.shiro.demo.service.AccountProviderImpl;
import org.jsets.shiro.demo.service.FilteRulesProviderImpl;
import org.jsets.shiro.demo.service.PasswdRetryLimitHandlerImpl;

/**
 * 系统安全配置
 * 继承自JsetsShiroConfigurationAdapter以扩展、定制鉴权组件
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年8月05日 
 *
 */
@Configuration
public class ApplicationSecurityConfig extends JsetsShiroConfigurationAdapter{

	// 账号信息提供者
	@Autowired
	private AccountProviderImpl accountProviderImpl;
	// 密码输入错误次数超限处理器
	@Autowired
	private PasswdRetryLimitHandlerImpl passwdRetryLimitHandlerImpl;
	// 动态URL过滤规则
	@Autowired
	private FilteRulesProviderImpl filteRulesProviderImpl;
	
	@Override
	protected void configure(SecurityManagerConfig securityManager) {
		securityManager.setAccountProvider(accountProviderImpl);
		securityManager.setPasswdRetryLimitHandler(passwdRetryLimitHandlerImpl);
	}

	@Override
	protected void configure(FilterChainConfig filterChain) {
		filterChain.setShiroFilteRulesProvider(filteRulesProviderImpl);
	}

}