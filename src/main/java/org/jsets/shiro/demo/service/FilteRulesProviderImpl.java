package org.jsets.shiro.demo.service;

import java.util.List;
import org.jsets.shiro.api.ShiroFilteRulesProvider;
import org.jsets.shiro.demo.mapper.RoleMapper;
import org.jsets.shiro.model.CustomRule;
import org.jsets.shiro.model.RolePermRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
/**
 * 动态过滤规则提供者实现
 * 
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年8月05日 
 */
@Service
public class FilteRulesProviderImpl implements ShiroFilteRulesProvider{
	
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 加载基于角色/资源的过滤规则
	 * <br>大部分系统的安全体系都是RBAC(基于角色的权限访问控制)授权模型。
	 * <br>即：用户--角色--资源(URL),对应关系可配并且存储在数据库中。
	 * <br>此方法提供的数据为：RolePermRule{url资源地址、needRoles需要的角色列表}
	 * <br>在shiro中生成的过滤器链为：url=roles[角色1、角色2、角色n]
	 * <br>当用户持有[角色1、角色2、角色n]中的任何一个角色，则给予访问，否则不予访问
	 * 
	 * <br>权限指用户能操作资源的统称、角色则说权限的集合。
	 * <br>权限授权模型直接表示为：用户--资源(URL)。
	 * <br>此方法提供的数据格为：PermRule{url资源地址、needPerms需要的权限列表}
	 * <br>在shiro中生成的过滤器链为：url=perms[权限编码1、权限编码2、权限编码n]
	 * <br>当用户持有[权限编码1、权限编码2、权限编码n]中的任何一个权限，则给予访问，否则不予访问
	 * 
	 * @return  @see org.jsets.shiro.model.RolePermRule
	 *
	 */
	@Override
	public List<RolePermRule> loadRolePermRules(){
		return roleMapper.selectRolePermRules();
	}

	@Override
	public List<RolePermRule> loadHmacRules() {
		/// HMAC数字签名鉴权过滤规则配置
		/// 为了展示数据原貌使用了编码配置
		/// 真实场景中可以通过界面配置，比如做一个"接口管理"功能
		/// 或者放到"资源管理"中和菜单、按钮一块管理
		/// 删除操作需要通过HMAC数字摘要认证并且具有"role_admin"角色
		RolePermRule hmacRule1 = new RolePermRule();
		hmacRule1.setUrl("/hmac_api/delete");
		hmacRule1.setNeedRoles("role_admin");
		/// 其余操作需要通过HMAC数字摘要认证
		RolePermRule hmacRule2 = new RolePermRule();
		hmacRule2.setUrl("/hmac_api/**");
		List<RolePermRule> hmacRules = Lists.newLinkedList();
		hmacRules.add(hmacRule1);
		hmacRules.add(hmacRule2);
		return hmacRules;
	}

	@Override
	public List<RolePermRule> loadJwtRules() {
		/// JWT令牌鉴权过滤规则配置
		/// 为了展示数据原貌使用了编码配置
		/// 真实场景中可以通过界面配置，比如做一个"接口管理"功能
		/// 或者放到"资源管理"中和菜单、按钮一块管理
		
		/// 删除操作需要通过JWT令牌认证并且具有"role_admin"角色
		RolePermRule jwtRule1 = new RolePermRule();
		jwtRule1.setUrl("/jwt_api/delete");
		jwtRule1.setNeedRoles("role_admin");
		/// 其余操作需要通过JWT令牌认证
		RolePermRule jwtRule2 = new RolePermRule();
		jwtRule2.setUrl("/jwt_api/**");
		List<RolePermRule> jwtRules = Lists.newLinkedList();
		jwtRules.add(jwtRule1);
		jwtRules.add(jwtRule2);
		return jwtRules;
	}

	@Override
	public List<CustomRule> loadCustomRules() {
		return null;
	}
	
}