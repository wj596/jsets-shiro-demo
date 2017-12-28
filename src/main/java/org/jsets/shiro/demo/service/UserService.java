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
			shiroSecurityService.clearAuthCache(user.getAccount());
		}
	}
	
	public void updateStatus(String account,Short status){
		jdbcEnhance.update(SqlBuilder.BUILD()
						.UPDATE("T_USER")
						.SET("STATUS = ?")
						.WHERE("ACCOUNT = ?"), 
					status,account);
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