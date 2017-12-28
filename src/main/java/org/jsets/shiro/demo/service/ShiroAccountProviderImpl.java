package org.jsets.shiro.demo.service;


import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.jsets.shiro.demo.domain.entity.UserEntity;
import org.jsets.shiro.model.Account;
import org.jsets.shiro.service.ShiroAccountProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Sets;
/**
 * 实现安全信息服务接口，以便向shiro提供账号信息
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年6月24日 下午2:55:15
 */ 
@Service
public class ShiroAccountProviderImpl implements ShiroAccountProvider {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;

	@Override
	public Account loadAccount(String account) throws AuthenticationException {
		UserEntity user = userService.getByAccount(account);
		if(null == user){
			throw new AuthenticationException("账号或密码错误");
		}
		// 针对用户的登陆限制，
		// 如用户被锁定、被禁用等限制登陆的场景，抛出AuthenticationException即可
		if(UserEntity.USER_STATUS_LOCKED == user.getStatus()){
			throw new AuthenticationException("账号已被锁定，请联系系统管理员");
		}
		return user;
	}
	@Override
	public Set<String> loadRoles(String account) {
		System.out.println("  ---------------loadRoles");
		return Sets.newHashSet(userRoleService.listUserRoles(account));
	}
	/**
	 * 系统采用  基于角色的权限访问控制(RBAC)策略
	 * 不用加载用的权限，所以此方法不用实现
	 * 所谓的权限通常可以理解为用户所能操作的资源，如（user:add、user:delete）。
	 */ 
	@Override
	public Set<String> loadPermissions(String account) {
		return null;
	}
}