package org.jsets.shiro.demo.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.jsets.shiro.demo.domain.BaseEntity;

@Entity
@Table(name="t_resource")
public class ResourceEntity extends BaseEntity{

	private static final long serialVersionUID = -8265881454439961651L;
	
	public static final int RESOURCE_TYPE_MENU = 1;
	public static final int RESOURCE_TYPE_BUTTON = 2;
	
	private String code;// 编码
    private String name;// 名称
    private String parentId;// 父编号
    private String url;// 路径
    private Short type; //类型 1:菜单 2:按钮
    private Short status;//状态    1:正常、9：删除
    
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}

}