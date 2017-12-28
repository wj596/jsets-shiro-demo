package org.jsets.shiro.demo.service;

import java.util.List;
import java.util.Map;
import org.jsets.jdbc.JdbcEnhance;
import org.jsets.jdbc.util.SqlBuilder;
import org.jsets.shiro.demo.domain.entity.ResourceEntity;
import org.jsets.shiro.demo.domain.entity.RoleResourceEntity;
import org.jsets.shiro.demo.util.CommonUtil;
import org.jsets.shiro.service.ShiroSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Maps;

/**
 * 
 * @author wangjie
 *
 */
@Service
public class RoleResourceService {
	
	@Autowired
	private JdbcEnhance jdbcEnhance;
	@Autowired
	private ShiroSecurityService shiroSecurityService;
	
	@Transactional
	public void save(String roleId, String resourceIds){
		this.deleteResourceByRole(roleId);
		for(String resourceId:CommonUtil.split(resourceIds)){
			RoleResourceEntity roleResource = new RoleResourceEntity();
			roleResource.setRoleId(roleId);
			roleResource.setResourceId(resourceId);
			this.save(roleResource);
		}
	}

	public void save(RoleResourceEntity roleResource){
		jdbcEnhance.insert(roleResource);
		// 刷新动态URL权限控制
		shiroSecurityService.reloadFilterRules();
	}
	
	public void deleteResourceByRole(String roleId){
		jdbcEnhance.delete(SqlBuilder.BUILD()
						.DELETE_FROM("T_ROLE_RESOURCE")
						.WHERE("ROLE_ID = ?")
					, roleId);
	}
	
	public List<ResourceEntity> listResourceByRole(String roleId){
		return jdbcEnhance
				.selector()
				.SELECT("R.*")
				.FROM("T_ROLE_RESOURCE T")
				.JOIN("T_RESOURCE R ON T.RESOURCE_ID = R.ID")
				.WHERE("T.ROLE_ID = ?")
				.entityClass(ResourceEntity.class)
				.parameter(roleId)
				.list();
	}

	public Map<String,String> resourceRoleMapping(){
		 Map<String,String> accessibles = Maps.newLinkedHashMap();
		 List<Map<String,Object>> urlRoles = this.jdbcEnhance
				.getJdbcTemplate()
				.queryForList(SqlBuilder.BUILD()
						.SELECT("URL,GROUP_CONCAT(T.ROLE_ID ORDER BY R.URL) ACCESS_ROLES")
						.FROM("T_ROLE_RESOURCE T")
						.JOIN("T_RESOURCE R ON T.RESOURCE_ID = R.ID")
						.GROUP_BY("R.URL")
						.toString());
		 for(Map<String,Object> accessible: urlRoles){
			 accessibles.put((String)accessible.get("URL"), (String)accessible.get("ACCESS_ROLES"));
		 }
		 return accessibles;
	}

}