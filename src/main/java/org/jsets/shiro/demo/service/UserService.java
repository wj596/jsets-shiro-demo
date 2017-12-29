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
package org.jsets.shiro.demo.service;

import java.util.List;

import org.jsets.jdbc.JdbcEnhance;
import org.jsets.jdbc.util.SqlBuilder;
import org.jsets.shiro.demo.domain.entity.UserEntity;
import org.jsets.shiro.demo.domain.entity.UserRoleEntity;
import org.jsets.shiro.demo.util.CommonUtil;
import org.jsets.shiro.service.ShiroSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.base.Strings;
/**
 * 用户管理Service
 * 
 * 需要注意两点：
 * <br>1：加密存储密码时使用shiroSecurityService.password(password明文)加密，
 *       保证存储的密码和登陆验证时使用的加密口径（加密算法、hash盐值、hash次数）是一样的。
 * <br>2：如果启用了auth-cache缓存，修改用户信息(用户状态、持有角色等和认证授权有关的信息)后，
 *       使用shiroSecurityService.clearAuthCache(account)清除该用户的认证和授权信息缓存。
 *       
 * @author wangjie (https://github.com/wj596) 
 * @date 2016年6月24日 下午2:55:15
 */ 
@Service
public class UserService {
	
	@Autowired
	private JdbcEnhance jdbcEnhance;
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private ShiroSecurityService shiroSecurityService;
	
	@Transactional
	public void save(UserEntity user){
		if(Strings.isNullOrEmpty(user.getId())){
			// 密码明文加密存储
			user.setPassword(shiroSecurityService.password(user.getPassword()));
			user.setCreateUser(shiroSecurityService.getUser().getAccount());
			user.setCreateTime(CommonUtil.nowDate());
			user.setStatus(UserEntity.USER_STATUS_OK);
			jdbcEnhance.insert(user);
		} else {
			userRoleService.deleteByUser(user.getId());
			jdbcEnhance.update(user);
		}
		if(!Strings.isNullOrEmpty(user.getRoleCodes())){
			for(String roleName:CommonUtil.split(user.getRoleCodes())){
				UserRoleEntity userRole = new UserRoleEntity();
				userRole.setUserId(user.getId());
				userRole.setRoleId(roleName);
				userRoleService.save(userRole);
			}
			// 清除该用户的认证和授权信息缓存
			shiroSecurityService.clearAuthCache(user.getAccount());
		}
	}
	
	public void updateStatus(String account,Short status){
		jdbcEnhance.update(SqlBuilder.BUILD()
						.UPDATE("T_USER")
						.SET("STATUS = ?")
						.WHERE("ACCOUNT = ?"), 
					status,account);
		// 清除该用户的认证和授权信息缓存
		shiroSecurityService.clearAuthCache(account);
	}

	public UserEntity getByAccount(String account){
		return jdbcEnhance
				.selector()
				.SELECT("T.*,TR.ROLE_CODES")
				.FROM("T_USER T")
				.LEFT_OUTER_JOIN("(SELECT GROUP_CONCAT(R.CODE) AS ROLE_CODES,P.USER_ID "
						+ "FROM T_USER_ROLE P "
						+ "LEFT JOIN T_ROLE R ON R.CODE = P.ROLE_ID "
						+ "GROUP BY P.USER_ID ) TR "
						+ "ON T.ID = TR.USER_ID")
				.WHERE("T.ACCOUNT = ?")
				.WHERE("T.STATUS <> 9")
				.entityClass(UserEntity.class)
				.parameter(account)
				.get();
	}

	public List<UserEntity> list(){
		return jdbcEnhance
				.selector()
				.SELECT("T.*,TR.ROLE_CODES")
				.FROM("T_USER T")
				.LEFT_OUTER_JOIN("(SELECT GROUP_CONCAT(R.CODE) AS ROLE_CODES,P.USER_ID "
						+ "FROM T_USER_ROLE P "
						+ "LEFT JOIN T_ROLE R ON R.CODE = P.ROLE_ID "
						+ "GROUP BY P.USER_ID ) TR "
						+ "ON T.ID = TR.USER_ID")
				.WHERE("T.STATUS <> 9")
				.entityClass(UserEntity.class)
				.list();
	}
}