package org.jsets.shiro.demo.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.jsets.shiro.demo.domain.BaseEntity;

@Entity
@Table(name="t_role_resource")
public class RoleResourceEntity extends BaseEntity{

	private static final long serialVersionUID = -6107572732501386464L;
	
	private String roleId;
	private String resourceId;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
}