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
import org.jsets.shiro.demo.domain.entity.ResourceEntity;
import org.jsets.shiro.demo.domain.entity.RoleResourceEntity;
import org.jsets.shiro.demo.mapper.ResourceMapper;
import org.jsets.shiro.demo.mapper.RoleResourceMapper;
import org.jsets.shiro.demo.util.CommonUtil;
import org.jsets.shiro.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 资源管理Service
 * 
 * @author wangjie (https://github.com/wj596)
 * @date 2016年9月15日
 */ 
@Service
public class ResourceService {
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Autowired
	private RoleResourceMapper roleResourceMapper;
	
	public int save(ResourceEntity resource){
		return resourceMapper.insert(resource);
	}
	
	public int delete(String id){
		return resourceMapper.deleteById(id);
	}
	
	public int update(ResourceEntity resource){
		return resourceMapper.updateById(resource);
	}
	
	public ResourceEntity get(String id){
		return resourceMapper.selectById(id);
	}
	
	public List<ResourceEntity> list(){
		return resourceMapper.selectList(new QueryWrapper<ResourceEntity>());
	}	
	
	public List<ResourceEntity> selectResourcesByRole(String roleId){
		return roleResourceMapper.selectResourcesByRole(roleId);
	}	

	
	/**
	 *  角色-资源绑定
	 */
	@Transactional
	public void roleResBind(String roleId, String resourceIds){
		this.roleResourceMapper.deleteResourceByRole(roleId);
		for(String resourceId:CommonUtil.split(resourceIds)){
			RoleResourceEntity roleResource = new RoleResourceEntity();
			roleResource.setRoleId(roleId);
			roleResource.setResourceId(resourceId);
			this.roleResourceMapper.insert(roleResource);
		}
		// 角色对应的资源改变，要刷新动态过滤规则，以便及时应用更新
		ShiroUtils.reloadFilterRules();
	}
}