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
import org.jsets.shiro.demo.domain.entity.ResourceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 资源管理Service
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
@Service
public class ResourceService {
	
	@Autowired
	private JdbcEnhance jdbcEnhance;
	
	public int save(ResourceEntity resource){
		return jdbcEnhance.insert(resource);
	}
	
	public int delete(String id){
		return jdbcEnhance.delete(ResourceEntity.class, id);
	}
	
	public int update(ResourceEntity resource){
		return jdbcEnhance.update(resource);
	}
	
	public int get(String id){
		return jdbcEnhance.get(ResourceEntity.class, id);
	}
	
	public List<ResourceEntity> list(){
		return jdbcEnhance
				.selector()
				.SELECT("*")
				.FROM("T_RESOURCE")
				.ORDER_BY("ID")
				.entityClass(ResourceEntity.class)
				.list();
	}	
}