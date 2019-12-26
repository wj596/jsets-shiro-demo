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
import org.jsets.shiro.demo.domain.entity.RoleEntity;
import org.jsets.shiro.demo.mapper.RoleMapper;
import org.jsets.shiro.model.RolePermRule;
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
	private RoleMapper roleMapper;
	
	public int save(RoleEntity role){
		return roleMapper.insert(role);
	}
	
	public int delete(String id){
		return roleMapper.deleteById(id);
	}
	
	public int update(RoleEntity role){
		return roleMapper.updateById(role);
	}
	
	public RoleEntity get(String id){
		return roleMapper.selectById(id);
	}
	
	public List<RoleEntity> list(){
		return roleMapper.selectRoles();
	}
}