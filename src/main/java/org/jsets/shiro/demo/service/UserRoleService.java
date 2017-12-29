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