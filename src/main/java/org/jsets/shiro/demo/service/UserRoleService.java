package org.jsets.shiro.demo.service;

import java.util.List;

import org.jsets.jdbc.JdbcEnhance;
import org.jsets.jdbc.util.SqlBuilder;
import org.jsets.shiro.demo.domain.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

	@Autowired
	private JdbcEnhance jdbcEnhance;

	
	public int save(UserRoleEntity userRole){
		return jdbcEnhance.insert(userRole);
	}
	
	public int deleteByUser(String userId){
		return jdbcEnhance.delete(SqlBuilder
					.BUILD()
					.DELETE_FROM("T_USER_ROLE")
					.WHERE("USER_ID = ?")
				, userId);
	}
	
	public List<String> listUserRoles(String account){
		return jdbcEnhance
				.getJdbcTemplate()
				.queryForList(SqlBuilder
						.BUILD()
						.SELECT("T.ROLE_ID")
						.FROM("T_USER_ROLE T")
						.JOIN("T_USER U ON T.USER_ID = U.ID")
						.WHERE("U.ACCOUNT = ?").toString()
				, String.class, account);

	}
}