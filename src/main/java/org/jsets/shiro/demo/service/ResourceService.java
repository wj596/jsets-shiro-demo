package org.jsets.shiro.demo.service;

import java.util.List;
import org.jsets.jdbc.JdbcEnhance;
import org.jsets.shiro.demo.domain.entity.ResourceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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