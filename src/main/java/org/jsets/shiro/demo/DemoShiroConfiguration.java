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

import org.jsets.shiro.config.FilterChainConfig;
import org.jsets.shiro.config.JsetsShiroConfigurationAdapter;
import org.jsets.shiro.config.SecurityManagerConfig;
import org.jsets.shiro.demo.service.PasswdRetryLimitHandlerImpl;
import org.jsets.shiro.demo.service.ShiroAccountProviderImpl;
import org.jsets.shiro.demo.service.ShiroFilteRulesProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * 继承自JsetsShiroConfigurationAdapter以便应用系统设置自己的配置
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年8月05日 
 *
 */
@Configuration
public class DemoShiroConfiguration extends JsetsShiroConfigurationAdapter{

	@Autowired
	private ShiroAccountProviderImpl shiroAccountProvider;
	@Autowired
	private PasswdRetryLimitHandlerImpl passwdRetryLimitHandler;
	@Autowired
	private ShiroFilteRulesProviderImpl shiroFilteRulesProvider;
	
	@Override
	protected void configure(SecurityManagerConfig securityManager) {
		// 设置账号信息提供者实现
		securityManager.setAccountProvider(this.shiroAccountProvider);
		// 设置密码错误次数超限处理器实现
		securityManager.setPasswdRetryLimitHandler(this.passwdRetryLimitHandler);
	}

	@Override
	protected void configure(FilterChainConfig filterChain) {
		// 设置过滤规则提供者，实现动态URL鉴权过滤
		filterChain.setShiroFilteRulesProvider(this.shiroFilteRulesProvider);
	}

}