package org.jsets.shiro.demo.domain.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_role")
public class RoleEntity implements Serializable{
	
	private static final long serialVersionUID = -2914079496867008988L;
	
	@Id
	private String code;// 名称
    private String name;// 描述
    private Short status;//状态    1:正常、9：删除
    @Transient
    private String resourceNames;//拥有的资源
    
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getResourceNames() {
		return resourceNames;
	}
	public void setResourceNames(String resourceNames) {
		this.resourceNames = resourceNames;
	}
}