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
import org.jsets.shiro.demo.domain.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 角色管理Service
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
@Service
public class RoleService {
	
	@Autowired
	private JdbcEnhance jdbcEnhance;
	
	public int save(RoleEntity role){
		return jdbcEnhance.insert(role);
	}
	
	public int delete(String id){
		return jdbcEnhance.delete(RoleEntity.class, id);
	}
	
	public int update(RoleEntity role){
		return jdbcEnhance.update(role);
	}
	
	public int get(String id){
		return jdbcEnhance.get(RoleEntity.class, id);
	}
	
	public List<RoleEntity> list(){
		return jdbcEnhance
				.selector()
				.SELECT("T.*,P.RESOURCE_NAMES")
				.FROM("T_ROLE T")
				.LEFT_OUTER_JOIN("(SELECT TRR.ROLE_ID,GROUP_CONCAT(TR.NAME ORDER BY TR.ID) RESOURCE_NAMES "
						+ "FROM T_ROLE_RESOURCE TRR JOIN T_RESOURCE TR "
						+ "ON TRR.RESOURCE_ID = TR.ID "
						+ "GROUP BY TRR.ROLE_ID ) P "
						+ "ON T.CODE = P.ROLE_ID")
				.entityClass(RoleEntity.class)
				.list();
	}
}