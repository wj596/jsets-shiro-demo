package org.jsets.shiro.demo.service;

import java.util.List;
import org.jsets.jdbc.JdbcEnhance;
import org.jsets.shiro.demo.domain.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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