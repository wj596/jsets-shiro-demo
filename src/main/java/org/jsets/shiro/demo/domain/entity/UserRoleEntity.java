package org.jsets.shiro.demo.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.jsets.shiro.demo.domain.BaseEntity;

@Entity
@Table(name="t_user_role")
public class UserRoleEntity extends BaseEntity{

	private static final long serialVersionUID = 5923259786012610208L;
	
	private String userId;
	private String roleId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}