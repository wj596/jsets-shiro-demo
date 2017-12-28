package org.jsets.shiro.demo;

import org.jsets.shiro.config.FilterChainConfig;
import org.jsets.shiro.config.JsetsShiroConfigurationAdapter;
import org.jsets.shiro.config.SecurityManagerConfig;
import org.jsets.shiro.demo.service.PasswdRetryLimitHandlerImpl;
import org.jsets.shiro.demo.service.ShiroAccountProviderImpl;
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
	
	@Override
	protected void configure(SecurityManagerConfig securityManager) {
		securityManager.setAccountProvider(shiroAccountProvider);
		securityManager.setPasswdRetryLimitHandler(passwdRetryLimitHandler);
	}

	@Override
	protected void configure(FilterChainConfig filterChain) {

	}

}